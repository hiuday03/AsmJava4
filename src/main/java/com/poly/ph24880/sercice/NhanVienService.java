package com.poly.ph24880.sercice;


import com.poly.ph24880.entity.NhanVien;

import java.util.List;

public interface NhanVienService {

    List<NhanVien> getAll();

    NhanVien getOne(String id);

    Boolean add(NhanVien nhanVien);

    Boolean update(NhanVien nhanVien);

    Boolean delete(NhanVien nhanVien);

    String validateValue(NhanVien nhanVien);

}
