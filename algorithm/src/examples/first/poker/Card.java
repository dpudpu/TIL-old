package examples.first.poker;

public class Card {
    private String pattern;
    private int num;

    public Card(String pattern, int num){
        this.pattern=pattern;
        this.num=num;
    }

    public String getPattern() {
        return pattern;
    }

    public int getNum() {
        return num;
    }

    @Override
    public String toString() {
        String strNum = num+"";
        if(num==1)
            strNum="A";
        else if(num==11)
            strNum="J";
        else if(num==12)
            strNum="Q";
        else if(num==13)
            strNum="K";

        return pattern+""+strNum;
    }
}