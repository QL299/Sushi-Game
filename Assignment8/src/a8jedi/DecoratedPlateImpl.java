package a8jedi;

import comp401.sushi.Plate;
import comp401.sushi.PlatePriceException;
import comp401.sushi.Sushi;

public class DecoratedPlateImpl implements DecoratedPlate {

	// encapsulate original object
	private Plate plate;
	private int count = 0;

	public DecoratedPlateImpl(Plate p) {
		this.plate = p;
	}

	@Override
	public Sushi getContents() {
		return plate.getContents();
	}

	@Override
	public void setContents(Sushi s) throws PlatePriceException {
		plate.setContents(s);
	}

	@Override
	public Sushi removeContents() {
		return plate.removeContents();
	}

	@Override
	public boolean hasContents() {
		return plate.hasContents();
	}

	@Override
	public double getPrice() {
		return plate.getPrice();
	}

	@Override
	public Color getColor() {
		return plate.getColor();
	}

	@Override
	public double getProfit() {
		return plate.getProfit();
	}

	// unwrap the decorator
	@Override
	public Plate getPlate() {
		return plate;
	}

	@Override
	public int getCount() {
		return count;
	}

	@Override
	public void updateCount() {
		count += 1;

	}

}
