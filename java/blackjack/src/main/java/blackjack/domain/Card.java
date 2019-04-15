package blackjack.domain;

public class Card {
    private Pattern pattern;
    private Numeric numeric;

    public Card(Pattern pattern, Numeric numeric) {
        this.pattern = pattern;
        this.numeric = numeric;
    }

    public Pattern getPattern() {
        return pattern;
    }

    public Numeric getNumeric() {
        return numeric;
    }

    @Override
    public String toString() {
        return "["+pattern + ", " + numeric+"] ";
    }

    public enum Pattern {
        SPADE("spade"),
        HEART("heart"),
        DIAMOND("diamond"),
        CLUB("club");

        private String pattern;

        Pattern(String pattern) {
            this.pattern = pattern;
        }
    }

    public enum Numeric {
        ACE("A", 1),
        TWO("2", 2),
        THREE("3", 3),
        FOUR("4", 4),
        FIVE("5", 5),
        SIX("6", 6),
        SEVEN("7", 7),
        EIGHT("8", 8),
        NINE("9", 9),
        TEN("10", 10),
        JACK("J", 10),
        QUEEN("Q", 10),
        KING("K", 10);

        private String mark;
        private int point;

        Numeric(String mark, int point) {
            this.mark = mark;
            this.point = point;
        }

        public int getPoint() {
            return point;
        }
    }
}
