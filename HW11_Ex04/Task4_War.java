package bg.swift.HW11_Ex04;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Task4_War {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int numberOfCards = sc.nextInt();
		sc.nextLine();
		String firstLine = sc.nextLine();
		String secondLine = sc.nextLine();
		String[] firstInput = firstLine.split(" ");
		String[] secondInput = secondLine.split(" ");
		
		List<CardRank> firstPlayerHand = createPlayerHand(firstInput, numberOfCards);
		List<CardRank> secondPlayerHand = createPlayerHand(secondInput, numberOfCards);
		
		int round = 0;
		boolean hasDraw = false;
		
		while(firstPlayerHand.size() != 0 && secondPlayerHand.size() != 0 && !hasDraw) {		
			hasDraw = duel(firstPlayerHand, secondPlayerHand);
			round++;
		}
		
		if(hasDraw) {
			System.out.println("Game is draw on round " + round + ".");
		} else {
			printResult(firstPlayerHand, secondPlayerHand, round);
		}
		sc.close();
	}
	
	private static List<CardRank> createPlayerHand(String[] input, int numberOfCards){
		List<CardRank> playerHand = new ArrayList<>();
		CardRank [] rank = CardRank.values();
		
		for(int i = 0; i < numberOfCards; i++) {
			String temp = String.valueOf(input[i].charAt(0));
			for(int j = 0; j < rank.length; j++) {
				if(rank[j].getName().equals(temp)) {
					playerHand.add(rank[j]);
					break;
				}
			}
		}
		return playerHand;
	}
	
	private static boolean duel(List<CardRank> firstPlayerHand, List<CardRank> secondPlayerHand) {
		if(firstPlayerHand.get(0).getPoints() > secondPlayerHand.get(0).getPoints()) {
			firstPlayerHand.add(firstPlayerHand.get(0));
			firstPlayerHand.remove(0);
			firstPlayerHand.add(secondPlayerHand.get(0));
			secondPlayerHand.remove(0);
		} else if(firstPlayerHand.get(0).getPoints() < secondPlayerHand.get(0).getPoints()) {
			secondPlayerHand.add(secondPlayerHand.get(0));
			secondPlayerHand.remove(0);
			secondPlayerHand.add(firstPlayerHand.get(0));
			firstPlayerHand.remove(0);
		} else if (firstPlayerHand.get(0).getPoints() == secondPlayerHand.get(0).getPoints()) {
			if(war(firstPlayerHand, secondPlayerHand)) {
				return true;
			}
		}
		return false;
	}
	
	private static boolean war(List<CardRank> firstPlayerHand, List<CardRank> secondPlayerHand) {
		int sumOfPointsOnFirstPlayer = 0;
		int sumOfPointsOnSecondPlayer = 0;
		List<CardRank> temp1 = new ArrayList<>();
		List<CardRank> temp2 = new ArrayList<>();
		if (firstPlayerHand.size() > 3 && secondPlayerHand.size() > 3) {
			for (int i = 1; i <= 3; i++) {
				sumOfPointsOnFirstPlayer += firstPlayerHand.get(i).getPoints();
				temp1.add(firstPlayerHand.get(i));
				sumOfPointsOnSecondPlayer += secondPlayerHand.get(i).getPoints();
				temp2.add(secondPlayerHand.get(i));
			}
			if (sumOfPointsOnFirstPlayer > sumOfPointsOnSecondPlayer) {
				firstPlayerHand.add(1, secondPlayerHand.get(0));
				firstPlayerHand.addAll(temp2);
				for(int i = 0; i <= 3; i++) {
					secondPlayerHand.remove(0);
				}
			} else if (sumOfPointsOnFirstPlayer < sumOfPointsOnSecondPlayer) {
				secondPlayerHand.add(1, firstPlayerHand.get(0));
				secondPlayerHand.addAll(temp1);
				for(int i = 0; i <= 3; i++) {
					firstPlayerHand.remove(0);
				}
			} else {
				return true;
			}
		} else {
			for (int i = 1; i < firstPlayerHand.size(); i++) {
				sumOfPointsOnFirstPlayer += firstPlayerHand.get(i).getPoints();
				temp1.add(firstPlayerHand.get(i));
				
			}
			for(int i = 1; i < secondPlayerHand.size(); i++) {
				sumOfPointsOnSecondPlayer += secondPlayerHand.get(i).getPoints();
				temp2.add(secondPlayerHand.get(i));
			}
			if (sumOfPointsOnFirstPlayer > sumOfPointsOnSecondPlayer) {
					firstPlayerHand.add(1, secondPlayerHand.get(0));
					firstPlayerHand.addAll(temp2);
					secondPlayerHand.removeAll(secondPlayerHand);
				} else if (sumOfPointsOnFirstPlayer < sumOfPointsOnSecondPlayer) {
					secondPlayerHand.add(1, firstPlayerHand.get(0));
					secondPlayerHand.addAll(temp1);
					firstPlayerHand.removeAll(firstPlayerHand);
				} else {
					return true;
				}
		}
		return false;
	}

	private static void printResult(List<CardRank> firstPlayerHand, List<CardRank> secondPlayerHand, int round) {
		if(firstPlayerHand.size() == 0) {
			System.out.println("Player 2 wins on round " + round + ".");
		} else {
			System.out.println("Player 1 wins on round " + round + ".");
		}
	}
}
