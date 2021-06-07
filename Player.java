package blackjack;

import java.util.ArrayList;
import java.util.List;

public class Player extends Dealer {

    int score = 0;
    List<Card> hand = new ArrayList<Card>();

    Player(List<Card> deckOfCards, int score, List<Card> hand) {
        super(deckOfCards);
        this.score = score;
        this.hand = hand;
    }

    public String nemesisTurn() {
        if (hand.size() == 0) {
            return "H";
        }

        if (score < 17) {
            return "H";
        } else {
            return "S";
        }
    }

    public void scoreOfAce() {
        int tempScore = score;
        if (tempScore + 11 > 21 || tempScore + 1 == 21) {
            findSum("1");
        } else {
            findSum("11");
        }
    }

    public void takeCard(List<Card> deckOfCards) {
        int n = deckOfCards.size();
        int r = (int) (Math.random() * (n));
        hand.add(deckOfCards.get(r));
        deckOfCards.remove(r);
    }

    public String playersHand() {
        StringBuilder myHandStr = new StringBuilder();
        for (int i = hand.size() - 1; i >= 0; i--) {
            myHandStr.append("The ");
            myHandStr.append(hand.get(i).rank);
            myHandStr.append(" of ");
            myHandStr.append(hand.get(i).suit);
            if (i != 0) {
                myHandStr.append("\n");
            }
        }
        if (hand.size() == 0) { // myHandStr.length() == 0
            return "Your hand is empty";
        }
        return myHandStr.toString();
    }

    public boolean isAce() {
        return hand.get(hand.size() - 1).rank.equals("Ace");
    }

    public int findSum(String aceScore) {
        int total = getScore();

        String ranking = hand.get(hand.size() - 1).rank;
        if (ranking.equals("Jack") || ranking.equals("Queen") || ranking.equals("King")) {
            ranking = "10";
        }
        if (ranking.equals("Ace")) {
            ranking = aceScore;
        }
        int temp = Integer.parseInt(ranking);
        total += temp;

        score = total;
        return total;
    }

    public int getScore() {
        return score;
    }
}
