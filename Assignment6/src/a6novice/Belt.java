package a6novice;

import comp401.sushi.Plate;

public class Belt {

	// fields
	private Plate[] plates;
	private int size;

	// constructor
	// validate input: size must be positive value
	public Belt(int size) {
		if (size <= 0) {
			throw new IllegalArgumentException("Size must be positive");
		} else {
			this.size = size;
			this.plates = new Plate[size];
		}
	}

    //getter
	public int getSize() {
		return size;
	}

    // position from 0 to size
	// return plate at specified position
	public Plate getPlateAtPosition(int position) {
		if (position < 0 || position >= this.getSize()) {
			throw new IllegalArgumentException("Position should range from 0 to size-1");
		}
		return plates[position];
	}

	//set plate at specified position
	public void setPlateAtPosition(Plate plate, int position) throws BeltPlateException {
		if (plate == null) {
			throw new IllegalArgumentException("No plate provided");
		}
		if (position < 0 || position >= this.getSize()) {
			throw new IllegalArgumentException("Position is out of range");
		}
		if (plates[position] != null) {
			throw new BeltPlateException(position, plate, this);
		}
		plates[position] = plate;
	}
	//remove plate at specified position
	public void clearPlateAtPosition(int position) {
		if (position < 0 || position >= this.getSize()) {
			throw new IllegalArgumentException("Position is out of range");
		}
		plates[position] = null;
	}

	// remove plate at specified position 
    // and return the plate
	public Plate removePlateAtPosition(int position) {
		if (position < 0 || position >= this.getSize()) {
			throw new IllegalArgumentException("Position is out of range");
		}
		if (plates[position] == null) {
			throw new java.util.NoSuchElementException("There is no plate at the specified position");
		}
		Plate plate_returned = this.getPlateAtPosition(position);
		this.clearPlateAtPosition(position);
		return plate_returned;
	}

}
