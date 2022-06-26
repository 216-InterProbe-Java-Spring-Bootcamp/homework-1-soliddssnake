package com.interprobe.homework1.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "PRODUCT_REVIEW")
@Getter
@Setter
public class ProductReview {

    @Id
    @GeneratedValue(generator = "ProductReview")
    @SequenceGenerator(name = "ProductReview",sequenceName = "PRODUCT_REVIEW_ID_SEQ")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_USER",nullable = false,foreignKey = @ForeignKey(name = "FK_PRODUCT_REVIEW_USER"))
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_PRODUCT",nullable = false,foreignKey = @ForeignKey(name = "FK_PRODUCT_REVIEW_PRODUCT"))
    private Product product;

    @Column(name = "REVIEW", length = 500)
    private String review;

    @Column(name = "REVIEW_DATE")
    @Temporal(TemporalType.DATE)
    private Date reviewDate;

}
