package examples.first.exam01;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NHLottoMachine implements LottoMachine {
    private List<LottoBall> balls;

    @Override
    public void put(List<LottoBall> balls) {
        this.balls=balls;
    }

    @Override
    public void mix() {
        Collections.shuffle(balls); // 섞어주는 static 변수
    }

    @Override
    public List<LottoBall> getBalls() {
        List<LottoBall> result = new ArrayList<>();
        for(int i=0; i<6; i++){
            result.add(balls.get(i)); // balls가 6개라는 가정하에 작성 - (에러가 발생 할 수 있다는 가정하에 작성)
        }
        return result;
    }


}
