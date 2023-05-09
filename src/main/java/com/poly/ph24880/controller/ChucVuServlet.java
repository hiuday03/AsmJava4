package com.poly.ph24880.controller;

import com.poly.ph24880.entity.ChucVu;
import com.poly.ph24880.sercice.ChucVuService;
import com.poly.ph24880.sercice.impl.ChucVuServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@WebServlet(name = "ChucVuServlet", value = {
        "/chuc-vu/view-all",
        "/chuc-vu/detail",
        "/chuc-vu/remove",
        "/chuc-vu/view-update",
        "/chuc-vu/update",
        "/chuc-vu/view-create",
        "/chuc-vu/create",
})
public class ChucVuServlet extends HttpServlet {

    private ChucVuService service = new ChucVuServiceImpl();
    List<ChucVu> listCV = new ArrayList<>();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("/chuc-vu/view-all")) {
            this.viewAll(request, response);
        } else if (uri.contains("/chuc-vu/detail")) {
            this.detail(request, response);
        } else if (uri.contains("/chuc-vu/remove")) {
            this.remove(request, response);
        } else if (uri.contains("/chuc-vu/view-update")) {
            this.viewUpdate(request, response);
        } else if (uri.contains("/chuc-vu/view-create")) {
            this.viewCreate(request, response);
        } else {
            this.viewAll(request, response);
        }

    }

    private void viewAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        listCV = service.getAll();
        request.setAttribute("listCV", listCV);
        request.setAttribute("view", "/views/chucVu/index.jsp");
        request.getRequestDispatcher("/views/layout.jsp").forward(request, response);
    }

    private void detail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        if (id != null) {
            ChucVu chucVu = service.getOne(id);
            request.setAttribute("chucVu", chucVu);
            request.setAttribute("listCV", listCV);
            request.setAttribute("view", "/views/chucVu/detail.jsp");
            request.getRequestDispatcher("/views/layout.jsp").forward(request, response);
        }
    }

    private void remove(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        ChucVu chucVu = service.getOne(id);
        service.delete(chucVu);
        listCV = service.getAll();
        request.setAttribute("listCV", listCV);
        request.setAttribute("view", "/views/chucVu/index.jsp");
        request.getRequestDispatcher("/views/layout.jsp").forward(request, response);
    }

    private void viewUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        ChucVu chucVu = service.getOne(id);
        request.setAttribute("chucVu", chucVu);
        List<ChucVu> listCV = service.getAll();
        request.setAttribute("listCV", listCV);
        request.setAttribute("view", "/views/chucVu/update.jsp");
        request.getRequestDispatcher("/views/layout.jsp").forward(request, response);
    }

    private void viewCreate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("view", "/views/chucVu/create.jsp");
        request.getRequestDispatcher("/views/layout.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("/chuc-vu/update")) {
            this.update(request, response);
        } else {
            this.create(request, response);
        }
    }

    private void create(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        UUID id = UUID.randomUUID();
        String ma = request.getParameter("ma");
        String ten = request.getParameter("ten");
        ChucVu chucVu = new ChucVu(String.valueOf(id), ma, ten);
        if (service.validateValue(chucVu) != null) {
            request.setAttribute("result", service.validateValue(chucVu));
            request.setAttribute("view", "/views/chucVu/create.jsp");
            request.getRequestDispatcher("/views/layout.jsp").forward(request, response);
        } else {
            service.add(chucVu);
            response.sendRedirect("/chuc-vu/view-all");
        }
    }

    private void update(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id = request.getParameter("id");
        String ma = request.getParameter("ma");
        String ten = request.getParameter("ten");

        ChucVu chucVu = new ChucVu(id, ma, ten);
        service.update(chucVu);

        response.sendRedirect("/chuc-vu/view-all");
    }
}
