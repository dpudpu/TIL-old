package com.jmt.bbang.domain;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "purchase")
@Getter
@Setter
public class Purchase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    @OneToOne(mappedBy = "purchase")
    private Delivery delivery;

    // Many인데 Collection을 사용하지 않아서 에러가 났었다.
    @OneToMany(mappedBy = "purchase")
    private Set<PurchaseProduct> purchaseProduct;

    @OneToOne(mappedBy = "purchase")
    private Payment payment;
}
