package algorithm;

import java.util.ArrayList;
import java.util.List;

public class CardFactory {
    private CardFactory(){
    }



    public static List<Card> create(){
        String[] pattern = new String[]{"♥","♣","♠","◆"};
        List<Card> list = new ArrayList<Card>();

        for(int i=0; i<pattern.length; i++){
            for(int num=1; num<=12; num++){
                Card card = new Card(pattern[i], num);
                list.add(card);
            }//숫자
        }//패턴
        return list;
    }//메소드

}
