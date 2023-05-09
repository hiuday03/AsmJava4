package com.poly.ph24880.sercice;


import com.poly.ph24880.entity.MauSac;

import java.util.List;

public interface MauSacService {

    List<MauSac> getAll();

    MauSac getOne(String id);

    Boolean add(MauSac mauSac);

    Boolean update(MauSac mauSac);

    Boolean delete(MauSac mauSac);

    String validateValue(MauSac mauSac);

}
