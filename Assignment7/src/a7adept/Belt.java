package a7adept;

import java.util.NoSuchElementException;
import java.util.Observable;

import comp401.sushi.Plate;

public class Belt extends Observable {

	private Plate belt[];

	public Belt(int size) {
		if (size < 1) {
			throw new IllegalArgumentException();
		}
          belt = new Plate[size];
    }

	public int getSize() {
		return belt.length;
	}

	public Plate getPlateAtPosition(int position) {
		position = normalizePosition(position);
		return belt[position];
	}

	public void setPlateAtPosition(Plate plate, int position) throws BeltPlateException {
		position = normalizePosition(position);

		if (plate == null) {
			throw new IllegalArgumentException("Plate is null");
		}

		if (belt[position] != null) {
			throw new BeltPlateException(position, plate, this);
		}
		belt[position] = plate;

		PlateEvent plate_placed = new PlateEvent(PlateEvent.EventType.PLATE_PLACED, plate, position);
		setChanged();
		notifyObservers(plate_placed);
	}

	public void clearPlateAtPosition(int position) {
		position = normalizePosition(position);
		Plate temporaryPlate = belt[position];

		belt[position] = null;

		PlateEvent plate_removed = new PlateEvent(PlateEvent.EventType.PLATE_REMOVED, temporaryPlate, position);
		setChanged();
		notifyObservers(plate_removed);
	}

	public Plate removePlateAtPosition(int position) {
		Plate plate = getPlateAtPosition(position);
		if (plate == null) {
			throw new NoSuchElementException();
		}
		clearPlateAtPosition(position);

		return plate;
	}

	public int setPlateNearestToPosition(Plate plate, int position) throws BeltFullException {
		for (int i = 0; i < getSize(); i++) {
			try {
				setPlateAtPosition(plate, position);
				return normalizePosition(position);
			} catch (BeltPlateException e) {
				position += 1;
			}
		}
		throw new BeltFullException(this);
	}

	private int normalizePosition(int position) {
		int nornal_position = position % getSize();

		if (position < 0) {
			nornal_position += getSize();
		}

		return nornal_position;
	}

	public void rotate() {
		Plate last_plate = belt[getSize() - 1];
		for (int i = getSize() - 1; i > 0; i--) {
			belt[i] = belt[i - 1];
		}
		belt[0] = last_plate;
	}
}
