package com.poly.ph24880.controller;

import com.poly.ph24880.entity.KhachHang;
import com.poly.ph24880.sercice.KhachHangService;
import com.poly.ph24880.sercice.impl.KhachHangServiceImpl;
import com.poly.ph24880.validate.Validate;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
//import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@WebServlet(name = "KhachHangServlet", value = {
        "/khach-hang/view-all",
        "/khach-hang/detail",
        "/khach-hang/remove",
        "/khach-hang/view-update",
        "/khach-hang/update",
        "/khach-hang/view-create",
        "/khach-hang/create"
})
public class KhachHangServlet extends HttpServlet {

    private KhachHangService service = new KhachHangServiceImpl();
    List<KhachHang> listKH = new ArrayList<>();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("/khach-hang/view-all")) {
            this.viewAll(request, response);
        } else if (uri.contains("/khach-hang/detail")) {
            this.detail(request, response);
        } else if (uri.contains("/khach-hang/remove")) {
            this.remove(request, response);
        } else if (uri.contains("/khach-hang/view-update")) {
            this.viewUpdate(request, response);
        } else if (uri.contains("/khach-hang/view-create")) {
            this.viewCreate(request, response);
        } else {
            this.viewAll(request, response);
        }
    }

    private void viewCreate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("view", "/views/khachHang/create.jsp");
        request.getRequestDispatcher("/views/layout.jsp").forward(request, response);
    }

    private void viewUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        KhachHang khachHang = service.getOne(id);
        request.setAttribute("khachHang", khachHang);
        List<KhachHang> listKH = service.getAll();
        request.setAttribute("listKH", listKH);
        request.setAttribute("view", "/views/khachHang/update.jsp");
        request.getRequestDispatcher("/views/layout.jsp").forward(request, response);
    }

    private void remove(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        KhachHang khachHang = service.getOne(id);
        service.delete(khachHang);
        listKH = service.getAll();
        request.setAttribute("listKH", listKH);
        request.setAttribute("view", "/views/khachHang/index.jsp");
        request.getRequestDispatcher("/views/layout.jsp").forward(request, response);
    }

    private void detail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        if (id != null) {
            KhachHang khachHang = service.getOne(id);
            request.setAttribute("khachHang", khachHang);
            request.setAttribute("listKH", listKH);
            request.setAttribute("view", "/views/khachHang/detail.jsp");
            request.getRequestDispatcher("/views/layout.jsp").forward(request, response);
        }
    }

    private void viewAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        listKH = service.getAll();
        request.setAttribute("listKH", listKH);
        request.setAttribute("view", "/views/khachHang/index.jsp");
        request.getRequestDispatcher("/views/layout.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("/khach-hang/update")) {
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
        String ngaySinh = request.getParameter("ngaySinh");
        String sdt = request.getParameter("sdt");
        String diaChi = request.getParameter("diaChi");
        String thanhPho = request.getParameter("thanhPho");
        String quocGia = request.getParameter("quocGia");
        String matKhau = request.getParameter("matKhau");
        KhachHang khachHang = new KhachHang(String.valueOf(id), ma,ten, tenDem, ho, LocalDate.parse(ngaySinh), sdt, diaChi, thanhPho, quocGia, matKhau );
        if (service.validateValue(khachHang)!=null){
            request.setAttribute("result",service.validateValue(khachHang));
            request.setAttribute("view", "/views/khachHang/create.jsp");
            request.getRequestDispatcher("/views/layout.jsp").forward(request, response);
        }else {
            service.add(khachHang);
            response.sendRedirect("/khach-hang/view-all");
        }
//        List<String> errors = Validate.validateInput(khachHang);
//        if (!errors.isEmpty()){
//            request.setAttribute("erroes", errors);
//            request.setAttribute("view", "/views/khachHang/create.jsp");
//            request.getRequestDispatcher("/views/layout.jsp").forward(request, response);
//        }else {
//            service.add(khachHang);
//            response.sendRedirect("/khach-hang/view-all");
//        }
    }

    private void update(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id = request.getParameter("id");
        String ma = request.getParameter("ma");
        String ten = request.getParameter("ten");
        String tenDem = request.getParameter("tenDem");
        String ho = request.getParameter("ho");
        String ngaySinh = request.getParameter("ngaySinh");
        String sdt = request.getParameter("sdt");
        String diaChi = request.getParameter("diaChi");
        String thanhPho = request.getParameter("thanhPho");
        String quocGia = request.getParameter("quocGia");
        String matKhau = request.getParameter("matKhau");
        KhachHang khachHang = new KhachHang(id, ma,ten, tenDem, ho, LocalDate.parse(ngaySinh), sdt, diaChi, thanhPho, quocGia, matKhau );
        service.update(khachHang);
        response.sendRedirect("/khach-hang/view-all");
    }
}
