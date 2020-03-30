package a7jedi;

import comp401.sushi.Plate;

public class PlateEvent {
	public enum EventType {
		PLATE_PLACED, PLATE_REMOVED
	};

	private EventType t;
	private Plate pl;
	private int po;

	public PlateEvent(EventType type, Plate plate, int position) {
		this.t = type;
		this.pl = plate;
		this.po = position;
	}

	public EventType getType() {
		return t;
	}

	public Plate getPlate() {
		return pl;
	}

	public int getPosition() {
		return po;
	}
}