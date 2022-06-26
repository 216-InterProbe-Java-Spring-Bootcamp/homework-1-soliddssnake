package com.interprobe.homework1.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "PRODUCT")
@Getter
@Setter
public class Product {

    @Id
    @GeneratedValue(generator = "Product")
    @SequenceGenerator(name = "Product",sequenceName = "PRODUCT_ID_SEQ")
    private Long id;

    @Column(name = "NAME",nullable = false)
    private String name;

    @Column(name = "PRICE",nullable = false)
    private int price;

    @Column(name = "EXPIRATION_DATE")
    private Date expirationDate;

}
