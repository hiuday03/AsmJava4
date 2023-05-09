package com.poly.ph24880.sercice.impl;

import com.poly.ph24880.entity.CuaHang;
import com.poly.ph24880.repository.CuaHangRepository;
import com.poly.ph24880.sercice.CuaHangService;

import java.util.List;

public class CuaHangServiceImpl implements CuaHangService {

    private CuaHangRepository repository = new CuaHangRepository();

    @Override
    public List<CuaHang> getAll() {
        return repository.getAll();
    }

    @Override
    public CuaHang getOne(String id) {
        return repository.getOne(id);
    }

    @Override
    public Boolean add(CuaHang cuaHang) {
        return repository.add(cuaHang);
    }

    @Override
    public Boolean update(CuaHang cuaHang) {
        return repository.update(cuaHang);
    }

    @Override
    public Boolean delete(CuaHang cuaHang) {
        return repository.delete(cuaHang);
    }

    @Override
    public String validateValue(CuaHang cuaHang) {
        if (cuaHang.getMa().isEmpty()) {
            return "Mã không được để trống";
        } else if (cuaHang.getTen().isEmpty()) {
            return "Tên không được để trống";
        } else if (cuaHang.getQuocGia().isEmpty()) {
            return "Quốc gia không được để trống";
        } else if (cuaHang.getDiaChi().isEmpty()) {
            return "Địa chỉ không được để trống";
        } else if (cuaHang.getThanhPho().isEmpty()) {
            return "Thành phố không được để trống";
        } else {
            return null;
        }
    }
}
