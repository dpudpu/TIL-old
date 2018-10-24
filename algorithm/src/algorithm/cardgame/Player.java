package algorithm;

import java.util.ArrayList;
import java.util.List;

public class Player{
    String name;
    List<Card> cardList;

    public Player(String name){
        this.name = name;
        this.cardList = new ArrayList<>();
    }

    public void clear(){
        cardList.clear();
    }

    public void addCard(Card card){
        cardList.add(card);
    }

    @Override
    public String toString() {
        return name;
    }

    public List<Card> getCard(){
        System.out.print(name+"의 카드 : ");
        for(Card cards : cardList)
            System.out.print(cards);
        System.out.println();

        return cardList;
    }
}
