 

```
create table wishlist (
   member_id bigint not null,
    product_id bigint not null,
    primary key (member_id, product_id)
) engine=MyISAM

alter table wishlist 
       add constraint FKqchevbfw5wq0f4uqacns02rp7 
       foreign key (product_id) 
       references product (id)
```

스푸링부트에서 JPA를 이용해서 이렇게 테이블을 선언해주고 외래키를 주었을 때

product에 row가 아무것도 없음에도 불구하고 wishlist에서는 insert가 추가됩니다. 

(원래는 product_id가 product의 id를 외래키로 받기때문에 생성되면 안됩니다.)



이유는 테이블을 생성할 때 create문에 engine=MyISAM이 붙는데 mysql에서는 **InnoDB**여야 한다고 하내요. 

**참고:** http://jason-heo.github.io/mysql/2014/03/05/mysql-foreign-key.html

​       

해결 방법은 properties에 

spring.jpa.database-platform: org.hibernate.dialect.MySQL5InnoDBDialect 

를 붙여주면 해결됩니다. 적용한 뒤에 스프링부트를 run해주면 에러문이 뜨지만 작동은 잘되기 때문에 이것은 신경쓰지 않으셔도 됩니다. (어차피 나중에 직접 DB에서 테이블 생성하기 때문에 이거 안씁니다.)
