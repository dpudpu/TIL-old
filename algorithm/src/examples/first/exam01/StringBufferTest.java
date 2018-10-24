package examples.first.exam01;

public class StringBufferTest {
    /**
     * 프로그램 시작점.
     * @param args
     */
    public static void main(String args[]){
        //스프링 버퍼를 사용
        StringBuffer sb = new StringBuffer();
        sb.append("hello");
        sb.append(" ");
        sb.append("world");

        //sb가 가지고 있는 toString()메소드는 내부적인 문자열을 리턴(반환)한다.
        System.out.println(sb.toString());
    }
}
