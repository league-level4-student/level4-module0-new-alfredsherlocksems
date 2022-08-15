package _06_Card_Game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import _06_Card_Game.Card.Rank;
import _06_Card_Game.Card.Suit;

public class CardDealer implements ActionListener {
    
    ArrayList<Card> deck = new ArrayList<Card>();
    Rank[] ranks = Rank.values();
    Suit[] suit = Suit.values();
    Card card;
    Random ran = new Random();
    ArrayList<Card> player  = new ArrayList<Card>();
    ArrayList<Card> dealer = new ArrayList<Card>();
    JFrame frame;
    JPanel panel;
    JButton hit = new JButton();
    JButton stand = new JButton();
    JLabel card1 = new JLabel();
    JLabel card2 = new JLabel();
    String card2Text;
    
    public void setup() {
    	frame = new JFrame();
    	panel = new JPanel();
    	frame.setVisible(true);
    	frame.setSize(400, 400);
    	frame.add(panel);
    	panel.add(hit);
    	panel.add(stand);
    	hit.setText("hit");
    	stand.setText("stand");
    	hit.addActionListener(this);
    	stand.addActionListener(this);
    	panel.add(card1);
    	panel.add(card2);
    	frame.pack();
    }
    
    public void makeDeck() {
    	for (int i = 0; i < 4; i++) {
        	for (int j = 0; j < ranks.length; j++) {
        		card = new Card(ranks[j], suit[i]);
        		deck.add(card);
        	}
        }
    }
    
    public void shuffle() {
    	Card value;
    	ArrayList<Card> newDeck = new ArrayList<Card>();
    	int random = 0;
    	for(int i = 52; i > 0; i--) {
    		random = ran.nextInt(i );
    		newDeck.add(deck.get(random));
    		deck.remove(random);
    	}
    	deck = newDeck;
    }
    
    public void play() {
    	player.add(deck.get(0));
    	dealer.add(deck.get(1));
    	player.add(deck.get(2));
    	dealer.add(deck.get(3));
    	while (getDealerTotal() < 17) {
    		shuffle();
    		dealer.add(deck.get(0));
    	}
    	if (getDealerTotal() > 21) {
    		winChecker();
    	}
    	//card1.setText(player.get(0).getSuit() + " " + player.get(0).getRank());
    	cardDisplay(player.get(0), card1);
    	cardDisplay(player.get(1), card2);
    	frame.pack();
    }
    
    public void winChecker() {
    	if (getDealerTotal() > 21) {
    		JOptionPane.showMessageDialog(null, "You win with " + getPlayerTotal() + "! The dealer had " + getDealerTotal());
    	}
    	else if (getPlayerTotal() > 21) {
    		JOptionPane.showMessageDialog(null, "You lose with " + getPlayerTotal() + "! The dealer had " + getDealerTotal());
    	}
    	else if(getPlayerTotal() > getDealerTotal()) {
    		JOptionPane.showMessageDialog(null, "You win with " + getPlayerTotal() + "! The dealer had " + getDealerTotal());
    	}
    	else {
    		JOptionPane.showMessageDialog(null, "You lose with " + getPlayerTotal() + "! The dealer had " + getDealerTotal());
    	}
    	frame.repaint();
    	setup();
    }
    
    public void cardDisplay(Card card, JLabel label) {
    	label.setText(card.getSuit() + " " + card.getRank());
    }
    
    public int getPlayerTotal()
    {
    	int playerTotal = 0;
    	for (int i = 0; i < player.size(); i++) {
    		playerTotal+=player.get(i).getRank().getValue();
    	}
    	return playerTotal;
    }
    
    public int getDealerTotal() {
    	int dealerTotal = 0;
    	for (int i = 0; i < dealer.size(); i++) {
    	dealerTotal+=dealer.get(i).getRank().getValue();
    	}
    	return dealerTotal;
    }
    public static void main (String [] args) {
    	CardDealer play = new CardDealer();
    	play.setup();
    	play.makeDeck();
    	play.shuffle();
    	play.play();
    }

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if (arg0.getSource() == hit) {
			shuffle();
			player.add(deck.get(0));
			card2Text = card2.getText();
			card2.setText(card2Text + " " + deck.get(0).getSuit() + " " + deck.get(0).getRank());
		}
		if (arg0.getSource() == stand || getPlayerTotal() > 21) {
			winChecker();
		}
		frame.pack();
	}
}
