package com.poly.ph24880.sercice;

import com.poly.ph24880.entity.ChucVu;

import java.util.List;

public interface ChucVuService {

    List<ChucVu> getAll();

    ChucVu getOne(String id);

    Boolean add(ChucVu chucVu);

    Boolean update(ChucVu chucVu);

    Boolean delete(ChucVu chucVu);

    String validateValue(ChucVu chucVu);

}
