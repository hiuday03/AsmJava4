package com.poly.ph24880.controller;

import com.poly.ph24880.entity.ChucVu;
import com.poly.ph24880.entity.CuaHang;
import com.poly.ph24880.entity.NhanVien;
import com.poly.ph24880.sercice.ChucVuService;
import com.poly.ph24880.sercice.CuaHangService;
import com.poly.ph24880.sercice.NhanVienService;
import com.poly.ph24880.sercice.impl.ChucVuServiceImpl;
import com.poly.ph24880.sercice.impl.CuaHangServiceImpl;
import com.poly.ph24880.sercice.impl.NhanVienServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@WebServlet(name = "NhanVienServlet", value = {
        "/nhan-vien/view-all",
        "/nhan-vien/detail",
        "/nhan-vien/remove",
        "/nhan-vien/view-update",
        "/nhan-vien/update",
        "/nhan-vien/view-create",
        "/nhan-vien/create"
})
public class NhanVienServlet extends HttpServlet {

    private NhanVienService service = new NhanVienServiceImpl();
    private CuaHangService cuaHangService = new CuaHangServiceImpl();
    private ChucVuService chucVuService = new ChucVuServiceImpl();
    List<ChucVu> listCV = new ArrayList<>();
    List<CuaHang> listCH = new ArrayList<>();
    List<NhanVien> listNV = new ArrayList<>();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("/nhan-vien/view-all")) {
            this.viewAll(request, response);
        } else if (uri.contains("/nhan-vien/detail")) {
            this.detail(request, response);
        } else if (uri.contains("/nhan-vien/remove")) {
            this.remove(request, response);
        } else if (uri.contains("/nhan-vien/view-update")) {
            this.viewUpdate(request, response);
        } else if (uri.contains("/nhan-vien/view-create")) {
            this.viewCreate(request, response);
        } else {
            this.viewAll(request, response);
        }
    }

    private void viewCreate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        listCH = cuaHangService.getAll();
        request.setAttribute("listCH", listCH);
        listCV = chucVuService.getAll();
        request.setAttribute("listCV", listCV);
        request.setAttribute("view", "/views/nhanVien/create.jsp");
        request.getRequestDispatcher("/views/layout.jsp").forward(request, response);
    }

    private void viewUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String id = request.getParameter("id");
        NhanVien nhanVien = service.getOne(id);
        request.setAttribute("nhanVien", nhanVien);
        List<NhanVien> listNV = service.getAll();
        request.setAttribute("listNV", listNV);
        listCH = cuaHangService.getAll();
        request.setAttribute("listCH", listCH);
        listCV = chucVuService.getAll();
        request.setAttribute("listCV", listCV);
        request.setAttribute("view", "/views/nhanVien/update.jsp");
        request.getRequestDispatcher("/views/layout.jsp").forward(request, response);
    }

    private void remove(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        NhanVien nhanVien = service.getOne(id);
        service.delete(nhanVien);
        listNV = service.getAll();
        request.setAttribute("listNV", listNV);
        request.setAttribute("view", "/views/nhanVien/index.jsp");
        request.getRequestDispatcher("/views/layout.jsp").forward(request, response);
    }

    private void detail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        if (id != null) {
            NhanVien nhanVien = service.getOne(id);
            request.setAttribute("nhanVien", nhanVien);
            request.setAttribute("listNV", listNV);
            listCH = cuaHangService.getAll();
            request.setAttribute("listCH", listCH);
            listCV = chucVuService.getAll();
            request.setAttribute("listCV", listCV);
            request.setAttribute("view", "/views/nhanVien/detail.jsp");
            request.getRequestDispatcher("/views/layout.jsp").forward(request, response);
        }
    }

    private void viewAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        listCH = cuaHangService.getAll();
        request.setAttribute("listCH", listCH);
        listCV = chucVuService.getAll();
        request.setAttribute("listCV", listCV);
        listNV = service.getAll();
        request.setAttribute("listNV", listNV);
        request.setAttribute("view", "/views/nhanVien/index.jsp");
        request.getRequestDispatcher("/views/layout.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("/nhan-vien/update")) {
            this.update(request, response);
        } else {
            this.create(request, response);
        }
    }

    private void create(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        UUID id = UUID.randomUUID();
        String ma = request.getParameter("ma");
        String ten = request.getParameter("ten");
        String tenDem = request.getParameter("tenDem");
        String ho = request.getParameter("ho");
        String gioiTinh = request.getParameter("gioiTinh");
        String ngaySinh = request.getParameter("ngaySinh");
        String diaChi = request.getParameter("diaChi");
        String sdt = request.getParameter("sdt");
        String matKhau = request.getParameter("matKhau");
        String idCH = request.getParameter("idCH");
        String idCV = request.getParameter("idCV");
        String idGuiBC = request.getParameter("idGuiBC");
        String trangThai = request.getParameter("trangThai");
        NhanVien nhanVien = new NhanVien(
                String.valueOf(id), ma, ten, tenDem,
                ho, gioiTinh, Date.valueOf(ngaySinh), diaChi, sdt, matKhau,
                cuaHangService.getOne(idCH), chucVuService.getOne(idCV),
                idGuiBC, Integer.parseInt(trangThai));
        if (service.validateValue(nhanVien) != null) {
            listCH = cuaHangService.getAll();
            request.setAttribute("listCH", listCH);
            listCV = chucVuService.getAll();
            request.setAttribute("listCV", listCV);
            request.setAttribute("result", service.validateValue(nhanVien));
            request.setAttribute("view", "/views/nhanVien/create.jsp");
            request.getRequestDispatcher("/views/layout.jsp").forward(request, response);
        } else {
            service.add(nhanVien);
            response.sendRedirect("/nhan-vien/view-all");
        }
    }

    private void update(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id = request.getParameter("id");
        String ma = request.getParameter("ma");
        String ten = request.getParameter("ten");
        String tenDem = request.getParameter("tenDem");
        String ho = request.getParameter("ho");
        String gioiTinh = request.getParameter("gioiTinh");
        String ngaySinh = request.getParameter("ngaySinh");
        String diaChi = request.getParameter("diaChi");
        String sdt = request.getParameter("sdt");
        String matKhau = request.getParameter("matKhau");
        String idCH = request.getParameter("idCH");
        String idCV = request.getParameter("idCV");
        String idGuiBC = request.getParameter("idGuiBC");
        String trangThai = request.getParameter("trangThai");
        NhanVien nhanVien = new NhanVien(
                id, ma, ten, tenDem, ho, gioiTinh,
                Date.valueOf(ngaySinh), diaChi, sdt, matKhau,
                cuaHangService.getOne(idCH), chucVuService.getOne(idCV),
                idGuiBC, Integer.valueOf(trangThai));
        service.update(nhanVien);
        response.sendRedirect("/nhan-vien/view-all");
    }
}
