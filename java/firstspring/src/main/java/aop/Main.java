package aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String args[]){
        ApplicationContext context= new ClassPathXmlApplicationContext("expert.xml");

        IPerson boy = (IPerson)context.getBean("boy");
        IPerson girl = (IPerson)context.getBean("girl");
        Man man = (Man)context.getBean("man");
        boy.housework();
        System.out.println();
        girl.housework();
        System.out.println(  );
        man.housework();
    }
}
