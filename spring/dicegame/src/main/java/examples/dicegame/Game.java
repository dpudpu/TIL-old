package examples.dicegame;

import java.util.List;

public class Game {
    List<Player> playerList;


    public Game(){
        System.out.println("Game()");
    }

    public void setPlayerList(List<Player> list){
        System.out.println("Game.setPalyerList()");
        this.playerList = list;
    }

    public void play(){
        System.out.println("Game.play()");

        int max=0;
        String name="";
        for(Player p : playerList) {
            p.play();
            if(max<p.getDice().getNumber()) {
                max = p.getDice().getNumber();
                name=p.getName();
            }
        }
        System.out.println(name+"이 승리하였습니다.");
    }
}
