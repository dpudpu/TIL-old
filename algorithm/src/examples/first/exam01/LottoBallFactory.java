package examples.first.exam01;


import java.util.ArrayList;
import java.util.List;

//로또 공장은 세상에 많을 필요가 있을까? - 하나면 되니까 private으로 생성자 선언
public class LottoBallFactory {
    // private 생성자만 있으면 외부에서 new로 객체를 생성할 수 없다.
    private LottoBallFactory(){

    }

    // static한 메소드는 인스턴스를 생성하지 않아도 사용가능하다.
    // List<LottoBall>을 만드는 기능.
    public static List<LottoBall> createBalls(){
        List<LottoBall> list = new ArrayList<>();
        for(int i=1; i<=45; i++){
            LottoBall ball = new LottoBall(i);
            list.add(ball);
        }
        return list;
    }


}
