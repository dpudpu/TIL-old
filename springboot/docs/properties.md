- SpringboardApplication이 해당된 패키지 밑의 모든 component를 스캔해준다.

  Spring 5부터는 Java8에서만 사용 가능해졌고, 자바8에서는 인터페이스가 구현된 메소드를 가지고 있을수 있다. 이것을 default method 라고 한다. (자식은 오버라이드 구현하지 않아도 된다.)

  그래서 스프링부트2.0이상 부터는 스프링5가 적용되어서 더이상 Adapter를 사용하지 않아도 되었고 그 중 하나인 webmvcconfigureradapter가 Deprecated 되었다.

- Adapter란 ? 

  인터페이스를 상속받으면  필요한 메소드 몇가지만 구현(오버라이드)하고 싶음에도 불구하고 부모의 모든 메소드를 구 현해줘야 한다. 그래서 해당 인터페이스를 상속받은 추상클래스를 만들어주었고 이것을 Adapter라고 한다.



- 설정파일을 불러올 때

  1. Environment는 원시적이지만 강력하다. jar에 포함가능 
  2. @Value(${name })   - 각 변수마다 일일이 적어줘야함.
  3. @ConfigurationProperties(prefix = "serverinfo")

  3번이 가장 추천하는 방식이다. 일일이 입력을 안해줘도 되서 좋다.
