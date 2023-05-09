package com.poly.ph24880.controller;

import com.poly.ph24880.entity.CuaHang;
import com.poly.ph24880.sercice.CuaHangService;
import com.poly.ph24880.sercice.impl.CuaHangServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@WebServlet(name = "CuaHangServlet", value = {
        "/cua-hang/view-all",
        "/cua-hang/detail",
        "/cua-hang/remove",
        "/cua-hang/view-update",
        "/cua-hang/update",
        "/cua-hang/view-create",
        "/cua-hang/create",
})
public class CuaHangServlet extends HttpServlet {

    private CuaHangService service = new CuaHangServiceImpl();
    List<CuaHang> listCH = new ArrayList<>();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("/cua-hang/view-all")) {
            this.viewAll(request, response);
        } else if (uri.contains("/cua-hang/detail")) {
            this.detail(request, response);
        } else if (uri.contains("/cua-hang/remove")) {
            this.remove(request, response);
        } else if (uri.contains("/cua-hang/view-update")) {
            this.viewUpdate(request, response);
        } else if (uri.contains("/cua-hang/view-create")) {
            this.viewCreate(request, response);
        } else {
            this.viewAll(request, response);
        }
    }

    private void viewCreate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("view", "/views/cuaHang/create.jsp");
        request.getRequestDispatcher("/views/layout.jsp").forward(request, response);
    }

    private void viewUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        CuaHang cuaHang = service.getOne(id);
        request.setAttribute("cuaHang", cuaHang);
        List<CuaHang> listCH = service.getAll();
        request.setAttribute("listCH", listCH);
        request.setAttribute("view", "/views/cuaHang/update.jsp");
        request.getRequestDispatcher("/views/layout.jsp").forward(request, response);
    }

    private void remove(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        CuaHang cuaHang = service.getOne(id);
        service.delete(cuaHang);
        listCH = service.getAll();
        request.setAttribute("listCH", listCH);
        request.setAttribute("view", "/views/cuaHang/index.jsp");
        request.getRequestDispatcher("/views/layout.jsp").forward(request, response);
    }

    private void detail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        if (id != null) {
            CuaHang cuaHang = service.getOne(id);
            request.setAttribute("cuaHang", cuaHang);
            request.setAttribute("listCH", listCH);
            request.setAttribute("view", "/views/cuaHang/detail.jsp");
            request.getRequestDispatcher("/views/layout.jsp").forward(request, response);
        }
    }

    private void viewAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        listCH = service.getAll();
        request.setAttribute("listCH", listCH);
        request.setAttribute("view", "/views/cuaHang/index.jsp");
        request.getRequestDispatcher("/views/layout.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("/cua-hang/update")) {
            this.upadte(request, response);
        } else {
            this.create(request, response);
        }
    }

    private void create(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        UUID id = UUID.randomUUID();
        String ma = request.getParameter("ma");
        String ten = request.getParameter("ten");
        String diaChi = request.getParameter("diaChi");
        String thanhPho = request.getParameter("thanhPho");
        String quocGia = request.getParameter("quocGia");
        CuaHang cuaHang = new CuaHang(String.valueOf(id), ma, ten, diaChi, thanhPho, quocGia);
        if (service.validateValue(cuaHang)!=null){
            request.setAttribute("result",service.validateValue(cuaHang));
            request.setAttribute("view", "/views/cuaHang/create.jsp");
            request.getRequestDispatcher("/views/layout.jsp").forward(request, response);
        }else {
            service.add(cuaHang);
            response.sendRedirect("/cua-hang/view-all");
        }
    }

    private void upadte(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id = request.getParameter("id");
        String ma = request.getParameter("ma");
        String ten = request.getParameter("ten");
        String diaChi = request.getParameter("diaChi");
        String thanhPho = request.getParameter("thanhPho");
        String quocGia = request.getParameter("quocGia");
        CuaHang cuaHang = new CuaHang(id, ma, ten, diaChi, thanhPho, quocGia);
        service.update(cuaHang);
        response.sendRedirect("/cua-hang/view-all");
    }
}
