package _06_Card_Game;

public class Card {

    private final Rank rank;
    private final Suit suit;

    public Card(Rank rank, Suit suit) {
        this.rank = rank;
        this.suit = suit;
    }
    
    enum Suit {
    	HEARTS, CLUBS, SPADES, DIAMONDS
    }
    
    enum Rank {
    	TWO(2), THREE(3), FOUR(4), FIVE(5), SIX(6), SEVEN(7), EIGHT(8), NINE(9), TEN(10), JACK(10), QUEEN(10), KING(10), ACE(11);
    	public int value;
    	
    	private Rank (int value) {
    		this.value = value;
    	}
    	
    	public int getValue() {
    		return value;
    	}

    }

    public Rank getRank() {
        return rank;
    }

    public Suit getSuit() {
        return suit;
    }
    
  
    public String toString() {
        return rank + " of " + suit;
    }

}
