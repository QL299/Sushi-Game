package sushigame.view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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

public class BeltView extends JPanel implements BeltObserver,ActionListener {

	private Belt belt;
	private JButton[] belt_buttons;
	private String[] context;

	public BeltView(Belt b) {
		this.belt = b;
		belt.registerBeltObserver(this);
		setLayout(new GridLayout(belt.getSize(), 1));
		belt_buttons = new JButton[belt.getSize()];
		context = new String[belt.getSize()];
		for (int i = 0; i < belt.getSize(); i++) {
			JButton pbutton = new JButton("");
			Plate p = belt.getPlateAtPosition(i);
	        pbutton.addActionListener(this);
			pbutton.setMinimumSize(new Dimension(500, 20));
			pbutton.setPreferredSize(new Dimension(500, 20));
			pbutton.setOpaque(true);
			pbutton.setBackground(Color.GRAY);
			pbutton.setBorderPainted(false);
			add(pbutton);
			belt_buttons[i] = pbutton;
		}
		refresh();
	}

	@Override
	public void handleBeltEvent(BeltEvent e) {
		refresh();
	}

	private void refresh() {
		for (int i = 0; i < belt.getSize(); i++) {
			Plate p = belt.getPlateAtPosition(i);
			JButton pbutton = belt_buttons[i];

			// no plate at this position
			if (p == null) {
				pbutton.setText("");
				pbutton.setBackground(Color.GRAY);
			} else {
				// has plate at this position
				pbutton.setText(p.toString());
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
				pbutton.setText(sushiColor + ", " + sushiType + ",  Chef:" + chefName + ",  Age:" + age);
				switch (p.getColor()) {
				case RED:
					pbutton.setBackground(Color.RED); break;
				case GREEN:
					pbutton.setBackground(Color.GREEN); break;
				case BLUE:
					pbutton.setBackground(Color.BLUE); break;
				case GOLD:
					pbutton.setBackground(Color.YELLOW); break;
				}
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent evt) {
		Object context;
		String con1 = null, con2 = null, con3 = null, con4 = null;
		Object con5 = null;
		
		int buttonp = 0;
		for( int i = 0; i < belt.getSize();i++) {
			if(evt.getSource().equals(belt_buttons[i])) {
				buttonp = i;
			}
		}
        if(!(belt.getPlateAtPosition(buttonp)!= null)) {
        	context = "no plate";
        }else {
        	Plate p = belt.getPlateAtPosition(buttonp);
        	con1 = "The color of the plate is " + p.getColor().toString();
        	Sushi s = p.getContents();
        	String sushiType = "";
			String sushiColor = p.getColor().toString();
			if (s instanceof Sashimi) {
				sushiType = s.getIngredients()[0].getName();
			} else if (s instanceof Nigiri) {
				sushiType = s.getIngredients()[0].getName();
			} else if (s instanceof Roll) {
				sushiType = "[";
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
		con2 = "The ingredient for this plate is " + sushiType;
        	con3 = "The chef for this plate is " + p.getChef().getName();
        	con4 = "The type of sushi is " + p.getContents().getTypeName();
        con5 = "This plate has been on the belt for " + belt.getAgeOfPlateAtPosition(buttonp) + " rotations";
        context = con1 + "\n" + con2 + "\n" +con3 +"\n" +con4 +"\n" +con5;
        
        }
		JOptionPane.showMessageDialog(null, context);
	}
}
