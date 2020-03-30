package sushigame.view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Comparator;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import sushigame.model.Belt;
import sushigame.model.BeltEvent;
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
		
		
		JPanel n_Panel = new JPanel();
		JButton b_Button = new JButton("Balance");
		JButton s_Button = new JButton("Sold");
		JButton spoiled_Button = new JButton("Spoiled");
		
		b_Button.addActionListener(this);
		s_Button.addActionListener(this);
		spoiled_Button.addActionListener(this);
		
		n_Panel.add(new JLabel("Sorted by"));
		n_Panel.add(b_Button);
		n_Panel.add(s_Button);
		n_Panel.add(spoiled_Button);
		
		add(n_Panel, BorderLayout.NORTH);
		
	}

	private String makeScoreboardHTML() {
		String s_html = "<html>";
		s_html += "<h1>Scoreboard</h1>";

		Chef[] opp_chefs= game_model.getOpponentChefs();
		Chef[] chefs = new Chef[opp_chefs.length+1];
		chefs[0] = game_model.getPlayerChef();
		for (int i=1; i<chefs.length; i++) {
			chefs[i] = opp_chefs[i-1];
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
			s_html += c.getName() + " ($ " + Math.round(c.getBalance()*100.0)/100.0 + ")" +"<br>"+"  Consumed: "  + c.getFoodConsumedAmount()  + "  Spoiled: " + c.getFoodSpoiledAmount() + "<br>" + "<br>";
		}
		return s_html;
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
