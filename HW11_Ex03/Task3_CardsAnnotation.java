package bg.swift.HW11_Ex03;

public class Task3_CardsAnnotation {

	public static void main(String[] args) {
		CardsAnnotation cardAnnotation = Card.class.getAnnotation(CardsAnnotation.class);
		CardsAnnotation cardSuitAnnotation = CardSuit.class.getAnnotation(CardsAnnotation.class);
		CardsAnnotation cardRankAnnotation = CardRank.class.getAnnotation(CardsAnnotation.class);
		
		printAnnotation(new Card(CardSuit.DIAMONDS, CardRank.ACE), cardAnnotation);
		printAnnotation(CardRank.ACE, cardRankAnnotation);
		printAnnotation(CardSuit.DIAMONDS, cardSuitAnnotation);
	}

	private static void printAnnotation(Object other, CardsAnnotation annotation) {
		if (other instanceof Card) {
			System.out.printf("%s %s %s%n", ((Card) other).getClass().getSimpleName(), annotation.type(),
					annotation.description());
			return;
		} else if (other.equals(CardRank.ACE)) {
			System.out.printf("%s %s %s%n", CardRank.class.getSimpleName(), annotation.type(),
					annotation.description());
			return;
		} else {
			System.out.printf("%s %s %s%n", CardSuit.class.getSimpleName(), annotation.type(),
					annotation.description());
			return;
		}
	}
}
