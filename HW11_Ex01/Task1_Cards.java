package bg.swift.HW11_Ex01;

public class Task1_Cards {

	public enum CardSuit {
		CLUBS, 
		DIAMONDS, 
		HEARTS, 
		SPADES;
	}

	public enum CardRank {
		TWO, 
		THREE, 
		FOUR, 
		FIVE, 
		SIX, 
		SEVEN, 
		EIGHT, 
		NINE, 
		TEN, 
		JACK, 
		QUEEN, 
		KING, 
		ACE;
	}
	
	public static void main(String[] args) {
		CardSuit[] suit = CardSuit.values();
		CardRank[] rank = CardRank.values();
		
		for (int i = 0; i < suit.length; i++) {
			if (i < suit.length - 1) {
				System.out.print(suit[i].name() + ", ");
			} else {
				System.out.print(suit[i].name());
			}
		}
		System.out.println();
		for (int i = 0; i < rank.length; i++) {
			if (i < rank.length - 1) {
				System.out.print(rank[i].name() + ", ");
			} else {
				System.out.print(rank[i].name());
			}
		}
	}
}
