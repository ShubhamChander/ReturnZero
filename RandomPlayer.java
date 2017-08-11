import java.util.Arrays;
import java.util.ArrayList;
import java.util.Stack;

public class RandomPlayer extends Player{

	public RandomPlayer(Card [] cards){
		this.hand = new ArrayList<Card>(Arrays.asList(cards));
	}
	
	
	//The Play Method
	public boolean play(DiscardPile discardPile, Stack<Card> drawPile, ArrayList<Player> players){
		Card topOfDiscard = discardPile.top();
		int i = 0;
		boolean cardPlayed = false;
		while(i < this.hand.size() || cardPlayed == false){
			if((topOfDiscard.getSuit().equals(this.hand.get(i).getSuit())) || topOfDiscard.getRank() == this.hand.get(i).getRank()){
				discardPile.add(this.hand.get(i));
				cardPlayed = true;
			}
			else{
				//pick up a card and check to see if that equals topofdiscard card and play 
				Card newCard = drawPile.pop();
				if(topOfDiscard.getSuit().equals(newCard.getSuit()) || topOfDiscard.getRank() == newCard.getRank()){
					discardPile.add(this.hand.get(i));
				}
				else{
					this.hand.add(newCard);
				}
				cardPlayed = true; 
			}
		}
		if(this.hand.size() == 0){
			return true;
		}
		return false; 
	}
	
}

