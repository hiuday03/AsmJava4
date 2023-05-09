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

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "ChiTietSP")
public class ChiTietSP {

    @Id
    @Column(name = "Id", columnDefinition = "UNIQUEIDENTIFIER")
    private String id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "IdSP", referencedColumnName = "id")
    private SanPham idSP;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "IdNsx", referencedColumnName = "id")
    private NhaSanXuat idNSX;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "IdMauSac", referencedColumnName = "id")
    private MauSac idMauSac;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "IdDongSP", referencedColumnName = "id")
    private DongSanPham idDongSP;

    @Column(name = "NamBH")
    private Integer namBH;

    @Column(name = "MoTa")
    private String moTa;

    @Column(name = "SoLuongTon")
    private Integer soLuongTon;

    @Column(name = "GiaNhap")
    private Float giaNhap;

    @Column(name = "GiaBan")
    private Float giaBan;
}
