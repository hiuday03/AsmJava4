package com.poly.ph24880.sercice.impl;

import com.poly.ph24880.entity.KhachHang;
import com.poly.ph24880.repository.KhachHangRepository;
import com.poly.ph24880.sercice.KhachHangService;

import java.util.List;

public class KhachHangServiceImpl implements KhachHangService {

    private KhachHangRepository repository = new KhachHangRepository();

    @Override
    public List<KhachHang> getAll() {
        return repository.getAll();
    }

    @Override
    public KhachHang getOne(String id) {
        return repository.getOne(id);
    }

    @Override
    public Boolean add(KhachHang khachHang) {
        return repository.add(khachHang);
    }

    @Override
    public Boolean update(KhachHang khachHang) {
        return repository.update(khachHang);
    }

    @Override
    public Boolean delete(KhachHang khachHang) {
        return repository.delete(khachHang);
    }

    @Override
    public String validateValue(KhachHang khachHang) {
        String regex = "(0\\d{9})";
        if (khachHang.getMa().isEmpty()) {
            return "Mã không được để trống";
        } else if (khachHang.getHo().isEmpty()) {
            return "Họ không được để trống";
        } else if (khachHang.getTenDem().isEmpty()) {
            return "Tên đệm không được để trống";
        } else if (khachHang.getTen().isEmpty()) {
            return "Tên không được để trống";
        } else if (String.valueOf(khachHang.getNgaySinh()).trim().isEmpty()) {
            return "Ngày sinh không được để trống";
        } else if (khachHang.getSdt().isEmpty()) {
            return "SDT không được để trống";
        } else if (khachHang.getThanhPho().isEmpty()) {
            return "Thành phố không được để trống";
        } else if (khachHang.getDiaChi().isEmpty()) {
            return "Địa chỉ không được để trống";
        } else if (khachHang.getQuocGia().isEmpty()) {
            return "Quốc gia không được để trống";
        } else if (khachHang.getMatKhau().isEmpty()) {
            return "Mật khẩu không được để trống";
        } else if (!khachHang.getSdt().matches(regex)) {
            return "SDT bắt buộc phải có số 0 ở đầu và 10 số";
        } else {
            return null;
        }
    }

}
