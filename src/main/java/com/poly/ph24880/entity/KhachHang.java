package com.poly.ph24880.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//import java.sql.Date;
import java.time.LocalDate;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "KhachHang")
public class KhachHang {

@Id
@Column(name = "Id", columnDefinition = "UNIQUEIDENTIFIER")
    private String id;

@Column(name = "Ma")
    private String ma;

@Column(name = "Ten")
    private String ten;

@Column(name = "TenDem")
    private String tenDem;

@Column(name = "Ho")
    private String ho;

@Column(name = "NgaySinh")
    private LocalDate ngaySinh;

@Column(name = "Sdt")
    private String sdt;

@Column(name = "DiaChi")
    private String diaChi;

@Column(name = "ThanhPho")
    private String thanhPho;

@Column(name = "QuocGia")
    private String quocGia;

@Column(name = "MatKhau")
    private String matKhau;
}
