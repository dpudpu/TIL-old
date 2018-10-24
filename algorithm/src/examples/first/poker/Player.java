package examples.first.poker;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private String name;
    private List<Card> cardList;

    public Player(String name) {
        this.name = name;
        cardList=new ArrayList<Card>();
    }

    public String getName() {
        return name;
    }

    public void addCard(Card card){
        cardList.add(card);
    }
    public void clear(){
        cardList.clear();
    }
    public List<Card> getCards(){
        return cardList;
    }
}
