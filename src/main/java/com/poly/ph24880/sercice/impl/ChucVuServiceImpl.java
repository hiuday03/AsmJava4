package com.poly.ph24880.sercice.impl;

import com.poly.ph24880.entity.ChucVu;
import com.poly.ph24880.repository.ChucVuRepository;
import com.poly.ph24880.sercice.ChucVuService;

import java.util.List;

public class ChucVuServiceImpl implements ChucVuService {

    private ChucVuRepository repository = new ChucVuRepository();

    @Override
    public List<ChucVu> getAll() {
        return repository.getAll();
    }

    @Override
    public ChucVu getOne(String id) {
        return repository.getOne(id);
    }

    @Override
    public Boolean add(ChucVu chucVu) {
        return repository.add(chucVu);
    }

    @Override
    public Boolean update(ChucVu chucVu) {
        return repository.update(chucVu);
    }

    @Override
    public Boolean delete(ChucVu chucVu) {
        return repository.delete(chucVu);
    }

    @Override
    public String validateValue(ChucVu chucVu) {
        if (chucVu.getMa().isEmpty()) {
            return "Mã không được để trống";
        } else if (chucVu.getTen().isEmpty()) {
            return "Tên không được để trống";
        } else {
            return null;
        }
    }
}
