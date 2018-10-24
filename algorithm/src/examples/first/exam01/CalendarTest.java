package examples.first.exam01;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class CalendarTest {
    public static void main(String[] args){
        Calendar cal1 = new GregorianCalendar();

        Calendar cal2 = Calendar.getInstance(); // 사용자한테 객체 생성과정을 숨긴다.
        //추상클래스는 new로 생성은 불가능하지만 자기 자신을 생성해주는 메소드를]

        //필드
        System.out.println(Calendar.AM);
        System.out.println(Calendar.MONTH);

        System.out.println(cal2.get(Calendar.YEAR));
        System.out.println(cal2.get(Calendar.MONTH));


    }
}
