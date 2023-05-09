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

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "MauSac")
public class MauSac {

    @Id
    @Column(name = "Id", columnDefinition = "UNIQUEIDENTIFIER")
    private String id;

    @Column(name = "Ma")
    private String ma;

    @Column(name = "Ten")
    private String ten;

}
