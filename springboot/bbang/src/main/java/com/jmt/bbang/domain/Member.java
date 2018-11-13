package com.jmt.bbang.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "member")
@Getter
@Setter
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 20, nullable = false)
    private String name;
    @Column(length = 40, nullable = false)
    private String memberId;
    @Column(length = 255, nullable = false)
    private String password;
    @Column(length = 255, nullable = false)
    private String email;
    @Column(length = 20, nullable = false)
    private String gender;
    @Column(length = 100, nullable = false)
    private String phoneNum;
    @Column(length = 255, nullable = false)
    private String addr;
    @Column(length = 255, nullable = false)
    private String addrDetails;
    @Column(length = 255, nullable = false)
    private String zipCode;
    private boolean recievingMail;
    private boolean recievingSms;
    @Column(name = "point")
    private int point=0;

    @OneToMany(mappedBy = "member")
    private Set<Cart> cart;

    @ManyToMany
    @JoinTable(name = "member_coupon",
            joinColumns = @JoinColumn(name = "member_id", referencedColumnName = "id") ,
            inverseJoinColumns = @JoinColumn(name = "coupon_id", referencedColumnName = "id") )
    private List<Coupon> memberCoupon;


    @ManyToMany
    @JoinTable(name = "wishlist",
            joinColumns = @JoinColumn(name = "member_id", referencedColumnName = "id") ,
            inverseJoinColumns = @JoinColumn(name = "product_id", referencedColumnName = "id") )
    private Set<Product> wishlist;
}
