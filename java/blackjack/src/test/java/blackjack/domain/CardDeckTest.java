package blackjack.domain;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.List;

public class CardDeckTest {
    private CardDeck cardDeck;
    private List<Card> cards;

    @Before
    public void setup() {
        cardDeck = new CardDeck();
        cards = cardDeck.getCards();
    }

    @Test
    public void 카드덱생성_테스트() {
        Assert.assertEquals(52, cards.size());
    }

    @Test
    public void 패턴_테스트() {
        assertThat(cards.get(0).getPattern(), is(Card.Pattern.SPADE));
    }
}
