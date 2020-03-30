package sushigame.view;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import comp401.sushi.AvocadoPortion;
import comp401.sushi.CrabPortion;
import comp401.sushi.EelPortion;
import comp401.sushi.IngredientPortion;
import comp401.sushi.Nigiri;
import comp401.sushi.Nigiri.NigiriType;
import comp401.sushi.Plate;
import comp401.sushi.RedPlate;
import comp401.sushi.RicePortion;
import comp401.sushi.Roll;
import comp401.sushi.SalmonPortion;
import comp401.sushi.Sashimi;
import comp401.sushi.Sashimi.SashimiType;
import comp401.sushi.SeaweedPortion;
import comp401.sushi.ShrimpPortion;
import comp401.sushi.Sushi;
import comp401.sushi.TunaPortion;

public class PlayerChefView extends JPanel implements ActionListener {

	private List<ChefViewListener> listeners;
	private Sushi kmp_roll;
	private Sushi crab_sashimi;
	private Sushi eel_nigiri;
	private int belt_size;

	private Plate.Color customColor = Plate.Color.RED;
	private String sushiType;
	private Sashimi.SashimiType sashimiType;
	private Nigiri.NigiriType nigiriType;

	private JCheckBox redPlateChooser;
	private JCheckBox bluePlateChooser;
	private JCheckBox goldPlateChooser;
	private JCheckBox greenPlateChooser;

	private JPanel pricePanel;
	private JPanel sashimiTypePanel;
	private JPanel nigiriTypePanel;
	private JPanel ingredientPanel;

	private JTextField price_text;
	private JTextField position_text;
	private JTextField shrimp_oz_text;
	private JTextField tuna_oz_text;
	private JTextField seaweed_oz_text;
	private JTextField salmon_oz_text;
	private JTextField rice_oz_text;
	private JTextField eel_oz_text;
	private JTextField crab_oz_text;
	private JTextField avocado_oz_text;

	private Nigiri nigiri;
	private Sashimi sashimi;
	private Roll roll;

