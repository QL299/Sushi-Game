package a8jedi;

import comp401.sushi.Plate;

public interface DecoratedPlate extends Plate {

	public Plate getPlate();

	public int getCount();

	public void updateCount();

}
