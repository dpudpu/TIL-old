package com.jmt.bbang.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "delivery")
@Getter
@Setter
public class Delivery {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 100, nullable = false)
    private String receiver;
    @Column(length = 100, nullable = false)
    private String phoneNum;
    @Column(length = 255, nullable = false)
    private String addr;
    @Column(length = 255, nullable = false)
    private String deliveryCompany;
    @Column(length = 255, nullable = false)
    private String deliveryNumber;
    @Column(length = 50, nullable = false)
    private String status;
    private Date arrivalDate;

    @OneToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name="purchase_id")
    private Purchase purchase;

}
