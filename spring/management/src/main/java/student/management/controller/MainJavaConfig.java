package student.management.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainJavaConfig {
    public static void main(String args[]){
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(StudentConfig.class);
        MainController mainController = applicationContext.getBean("mainController",MainController.class);
        mainController.control();
    }
}
