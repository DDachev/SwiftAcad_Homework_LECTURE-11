package bg.swift.HW11_Ex02;

import java.util.ArrayList;
import java.util.List;

public class Task2_Deck {

	public static void main(String[] args) {
		List<Card> deck = new ArrayList<>();
		CardSuit[] suit = CardSuit.values();

		for (int i = 0; i < suit.length; i++) {
			deck.addAll(createDeckOfSuit(suit[i]));
		}

		for (Card i : deck) {
			System.out.println(i.toString());
		}
	}

	private static List<Card> createDeckOfSuit(CardSuit suit) {
		ArrayList<Card> cards = new ArrayList<>();
		CardRank[] ranks = CardRank.values();
		for (int i = 0; i < ranks.length; i++) {
			cards.add(new Card(suit, ranks[i]));
		}
		return cards;
	}
}
