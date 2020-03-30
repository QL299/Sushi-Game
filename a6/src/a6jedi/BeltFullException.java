package a6jedi;

public class BeltFullException extends Exception {

	private Belt belt;

	public BeltFullException(Belt belt) {
		super("The Belt is full");
		this.belt = belt;
	}

	public Belt getBelt() {
		return belt;
	}

}
