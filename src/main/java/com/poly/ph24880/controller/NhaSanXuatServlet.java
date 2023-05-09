package com.poly.ph24880.controller;

import com.poly.ph24880.entity.NhaSanXuat;
import com.poly.ph24880.sercice.NhaSanXuatService;
import com.poly.ph24880.sercice.impl.NhaSanXuatServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@WebServlet(name = "NhaSanXuatServlet", value = {
        "/nha-san-xuat/view-all",
        "/nha-san-xuat/detail",
        "/nha-san-xuat/remove",
        "/nha-san-xuat/view-update",
        "/nha-san-xuat/update",
        "/nha-san-xuat/view-create",
        "/nha-san-xuat/create"
})
public class NhaSanXuatServlet extends HttpServlet {

    private NhaSanXuatService service = new NhaSanXuatServiceImpl();
    List<NhaSanXuat> listNSX = new ArrayList<>();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("/nha-san-xuat/view-all")) {
            this.viewAll(request, response);
        } else if (uri.contains("/nha-san-xuat/detail")) {
            this.detail(request, response);
        } else if (uri.contains("/nha-san-xuat/remove")) {
            this.remove(request, response);
        } else if (uri.contains("/nha-san-xuat/view-update")) {
            this.viewUpdate(request, response);
        } else if (uri.contains("/nha-san-xuat/view-create")) {
            this.viewCreate(request, response);
        } else {
            this.viewAll(request, response);
        }
    }

    private void viewCreate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("view", "/views/nhaSX/create.jsp");
        request.getRequestDispatcher("/views/layout.jsp").forward(request, response);
    }

    private void viewUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        NhaSanXuat nhaSanXuat = service.getOne(id);
        request.setAttribute("nhaSanXuat", nhaSanXuat);
        List<NhaSanXuat> listNSX = service.getAll();
        request.setAttribute("listNSX", listNSX);
        request.setAttribute("view", "/views/nhaSX/update.jsp");
        request.getRequestDispatcher("/views/layout.jsp").forward(request, response);
    }

    private void remove(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        NhaSanXuat nhaSanXuat = service.getOne(id);
        service.delete(nhaSanXuat);
        listNSX = service.getAll();
        request.setAttribute("listNSX", listNSX);
        request.setAttribute("view", "/views/nhaSX/index.jsp");
        request.getRequestDispatcher("/views/layout.jsp").forward(request, response);
    }

    private void detail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        if (id != null) {
            NhaSanXuat nhaSanXuat = service.getOne(id);
            request.setAttribute("nhaSanXuat", nhaSanXuat);
            request.setAttribute("listNSX", listNSX);
            request.setAttribute("view", "/views/nhaSX/detail.jsp");
            request.getRequestDispatcher("/views/layout.jsp").forward(request, response);
        }
    }

    private void viewAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        listNSX = service.getAll();
        request.setAttribute("listNSX", listNSX);
        request.setAttribute("view", "/views/nhaSX/index.jsp");
        request.getRequestDispatcher("/views/layout.jsp").forward(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("/nha-san-xuat/update")) {
            this.update(request, response);
        } else {
            this.create(request, response);
        }
    }

    private void create(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        UUID id = UUID.randomUUID();
        String ma = request.getParameter("ma");
        String ten = request.getParameter("ten");
        NhaSanXuat nhaSanXuat = new NhaSanXuat(String.valueOf(id), ma, ten);
        if (service.validateValue(nhaSanXuat) != null) {
            request.setAttribute("result", service.validateValue(nhaSanXuat));
            request.setAttribute("view", "/views/nhaSX/create.jsp");
            request.getRequestDispatcher("/views/layout.jsp").forward(request, response);
        } else {
            service.add(nhaSanXuat);
            response.sendRedirect("/nha-san-xuat/view-all");
        }
    }

    private void update(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id = request.getParameter("id");
        String ma = request.getParameter("ma");
        String ten = request.getParameter("ten");
        NhaSanXuat nhaSanXuat = new NhaSanXuat(id, ma, ten);
        service.update(nhaSanXuat);
        response.sendRedirect("/nha-san-xuat/view-all");
    }
}
