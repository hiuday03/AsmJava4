package com.poly.ph24880.sercice;


import com.poly.ph24880.entity.ChiTietSP;

import java.util.List;

public interface ChiTietSPService {

    List<ChiTietSP> getAll();

    ChiTietSP getOne(String id);

    Boolean add(ChiTietSP chiTietSP);

    Boolean update(ChiTietSP chiTietSP);

    Boolean delete(ChiTietSP chiTietSP);

    String validateValue(ChiTietSP chiTietSP);
}
