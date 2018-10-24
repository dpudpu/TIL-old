package examples.first.poker;

import java.util.ArrayList;
import java.util.List;

public class PokerGame {
    public static void main(String args[]){

        // Dealer, Player, Card, CardFactory 클래스  필요

        // 카드 생성 (문양, 숫자)
        List<Card> cards = CardFactory.create();

        // 딜러 생성
        Dealer dealer = new Dealer("딜러");
        dealer.setCardList(cards);

        // 플레이어 생성
        List<Player> playerList = new ArrayList<Player>();
        playerList.add(new Player("A"));
        playerList.add(new Player("B"));
        playerList.add(new Player("C"));
        dealer.setPlayerList(playerList);

        // 게임 시작
        dealer.newGame();
        // 카드 믹스
        dealer.cardMix();

        // 플레이어별 카드 5장씩 분배
        for(int cnt=0; cnt<5; cnt++ ) {
            for (Player p : playerList) {
                p.addCard(dealer.getCard());
            }
        }

        // 플레이어 패 확인 & 승자 확인
        dealer.result();

        // Dealer (게임시작, 카드 섞기, 분배, 결과)
        // Player (카드받기, 카드주기)
        // 카드

    }
}
