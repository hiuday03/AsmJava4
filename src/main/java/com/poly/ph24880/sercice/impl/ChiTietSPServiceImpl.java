package com.poly.ph24880.sercice.impl;

import com.poly.ph24880.entity.ChiTietSP;
import com.poly.ph24880.repository.ChiTietSPRepository;
import com.poly.ph24880.sercice.ChiTietSPService;

import java.util.List;

public class ChiTietSPServiceImpl implements ChiTietSPService {

    private ChiTietSPRepository repository = new ChiTietSPRepository();

    @Override
    public List<ChiTietSP> getAll() {
        return repository.getAll();
    }

    @Override
    public ChiTietSP getOne(String id) {
        return repository.getOne(id);
    }

    @Override
    public Boolean add(ChiTietSP chiTietSP) {
        return repository.add(chiTietSP);
    }

    @Override
    public Boolean update(ChiTietSP chiTietSP) {
        return repository.update(chiTietSP);
    }

    @Override
    public Boolean delete(ChiTietSP chiTietSP) {
        return repository.delete(chiTietSP);
    }

    @Override
    public String validateValue(ChiTietSP chiTietSP) {
        if (chiTietSP.getMoTa().isEmpty()) {
            return "Mô tả không được để trống";
        } else if (chiTietSP.getNamBH() == 0) {
            return "Năm bảo hành không được để trống";
        } else if (chiTietSP.getSoLuongTon() == 0) {
            return "Số lượng không được để trống";
        } else if (chiTietSP.getGiaBan() == 0) {
            return "Giá bán không được để trống";
        } else if (chiTietSP.getGiaNhap() == 0) {
            return "Giá nhập không được để trống";
        } else {
            return null;
        }
    }
}
