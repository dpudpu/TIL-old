package examples.first.exam01;

import java.util.List;

public class LottoMain {
    public static void main(String[] args){
        // 로또볼 45개를 준비한다.
        List<LottoBall> list = LottoBallFactory.createBalls();

        LottoMachine machine = new NHLottoMachine(); // 인터페이스가 있으면 인터페이스를 활용.

        // 로또머신에 넣는다.
        machine.put(list);

        // 로또머신의 로또볼을 섞는다.
        machine.mix();

        // 섞인 볼들중에서 6개를 꺼낸다.
        List<LottoBall> result = machine.getBalls();


        // 그 결과를 출력한다.
        for(LottoBall ball : result){
            System.out.print(ball.getNumber()+" ");
        }



    }

}
