package com.poly.ph24880.controller;

import com.poly.ph24880.entity.DongSanPham;
import com.poly.ph24880.sercice.DongSanPhamService;
import com.poly.ph24880.sercice.impl.DongSanPhamServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@WebServlet(name = "DongSanPhamServlet", value = {
        "/dong-san-pham/view-all",
        "/dong-san-pham/detail",
        "/dong-san-pham/remove",
        "/dong-san-pham/view-update",
        "/dong-san-pham/update",
        "/dong-san-pham/view-create",
        "/dong-san-pham/create",
})
public class DongSanPhamServlet extends HttpServlet {

    private DongSanPhamService service = new DongSanPhamServiceImpl();
    List<DongSanPham> listDSP = new ArrayList<>();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("/dong-san-pham/view-all")) {
            this.viewAll(request, response);
        } else if (uri.contains("/dong-san-pham/detail")) {
            this.detail(request, response);
        } else if (uri.contains("/dong-san-pham/remove")) {
            this.remove(request, response);
        } else if (uri.contains("/dong-san-pham/view-update")) {
            this.viewUpdate(request, response);
        } else if (uri.contains("/dong-san-pham/view-create")) {
            this.viewCreate(request, response);
        } else {
            this.viewAll(request, response);
        }
    }

    private void viewCreate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("view", "/views/dongSP/create.jsp");
        request.getRequestDispatcher("/views/layout.jsp").forward(request, response);
    }

    private void viewUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        DongSanPham dongSanPham = service.getOne(id);
        request.setAttribute("dongSanPham", dongSanPham);
        List<DongSanPham> dongSanPhams = service.getAll();
        request.setAttribute("listDSP", listDSP);
        request.setAttribute("view", "/views/dongSP/update.jsp");
        request.getRequestDispatcher("/views/layout.jsp").forward(request, response);
    }

    private void remove(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        DongSanPham dongSanPham = service.getOne(id);
        service.delete(dongSanPham);
        listDSP = service.getAll();
        request.setAttribute("listDSP", listDSP);
        request.setAttribute("view", "/views/dongSP/index.jsp");
        request.getRequestDispatcher("/views/layout.jsp").forward(request, response);
    }

    private void detail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        if (id != null) {
            DongSanPham dongSanPham = service.getOne(id);
            request.setAttribute("dongSanPham", dongSanPham);
            request.setAttribute("listDSP", listDSP);
            request.setAttribute("view", "/views/dongSP/detail.jsp");
            request.getRequestDispatcher("/views/layout.jsp").forward(request, response);
        }
    }

    private void viewAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        listDSP = service.getAll();
        request.setAttribute("listDSP", listDSP);
        request.setAttribute("view", "/views/dongSP/index.jsp");
        request.getRequestDispatcher("/views/layout.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("/dong-san-pham/update")) {
            this.udpate(request, response);
        } else {
            this.create(request, response);
        }
    }

    private void create(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        UUID id = UUID.randomUUID();
        String ma = request.getParameter("ma");
        String ten = request.getParameter("ten");
        DongSanPham dongSanPham = new DongSanPham(String.valueOf(id), ma, ten);
        if (service.validateValue(dongSanPham) != null) {
            request.setAttribute("result", service.validateValue(dongSanPham));
            request.setAttribute("view", "/views/dongSP/create.jsp");
            request.getRequestDispatcher("/views/layout.jsp").forward(request, response);
        } else {
            service.add(dongSanPham);
            response.sendRedirect("/dong-san-pham/view-all");
        }
    }

    private void udpate(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id = request.getParameter("id");
        String ma = request.getParameter("ma");
        String ten = request.getParameter("ten");

        DongSanPham dongSanPham = new DongSanPham(id, ma, ten);

        service.update(dongSanPham);
        response.sendRedirect("/dong-san-pham/view-all");
    }
}
