package sushigame.view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import sushigame.model.BeltEvent;
import sushigame.model.BeltEvent.EventType;
import sushigame.model.BeltObserver;
import sushigame.model.Chef;
import sushigame.model.SushiGameModel;

public class ScoreboardWidget extends JPanel implements BeltObserver , ActionListener {

	private SushiGameModel game_model;
	private JLabel display;
	
	private int sortType = 1;
	
	public ScoreboardWidget(SushiGameModel gm) {
		game_model = gm;
		game_model.getBelt().registerBeltObserver(this);
		
		display = new JLabel();
		display.setVerticalAlignment(SwingConstants.TOP);
		setLayout(new BorderLayout());
		add(display, BorderLayout.CENTER);
		display.setText(makeScoreboardHTML());
		
		
		JPanel northPanel = new JPanel();
		JButton balanceButton = new JButton("balance");
		JButton soldButton = new JButton("sold");
		JButton spoiledButton = new JButton("spoiled");
		
		balanceButton.addActionListener(this);
		soldButton.addActionListener(this);
		spoiledButton.addActionListener(this);
		
		northPanel.add(new JLabel("sort by"));
		northPanel.add(balanceButton);
		northPanel.add(soldButton);
		northPanel.add(spoiledButton);
		
		add(northPanel, BorderLayout.NORTH);
		
	}

	private String makeScoreboardHTML() {
		String sb_html = "<html>";
		sb_html += "<h1>Scoreboard</h1>";

		// Create an array of all chefs and sort by balance.
		Chef[] opponent_chefs= game_model.getOpponentChefs();
		Chef[] chefs = new Chef[opponent_chefs.length+1];
		chefs[0] = game_model.getPlayerChef();
		for (int i=1; i<chefs.length; i++) {
			chefs[i] = opponent_chefs[i-1];
		}
		if(sortType == 1){
			Arrays.sort(chefs, new HighToLowBalanceComparator());
		}
		else if(sortType == 2){
			Arrays.sort(chefs, new HighToLowFoodSoldComparator());
		}
		else if(sortType == 3){
			Arrays.sort(chefs, new LowToHighFoodSpoiledComparator());
		}
		
		for (Chef c : chefs) {
			sb_html += c.getName() + " ($" + Math.round(c.getBalance()*100.0)/100.0 + ") consumed:" + c.getFoodConsumedAmount()  + "spoiled:" + c.getFoodSpoiledAmount() + "<br>";
		}
		return sb_html;
	}

	public void refresh() {
		display.setText(makeScoreboardHTML());		
	}
	
	@Override
	public void handleBeltEvent(BeltEvent e) {
		if (e.getType() == BeltEvent.EventType.ROTATE || e.getType() == BeltEvent.EventType.PLATE_SPOILED || e.getType() == BeltEvent.EventType.PLATE_CONSUMED) {
			refresh();
		}		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if("balance".equals(e.getActionCommand())){
			sortType = 1;
		}else if("sold".equals(e.getActionCommand())){
			sortType = 2;
		}else if("spoiled".equals(e.getActionCommand())){
			sortType = 3;
		}
		refresh();
	}

}
