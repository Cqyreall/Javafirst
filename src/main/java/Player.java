import java.util.ArrayList;

public class Player {

    private String name;
    private ArrayList<Card> cards;
    private boolean twist;

    public Player(String name, ArrayList<Card> cards) {
        this.name = name;
        this.cards = cards;
        this.twist = false;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Card> getCards() {
        return cards;
    }

    public void setCards(ArrayList<Card> cards) {
        this.cards = cards;
    }

    public boolean isTwist() {
        return twist;
    }

    public void setTwist(boolean twist) {
        this.twist = twist;
    }
}
