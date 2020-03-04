/*
 * Frank Mancia
 * CECS 274-05
 * Prog #2 - Solitaire Prime
 * Due Mar 3 2020
 */

package Solitaire;

import java.util.Scanner;

public class Solitaire {
	
	public static boolean isPrime(int x)
	{
		if((x % 2) == 0) return false; //not prime
		else return true; //is prime
		
	}
	
	public static int menu() //return the menu option the user typed 
	
	{ 
		int in;
		Scanner scnr = new Scanner(System.in);
		
		System.out.print("1. New Deck \n2. Display Deck\n3. Shuffle Deck\n4. Play Game\n5. Exit\n6. Simulate 1000 Games\nOption: ");
		
		in = scnr.nextInt();
		
		if(in == 5) scnr.close();
		
		return in;
	}

	public static boolean playSolitairePrime(Deck deck)
	{
		Card face = deck.deal();
		int iVal = face.getValue();
		int total = 0;
		int count = 0;
		int rem = deck.cardsLeft();
		
		while(rem != 1)
		{
			iVal = face.getValue();
			total += iVal;
			face.display();
			
			if(isPrime(iVal) == true) //If it is prime
			{
				System.out.println("Prime: " + total);

				count++;
				total = 0;
			}
		
			//count++;
			face = deck.deal();
			rem = deck.cardsLeft();
		}// end of while
		if(isPrime(iVal) == false) 
		{
			System.out.println("Loser\n");
			rem = deck.cardsLeft();
			return false; //lose game
		}
		else 
		{
			System.out.println("\nWinner in "+ count + " piles!\n");
			rem = deck.cardsLeft();
			return true; //win game
		}
		
	}
	
	public static void main(String[] args) 
	{
		System.out.println("Welcome to Solitaire Prime!\n----------------");

		Deck myDeck = null;
		int choice = menu();
		
		while(choice != 5) {
			if(choice == 6)
			{
				int win = 0;
				int lose = 0;
				for(int i = 0; i < 1000; i++)
				{
					myDeck = new Deck();
					myDeck.shuffle();
					if(playSolitairePrime(myDeck) == true) win++;
					else lose++;
				}
				System.out.println("In 1000 games, you won: " + win + " and lost: " + lose + "\n");
			}
			
			if(choice == 1) myDeck = new Deck();
			
			if(choice == 2) myDeck.display();
			
			if(choice == 3) myDeck.shuffle();
			
			if(choice == 4) 
			{
				System.out.println("\nPlaying Solitaire Prime!!!\n");
				playSolitairePrime(myDeck);
			}
			
			if(choice == 5) System.exit(0);
			
			choice = menu();
		}
	}

}
