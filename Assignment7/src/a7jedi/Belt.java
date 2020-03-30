package a7jedi;

import java.util.NoSuchElementException;
import java.util.Observable;

import comp401.sushi.Plate;

public class Belt extends Observable {

	private Plate belt[];
	private Customer customer[];

	public Belt(int a) {

		if (a < 1) {
			throw new IllegalArgumentException("Belt size must be greater than zero.");
		}

		belt = new Plate[a];
		customer = new Customer[a];
	}

	public void registerCustomerAtPosition(Customer c, int p) {

		p = normalizePosition(p);

		// If the Customer gives null object, throw it
		if (c == null) {
			throw new IllegalArgumentException();
		}
		
		for (int i = 0; i < customer.length; i++) {
			
			// If the object is registered at a different position, throw it
			
			if (customer[i] == c) {
				throw new RuntimeException();
			}
		}

		// If the position is already registered, throw it
		
		if (customer[p] != null) {
			throw new RuntimeException();
		}


		customer[p] = c;
	}

	public Customer unregisterCustomerAtPosition(int p) {
		
		p = normalizePosition(p);

		Customer tempCustomer = customer[p];
		
		// If there is no customer registered, return null
		
		if (tempCustomer == null) {
			return null;
		}

		customer[p] = null;
		return tempCustomer;
	}

	public int getSize() {
		return belt.length;
	}

	public Plate getPlateAtPosition(int p) {
		p = normalizePosition(p);
		return belt[p];
	}

	public void setPlateAtPosition(Plate plate, int p) throws BeltPlateException {
		p = normalizePosition(p);

		if (plate == null) {
			throw new IllegalArgumentException("Plate is null");
		}

		if (belt[p] != null) {
			throw new BeltPlateException(p, plate, this);
		}
		belt[p] = plate;

	    PlateEvent plate_placed = new PlateEvent(PlateEvent.EventType.PLATE_PLACED, plate, p);
		setChanged();
		notifyObservers(plate_placed);
	}

	public void clearPlateAtPosition(int p) {
		p = normalizePosition(p);
		Plate temporaryPlate = belt[p];

		belt[p] = null;

		PlateEvent plate_removed = new PlateEvent(PlateEvent.EventType.PLATE_REMOVED, temporaryPlate, p);
		setChanged();
		notifyObservers(plate_removed);
	}

	public Plate removePlateAtPosition(int p) {
		Plate plate = getPlateAtPosition(p);
		if (plate == null) {
			throw new NoSuchElementException();
		}
		clearPlateAtPosition(p);

		return plate;
	}

	public int setPlateNearestToPosition(Plate plate, int p) throws BeltFullException {
		for (int i = 0; i < getSize(); i++) {
			try {
				setPlateAtPosition(plate, p);
				return normalizePosition(p);
			} catch (BeltPlateException e) {
				p += 1;
			}
		}
		throw new BeltFullException(this);
	}

	private int normalizePosition(int p) {
		int normalized_position = p % getSize();

		if (p < 0) {
			normalized_position += getSize();
		}

		return normalized_position;
	}

	public void rotate() {
		Plate last_plate = belt[getSize() - 1];
		for (int i = getSize() - 1; i > 0; i--) {
			belt[i] = belt[i - 1];
		}
		belt[0] = last_plate;

		// If there is a plate at the customer's position, get notification
		
		for (int i = 0; i < customer.length; i++) {
			if(customer[i]!=null){
			customer[i].observePlateOnBelt(this, belt[i], i);
			}
		}

	}
}
