package com.poly.ph24880.controller;

import com.poly.ph24880.entity.ChiTietSP;
import com.poly.ph24880.entity.DongSanPham;
import com.poly.ph24880.entity.MauSac;
import com.poly.ph24880.entity.NhaSanXuat;
import com.poly.ph24880.entity.SanPham;
import com.poly.ph24880.sercice.ChiTietSPService;
import com.poly.ph24880.sercice.DongSanPhamService;
import com.poly.ph24880.sercice.MauSacService;
import com.poly.ph24880.sercice.NhaSanXuatService;
import com.poly.ph24880.sercice.SanPhamService;
import com.poly.ph24880.sercice.impl.ChiTietSPServiceImpl;
import com.poly.ph24880.sercice.impl.DongSanPhamServiceImpl;
import com.poly.ph24880.sercice.impl.MauSacServiceImpl;
import com.poly.ph24880.sercice.impl.NhaSanXuatServiceImpl;
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

@WebServlet(name = "ChiTietSPServlet", value = {

        "/chi-tiet-san-pham/view-all",
        "/chi-tiet-san-pham/detail",
        "/chi-tiet-san-pham/remove",
        "/chi-tiet-san-pham/view-update",
        "/chi-tiet-san-pham/update",
        "/chi-tiet-san-pham/view-create",
        "/chi-tiet-san-pham/create"
})
public class ChiTietSPServlet extends HttpServlet {
    private ChiTietSPService service = new ChiTietSPServiceImpl();
    private SanPhamService sanPhamService = new SanPhamServiceImpl();
    private NhaSanXuatService nhaSanXuatService = new NhaSanXuatServiceImpl();
    private DongSanPhamService dongSanPhamService = new DongSanPhamServiceImpl();
    private MauSacService mauSacService = new MauSacServiceImpl();
    List<ChiTietSP> listCTSP = new ArrayList<>();
    List<SanPham> listSP = new ArrayList<>();
    List<NhaSanXuat> listNSX = new ArrayList<>();
    List<MauSac> listMS = new ArrayList<>();
    List<DongSanPham> listDSP = new ArrayList<>();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("/chi-tiet-san-pham/view-all")) {
            this.viewAll(request, response);
        } else if (uri.contains("/chi-tiet-san-pham/detail")) {
            this.detail(request, response);
        } else if (uri.contains("/chi-tiet-san-pham/remove")) {
            this.remove(request, response);
        } else if (uri.contains("/chi-tiet-san-pham/view-update")) {
            this.viewUpdate(request, response);
        } else if (uri.contains("/chi-tiet-san-pham/view-create")) {
            this.viewCreate(request, response);
        } else {
            this.viewAll(request, response);
        }
    }

    private void viewCreate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        listSP = sanPhamService.getAll();
        request.setAttribute("listSP", listSP);
        listNSX = nhaSanXuatService.getAll();
        request.setAttribute("listNSX", listNSX);
        listMS = mauSacService.getAll();
        request.setAttribute("listMS", listMS);
        listDSP = dongSanPhamService.getAll();
        request.setAttribute("listDSP", listDSP);
        request.setAttribute("view", "/views/chiTietSP/create.jsp");
        request.getRequestDispatcher("/views/layout.jsp").forward(request, response);
    }

    private void viewUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        ChiTietSP chiTietSP = service.getOne(id);
        request.setAttribute("chiTietSP", chiTietSP);
        List<ChiTietSP> listCTSP = service.getAll();
        request.setAttribute("listCTSP", listCTSP);
        listSP = sanPhamService.getAll();
        request.setAttribute("listSP", listSP);
        listNSX = nhaSanXuatService.getAll();
        request.setAttribute("listNSX", listNSX);
        listMS = mauSacService.getAll();
        request.setAttribute("listMS", listMS);
        listDSP = dongSanPhamService.getAll();
        request.setAttribute("listDSP", listDSP);
        request.setAttribute("view", "/views/chiTietSP/update.jsp");
        request.getRequestDispatcher("/views/layout.jsp").forward(request, response);
    }

    private void remove(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        ChiTietSP chiTietSP = service.getOne(id);
        service.delete(chiTietSP);
        listCTSP = service.getAll();
        request.setAttribute("listCTSP", listCTSP);
        request.setAttribute("view", "/views/chiTietSP/index.jsp");
        request.getRequestDispatcher("/views/layout.jsp").forward(request, response);
    }

    private void detail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        if (id != null) {
            ChiTietSP chiTietSP = service.getOne(id);
            request.setAttribute("chiTietSP", chiTietSP);
            request.setAttribute("listCTSP", listCTSP);
            listSP = sanPhamService.getAll();
            request.setAttribute("listSP", listSP);
            listNSX = nhaSanXuatService.getAll();
            request.setAttribute("listNSX", listNSX);
            listMS = mauSacService.getAll();
            request.setAttribute("listMS", listMS);
            listDSP = dongSanPhamService.getAll();
            request.setAttribute("listDSP", listDSP);
            request.setAttribute("view", "/views/chiTietSP/detail.jsp");
            request.getRequestDispatcher("/views/layout.jsp").forward(request, response);
        }
    }

    private void viewAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        listCTSP = service.getAll();
        request.setAttribute("listCTSP", listCTSP);
        listSP = sanPhamService.getAll();
        request.setAttribute("listSP", listSP);
        listNSX = nhaSanXuatService.getAll();
        request.setAttribute("listNSX", listNSX);
        listMS = mauSacService.getAll();
        request.setAttribute("listMS", listMS);
        listDSP = dongSanPhamService.getAll();
        request.setAttribute("listDSP", listDSP);
        request.setAttribute("view", "/views/chiTietSP/index.jsp");
        request.getRequestDispatcher("/views/layout.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("/chi-tiet-san-pham/update")) {
            this.update(request, response);
        } else {
            this.create(request, response);
        }
    }

    private void create(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        UUID id = UUID.randomUUID();
        String idSP = request.getParameter("idSP");
        String idNSX = request.getParameter("idNSX");
        String idMauSac = request.getParameter("idMauSac");
        String idDongSP = request.getParameter("idDongSP");
        String namBH = request.getParameter("namBH");
        String moTa = request.getParameter("moTa");
        String soLuongTon = request.getParameter("soLuongTon");
        String giaNhap = request.getParameter("giaNhap");
        String giaBan = request.getParameter("giaBan");
        ChiTietSP chiTietSP = new ChiTietSP(
                String.valueOf(id), sanPhamService.getOne(idSP),
                nhaSanXuatService.getOne(idNSX), mauSacService.getOne(idMauSac),
                dongSanPhamService.getOne(idDongSP), Integer.parseInt(namBH),
                moTa, Integer.parseInt(soLuongTon), Float.parseFloat(giaNhap),
                Float.parseFloat(giaBan));
        if (service.validateValue(chiTietSP) != null) {
            listNSX = nhaSanXuatService.getAll();
            listSP = sanPhamService.getAll();
            listMS = mauSacService.getAll();
            listDSP = dongSanPhamService.getAll();
            request.setAttribute("listDSP", listDSP);
            request.setAttribute("listMS", listMS);
            request.setAttribute("listNSX", listNSX);
            request.setAttribute("listSP", listSP);
            request.setAttribute("result",service.validateValue(chiTietSP));
            request.setAttribute("view", "/views/chiTietSP/create.jsp");
            request.getRequestDispatcher("/views/layout.jsp").forward(request, response);
        } else {
            service.add(chiTietSP);
            response.sendRedirect("/chi-tiet-san-pham/view-all");
        }
    }

    private void update(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id = request.getParameter("id");
        String idSP = request.getParameter("idSP");
        String idNSX = request.getParameter("idNSX");
        String idMauSac = request.getParameter("idMauSac");
        String idDongSP = request.getParameter("idDongSP");
        String namBH = request.getParameter("namBH");
        String moTa = request.getParameter("moTa");
        String soLuongTon = request.getParameter("soLuongTon");
        String giaNhap = request.getParameter("giaNhap");
        String giaBan = request.getParameter("giaBan");
        ChiTietSP chiTietSP = new ChiTietSP(
                id, sanPhamService.getOne(idSP),
                nhaSanXuatService.getOne(idNSX), mauSacService.getOne(idMauSac),
                dongSanPhamService.getOne(idDongSP), Integer.parseInt(namBH),
                moTa, Integer.parseInt(soLuongTon), Float.parseFloat(giaNhap),
                Float.parseFloat(giaBan));
        service.update(chiTietSP);
        response.sendRedirect("/chi-tiet-san-pham/view-all");
    }

}
