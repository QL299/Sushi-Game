package a7adept;

import java.util.Observable;
import java.util.Observer;

import comp401.sushi.Plate;

public class PlateCounter implements Observer {

	private Belt belt;

	public PlateCounter(Belt belt) {

		if (belt == null) {
			throw new IllegalArgumentException();
		}

		belt.addObserver(this);
		this.belt = belt;

	}

	public void update(Observable o, Object arg) {
		Belt belt = (Belt) o;
		this.belt = belt;
		PlateEvent plate_event = (PlateEvent) arg;
	}

	public int getRedPlateCount() {
		int red_Number = 0;

		for (int i = 0; i < belt.getSize(); i++) {
			if (belt.getPlateAtPosition(i) != null) {

				if (belt.getPlateAtPosition(i).getColor().equals(Plate.Color.RED)) {
					red_Number++;
				}
			}
		}

		return red_Number;
	}

	public int getGreenPlateCount() {

		int green_Number = 0;

		for (int i = 0; i < belt.getSize(); i++) {
			if (belt.getPlateAtPosition(i) != null) {
				if (belt.getPlateAtPosition(i).getColor().equals(Plate.Color.GREEN)) {
					green_Number++;
				}
			}
		}

		return green_Number;
	}

	public int getBluePlateCount() {

		int blue_Number = 0;

		for (int i = 0; i < belt.getSize(); i++) {
			if (belt.getPlateAtPosition(i) != null) {

				if (belt.getPlateAtPosition(i).getColor().equals(Plate.Color.BLUE)) {
					blue_Number++;
				}
			}
		}

		return blue_Number;
	}

	public int getGoldPlateCount() {

		int gold_Number = 0;

		for (int i = 0; i < belt.getSize(); i++) {
			if (belt.getPlateAtPosition(i) != null) {

				if (belt.getPlateAtPosition(i).getColor().equals(Plate.Color.GOLD)) {
					gold_Number++;
				}
			}
		}

		return gold_Number;
	}

}
