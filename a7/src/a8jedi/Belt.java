package a8jedi;

import java.util.NoSuchElementException;
import java.util.Observable;

import comp401.sushi.Plate;

public class Belt extends Observable {

	private DecoratedPlate belt[];

	public Belt(int size) {
		if (size < 1) {
			throw new IllegalArgumentException();
		}

		belt = new DecoratedPlate[size];

	}

	// Methods

	public int getSize() {
		return belt.length;
	}

	public Plate getPlateAtPosition(int position) {
		position = normalizePosition(position);
		if (belt[position] == null) {
			return null;
		} else {
			return belt[position].getPlate(); // unwrap decorated object
		}
	}

	public void setPlateAtPosition(Plate plate, int position) throws BeltPlateException {
		position = normalizePosition(position);

		if (plate == null) {
			throw new IllegalArgumentException("Plate is null");
		}

		if (belt[position] != null) {
			throw new BeltPlateException(position, plate, this);
		}
		belt[position] = new DecoratedPlateImpl(plate); // wrap the object

		// notify the observer by passing the event object
		PlateEvent plate_placed = new PlateEvent(PlateEvent.EventType.PLATE_PLACED, plate, position);
		setChanged();
		notifyObservers(plate_placed);
	}

	public void clearPlateAtPosition(int position) {
		position = normalizePosition(position);
		if (belt[position] == null) {
			belt[position] = null;
		} else {
			Plate temporaryPlate = belt[position].getPlate();
			belt[position] = null;
			// notify the observer by passing the event object
			PlateEvent plate_removed = new PlateEvent(PlateEvent.EventType.PLATE_REMOVED, temporaryPlate, position);
			setChanged();
			notifyObservers(plate_removed);
		}

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
		// rotate
		DecoratedPlate last_plate = belt[getSize() - 1];
		for (int i = getSize() - 1; i > 0; i--) {
			belt[i] = belt[i - 1];
		}
		belt[0] = last_plate;

		// count
		for (int j = 0; j < belt.length; j++) {
			if (belt[j] != null) {
				belt[j].updateCount();
			}
		}

		// check spoil
		// contains shellfish: 1 * belt length
		// does not contain shellfish but is not vegetarian: 2 * belt length
		// vegetarian: 3 * belt length
		for (int k = 0; k < belt.length; k++) {
			if (belt[k] != null) {
				if (belt[k].getPlate().getContents().getHasShellfish() && getAgeOfPlateAtPosition(k) >= belt.length) {
					// notify the observer by passing the event object
					PlateEvent plate_spoiled = new PlateEvent(PlateEvent.EventType.PLATE_SPOILED, belt[k].getPlate(),
							k);
					setChanged();
					notifyObservers(plate_spoiled);
				} else if (!belt[k].getPlate().getContents().getIsVegetarian()
						&& getAgeOfPlateAtPosition(k) >= belt.length * 2) {
					// notify the observer by passing the event object
					PlateEvent plate_spoiled = new PlateEvent(PlateEvent.EventType.PLATE_SPOILED, belt[k].getPlate(),
							k);
					setChanged();
					notifyObservers(plate_spoiled);
				} else if (belt[k].getPlate().getContents().getIsVegetarian()
						&& getAgeOfPlateAtPosition(k) >= belt.length * 3) {
					// notify the observer by passing the event object
					PlateEvent plate_spoiled = new PlateEvent(PlateEvent.EventType.PLATE_SPOILED, belt[k].getPlate(),
							k);
					setChanged();
					notifyObservers(plate_spoiled);
				}
			}
		}
	}

	public int getAgeOfPlateAtPosition(int position) {
		if (belt[position] == null) {
			return -1;
		} else {
			return belt[position].getCount();
		}
	}
}
