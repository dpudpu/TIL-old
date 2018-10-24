package algorithm;

public class Card {
    private String pattern;
    private int number;

    // 카드 번호 초기화
    public Card(String pattern, int number){
        this.number=number;
        this.pattern=pattern;
    }

    // 카드 번호 호출
    public int getCardNum(){
        return number;
    }

    @Override
    public String toString() {
        String strNum=number+"";
        if(number==1)
            strNum="A";
        else if(number==10)
            strNum="J";
        else if(number==11)
            strNum="Q";
        else if(number==12)
            strNum="K";

        return pattern+" "+strNum;
    }
}
