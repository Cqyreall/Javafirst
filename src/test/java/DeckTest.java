import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class DeckTest {

    Deck deck;
    Suites suite;
    Values value;
    Player cyril;
    ArrayList<Card> playersHand;
    ArrayList<Card> player2Hand;
    Player john;

    @Before
    public void before(){
        deck = new Deck();
        playersHand = new ArrayList<Card>();
        player2Hand = new ArrayList<Card>();
        cyril = new Player("Cyril", playersHand);
        john = new Player("John", player2Hand);
    }

    @Test
    public void suiteHasValues(){
        assertEquals("Spade", Array.get(Suites.SUITES.getSuite(), 0));
    }

    @Test
    public void deckHas52Cards(){
        assertEquals(52, deck.populateDeck(Suites.SUITES.getSuite(), Values.VALUES.getValues()).size());
    }

    @Test
    public void deckDealsPlayer(){
        Deck gameDeck = new Deck();
        ArrayList<Card> populatedDeck = deck.populateDeck(Suites.SUITES.getSuite(), Values.VALUES.getValues());
        gameDeck.setCardDeck(populatedDeck);
        gameDeck.deal(cyril);
        assertEquals(51, gameDeck.getCardDeck().size());
        assertEquals(1, cyril.getCards().size());
    }

    @Test
    public void playGame(){
        Deck gameDeck  = new Deck();
        ArrayList<Card> populatedDeck = deck.populateDeck(Suites.SUITES.getSuite(), Values.VALUES.getValues());
        gameDeck.setCardDeck(populatedDeck);
        String winner = gameDeck.playGame(cyril, john);
        assertEquals(50, gameDeck.getCardDeck().size());
        assertEquals(1, cyril.getCards().size());
        assertEquals(1, john.getCards().size());
//        assertEquals("The winner is Cyril", winner);
    }






}
