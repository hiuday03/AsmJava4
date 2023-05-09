package com.poly.ph24880.sercice;


import com.poly.ph24880.entity.DongSanPham;

import java.util.List;

public interface DongSanPhamService {

    List<DongSanPham> getAll();

    DongSanPham getOne(String id);

    Boolean add(DongSanPham dongSanPham);

    Boolean update(DongSanPham dongSanPham);

    Boolean delete(DongSanPham dongSanPham);

    String validateValue(DongSanPham dongSanPham);

}
