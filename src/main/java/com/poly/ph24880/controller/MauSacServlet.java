package com.poly.ph24880.controller;

import com.poly.ph24880.entity.MauSac;
import com.poly.ph24880.sercice.MauSacService;
import com.poly.ph24880.sercice.impl.MauSacServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@WebServlet(name = "MauSacServlet", value = {
        "/mau-sac/view-all",
        "/mau-sac/detail",
        "/mau-sac/remove",
        "/mau-sac/view-update",
        "/mau-sac/update",
        "/mau-sac/view-create",
        "/mau-sac/create"
})
public class MauSacServlet extends HttpServlet {

    private MauSacService service = new MauSacServiceImpl();
    List<MauSac> listMS = new ArrayList<>();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("/mau-sac/view-all")) {
            this.viewAll(request, response);
        } else if (uri.contains("/mau-sac/detail")) {
            this.detail(request, response);
        } else if (uri.contains("/mau-sac/remove")) {
            this.remove(request, response);
        } else if (uri.contains("/mau-sac/view-update")) {
            this.viewUpdate(request, response);
        } else if (uri.contains("/mau-sac/view-create")) {
            this.viewCreate(request, response);
        } else {
            this.viewAll(request, response);
        }
    }

    private void viewCreate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("view", "/views/mauSac/create.jsp");
        request.getRequestDispatcher("/views/layout.jsp").forward(request, response);
    }

    private void viewUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        MauSac mauSac = service.getOne(id);
        request.setAttribute("mauSac", mauSac);
        List<MauSac> listMS = service.getAll();
        request.setAttribute("listMS", listMS);
        request.setAttribute("view", "/views/mauSac/update.jsp");
        request.getRequestDispatcher("/views/layout.jsp").forward(request, response);
    }

    private void remove(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        MauSac mauSac = service.getOne(id);
        service.delete(mauSac);
        listMS = service.getAll();
        request.setAttribute("listMS", listMS);
        request.setAttribute("view", "/views/mauSac/index.jsp");
        request.getRequestDispatcher("/views/layout.jsp").forward(request, response);
    }

    private void detail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        if (id != null) {
            MauSac mauSac = service.getOne(id);
            request.setAttribute("mauSac", mauSac);
            request.setAttribute("listMS", listMS);
            request.setAttribute("view", "/views/mauSac/detail.jsp");
            request.getRequestDispatcher("/views/layout.jsp").forward(request, response);
        }
    }

    private void viewAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        listMS = service.getAll();
        request.setAttribute("listMS", listMS);
        request.setAttribute("view", "/views/mauSac/index.jsp");
        request.getRequestDispatcher("/views/layout.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("/mau-sac/update")) {
            this.update(request, response);
        } else {
            this.create(request, response);
        }
    }

    private void create(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        UUID id = UUID.randomUUID();
        String ma = request.getParameter("ma");
        String ten = request.getParameter("ten");
        MauSac mauSac = new MauSac(String.valueOf(id), ma, ten);
        if (service.validateValue(mauSac) != null) {
            request.setAttribute("result", service.validateValue(mauSac));
            request.setAttribute("view", "/views/mauSac/create.jsp");
            request.getRequestDispatcher("/views/layout.jsp").forward(request, response);
        } else {
            service.add(mauSac);
            response.sendRedirect("/mau-sac/view-all");
        }
    }

    private void update(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id = request.getParameter("id");
        String ma = request.getParameter("ma");
        String ten = request.getParameter("ten");
        MauSac mauSac = new MauSac(id, ma, ten);
        service.update(mauSac);
        response.sendRedirect("/mau-sac/view-all");
    }
}
