package a7jedi;

import java.util.Observable;
import java.util.Observer;

import comp401.sushi.Plate;

public class PlateCounter implements Observer {

	private Belt belt;

	public PlateCounter(Belt b) {

		if (b == null) {
			throw new IllegalArgumentException();
		}

		b.addObserver(this);
		this.belt = b;
	}

	@Override
	public void update(Observable o, Object arg) {
		Belt belt = (Belt) o;
		this.belt = belt;
		PlateEvent plate_event = (PlateEvent) arg;
	}

	public int getRedPlateCount() {
		int rNumber = 0;

		for (int i = 0; i < belt.getSize(); i++) {
			if (belt.getPlateAtPosition(i) != null) {

				if (belt.getPlateAtPosition(i).getColor().equals(Plate.Color.RED)) {
					rNumber++;
				}
			}
		}

		return rNumber;
	}

	public int getGreenPlateCount() {

		int grNumber = 0;

		for (int i = 0; i < belt.getSize(); i++) {
			if (belt.getPlateAtPosition(i) != null) {
				if (belt.getPlateAtPosition(i).getColor().equals(Plate.Color.GREEN)) {
					grNumber++;
				}
			}
		}

		return grNumber;
	}

	public int getBluePlateCount() {

		int bNumber = 0;

		for (int i = 0; i < belt.getSize(); i++) {
			if (belt.getPlateAtPosition(i) != null) {

				if (belt.getPlateAtPosition(i).getColor().equals(Plate.Color.BLUE)) {
					bNumber++;
				}
			}
		}

		return bNumber;
	}

	public int getGoldPlateCount() {

		int gNumber = 0;

		for (int i = 0; i < belt.getSize(); i++) {
			if (belt.getPlateAtPosition(i) != null) {

				if (belt.getPlateAtPosition(i).getColor().equals(Plate.Color.GOLD)) {
					gNumber++;
				}
			}
		}

		return gNumber;
	}

}