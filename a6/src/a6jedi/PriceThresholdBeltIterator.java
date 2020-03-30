package a6jedi;

import java.util.Iterator;

import comp401.sushi.Plate;

public class PriceThresholdBeltIterator implements Iterator<Plate> {

	private Belt belt;
	private int circular_position;
	private double max_price;

	public PriceThresholdBeltIterator(Belt belt, int start_position, double max_price) {
		this.belt = belt;
		this.max_price = max_price;
		if (start_position >= 0) {
			this.circular_position = start_position % belt.getSize();
		} else if (start_position < 0) {
			this.circular_position = start_position % belt.getSize() + belt.getSize();
		}
	}

	@Override
	public boolean hasNext() {
		int initial_position = circular_position;
		circular_position++;
		while (belt.getPlateAtPosition(circular_position) == null) {
			circular_position++;

			if (belt.getPlateAtPosition(circular_position) != null) {
				return true;
			} else if (circular_position == initial_position) {
				return false;
			}

		}
		return true;
	}

	@Override
	public Plate next() {
		if (!hasNext()) {
			throw new java.util.NoSuchElementException();
		} else {
			circular_position++;
			while (belt.getPlateAtPosition(circular_position) == null
					|| belt.getPlateAtPosition(circular_position).getPrice() > max_price) {
				circular_position++;
			}
		}
		return belt.getPlateAtPosition(circular_position);
	}
}
