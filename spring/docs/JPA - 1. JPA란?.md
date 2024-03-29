참고 서적 : 자바 ORM표준 JPA 프로그래밍 

------

## JPA란? 

  관계형 데이터베이스를 관리를 표현하는 자바 API다.      

​        
​            

## JPA 탄생까지

 객체 모델과 관계형 데이터베이스 모델은 지향하는 패러다임이 서로 다르다.  SQL과 개발자가 만든 객체를 관계 지어줘야 하는데 SQL 중심적으로 코드를 하게 되므로 객체지향과는 거리가 멀어져 서로 다른 방식의 사고가 충돌된다. 그래서 **Hibernate**가 나왔다.

#### Hibernate(ORM)  ———> JPA ——>Spring DATA JPA

ORM 기술로 Hibernate, OpenJPA, EclipseLink 과 같은 프레임워크들이 생겼고 이에 하이버네이트를 기반으로 ORM 기준 표준 **JPA**(Java Persistent API) 인터페이스가 나왔다.

*ORM은 객체와 관계형 데이터베이스를 매핑한다는 뜻이다.*

​             
​               

## JPA 사용 이유

- 생산성
  - 반복적인 코드와 CRUD용 SQL을 개발자가 직접 작성하지 않아도 된다.
- 유지보수
  - SQL에 의존적인 개발에서는 엔티티에 필드를 하나만 추가해도 관련된 SQL과 JDBC API를 모두 변경해야 했다. 반면에 JPA를 사용하면 이런 과정을 JPA가 대신 처리해준다.
- 패러다임의 불일치 해결
  - 도메인 기반의 프로그래밍으로 비즈니스 로직을 구현하는데 집중할 수 있다.
- 성능
  - Persistent Context가 제공하는 캐시 기능으로 성능 최적화까지 가능.
- 데이터 접근 추상화와 벤더 독립성
  - 하나의 데이터베이스에 종속적이지 않다.
- 표준
      

사용을 위해서는 의존성 추가가 필요하다.

```xml
<dependency>
   <groupId>org.springframework.boot</groupId>
   <artifactId>spring-boot-starter-data-jpa</artifactId>
</dependency>
```

