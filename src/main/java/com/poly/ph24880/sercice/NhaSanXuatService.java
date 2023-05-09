package com.poly.ph24880.sercice;


import com.poly.ph24880.entity.NhaSanXuat;

import java.util.List;

public interface NhaSanXuatService {

    List<NhaSanXuat> getAll();

    NhaSanXuat getOne(String id);

    Boolean add(NhaSanXuat nhaSanXuat);

    Boolean update(NhaSanXuat nhaSanXuat);

    Boolean delete(NhaSanXuat nhaSanXuat);

    String validateValue(NhaSanXuat nhaSanXuat);

}
