package pkgCore;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.*;


import java.util.ArrayList;
import java.util.Collections;

import pkgEnum.eRank;
import pkgEnum.eSuit;

public class Deck {

	private ArrayList<Card> cardsInDeck;

	public Deck() {
		cardsInDeck = new ArrayList<Card>();
		for (eSuit eSuit : eSuit.values()) {
			for (eRank eRank : eRank.values()) {
				cardsInDeck.add(new Card(eSuit, eRank));
			}
		}
		
		Collections.shuffle(cardsInDeck);
	}


	//TODO: Fix the Draw method so it throws an exception if the deck is empty
	public Card Draw() {
		
		return cardsInDeck.remove(0);
	}
	
	
	public Card Draw (eSuit eSuit) {
		for (Card c : this.cardsInDeck) {
			if (c.geteSuit() == eSuit) {
				cardsInDeck.remove(c);
				return c;
			}
		}
		return null;
	}
	
	
	public Card Draw (eRank eRank) {
		for (Card c : this.cardsInDeck) {
			if (c.geteRank() == eRank) {
				cardsInDeck.remove(c);
				return c;
			}
		}
		return null;
	}
	
	
	public int cardCount (eSuit eSuit) {
		
		List<Card> cards_eSuit = cardsInDeck.stream().filter(c -> c.geteSuit() == eSuit).collect(Collectors.toCollection(ArrayList::new));
		return cards_eSuit.size();
		
	}
	
	
	public int cardCount (eRank eRank) {
		
		List<Card> cards_eRank = cardsInDeck.stream().filter(c -> c.geteRank() == eRank).collect(Collectors.toCollection(ArrayList::new));
		return cards_eRank.size();
		
	}
	
	
	public int Count(Card c) {
		ArrayList<Card> cards_Rank = cardsInDeck.stream().filter(p -> p.geteRank() == c.geteRank())
				.collect(Collectors.toCollection(ArrayList::new));
		ArrayList<Card> cards_Suit = cards_Rank.stream().filter(p -> p.geteSuit() == c.geteSuit())
				.collect(Collectors.toCollection(ArrayList::new));
		return cards_Suit.size();

	}

	
}
