package bg.swift.HW11_Ex04;

public enum CardRank {
	TWO(2, "2"), 
	THREE(3, "3"), 
	FOUR(4, "4"), 
	FIVE(5, "5"), 
	SIX(6, "6"), 
	SEVEN(7, "7"), 
	EIGHT(8, "8"), 
	NINE(9, "9"), 
	TEN(10, "T"), 
	JACK(11, "J"), 
	QUEEN(12, "Q"), 
	KING(13, "K"), 
	ACE(14, "A");
	
	private int points;
	private String name;
	
	CardRank (int points, String name) {
		this.points = points;
		this.name = name;
	}
	
	public int getPoints() {
		return points;
	}
	
	public String getName() {
		return name;
	}
}
