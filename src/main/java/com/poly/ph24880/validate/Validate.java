package com.poly.ph24880.validate;

import com.poly.ph24880.entity.KhachHang;
import com.poly.ph24880.entity.NhanVien;

import java.util.ArrayList;
import java.util.List;

public class Validate {
    public static List<String> validateInput(KhachHang khachHang) {
        List<String> errors = new ArrayList<>();

        if (khachHang.getMa() == null || khachHang.getMa().trim().isEmpty()) {
            errors.add("Mã không được để trống");
        }

        if (khachHang.getTen() == null || khachHang.getTen().trim().isEmpty()) {
            errors.add("Tên không được để trống");
        }

        if (khachHang.getTenDem() == null || khachHang.getTenDem().trim().isEmpty()) {
            errors.add("Tên đệm không được để trống");
        }

        if (khachHang.getHo() == null || khachHang.getHo().trim().isEmpty()) {
            errors.add("Họ không được để trống");
        }

        if (khachHang.getNgaySinh() == null || String.valueOf(khachHang.getNgaySinh()).trim().isEmpty()) {
            errors.add("Ngày sinh không được để trống");
        }

        if (khachHang.getSdt() == null || khachHang.getSdt().trim().isEmpty()) {
            errors.add("Số điện thoại không được để trống");
        } else {
            if (khachHang.getSdt().length() != 10 || !khachHang.getSdt().matches("[0-9]+")) {
                errors.add("Số điện thoại phia rbawst đầu từ 0 và gồm 11 số.");
            }
        }

        if (khachHang.getDiaChi() == null || khachHang.getDiaChi().trim().isEmpty()) {
            errors.add("Địa chỉ không được để trống");
        }

        if (khachHang.getThanhPho() == null || khachHang.getThanhPho().trim().isEmpty()) {
            errors.add("Thành phố không được để trống");
        }

        if (khachHang.getQuocGia() == null || khachHang.getQuocGia().trim().isEmpty()) {
            errors.add("Quốc gia không được để trống");
        }

        if (khachHang.getMatKhau() == null || khachHang.getMatKhau().trim().isEmpty()) {
            errors.add("Mật khẩu không được để trống");
        }


        return errors;
    }

    public static List<String> validateInput(NhanVien nhanVien) {
        List<String> errors = new ArrayList<>();

        return null;
    }
}
