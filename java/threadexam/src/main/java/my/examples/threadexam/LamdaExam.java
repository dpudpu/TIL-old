package my.examples.threadexam;

import java.util.Arrays;
import java.util.List;

public class LamdaExam {
    public static void main(String args[]){
        final List<String> names = Arrays.asList("Sehoon", "Songwoo", "Chan", "Youngsuk", "Dajung");

        // 1) map()
//                names.stream().filter(name -> name.startsWith("S")).count());
        names.stream().map(name-> name.toUpperCase()).forEach(name-> System.out.println(name));
        names.forEach(name-> System.out.println(name));

        // 2) filter() 컬렉션을 조건에 의한 선택. boolean 결과를 리턴하는 람다표현식이 필요.
        System.out.println("이름이 S로 시작하는 사람은 몇명인가요? " + names.stream().filter(name->name.startsWith("S")).count());
        System.out.println();


        // 3) reduce() 엘리먼트를 비교하고 컬렉션에서 하나의 값으로 연산한다
        System.out.println(names.stream().reduce("hoone", (name1,name2) -> name1.length() >= name2.length() ? name1:name2));



    }
}
