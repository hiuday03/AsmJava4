package com.poly.ph24880.sercice.impl;

import com.poly.ph24880.entity.DongSanPham;
import com.poly.ph24880.repository.DongSanPhamRepository;
import com.poly.ph24880.sercice.DongSanPhamService;

import java.util.List;

public class DongSanPhamServiceImpl implements DongSanPhamService {

    private DongSanPhamRepository repository = new DongSanPhamRepository();

    @Override
    public List<DongSanPham> getAll() {
        return repository.getAll();
    }

    @Override
    public DongSanPham getOne(String id) {
        return repository.getOne(id);
    }

    @Override
    public Boolean add(DongSanPham dongSanPham) {
        return repository.add(dongSanPham);
    }

    @Override
    public Boolean update(DongSanPham dongSanPham) {
        return repository.update(dongSanPham);
    }

    @Override
    public Boolean delete(DongSanPham dongSanPham) {
        return repository.delete(dongSanPham);
    }

    @Override
    public String validateValue(DongSanPham dongSanPham) {
        if (dongSanPham.getMa().isEmpty()) {
            return "Mã không được để trống";
        } else if (dongSanPham.getTen().isEmpty()) {
            return "Tên không được để trống";
        } else {
            return null;
        }
    }
}
