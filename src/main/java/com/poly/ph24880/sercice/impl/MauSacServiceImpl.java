package com.poly.ph24880.sercice.impl;

import com.poly.ph24880.entity.MauSac;
import com.poly.ph24880.repository.MauSacRepository;
import com.poly.ph24880.sercice.MauSacService;

import java.util.List;

public class MauSacServiceImpl implements MauSacService {

    private MauSacRepository repository = new MauSacRepository();

    @Override
    public List<MauSac> getAll() {
        return repository.getAll();
    }

    @Override
    public MauSac getOne(String id) {
        return repository.getOne(id);
    }

    @Override
    public Boolean add(MauSac mauSac) {
        return repository.add(mauSac);
    }

    @Override
    public Boolean update(MauSac mauSac) {
        return repository.update(mauSac);
    }

    @Override
    public Boolean delete(MauSac mauSac) {
        return repository.delete(mauSac);
    }

    @Override
    public String validateValue(MauSac mauSac) {
        if (mauSac.getMa().isEmpty()) {
            return "Mã không được để trống";
        } else if (mauSac.getTen().isEmpty()) {
            return "Tên không được để trống";
        } else {
            return null;
        }
    }
}
