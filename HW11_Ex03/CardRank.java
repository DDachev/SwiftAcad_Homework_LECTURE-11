package bg.swift.HW11_Ex03;

@CardsAnnotation(description = "Contains a set of constants for the ranks of a card.", type = "enum")
public enum CardRank {
	TWO(2), 
	THREE(3), 
	FOUR(4), 
	FIVE(5), 
	SIX(6), 
	SEVEN(7), 
	EIGHT(8), 
	NINE(9), 
	TEN(10), 
	JACK(11), 
	QUEEN(12), 
	KING(13), 
	ACE(14);
	public int numeration;
	
	CardRank (int numeration) {
		this.numeration = numeration;
	}
}
