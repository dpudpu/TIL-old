package student.management.controller;

import student.management.dao.StudentDao;

public class MainController {
    private UI ui;
    private StudentDao studentDao;

    public UI getUi() {
        return ui;
    }

    public void setUi(UI ui) {
        this.ui = ui;
    }

    public StudentDao getStudentDao() {
        return studentDao;
    }

    public void setStudentDao(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    public void control(){
        loop:while(true) {
            int sel = ui.main();
            switch (sel) {
                case 1:
                    if(studentDao.addStudent(ui.addStudent())==1)
                        System.out.println("등록성공");
                    continue;
                case 2:
                    ui.listStudent(studentDao.getList());
                    continue;
                case 3:
                    ui.end();
                    break loop;
                default:
                    System.out.println("다시 선택");
            }
        }
    }
}
