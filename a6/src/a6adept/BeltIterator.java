package a6adept;

import java.util.Iterator;

import comp401.sushi.Plate;

public class BeltIterator implements Iterator<Plate> {

	private Belt belt;
	private int circular_position;

	public BeltIterator(Belt belt, int start_position) {
		this.belt = belt;
		if (start_position >= 0) {
			this.circular_position = start_position % belt.getSize();
		} else if (start_position < 0) {
			this.circular_position = start_position % belt.getSize() + belt.getSize();
		}

	}

	@Override
	public boolean hasNext() {
		// TODO Auto-generated method stub
		boolean hasNext = false;
		for (int i = 0; i < belt.getSize(); i++) {
			if (belt.getPlateAtPosition(i) != null) {
				hasNext = true;
				break;
			}
		}
		return hasNext;

	}

	@Override
	public Plate next() {
		// TODO Auto-generated method stub
		if (!hasNext()) {
			throw new java.util.NoSuchElementException();
		} else {
			circular_position++;
			while (belt.getPlateAtPosition(circular_position) == null) {
				circular_position++;
			}
		}
		return belt.getPlateAtPosition(circular_position);

	}

	public void remove() {
		throw new UnsupportedOperationException();
	}

}
