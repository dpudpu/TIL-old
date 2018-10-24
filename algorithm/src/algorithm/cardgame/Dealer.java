package algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Dealer {
    String name;
    int index;
    List<Card> cardList;
    List<Player> playerList;

    public Dealer(String name){
        this.name=name;
        this.index=0;
    }

    public void setCard(List<Card> cards){
        cardList=cards;
    }

    public void setPlayers(List<Player> player){
        playerList=player;
    }

    public void newGame(){
        index=0;
        for(Player player : playerList){
//            player.clear();
        }
    }

    public void cardMix(){
        Collections.shuffle(cardList);
    }

    public Card getCard() {
        return cardList.get(index++);
    }

    public void getResult(){
        List<Card> cardResult = new ArrayList<>();
        List<Integer> sum= new ArrayList<Integer>();
        List<String> pName = new ArrayList<String>();

        for(Player p : playerList){ // 플레이별로 숫자 합 계산 후 입력.
            pName.add(p.toString());
            cardResult=p.getCard();

            int sum1=0;
            for(Card r : cardResult)
               sum1 +=r.getCardNum();
            sum.add(sum1);
        }


        for(int i=0; i<playerList.size();i++){
            if(sum.get(i)== Collections.max(sum))
                System.out.println(pName.get(i)+" 게임 승리");
        }


        System.out.println();
    }
}
