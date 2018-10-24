package algorithm;

import java.util.ArrayList;
import java.util.List;

public class CardGame {
    public static void main(String[] args){
        List<Card> cards = CardFactory.create();

//        for(Card card: cards){
//            System.out.println(card);
//        }


        Dealer d = new Dealer("딜러");
        d.setCard(cards);

        List<Player> playerList = new ArrayList<Player>();
        playerList.add(new Player("배"));
        playerList.add(new Player("대"));
        playerList.add(new Player("준"));



        d.setPlayers(playerList);

        d.newGame();

        d.cardMix();

        for(int i=0; i<5; i++){
            for(Player player : playerList){
                player.addCard(d.getCard());
            }
        }
        // 3번 호출
        d.getResult();



    }
}
