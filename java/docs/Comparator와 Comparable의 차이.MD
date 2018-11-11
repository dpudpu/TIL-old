

Comparator와 Comparable은 모두 인터페이스로 객체들을 정렬 또는 이진검색트리를 구성하는데 필요한 메서드를 정의하고 있다.



- Comparable - 이 인터페이스를 구현한 객체 스스로에게 부여하는 한 가지 기본 정렬 규칙을 설정하는 목적으로 사용한다.
- Comparator - 이 인터페이스를 구현한 클래스는 정렬 규칙 그 자체를 의미하며, 기본 정렬 규칙과 다르게 원하는대로 정렬순서를 지정하고 싶을 때 사용한다.





### 1. Comparable

```java
public class Book implements Comparable<Book> {
    private int price;
    public Book(int price){
        this.price = price;
    }
    public int getPrice(){
        return this.price;
    }

    @Override
    public int compareTo(Book o) {
        return this.price-o.price; // 자신이 앞에있는게 오름차순
    }
}
```



```java
 Collections.sort(myBookList);
 for (Book book : myBookList)
            System.out.println(book.getPrice());
```



Book클래스에서 Comparable 인터페이스를 상속받아서 compareTo를 구현해주면 나중에 Book 인스턴스를 생성한 뒤에 Collections.sort(myBookList)를 해주면 compareTo 메소드에 정의된 규칙에 따라서 알아서 정렬해준다. 


  
  
    
    

## 2. Comparator



#### 1. Comparator

```java
public static Comparator<Book> bookComparator = new Comparator<Book>() {
    @Override
    public int compare(Book o1, Book o2) {
        return o1.getPrice()-o2.getPrice(); 
        // 첫번째 파라미터가 앞에 있으면 오름차순
    }
};

```

```java
Collections.sort(myBookList, bookComparator);
```





#### 2.Anonymous Comparator

```java
Collections.sort(myBookList, new Comparator<Book>() {
    @Override
    public int compare(Book o1, Book o2) {
        return o2.getPrice()-o1.getPrice();  // o2가 앞에 있으면 내림차순.
    }
});
```





#### 3.Lambda Comparator

```java
// (a1, a2) -> { return a1 > a2; }
//  (a1, a2) -> a1 > a2; 는 같다.
Collections.sort(myBookList, (Book b1, Book b2)-> b1.getPrice()-b2.getPrice());
```

-----------
## 람다식

## 1. 개요

람다식, 또는 람다 함수는 [프로그래밍 언어](https://namu.wiki/w/%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%B0%8D%20%EC%96%B8%EC%96%B4)에서 사용되는 개념으로 [익명 함수](https://namu.wiki/w/%EC%9D%B5%EB%AA%85%20%ED%95%A8%EC%88%98)(Anonymous functions)를 지칭하는 용어이다. 실무적으로는 코드의 간결함, 지연 연산을 통한 퍼포먼스 향상, 그리고 기존 이터레이션 관련 코드를 구현하는 데 있어 불필요한 부분들을 제거할 수 있다는 점에서 비교적 중요하게 다루어지고 있다. 람다식은 주로 [고차 함수](https://namu.wiki/w/%EA%B3%A0%EC%B0%A8%20%ED%95%A8%EC%88%98)에 인자(argument)로 전달되거나 [고차 함수](https://namu.wiki/w/%EA%B3%A0%EC%B0%A8%20%ED%95%A8%EC%88%98)가 돌려주는 결과값으로 쓰인다.

## 2. 장점

- 코드의 간결성 - 효율적인 람다 함수의 사용을 통하여 불필요한 루프문의 삭제가 가능하며, 동일한 함수를 재활용할 수 있는 여지가 커진다.



- 필요한 정보만을 사용하는 방식을 통한 퍼포먼스 향상 - 지연 연산을 지원하는 방식[[2\]](https://namu.wiki/w/%EB%9E%8C%EB%8B%A4%EC%8B%9D#fn-2)을 통하여 효율적인 퍼포먼스를 기대할 수 있다. 이 경우 메모리 상의 효율성 및 불필요한 연산의 배제가 가능하다는 장점이 있다.



## 3. 단점

1. 어떤 방법으로 작성해도 모든 원소를 전부 순회하는 경우는 람다식이 조금 느릴 수 밖에 없다. (어떤 방법으로 만들어도 최종 출력되는 bytecode 나 어셈블리 코드는 단순 while(혹은 for) 문 보다 몇 단계를 더 거치게 된다.)
2. 익명함수의 특성상 함수 외부의 캡처를 위해 캡처를 하는 시간제약 논리제약적인 요소도 고려해야 하며, 디버깅 시 함수 콜스택 추적이 극도로 어렵다.
3. 람다식을 너무 남발하여 사용하게되면 오히려 코드를 이해하기 어려울 수 도 있다.





참고사이트 

 http://hochulshin.com/java-comparable-comparator/		  

 http://dev-daddy.tistory.com/23

 https://namu.wiki/w/%EB%9E%8C%EB%8B%A4%EC%8B%9D

