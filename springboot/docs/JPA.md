컴파일 전에 @을 보고 자동으로 getter, setter 를 추가해준다.

dao의 sql은 객체지향이 아니다.  

sql과 내가 만든 객체를 관계 지어줘야하는데 sql중심적이다. 서로 다른 방식의 사고가 충돌.





Hibernate(ORM)  ———> JPA ——>Spring DATA JPA

### Hibernate (ORM) Object-relational mapping

표준이 만들어져서 JPA가 나왔다. Hibernate가 JPA(Inteface)를 구현해준다.

데이터를 저장하는데 꼭 같은 db만을 사용하는게 아니다. ---> Spring DATA JPA	



Entity Manager가 DTO를 자동으로 table에 영속성을 부여해준다.(저장)

Entity - 영속성을 부여받을 객체 (@Entity를 붙여줘야한다.)

Entity는 반드시 식별자(@Id)를 가지고 있어야한다. (타입은 Long으로 해주는게 좋다.) 

@GeneratedValue(strategy = GeneraionType.IDENTITY) - 컬럼을 자동으로 만들어준다.



Spring DATA JPA가 자동으로 레파지토리 인터페이스를 구현해준다.

entity manager는 스프링부트가 자동으로 빈을 생성해준다.

아이디를 자동생성 해놨으면 트랜잭션이 끝났을때가 아니라 중간에 Insert된다.

1차 캐시 - getOne은 같은 트랜잭션에서 일어난 값을 가져온다.(참조가 같다.)

​               한번도 값을 불러온적이 없으면 select문을 사용한다.



영속성이 부여되었을때(save, getone) 스냅샷(복사본)이 만들어진다.

원본(객체)을 수정하면 스냅샷과 비교해서 바뀐게 있으면 자동으로 업데이트 된다.

jpa에는 update가 없다. 

hibernate는 sql을 최대한 줄이려고 늦게 실행하려고 한다.



test클래스에서 @Tansactional을 붙이면 원복되서 DB에 반영되지 않는다.





@ManyToOne - 다대일

@JoinColumn (name="member_id") - 외래키 설정

직접 사용하기 전까지는 sql을 실행하지 않는다. (getBoards()에서는 실행하지않는다. )



엔티티매니저가 리턴해주는건 Member가 아닌 Member를 상속받은 Proxy객체를 리턴해준다.

양방향은 데이터가 얼마 없을때 사용한다. (개수가 많지 않아 서로 부담 없을때)

양방향에서 부담될때는 Repository를 사용





#### Lazy Loading

일대다 관계일때 일에서 다를 가져올 때는 보통 조인문을 사용하는데 JPA에서 사용할 때는 다르다. @ManyToOne일 때, One에서 Many를 가져올 때 getBoards()를 실행하면 List가 아닌 getBoards()를 구현한 PersistentBag을 가져온다. 그리고 Boards를 직접 사용할 때 PersistentBag을 사용해서 sql문을 사용해 가져온다. 

(정보를 가져가도 사용할지 안할지 몰라서 사용할 때 sql을 실행.)

- 레이지로딩
- 엔티티 연관관계
- 1차 캐시, 스냅샷
