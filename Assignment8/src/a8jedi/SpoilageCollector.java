package a8jedi;

import comp401.Obser.observer;

import a8jedi.PlateEvent.EventType;
import a8jedi.Belt;

import comp401.sushi.IngredientPortion;

public class SpoilageCollector implements comp401.sushi.Observer {

	private Belt belt;
	private double cost = 0.0;
	private double shellfish = 0.0;
	private double seafood = 0.0;
	private double food = 0.0;

	public SpoilageCollector(Belt b) {
		if (b == null) {
			throw new IllegalArgumentException();
		}
		b.addObserver(this);
		this.belt = b;
	}

	@Override
	public void update(Observable o, Object arg) {
		Belt belt = (Belt) o;
		PlateEvent plate_event = (PlateEvent) arg;

		if (plate_event.getType() == PlateEvent.EventType.PLATE_SPOILED) {
			IngredientPortion[] ingredients = plate_event.getPlate().getContents().getIngredients();

			// spoil cost
			for (int i = 0; i < ingredients.length; i++) {
				cost += ingredients[i].getCost();
			}

			// spoil food amount
			for (int i = 0; i < ingredients.length; i++) {
				food += ingredients[i].getAmount();
			}

			// spoil shellfish amount
			for (int i = 0; i < ingredients.length; i++) {
				if (ingredients[i].getName().equals("crab") || ingredients[i].getName().equals("shrimp")) {
					shellfish += ingredients[i].getAmount();
				}
			}

			// spoil seafood amount
			for (int i = 0; i < ingredients.length; i++) {
				if (ingredients[i].getName().equals("crab") || ingredients[i].getName().equals("shrimp")
						|| ingredients[i].getName().equals("tuna") || ingredients[i].getName().equals("salmon")
						|| ingredients[i].getName().equals("eel")) {
					seafood += ingredients[i].getAmount();
				}
			}

			// remove spoiled plate from belt
			belt.clearPlateAtPosition(plate_event.getPosition());
		}

	}

	// getter
	public double getTotalSpoiledCost() {
		return cost;
	}

	public double getTotalSpoiledShellfish() {
		return shellfish;
	}

	public double getTotalSpoiledSeafood() {
		return seafood;
	}

	public double getTotalSpoiledFood() {
		return food;
	}

}
