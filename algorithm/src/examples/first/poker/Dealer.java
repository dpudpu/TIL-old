package examples.first.poker;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Dealer {
    private String name;
    private List<Player> playerList;
    private List<Card> cardList;
    private int index;

    public Dealer(String name){
        this.name=name;
        this.index=0;
    }

    public void setPlayerList(List<Player> playerList) {
        this.playerList = playerList;
    }

    public void setCardList(List<Card> cardList) {
        this.cardList = cardList;
    }

    public void newGame(){
        index=0;
    }
    public void cardMix(){
        Collections.shuffle(cardList);
    }

    public Card getCard(){
        return cardList.get(index++);
    }
//    public void result(){
//        for(Player p : playerList){
//            System.out.print(p.getName()+"의 카드 : ");
//            List<Card> card = p.getCards();
//            for(Card c : card){
//                System.out.print(c+" ");
//            }
//            System.out.println();
//        }
//    }

    public void result(){
        List<Integer> count = new ArrayList<Integer>();


        for(Player p : playerList){
            System.out.print(p.getName()+"의 카드 : ");
            List<Card> card = p.getCards();
            int pair1=0;
            int pair2=0;
            int pair1Num=0;
            int pair2Num=0;

            for(Card c : card){
                System.out.print(c.toString()+" ");
            }// 카드 번호 출력

            for(int i=0; i<card.size();i++){
                for(int j=i+1; j<card.size();j++){
                    if(card.get(i).getNum()==card.get(j).getNum()) {
                        pair1Num=card.get(i).getNum();
                        pair1++;
                    }
                }
            } // 겹치는 숫자 확인
            count.add(pair1);
            System.out.println("   겹 : "+pair1);
        }

        for(int i=0; i<playerList.size();i++){
            if(count.get(i)== Collections.max(count)){
                    System.out.println(playerList.get(i).getName() + " 게임 승리");
                }
        }

    }// result 메소드


}