	public PlayerChefView(int belt_size) {
		this.belt_size = belt_size;
		listeners = new ArrayList<ChefViewListener>();

		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));


		JPanel colorPanel = new JPanel();
		colorPanel.setPreferredSize(new Dimension(300, 0));
		redPlateChooser = new JCheckBox("Red");
		redPlateChooser.setActionCommand("choose_red");
		redPlateChooser.addActionListener(this);
		redPlateChooser.setSelected(true);
		bluePlateChooser = new JCheckBox("Blue");
		bluePlateChooser.setActionCommand("choose_blue");
		bluePlateChooser.addActionListener(this);
		goldPlateChooser = new JCheckBox("Gold");
		goldPlateChooser.setActionCommand("choose_gold");
		goldPlateChooser.addActionListener(this);
		greenPlateChooser = new JCheckBox("Green");
		greenPlateChooser.setActionCommand("choose_green");
		greenPlateChooser.addActionListener(this);
		ButtonGroup colorGroup = new ButtonGroup();
		colorGroup.add(redPlateChooser);
		colorGroup.add(bluePlateChooser);
		colorGroup.add(goldPlateChooser);
		colorGroup.add(greenPlateChooser);
		colorPanel.add(new JLabel("Plate color:"));
		colorPanel.add(redPlateChooser);
		colorPanel.add(bluePlateChooser);
		colorPanel.add(goldPlateChooser);
		colorPanel.add(greenPlateChooser);
		add(colorPanel);

		JPanel positionJapanel = new JPanel();
		position_text = new JTextField(2);
		positionJapanel.add(new JLabel("Position(1~20):"));
		positionJapanel.add(position_text);
		add(positionJapanel);

		pricePanel = new JPanel();
		price_text = new JTextField(5);
		pricePanel.setPreferredSize(new Dimension(300, 0));
		pricePanel.add(new JLabel("Price:"));
		pricePanel.add(price_text);
		pricePanel.add(new JLabel("($5~$10)"));
		pricePanel.setVisible(false);
		add(pricePanel);

		JPanel sushiTypePanel = new JPanel();
		sushiTypePanel.setPreferredSize(new Dimension(300, 0));
		JRadioButton sashimiSushi = new JRadioButton("sashimi");
		JRadioButton nigiriSushi = new JRadioButton("nigiri");
		JRadioButton rollSushi = new JRadioButton("roll");
		sashimiSushi.setActionCommand("choose_sashimi");
		nigiriSushi.setActionCommand("choose_nigiri");
		rollSushi.setActionCommand("choose_roll");
		sashimiSushi.addActionListener(this);
		nigiriSushi.addActionListener(this);
		rollSushi.addActionListener(this);

		ButtonGroup sushiTypeGroup = new ButtonGroup();
		sushiTypeGroup.add(sashimiSushi);
		sushiTypeGroup.add(nigiriSushi);
		sushiTypeGroup.add(rollSushi);
		sushiTypePanel.add(new JLabel("Type:"));
		sushiTypePanel.add(sashimiSushi);
		sushiTypePanel.add(nigiriSushi);
		sushiTypePanel.add(rollSushi);
		add(sushiTypePanel);

		sashimiTypePanel = new JPanel();
		sashimiTypePanel.setPreferredSize(new Dimension(300, 0));
		JRadioButton sashimi_tuna = new JRadioButton("Tuna");
		JRadioButton sashimi_salmon = new JRadioButton("Salmon");
		JRadioButton sashimi_eel = new JRadioButton("Eel");
		JRadioButton sashimi_crab = new JRadioButton("Crab");
		JRadioButton sashimi_shrimp = new JRadioButton("Shrimp");
		sashimi_tuna.setActionCommand("choose_sashimi_tuna");
		sashimi_salmon.setActionCommand("choose_sashimi_salmon");
		sashimi_eel.setActionCommand("choose_sashimi_eel");
		sashimi_crab.setActionCommand("choose_sashimi_crab");
		sashimi_shrimp.setActionCommand("choose_sashimi_shrimp");

		sashimi_tuna.addActionListener(this);
		sashimi_salmon.addActionListener(this);
		sashimi_eel.addActionListener(this);
		sashimi_crab.addActionListener(this);
		sashimi_shrimp.addActionListener(this);

		ButtonGroup sashimiTypeGroup = new ButtonGroup();
		sashimiTypeGroup.add(sashimi_crab);
		sashimiTypeGroup.add(sashimi_shrimp);
		sashimiTypeGroup.add(sashimi_eel);
		sashimiTypeGroup.add(sashimi_salmon);
		sashimiTypeGroup.add(sashimi_tuna);
		sashimiTypePanel.add(new JLabel("Sashimi type:"));
		sashimiTypePanel.add(sashimi_crab);
		sashimiTypePanel.add(sashimi_shrimp);
		sashimiTypePanel.add(sashimi_eel);
		sashimiTypePanel.add(sashimi_salmon);
		sashimiTypePanel.add(sashimi_tuna);
		sashimiTypePanel.setVisible(false);
		add(sashimiTypePanel);

		nigiriTypePanel = new JPanel();
		nigiriTypePanel.setPreferredSize(new Dimension(300, 0));
		JRadioButton nigiri_tuna = new JRadioButton("Tuna");
		JRadioButton nigiri_salmon = new JRadioButton("Salmon");
		JRadioButton nigiri_eel = new JRadioButton("Eel");
		JRadioButton nigiri_crab = new JRadioButton("Crab");
		JRadioButton nigiri_shrimp = new JRadioButton("Shrimp");

		nigiri_tuna.setActionCommand("choose_nigiri_tuna");
		nigiri_salmon.setActionCommand("choose_nigiri_salmon");
		nigiri_eel.setActionCommand("choose_nigiri_eel");
		nigiri_crab.setActionCommand("choose_nigiri_crab");
		nigiri_shrimp.setActionCommand("choose_nigiri_shrimp");

		nigiri_tuna.addActionListener(this);
		nigiri_salmon.addActionListener(this);
		nigiri_eel.addActionListener(this);
		nigiri_crab.addActionListener(this);
		nigiri_shrimp.addActionListener(this);

		ButtonGroup nigiriTypeGroup = new ButtonGroup();
		nigiriTypeGroup.add(nigiri_crab);
		nigiriTypeGroup.add(nigiri_shrimp);
		nigiriTypeGroup.add(nigiri_eel);
		nigiriTypeGroup.add(nigiri_salmon);
		nigiriTypeGroup.add(nigiri_tuna);
		nigiriTypePanel.add(new JLabel("Nigiri type:"));
		nigiriTypePanel.add(nigiri_crab);
		nigiriTypePanel.add(nigiri_shrimp);
		nigiriTypePanel.add(nigiri_eel);
		nigiriTypePanel.add(nigiri_salmon);
		nigiriTypePanel.add(nigiri_tuna);
		nigiriTypePanel.setVisible(false);
		add(nigiriTypePanel);

		ingredientPanel = new JPanel(new GridLayout(3, 3));
		ingredientPanel.setPreferredSize(new Dimension(300, 0));

		avocado_oz_text = new JTextField(1);
		crab_oz_text = new JTextField(1);
		eel_oz_text = new JTextField(1);
		rice_oz_text = new JTextField(1);
		salmon_oz_text = new JTextField(1);
		seaweed_oz_text = new JTextField(1);
		shrimp_oz_text = new JTextField(1);
		tuna_oz_text = new JTextField(1);
		
		JPanel panel1 = new JPanel();
		panel1.add(new JLabel("Avocado:"));
		panel1.add(avocado_oz_text);
		ingredientPanel.add(panel1);
		JPanel panel2 = new JPanel();
		panel2.add(new JLabel("Crab:"));
		panel2.add(crab_oz_text);
		ingredientPanel.add(panel2);
		JPanel panel3 = new JPanel();
		panel3.add(new JLabel("Eel:"));
		panel3.add(eel_oz_text);
		ingredientPanel.add(panel3);
		JPanel panel4 = new JPanel();
		panel4.add(new JLabel("Rice:"));
		panel4.add(rice_oz_text);
		ingredientPanel.add(panel4);
		JPanel panel5 = new JPanel();
		panel5.add(new JLabel("Salmon:"));
		panel5.add(salmon_oz_text);
		ingredientPanel.add(panel5);
		JPanel panel6 = new JPanel();
		panel6.add(new JLabel("Seaweed:"));
		panel6.add(seaweed_oz_text);
		ingredientPanel.add(panel6);
		JPanel panel7 = new JPanel();
		panel7.add(new JLabel("Shrimp:"));
		panel7.add(shrimp_oz_text);
		ingredientPanel.add(panel7);
		JPanel panel8 = new JPanel();
		panel8.add(new JLabel("Tuna:"));
		panel8.add(tuna_oz_text);
		ingredientPanel.add(panel8);
		ingredientPanel.setVisible(false);
		add(ingredientPanel);

		JButton makeBtn = new JButton("Make");
		makeBtn.setActionCommand("make");
		makeBtn.addActionListener(this);
		add(makeBtn);

		kmp_roll = new Roll("KMP Roll",
				new IngredientPortion[] { new EelPortion(1.0), new AvocadoPortion(0.5), new SeaweedPortion(0.2) });
		crab_sashimi = new Sashimi(Sashimi.SashimiType.CRAB);
		eel_nigiri = new Nigiri(Nigiri.NigiriType.EEL);
	}

	public void registerChefListener(ChefViewListener cl) {
		listeners.add(cl);
	}

	private void makeRedPlateRequest(Sushi plate_sushi, int plate_position) {
		for (ChefViewListener l : listeners) {
			l.handleRedPlateRequest(plate_sushi, plate_position);
		}
	}

	private void makeGreenPlateRequest(Sushi plate_sushi, int plate_position) {
		for (ChefViewListener l : listeners) {
			l.handleGreenPlateRequest(plate_sushi, plate_position);
		}
	}

	private void makeBluePlateRequest(Sushi plate_sushi, int plate_position) {
		for (ChefViewListener l : listeners) {
			l.handleBluePlateRequest(plate_sushi, plate_position);
		}
	}

	private void makeGoldPlateRequest(Sushi plate_sushi, int plate_position, double price) {
		for (ChefViewListener l : listeners) {
			l.handleGoldPlateRequest(plate_sushi, plate_position, price);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
		case "red_crab_sashimi_at_3":
			makeRedPlateRequest(crab_sashimi, 3);
			break;
		case "blue_eel_nigiri_at_8":
			makeBluePlateRequest(eel_nigiri, 8);
			break;
		case "gold_kmp_roll_at_5":
			makeGoldPlateRequest(kmp_roll, 5, 5.00);
			break;
		case "choose_red":
			customColor = Plate.Color.RED;
			pricePanel.setVisible(false);
			break;
		case "choose_blue":
			customColor = Plate.Color.BLUE;
			pricePanel.setVisible(false);
			break;
		case "choose_gold":
			customColor = Plate.Color.GOLD;
			pricePanel.setVisible(true);
			break;
		case "choose_green":
			customColor = Plate.Color.GREEN;
			pricePanel.setVisible(false);
			break;
		case "choose_sashimi":
			sushiType = "sashimi";
			ingredientPanel.setVisible(false);
			nigiriTypePanel.setVisible(false);
			sashimiTypePanel.setVisible(true);
			break;
		case "choose_nigiri":
			sushiType = "nigiri";
			ingredientPanel.setVisible(false);
			sashimiTypePanel.setVisible(false);
			nigiriTypePanel.setVisible(true);
			break;
		case "choose_roll":
			sushiType = "roll";
			nigiriTypePanel.setVisible(false);
			sashimiTypePanel.setVisible(false);
			ingredientPanel.setVisible(true);
			break;
		case "choose_sashimi_tuna":
			sashimiType = SashimiType.TUNA;
			break;
		case "choose_sashimi_salmon":
			sashimiType = SashimiType.SALMON;
			break;
		case "choose_sashimi_eel":
			sashimiType = SashimiType.EEL;
			break;
		case "choose_sashimi_crab":
			sashimiType = SashimiType.CRAB;
			break;
		case "choose_sashimi_shrimp":
			sashimiType = SashimiType.SHRIMP;
			break;
		case "choose_nigiri_tuna":
			nigiriType = NigiriType.TUNA;
			break;
		case "choose_nigiri_salmon":
			nigiriType = NigiriType.SALMON;
			break;
		case "choose_nigiri_eel":
			nigiriType = NigiriType.EEL;
			break;
		case "choose_nigiri_crab":
			nigiriType = NigiriType.CRAB;
			break;
		case "choose_nigiri_shrimp":
			nigiriType = NigiriType.SHRIMP;
			break;
		case "make":
			int position = 0;
			double price = 0;
			try {
				position = Integer.parseInt(position_text.getText());

			} catch (Exception e2) {
				// TODO: handle exception
				JOptionPane.showMessageDialog(null, "input a correct position");
			}

			if (sushiType.equals("sashimi")) {
				if (sashimiType == null) {
					JOptionPane.showMessageDialog(null, "select a sashimi type");
					return;
				}
				sashimi = new Sashimi(sashimiType);
				if (customColor == Plate.Color.RED) {
					makeRedPlateRequest(sashimi, position);
				} else if (customColor == Plate.Color.BLUE) {
					makeBluePlateRequest(sashimi, position);
				} else if (customColor == Plate.Color.GREEN) {
					makeGreenPlateRequest(sashimi, position);
				} else if (customColor == Plate.Color.GOLD) {
					try {
						price = Double.parseDouble(price_text.getText());
						if (price < 5 || price > 10) {
							throw new Exception();
						}
					} catch (Exception e2) {
						// TODO: handle exception
						JOptionPane.showMessageDialog(null, "input a correct price");
						return;
					}
					makeGoldPlateRequest(sashimi, position, price);
				}
			} else if (sushiType.equals("nigiri")) {
				if (nigiriType == null) {
					JOptionPane.showMessageDialog(null, "select a nigiri type");
					return;
				}
				nigiri = new Nigiri(nigiriType);
				if (customColor == Plate.Color.RED) {
					makeRedPlateRequest(nigiri, position);
				} else if (customColor == Plate.Color.BLUE) {
					makeBluePlateRequest(nigiri, position);
				} else if (customColor == Plate.Color.GREEN) {
					makeGreenPlateRequest(nigiri, position);
				} else if (customColor == Plate.Color.GOLD) {
					try {
						price = Double.parseDouble(price_text.getText());
						if (price < 5 || price > 10) {
							throw new Exception();
						}
					} catch (Exception e2) {
						// TODO: handle exception
						JOptionPane.showMessageDialog(null, "input a correct price");
						return;
					}
					makeGoldPlateRequest(nigiri, position, price);
				}
			} else if (sushiType.equals("roll")) {
				double avocado_oz = 0;
				double crab_oz = 0;
				double eel_oz = 0;
				double rice_oz = 0;
				double salmon_oz = 0;
				double seaweed_oz = 0;
				double shrimp_oz = 0;
				double tuna_oz = 0;
				try {
					if (!"".equals(avocado_oz_text.getText())) {
						avocado_oz = Double.parseDouble(avocado_oz_text.getText());
						if (avocado_oz < 0 || avocado_oz > 1.5)
							throw new Exception();
					}
					if (!"".equals(crab_oz_text.getText())) {
						crab_oz = Double.parseDouble(crab_oz_text.getText());
						if (crab_oz < 0 || crab_oz > 1.5)
							throw new Exception();
					}
					if (!"".equals(eel_oz_text.getText())) {
						eel_oz = Double.parseDouble(eel_oz_text.getText());
						if (eel_oz < 0 || eel_oz > 1.5)
							throw new Exception();
					}
					if (!"".equals(rice_oz_text.getText())) {
						rice_oz = Double.parseDouble(rice_oz_text.getText());
						if (rice_oz < 0 || rice_oz > 1.5)
							throw new Exception();
					}
					if (!"".equals(salmon_oz_text.getText())) {
						salmon_oz = Double.parseDouble(salmon_oz_text.getText());
						if (salmon_oz < 0 || salmon_oz > 1.5)
							throw new Exception();
					}
					if (!"".equals(seaweed_oz_text.getText())) {
						seaweed_oz = Double.parseDouble(seaweed_oz_text.getText());
						if (seaweed_oz < 0 || seaweed_oz > 1.5)
							throw new Exception();
					}
					if (!"".equals(shrimp_oz_text.getText())) {
						shrimp_oz = Double.parseDouble(shrimp_oz_text.getText());
						if (shrimp_oz < 0 || shrimp_oz > 1.5)
							throw new Exception();
					}
					if (!"".equals(tuna_oz_text.getText())) {
						tuna_oz = Double.parseDouble(tuna_oz_text.getText());
						if (tuna_oz < 0 || tuna_oz > 1.5)
							throw new Exception();
					}
				} catch (Exception e2) {
					// TODO: handle exception
					JOptionPane.showMessageDialog(null, "input the correct ounce of ingredient");
					return;
				}
				List<IngredientPortion> ingredientPortions = new ArrayList<IngredientPortion>();
				if (avocado_oz > 0) {
					ingredientPortions.add(new AvocadoPortion(avocado_oz));
				}
				if (crab_oz > 0) {
					ingredientPortions.add(new CrabPortion(crab_oz));
				}
				if (eel_oz > 0) {
					ingredientPortions.add(new EelPortion(eel_oz));
				}
				if (rice_oz > 0) {
					ingredientPortions.add(new RicePortion(rice_oz));
				}
				if (salmon_oz > 0) {
					ingredientPortions.add(new SalmonPortion(salmon_oz));
				}
				if (seaweed_oz > 0) {
					ingredientPortions.add(new SeaweedPortion(seaweed_oz));
				}
				if (shrimp_oz > 0) {
					ingredientPortions.add(new ShrimpPortion(shrimp_oz));
				}
				if (tuna_oz > 0) {
					ingredientPortions.add(new TunaPortion(tuna_oz));
				}
				roll = new Roll("custom roll",
						ingredientPortions.toArray(new IngredientPortion[ingredientPortions.size()]));
				if (customColor == Plate.Color.RED) {
					makeRedPlateRequest(roll, position);
				} else if (customColor == Plate.Color.BLUE) {
					makeBluePlateRequest(roll, position);
				} else if (customColor == Plate.Color.GREEN) {
					makeGreenPlateRequest(roll, position);
				} else if (customColor == Plate.Color.GOLD) {
					try {
						price = Double.parseDouble(price_text.getText());
						if (price < 5 || price > 10) {
							throw new Exception();
						}
					} catch (Exception e2) {
						// TODO: handle exception
						JOptionPane.showMessageDialog(null, "Input a correct price");
						return;
					}
					makeGoldPlateRequest(roll, position, price);
				}
			}
		}
	}

}