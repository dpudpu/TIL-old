package com.jmt.bbang.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "purchase_product")
@Getter
@Setter
public class PurchaseProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int price;
    private int quantity;
    // 환불을 신청하면 true로 변환해주고 Refund 테이블에 추가해준다.
    @Column(name = "refunded")
    private boolean refunded = false;

    // 1 --- 0..1 은 어떻게?
    @OneToOne(mappedBy = "purchaseProduct")
    private Refund refund;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "purchase_id")
    private Purchase purchase;

    @OneToOne
    @JoinColumn(name = "product_id")
    private Product product;




}
