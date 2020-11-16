import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class BlackJackTest {

    Player cyril;
    Player dealer;
    Deck deck;
    Suites suites;
    Values values;
    ArrayList<Card> playerHand;
    ArrayList<Card> dealerHand;

    @Before
    public void before(){
        deck = new Deck();
        playerHand = new ArrayList<Card>();
        dealerHand = new ArrayList<Card>();
        cyril = new Player("Cyril", playerHand);
        dealer = new Player("Dealer", dealerHand);
    }

    @Test
    public void playBlackJacks(){
        Deck gameDeck  = new Deck();
        ArrayList<Card> populatedDeck = deck.populateDeck(Suites.SUITES.getSuite(), Values.VALUES.getValues());
        gameDeck.setCardDeck(populatedDeck);
        gameDeck.playBlackJack(dealer, cyril);
//        assertEquals(48, gameDeck.getCardDeck().size());
    }
}
