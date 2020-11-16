import java.util.ArrayList;

public class Runner {

    public static void main(String[] args) {
        Deck deck = new Deck();
        ArrayList<Card> playersHand = new ArrayList<Card>();
        ArrayList<Card>dealerHand = new ArrayList<Card>();
        Player cyril = new Player("Cyril", playersHand);
        Player  dealer = new Player("Dealer", dealerHand);
        Deck gameDeck  = new Deck();
        ArrayList<Card> populatedDeck = deck.populateDeck(Suites.SUITES.getSuite(), Values.VALUES.getValues());
        gameDeck.setCardDeck(populatedDeck);
        System.out.println(gameDeck.playBlackJack(dealer, cyril));
    }
}
