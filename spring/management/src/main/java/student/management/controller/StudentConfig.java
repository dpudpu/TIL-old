package student.management.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import student.management.dao.StudentDao;

@Configuration
public class StudentConfig {
    @Bean
    public StudentDao studentDao(){
        System.out.println("studentDao()-------------------");
        StudentDao studentDao = new StudentDao();
        studentDao.setDbURL("jdbc:mysql://localhost:3306/management?useSSL=false & serverTimezone=UTC");
        studentDao.setDbId("root");
        studentDao.setDbPassword("root");

        return  studentDao;
    }

    @Bean
    public UI ui(){
        System.out.println("UI()-------------------");
        return new UI();
    }

    @Bean
    public MainController mainController(){
        System.out.println("maincontroller------------");
        MainController mainController = new MainController();
        mainController.setStudentDao(studentDao());
        mainController.setUi(ui());

        return mainController;
    }
}
