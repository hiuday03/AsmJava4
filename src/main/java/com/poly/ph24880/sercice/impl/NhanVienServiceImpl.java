package com.poly.ph24880.sercice.impl;

import com.poly.ph24880.entity.NhanVien;
import com.poly.ph24880.repository.NhanVienRepository;
import com.poly.ph24880.sercice.NhanVienService;

import java.util.List;

public class NhanVienServiceImpl implements NhanVienService {

    private NhanVienRepository repository = new NhanVienRepository();

    @Override
    public List<NhanVien> getAll() {
        return repository.getAll();
    }

    @Override
    public NhanVien getOne(String id) {
        return repository.getOne(id);
    }

    @Override
    public Boolean add(NhanVien nhanVien) {
        return repository.add(nhanVien);
    }

    @Override
    public Boolean update(NhanVien nhanVien) {
        return repository.update(nhanVien);
    }

    @Override
    public Boolean delete(NhanVien nhanVien) {
        return repository.delete(nhanVien);
    }

    @Override
    public String validateValue(NhanVien nhanVien) {
        String regex = "(0\\d{10})";
        if (nhanVien.getMa().isEmpty()) {
            return "Mã không được để trống";
        } else if (nhanVien.getHo().isEmpty()) {
            return "Họ không được để trống";
        } else if (nhanVien.getTenDem().isEmpty()) {
            return "Tên đệm không được để trống";
        } else if (nhanVien.getTen().isEmpty()) {
            return "Tên không được để trống";
//        } else if (nhanVien.getNgaySinh().equals("")) {
//            return "Ngày sinh không được để trống";
        } else if (nhanVien.getSdt().isEmpty()) {
            return "SDT không được để trống";
        } else if (nhanVien.getDiaChi().isEmpty()) {
            return "Địa chỉ không được để trống";
        } else if (nhanVien.getMatKhau().isEmpty()) {
            return "Mật khẩu không được để trống";
        } else if (!nhanVien.getSdt().matches(regex)) {
            return "SDT bắt buộc phải có số 0 ở đầu và 11 số";
        } else {
            return null;
        }
    }
}
