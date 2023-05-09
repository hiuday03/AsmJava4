package com.poly.ph24880.sercice;


import com.poly.ph24880.entity.CuaHang;

import java.util.List;

public interface CuaHangService {

    List<CuaHang> getAll();

    CuaHang getOne(String id);

    Boolean add(CuaHang cuaHang);

    Boolean update(CuaHang cuaHang);

    Boolean delete(CuaHang cuaHang);

    String validateValue(CuaHang cuaHang);

}
