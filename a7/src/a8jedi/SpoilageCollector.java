package a8jedi;

import java.util.Observable;
import java.util.Observer;

import comp401.sushi.IngredientPortion;

public class SpoilageCollector implements Observer {

	private Belt belt;
	private double spoil_cost = 0.0;
	private double spoil_shellfish = 0.0;
	private double spoil_seafood = 0.0;
	private double spoil_food = 0.0;

	public SpoilageCollector(Belt b) {
		if (b == null) {
			throw new IllegalArgumentException();
		}
		// register the observer
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
				spoil_cost += ingredients[i].getCost();
			}

			// spoil food amount
			for (int i = 0; i < ingredients.length; i++) {
				spoil_food += ingredients[i].getAmount();
			}

			// spoil shellfish amount
			for (int i = 0; i < ingredients.length; i++) {
				if (ingredients[i].getName().equals("crab") || ingredients[i].getName().equals("shrimp")) {
					spoil_shellfish += ingredients[i].getAmount();
				}
			}

			// spoil seafood amount
			for (int i = 0; i < ingredients.length; i++) {
				if (ingredients[i].getName().equals("crab") || ingredients[i].getName().equals("shrimp")
						|| ingredients[i].getName().equals("tuna") || ingredients[i].getName().equals("salmon")
						|| ingredients[i].getName().equals("eel")) {
					spoil_seafood += ingredients[i].getAmount();
				}
			}

			// remove spoiled plate from belt
			belt.clearPlateAtPosition(plate_event.getPosition());
		}

	}

	// getter
	public double getTotalSpoiledCost() {
		return spoil_cost;
	}

	public double getTotalSpoiledShellfish() {
		return spoil_shellfish;
	}

	public double getTotalSpoiledSeafood() {
		return spoil_seafood;
	}

	public double getTotalSpoiledFood() {
		return spoil_food;
	}

}
