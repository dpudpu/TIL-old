package blackjack.domain;

import java.util.Collections;
import java.util.Stack;

public class CardDeck {
    private Stack<Card> cards = new Stack<>();

    public CardDeck() {
        generateCards();
        Collections.shuffle(cards);
    }

    private void generateCards() {
        for (Card.Pattern pattern : Card.Pattern.values()) {
            for (Card.Numeric numeric : Card.Numeric.values()) {
                cards.add(new Card(pattern, numeric));
            }
        }
    }

    public Stack<Card> getCards() {
        return cards;
    }

    @Override
    public String toString() {
        return "CardDeck{" + cards.toString() + '}';
    }
}
