package examples.first.poker;

import java.util.ArrayList;
import java.util.List;

// 추상클래스로 인스턴스 생성 불가
public abstract class CardFactory {

    public static List<Card> create(){
         String[] pattern = new String[]{"♥","♣","♠","◆"};
         List<Card> list = new ArrayList<Card>();

        for(String p : pattern){
            for(int i=1; i<=13; i++) {
                Card card = new Card(p, i);
                list.add(card);
            }
        }
        return list;
    }//create 메소드 끝

}
