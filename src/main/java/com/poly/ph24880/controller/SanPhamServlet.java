package com.poly.ph24880.controller;

import com.poly.ph24880.entity.SanPham;
import com.poly.ph24880.sercice.SanPhamService;
import com.poly.ph24880.sercice.impl.SanPhamServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@WebServlet(name = "SanPhamServlet", value = {
        "/san-pham/view-all",
        "/san-pham/detail",
        "/san-pham/remove",
        "/san-pham/view-update",
        "/san-pham/update",
        "/san-pham/view-create",
        "/san-pham/create"
})
public class SanPhamServlet extends HttpServlet {

    private SanPhamService service = new SanPhamServiceImpl();
    List<SanPham> listSP = new ArrayList<>();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("/san-pham/view-all")) {
            this.viewAll(request, response);
        } else if (uri.contains("/san-pham/detail")) {
            this.detail(request, response);
        } else if (uri.contains("/san-pham/remove")) {
            this.remove(request, response);
        } else if (uri.contains("/san-pham/view-update")) {
            this.viewUpdate(request, response);
        } else if (uri.contains("/san-pham/view-create")) {
            this.viewCreate(request, response);
        } else {
            this.viewAll(request, response);
        }
    }

    private void viewCreate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("view", "/views/sanPham/create.jsp");
        request.getRequestDispatcher("/views/layout.jsp").forward(request, response);
    }

    private void viewUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        SanPham sanPham = service.getOne(id);
        request.setAttribute("sanPham", sanPham);
        List<SanPham> listSP = service.getAll();
        request.setAttribute("listSP", listSP);
        request.setAttribute("view", "/views/sanPham/update.jsp");
        request.getRequestDispatcher("/views/layout.jsp").forward(request, response);
    }

    private void remove(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        SanPham sanPham = service.getOne(id);
        service.delete(sanPham);
        listSP = service.getAll();
        request.setAttribute("listSP", listSP);
        request.setAttribute("view", "/views/sanPham/index.jsp");
        request.getRequestDispatcher("/views/layout.jsp").forward(request, response);
    }

    private void detail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        if (id != null) {
            SanPham sanPham = service.getOne(id);
            request.setAttribute("sanPham", sanPham);
            request.setAttribute("listSP", listSP);
            request.setAttribute("view", "/views/sanPham/detail.jsp");
            request.getRequestDispatcher("/views/layout.jsp").forward(request, response);
        }
    }

    private void viewAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        listSP = service.getAll();
        request.setAttribute("listSP", listSP);
        request.setAttribute("view", "/views/sanPham/index.jsp");
        request.getRequestDispatcher("/views/layout.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("/san-pham/update")) {
            this.update(request, response);
        } else {
            this.create(request, response);
        }
    }

    private void create(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        UUID id = UUID.randomUUID();
        String ma = request.getParameter("ma");
        String ten = request.getParameter("ten");
        SanPham sanPham = new SanPham(String.valueOf(id), ma, ten);
        if (service.validateValue(sanPham) != null) {
            request.setAttribute("result", service.validateValue(sanPham));
            request.setAttribute("view", "/views/sanPham/create.jsp");
            request.getRequestDispatcher("/views/layout.jsp").forward(request, response);
        } else {
            service.add(sanPham);
            response.sendRedirect("/san-pham/view-all");
        }
    }

    private void update(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id = request.getParameter("id");
        String ma = request.getParameter("ma");
        String ten = request.getParameter("ten");
        SanPham sanPham = new SanPham(id, ma, ten);
        service.update(sanPham);
        response.sendRedirect("/san-pham/view-all");
    }
}
