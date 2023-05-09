package com.poly.ph24880.sercice;


import com.poly.ph24880.entity.SanPham;

import java.util.List;

public interface SanPhamService {

    List<SanPham> getAll();

    SanPham getOne(String id);

    Boolean add(SanPham sanPham);

    Boolean update(SanPham sanPham);

    Boolean delete(SanPham sanPham);

    String validateValue(SanPham sanPham);

}
