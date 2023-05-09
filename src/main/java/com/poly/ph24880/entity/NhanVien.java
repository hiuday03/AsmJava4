package com.poly.ph24880.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.sql.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "NhanVien")
public class NhanVien {

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

    @Column(name = "GioiTinh")
    private String gioiTinh;

    @Column(name = "NgaySinh")
    private Date ngaySinh;

    @Column(name = "DiaChi")
    private String diaChi;

    @Column(name = "Sdt")
    private String sdt;

    @Column(name = "MatKhau")
    private String matKhau;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "IdCH", referencedColumnName = "id")
    private CuaHang idCH;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "IdCV", referencedColumnName = "id")
    private ChucVu idCV;

    @Column(name = "IdGuiBC")
    private String idGuiBC;

    @Column(name = "TrangThai")
    private Integer trangThai;

}
