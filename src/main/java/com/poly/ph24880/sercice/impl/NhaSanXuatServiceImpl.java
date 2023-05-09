package com.poly.ph24880.sercice.impl;

import com.poly.ph24880.entity.NhaSanXuat;
import com.poly.ph24880.repository.NhaSanXuatRepository;
import com.poly.ph24880.sercice.NhaSanXuatService;

import java.util.List;

public class NhaSanXuatServiceImpl implements NhaSanXuatService {

    private NhaSanXuatRepository repository = new NhaSanXuatRepository();

    @Override
    public List<NhaSanXuat> getAll() {
        return repository.getAll();
    }

    @Override
    public NhaSanXuat getOne(String id) {
        return repository.getOne(id);
    }

    @Override
    public Boolean add(NhaSanXuat nhaSanXuat) {
        return repository.add(nhaSanXuat);
    }

    @Override
    public Boolean update(NhaSanXuat nhaSanXuat) {
        return repository.update(nhaSanXuat);
    }

    @Override
    public Boolean delete(NhaSanXuat nhaSanXuat) {
        return repository.delete(nhaSanXuat);
    }

    @Override
    public String validateValue(NhaSanXuat nhaSanXuat) {
        if (nhaSanXuat.getMa().isEmpty()) {
            return "Mã không được để trống";
        } else if (nhaSanXuat.getTen().isEmpty()) {
            return "Tên không được để trống";
        } else {
            return null;
        }
    }
}
