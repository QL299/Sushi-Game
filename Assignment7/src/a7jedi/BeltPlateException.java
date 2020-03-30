package a7jedi;

import comp401.sushi.Plate;

public class BeltPlateException extends Exception {

	private int p;
	private Plate plate;
	private Belt belt;

	public BeltPlateException(int position, Plate plate_to_be_set, Belt belt) {
		this.p = position;
		this.plate = plate;
		this.belt = belt;
	}

	public int getPosition() {
		return p;
	}

	public Plate getPlateToSet() {
		return plate;
	}

	public Belt getBelt() {
		return belt;
	}

}
