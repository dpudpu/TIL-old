package com.jmt.bbang.domain;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "coupon")
@Getter
@Setter
public class Coupon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 20, nullable = false)
    private String name;
    private int discountRate;
    private Date expirationDate;

    @ManyToMany // 구매 개수 추가
    @JoinTable(name = "coupon_product",
            joinColumns = @JoinColumn(name = "coupon_id", referencedColumnName = "id") ,
            inverseJoinColumns = @JoinColumn(name = "product_id", referencedColumnName = "id") )
    private Set<Product> couponProducts;
}
