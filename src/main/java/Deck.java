import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Deck {

    private ArrayList<Card> cardDeck;

    public Deck() {
        this.cardDeck = new ArrayList<Card>();
    }

    public ArrayList<Card> getCardDeck() {
        return cardDeck;
    }

    public void setCardDeck(ArrayList<Card> cardDeck) {
        this.cardDeck = cardDeck;
    }

    public ArrayList<Card> populateDeck(String[] suites, String[] value){
        int cardValue = 0;
        for(int i = 0; i < suites.length; i++){
           Object currentSuite = Array.get(suites, i);
           String cardSuite = currentSuite.toString();
            for(int j = 0; j < value.length; j++){
                Object currentCard = Array.get(value, j);
                String cardStringValue = currentCard.toString();
                if(cardStringValue == "King" || cardStringValue == "Queen" || cardStringValue == "Judge"){
                    cardValue = 10;
                }
                else if(cardStringValue == "Ace"){
                    cardValue = 11;
                }
                else{
                    cardValue = Integer.parseInt(cardStringValue);
                }
                Card newCard = new Card(cardSuite, cardValue);
                this.cardDeck.add(newCard);
            }
        }
        return this.cardDeck;
    }

    public void shuffleCards(ArrayList<Card> deck){
         Collections.shuffle(deck);
    }

    public void deal(Player newPlayer){
        Random randomSelection = new Random();
        int index = randomSelection.nextInt(this.cardDeck.size());
        Card dealtCard = this.cardDeck.get(index);
        newPlayer.getCards().add(dealtCard);
        this.cardDeck.remove(index);

    }


    public String playGame(Player firstPlayer, Player secondPlayer) {
        String winningStatement = "";
        this.deal(firstPlayer);
        int firstPlayerCardValue = firstPlayer.getCards().get(0).getValue();
        this.deal(secondPlayer);
        int secondPlayerCardValue = secondPlayer.getCards().get(0).getValue();
        if(firstPlayerCardValue > secondPlayerCardValue){
            winningStatement = String.format("The winner is %s", firstPlayer.getName());
        }
        else if (firstPlayerCardValue < secondPlayerCardValue){
            winningStatement = String.format("The winner is %s", secondPlayer.getName());
        }
        else {
            winningStatement = "No Victor";
        }

        System.out.println(firstPlayerCardValue);
        System.out.println(secondPlayerCardValue);
        return winningStatement;
    }

    public String playBlackJack(Player dealer, Player player) {
        String winningStatement = "";

        for(int i = 0; i < 2; i++){
            this.deal(dealer);
            this.deal(player);
        }

        int dealer1CardValue = dealer.getCards().get(0).getValue();
        int dealer2CardValue = dealer.getCards().get(1).getValue();
        int dealerTotal = dealer1CardValue + dealer2CardValue;

        int firstPlayer1CardValue = player.getCards().get(0).getValue();
        int firstPlayer2CardValue = player.getCards().get(1).getValue();
        int firstplayer3CardValue = 0;
        int playerTotal = firstPlayer1CardValue + firstPlayer2CardValue;

        if(playerTotal < 13){
            this.deal(player);
            firstplayer3CardValue = player.getCards().get(2).getValue();
            playerTotal += firstplayer3CardValue;
        }

        if (dealerTotal < 16){
            this.deal(dealer);
            int dealer3CardValue = dealer.getCards().get(2).getValue();
            dealerTotal += dealer3CardValue;
        }

        if(playerTotal > 21){
            if(firstPlayer1CardValue == 11){
                firstPlayer1CardValue  = 1;
            }
            else if(firstPlayer2CardValue == 11){
                firstPlayer2CardValue = 1;
            }
            else if(firstplayer3CardValue == 11){
                firstplayer3CardValue = 1;
            }
            playerTotal = firstPlayer1CardValue + firstPlayer2CardValue;
        }

        if(playerTotal > 21){
            player.setTwist(true);
            winningStatement = String.format("%s wins!! total(%d) vs (%s  %d)", dealer.getName(), dealerTotal, player.getName(), playerTotal);
        }
        else if(dealerTotal > 21){
            dealer.setTwist(true);
            winningStatement = String.format("%s wins!! total(%d) vs (%s  %d)", player.getName(), playerTotal, dealer.getName(), dealerTotal);

        }
        else if(!dealer.isTwist() && !player.isTwist()){
            if(dealerTotal > playerTotal){
                winningStatement = String.format("%s wins!! total(%d) vs (%s  %d)", dealer.getName(), dealerTotal, player.getName(), playerTotal);
            }
            else if(playerTotal > dealerTotal){
                winningStatement = String.format("%s wins!! total(%d) vs (%s  %d)", player.getName(), playerTotal, dealer.getName(), dealerTotal);
            }

            else {
                winningStatement = String.format("Play Again dealer(%d), player(%d)", dealerTotal, playerTotal );
            }
        }


        System.out.println(dealer1CardValue);
        System.out.println(dealer2CardValue);
        System.out.println(dealerTotal);
        System.out.println(" ");
        System.out.println(firstPlayer1CardValue);
        System.out.println(firstPlayer2CardValue);
        System.out.println(firstplayer3CardValue);
        System.out.println(playerTotal);

        return winningStatement;
    }
}
