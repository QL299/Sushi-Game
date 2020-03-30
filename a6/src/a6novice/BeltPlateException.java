package a6novice;

import comp401.sushi.Plate;

public class BeltPlateException extends Exception {

	// fields
	private int position;
	private Plate plate_to_be_set;
	private Belt belt;

	// constructor
	public BeltPlateException(int position, Plate plate_to_be_set, Belt belt) {
		super("Belt at this position has already been occupied");
		this.position = position;
		this.plate_to_be_set = plate_to_be_set;
		this.belt = belt;
	}

	// getter
	public int getPosition() {
		return position;
	}

	public Plate getPlateToSet() {
		return plate_to_be_set;
	}

	public Belt getBelt() {
		return belt;
	};

}
