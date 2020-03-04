package Solitaire;

public class Card {
	private char suit; // suit is like hearts or diamonds
	private char rank; // rank is the number or ace or king
	
	public  Card(char r, char s) // constructor 
	{
		rank = r;
		suit = s;
	}
	
	public void display()
	{
		// need to compete example: Ace of Heart = AH
		// Queen of Diamonds = QD
		// Three of Clubs = 3C
		// Ten of Spades = 10S
		
		if((int)rank == 10) System.out.printf("10%c, ", suit);
		else System.out.printf("%c%c, ", rank, suit);
	}
	
	public int getValue()
	{	
		int v;
		
		if(rank == 'A') v = 1;
		else if(rank == 'J' || rank == 'Q' || rank == 'K' || (int)rank == 10) v = 10;
		else v = rank - '0';
		
		return v;
	}
	
	public char getRank()
	{
		return this.rank;
	}
	
	public char getSuit()
	{
		return this.suit;
	}
	
}
