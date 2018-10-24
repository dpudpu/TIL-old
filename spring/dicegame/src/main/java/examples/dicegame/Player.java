package examples.dicegame;

public class Player {
    private String name;
    private Dice dice;

    public Player(){
        System.out.println("Player()");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Dice getDice() {
        return dice;
    }

    public void setDice(Dice dice) {
        this.dice = dice;
    }

    public void play(){
        System.out.println(name+"가 주사위를 던져"+dice.getNumber()+" 나왔습니다.");
    }
}
