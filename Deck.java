package Solitaire;

import java.util.Random;

public class Deck {

	private Card [ ] storage;
	private Random r;
	private int top;
	
	public Deck()
	{
		char [] suits = {'H', 'D', 'S', 'C'};
		char [] ranks = {'A', '2', '3', '4', '5', '6', '7', '8', '9', (char)(10), 'J', 'Q', 'K'};
		storage = new Card[52];
		top = 0; //top card in the deck
		
		int count = 0;
		Card C1;
		for(int s = 0; s < suits.length; s++)
			for(int r = 0; r < ranks.length; r++)
			{
				C1 = new Card(ranks[r], suits[s]);
				storage[count++] = C1;
			}
		System.out.println("");
	}
	
	public void display()
	{
		for(Card x:storage)
		{
			char rank = x.getRank();
			char suit = x.getSuit();
			
			if(rank == ((char)(10))) System.out.println(String.format("10%c", suit));
			else System.out.print(String.format("%c%c ", rank, suit));
		}
		System.out.println("\n");
	}

	public void shuffle()
	{
		r = new Random();
		Card temp;
		Card temp2;
		
		for(Card x:storage)
		{
			int num = r.nextInt(storage.length);
			int num2 = r.nextInt(storage.length);
			if(num2 == num) r.nextInt(storage.length);
			
			temp = storage[num];
			temp2 = storage[num2];
			
			storage[num] = temp2;
			storage[num2] = temp;
		}
		System.out.println("");
	}
	
	public Card deal()
	{
		return storage[top];
	}
	
	public int cardsLeft() //how many cards are left in the deck
	{
		int left = storage.length - top;
		if(top != 52) top++;
		else top = 0;

		return left;
	}
}
