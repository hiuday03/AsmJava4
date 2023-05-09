package com.poly.ph24880.sercice.impl;

import com.poly.ph24880.entity.SanPham;
import com.poly.ph24880.repository.SanPhamRepository;
import com.poly.ph24880.sercice.SanPhamService;

import java.util.List;

public class SanPhamServiceImpl implements SanPhamService {

    private SanPhamRepository repository = new SanPhamRepository();

    @Override
    public List<SanPham> getAll() {
        return repository.getAll();
    }

    @Override
    public SanPham getOne(String id) {
        return repository.getOne(id);
    }

    @Override
    public Boolean add(SanPham sanPham) {
        return repository.add(sanPham);
    }

    @Override
    public Boolean update(SanPham sanPham) {
        return repository.update(sanPham);
    }

    @Override
    public Boolean delete(SanPham sanPham) {
        return repository.delete(sanPham);
    }

    @Override
    public String validateValue(SanPham sanPham) {
        if (sanPham.getMa().isEmpty()) {
            return "Mã không được để trống";
        } else if (sanPham.getTen().isEmpty()) {
            return "Tên không được để trống";
        } else {
            return null;
        }
    }
}
