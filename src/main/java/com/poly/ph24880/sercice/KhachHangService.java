package com.poly.ph24880.sercice;

import com.poly.ph24880.entity.KhachHang;

import java.util.List;

public interface KhachHangService {

    List<KhachHang> getAll();

    KhachHang getOne(String id);

    Boolean add(KhachHang khachHang);

    Boolean update(KhachHang khachHang);

    Boolean delete(KhachHang khachHang);

    String validateValue(KhachHang khachHang);

}
