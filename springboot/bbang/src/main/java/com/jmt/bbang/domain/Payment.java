package com.jmt.bbang.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "payment")
@Getter
@Setter
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int totalPrice;
    private Date regdate;
    @Column(name = "status")
    private boolean status=false;
    @Column(length = 100, nullable = false)
    private String type;
    @Column(length = 100)
    private String bankAccount;
    @Column(length = 100)
    private String cardNum;
    @OneToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name="purchase_id")
    private Purchase purchase;
}
