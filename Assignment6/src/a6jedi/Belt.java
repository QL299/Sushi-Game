package a6jedi;

import java.util.Iterator;

import comp401.sushi.Plate;

public class Belt implements Iterable<Plate> {

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
		int circular_position = 0;
		if (position >= 0) {
			circular_position = position % size;
		}
		if (position < 0) {
			circular_position = position % size + size;
		}
		return plates[circular_position];
	}

	//set plate at specified position
	public void setPlateAtPosition(Plate plate, int position) throws BeltPlateException {
		if (plate == null) {
			throw new IllegalArgumentException("No plate provided");
		}

		int circular_position = 0;
		if (position >= 0) {
			circular_position = position % size;
		}
		if (position < 0) {
			circular_position = position % size + size;
		}

		if (plates[circular_position] != null) {
			throw new BeltPlateException(position, plate, this);
		}
		plates[circular_position] = plate;
	}

	//remove plate at specified position
	public void clearPlateAtPosition(int position) {
		int circular_position = 0;
		if (position >= 0) {
			circular_position = position % size;
		}
		if (position < 0) {
			circular_position = position % size + size;
		}
		plates[circular_position] = null;
	}

	// remove plate at specified position 
	// return the plate
	public Plate removePlateAtPosition(int position) {
		int circular_position = 0;
		if (position >= 0) {
			circular_position = position % size;
		}
		if (position < 0) {
			circular_position = position % size + size;
		}
		if (plates[circular_position] == null) {
			throw new java.util.NoSuchElementException("There is no plate at the specified position");
		}
		Plate plate_returned = this.getPlateAtPosition(circular_position);
		this.clearPlateAtPosition(circular_position);
		return plate_returned;
	}

	//set plate at specific position if possible 
	//if not, set to the next highest position and return the position number
	public int setPlateNearestToPosition(Plate plate, int position) throws BeltFullException {
		int circular_position = 0;
		if (position >= 0) {
			circular_position = position % size;
		}
		if (position < 0) {
			circular_position = position % size + size;
		}

		int plate_placed = 0;
		boolean full = true;
		for (int i = 0; i < size; i++) {
			plate_placed = (circular_position + i) % size;
			if (plates[plate_placed] == null) {
				plates[plate_placed] = plate;
				full = false;
				break;
			}
		}

		if (full) {
			throw new BeltFullException(this);
		}
		return plate_placed;

	}

	// iterator
	@Override
	public Iterator<Plate> iterator() {
		return new BeltIterator(this, 0);
	}

	public Iterator<Plate> iteratorFromPosition(int position) {
		return new BeltIterator(this, position);
	}

	public Iterator<Plate> iterator(double max_price) {
		return new PriceThresholdBeltIterator(this, 0, max_price);
	}

	public Iterator<Plate> iterator(Plate.Color color) {
		return new ColorFilteredBeltIterator(this, 0, color);
	}

	public Iterator<Plate> iteratorFromPosition(int position, double max_price) {
		return new PriceThresholdBeltIterator(this, position, max_price);
	}

	public Iterator<Plate> iteratorFromPosition(int position, Plate.Color color) {
		return new ColorFilteredBeltIterator(this, position, color);
	}

    //rotate
	public void rotate() {
		Plate[] temp = plates.clone();
		plates[0] = temp[size - 1];
		for (int i = 1; i < size; i++) {
			plates[i] = temp[i - 1];
		}

	}

}