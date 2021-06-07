package blackjack;

import java.util.ArrayList;
import java.util.List;

public class Dealer {
    private final String[] suits = { "Clubs", "Diamonds", "Hearts", "Spades" };
    private final String[] ranks = { "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace" };
    private List<Card> deckOfCards = new ArrayList<Card>();

    Dealer(List<Card> deckOfCards) {
        this.deckOfCards = deckOfCards;
    }

    public List<Card> createDeck() {
        // creating the deckOfCards
        for (int i = 0; i < ranks.length; i++) {
            for (int j = 0; j < suits.length; j++) {
                // deck[suits.length * i + j] = ranks[i] + " of " + suits[j];
                Card card = new Card(ranks[i], suits[j]);
                deckOfCards.add(card);
            }
        }

        // shuffling the deck
        int n = suits.length * ranks.length;
        for (int i = 0; i < n; i++) {
            int r = i + (int) (Math.random() * (n - i));
            Card temp = deckOfCards.get(r);
            deckOfCards.set(r, deckOfCards.get(i));
            deckOfCards.set(i, temp);
        }

        return deckOfCards;
    }

    public class Card {
        String suit;
        String rank;

        Card(String rank, String suit) {
            this.rank = rank;
            this.suit = suit;
        }
    }

}
