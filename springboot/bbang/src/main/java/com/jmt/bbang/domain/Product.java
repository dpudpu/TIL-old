package com.jmt.bbang.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "product")
@Getter
@Setter
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 255, nullable = false)
    private String productName;
    @Column(length = 255, nullable = false)
    private String nutrition;
    private int price;
    private int pointRate;
    private boolean cutting;
    private Date regdate;
    @Column(name = "hit")
    private int hit=0;
    private int quantity;
    @Column(name = "total_sales")
    private int totalSales=0;


    // 나중에 구매목록에서 상품 링크를 클릭했을 경우 정보를 볼수있으려면 삭제해도
    // 게시판에서만 안보일뿐 상품 정보는 보여야하므로 추가해줌.
    @Column(name="deleted")
    private boolean deleted = false;

    @OneToMany(mappedBy = "product")
    private Set<ProductOption> productOptions;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @OneToOne(mappedBy = "product")
    private PurchaseProduct purchaseProducts;

    @OneToMany(mappedBy="product")
    private Set<Cart> carts;

}
