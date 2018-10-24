package student.management.controller;

import student.management.dto.Student;

import java.util.List;
import java.util.Scanner;

public class UI {
    public int main() {
        Scanner sc = new Scanner(System.in);
        System.out.println("1. 학생등록");
        System.out.println("2. 학생목록보기");
        System.out.println("3. 종료");
        System.out.print("선택 :");
        int sel = sc.nextInt();
        return sel;

    }

    public Student addStudent() {
        Scanner sc = new Scanner(System.in);
        Student student = new Student();
        System.out.print("이름 : ");
        student.setName(sc.nextLine());
        System.out.print("국어 : ");
        student.setKorean(sc.nextInt());
        System.out.print("영어 : ");
        student.setEnglish(sc.nextInt());
        System.out.print("수학 : ");
        student.setMath(sc.nextInt());

        return student;
    }

    public void listStudent(List<Student> list) {
        System.out.println("이름  국어  영어  수학");
        for (Student student : list) {
            System.out.println(student.getName() + "\t" + student.getKorean() + "\t" + student.getEnglish() + "\t" + student.getMath());
        }
    }

    public void end() {
        System.out.println("종료합니다.");
    }


}
