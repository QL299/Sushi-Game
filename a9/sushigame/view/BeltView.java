package sushigame.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.text.DecimalFormat;

import javax.swing.JLabel;
import javax.swing.JPanel;

import comp401.sushi.Ingredient;
import comp401.sushi.IngredientPortion;
import comp401.sushi.Nigiri;
import comp401.sushi.Plate;
import comp401.sushi.Roll;
import comp401.sushi.Sashimi;
import comp401.sushi.Sushi;
import sushigame.model.Belt;
import sushigame.model.BeltEvent;
import sushigame.model.BeltObserver;

public class BeltView extends JPanel implements BeltObserver {

	private Belt belt;
	private JLabel[] belt_labels;

	public BeltView(Belt b) {
		this.belt = b;
		belt.registerBeltObserver(this);
		setLayout(new GridLayout(belt.getSize(), 1));
		belt_labels = new JLabel[belt.getSize()];
		for (int i = 0; i < belt.getSize(); i++) {
			JLabel plabel = new JLabel("");
			plabel.setMinimumSize(new Dimension(1000, 20));
			plabel.setPreferredSize(new Dimension(1000, 20));
			plabel.setOpaque(true);
			plabel.setBackground(Color.GRAY);
			add(plabel);
			belt_labels[i] = plabel;
		}
		refresh();
	}

	@Override
	public void handleBeltEvent(BeltEvent e) {
		refresh();
	}

	// modified belt view
	private void refresh() {
		for (int i = 0; i < belt.getSize(); i++) {
			Plate p = belt.getPlateAtPosition(i);
			JLabel plabel = belt_labels[i];

			// no plate at this position
			if (p == null) {
				plabel.setText("");
				plabel.setBackground(Color.GRAY);
			} else {
				// has plate at this position
				plabel.setText(p.toString());
				String chefName = p.getChef().getName();
				Sushi s = p.getContents();
				String sushiType = "";
				String sushiColor = p.getColor().toString();
				if (s instanceof Sashimi) {
					sushiType = "Sashimi_" + s.getIngredients()[0].getName();
				} else if (s instanceof Nigiri) {
					sushiType = "Nigiri_" + s.getIngredients()[0].getName();
				} else if (s instanceof Roll) {
					sushiType = "Roll[";
					for (IngredientPortion ingredientPortion : s.getIngredients()) {
						Ingredient ingredient = ingredientPortion.getIngredient();
						String ingredientName = ingredient.getName();
						double ingredientAmount = ingredientPortion.getAmount();
						DecimalFormat df = new DecimalFormat("######0.00");
						sushiType += ingredientName + ":" + df.format(ingredientAmount) + "oz,";
					}
					if (sushiType.lastIndexOf(',') == sushiType.length() - 1) {
						sushiType = sushiType.substring(0, sushiType.length() - 1);
					}
					sushiType += "]";
				}
				int age = belt.getAgeOfPlateAtPosition(i);
				plabel.setText(sushiColor + ", " + sushiType + ",  Chef:" + chefName + ",  Age:" + age);
				switch (p.getColor()) {
				case RED:
					plabel.setBackground(Color.RED);
					break;
				case GREEN:
					plabel.setBackground(Color.GREEN);
					break;
				case BLUE:
					plabel.setBackground(Color.BLUE);
					break;
				case GOLD:
					plabel.setBackground(Color.YELLOW);
					break;
				}
			}
		}
	}
}
