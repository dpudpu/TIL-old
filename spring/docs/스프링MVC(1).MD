## Spring MVC 프로젝트 설정

- ContextLoaderListener 설정

- DistpacherSErvlet 설정

  - 프론트 컨트롤러 역할을 수행하는 DispacherServlet을 등록

- CharacterEncodingFilter 설정

  - 입력 값의 한국어가 깨지지 않도록 서블릿 컨테이너에 등록

- ViewResolver 설정

  - 논리적인 뷰 이름을 보고 실제로 표시할 물리적인 뷰가 무엇인지 판단할 때 사용한다. JSP를 사용하기 위해서는 JSP 용 ViewResolver를 설정한다.

  ```java
  @Bean
  public InternalResourceViewResolver getInternalResourceViewResolver() {
      InternalResourceViewResolver resolver = new InternalResourceViewResolver();
      resolver.setPrefix("/WEB-INF/views/");
      resolver.setSuffix(".jsp");
      return resolver;
  }
  ```

## ApplicationContext 생성 시기

#### web.xml에서 여러개의 Dispatcherservlet을 생성한다. (보통은 두개사용)

1. UI단 / 비즈니스로직 처리를 분리 해주기 위해서,  두개의 설정을 한다. (웹어플리케이션이 두개 있다)   

- ContextLoaderListener (ApplicationContext) - 부모
  - Service, DAO 설정이 있다. 비즈니스로직 (Web관련 x) 

- DipatcherServlet (WebApplicationContext) - 자식 (즉, 부모의 Service, DAO Bean 사용 가능.)
  - Controller



1. support해주는 클래스들을 이용해서 Java Config에서 ApplicationContext를 읽어들인다. 

```xml
<param-value>    org.springframework.web.context.support.AnnotationConfigWebApplicationContext
</param-value>
```





#### - DispacherServlet 을 FrontController로 설정하기

1. Web.xml 파일에 설정
2. WebApplicationInitializer 인터페이스를 구현해서 사용 

- 스프링이 xml -> ServletContainerInitializer(서블릿) -> WebApplicationInitializer

  순서로 읽어서 xml이 더 빠르지만 xml 설정파일로 해야해서 어려울수도 있는 단점이 있다. 

클라이언트의 모든 요청을 받은 후 이를 처리할 핸들러(Controller의 method) 에게 넘기고 핸들러가 처리한 결과를 받아 사용자에게 응답 결과를 보여준다.



#### @EnableWebMVC

web에 필요한 빈들을 대부분 자동으로 설정해준다.

xml 로 설정의 <mvc:annotaion-driven/>와 동일하다.

기본 설정이외의 설정이 필요하다면 WebMvcConfigurerAdapter를 상속 받아서 필요한 메소드를 오버라이딩한다.



#### @ComponentScan

Controller, Service, Repository, Component  애노테이션이 붙은 클래스를 찾아 스프링 컨테이너가 관리.
