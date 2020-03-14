package bg.swift.HW11_Ex03;

@CardsAnnotation(description = "Represents a card object used to play games with.", type = "class")
public class Card implements Comparable<Card> {
	private CardSuit cardSuit;
	private CardRank cardRank;
	
	public Card(CardSuit suit, CardRank rank) {
		this.cardRank = rank;
		this.cardSuit = suit;
	}
	
	@Override
	public String toString() {
		return cardRank.name() + " of " + cardSuit.name();
	}

	@Override
	public int compareTo(Card t) {
		return this.cardRank.numeration - t.cardRank.numeration;
	}

}
