1.IntelliJ 에서 maven 프로젝트를 생성한다.
    group id : examples.spring
    artifact id : firstspring

2. pom.xml 파일을 수정

spring-context 에 대한 depedency를 추가하면
spring-beans, aop에 대한 내용도 추가.

<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <groupId>examples.spring</groupId>
    <artifactId>firstspring</artifactId>
    <version>1.0-SNAPSHOT</version>


    <properties>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
        <spring.version>4.3.14.RELEASE</spring.version>
    </properties>

    <dependencies>
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-context</artifactId>
            <version>${spring.version}</version>
        </dependency>


        <!-- test 코드를 위한 것 -->
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-test</artifactId>
            <version>${spring.version}</version>
        </dependency>

        <dependency>
            <groupId>com.github.stefanbirkner</groupId>
            <artifactId>system-rules</artifactId>
            <version>1.5.0</version>
        </dependency>


        <dependency>
            <groupId>junit</groupId>
            <artifactId>junit</artifactId>
            <version>4.12</version>
            <scope>test</scope>
        </dependency>
    </dependencies>

    <build>
        <plugins>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-compiler-plugin</artifactId>
                <version>3.6.1</version>
                <configuration>
                    <source>1.8</source>
                    <target>1.8</target>
                </configuration>
            </plugin>
        </plugins>
    </build>
</project>

3. src/main/resources
폴더에 applicationContext.xml을 만든다.

Spring의 xml파일은 beans라는 root element(요소)를 가진다.

<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">


</beans>


숙제.

XML이 무엇이냐?
XML문서를 작성하는 방법에 대하여 조사하시오.
XML의 name space가 무엇인지 조사하시오.
XML에서 XML 스키마가 무엇인지 조사하시오.

4. 스프링에서 생성할 객체를 작성한다.

package examples.spring;

public class MyBean {
    public MyBean(){
        System.out.println("MyBean()");
    }

    public void print(){
        System.out.println("print!!!");
    }
}


5. applicationContext.xml 파일을 수정했다.

<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">
    <bean id="myBean" class="examples.spring.MyBean"/>
</beans>

6. 해당 설정을 읽어들여 사용하는 ApplicationContext( Bean컨테이너 )를 사용하는 코드를 작성한다.


package examples.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringExam01 {
    public static void main(String[] args){
        // 우리가 스프링 컨테이너라고 말하는 녀석은 ApplicationContext를 말한다.
        // ApplicationContext는 인터페이스다.
        ApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("applicationContext.xml");
        MyBean myBean = (MyBean)applicationContext.getBean("myBean"); // id에 해당하는 객체를 요청한다.
        myBean.print();

        MyBean myBean1 = applicationContext.getBean(MyBean.class);
        myBean1.print();

        if(myBean == myBean1){
            System.out.println("myBean == myBean1");
        }
    }
}