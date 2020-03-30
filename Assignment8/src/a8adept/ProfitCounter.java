package a8adept;

import java.util.Observable;
import java.util.Observer;

public class ProfitCounter implements Observer {

	private Belt belt;

	public ProfitCounter(Belt belt) {
		if (belt == null) {
			throw new IllegalArgumentException();
		}
		belt.addObserver(this);
		this.belt = belt;
	}

	@Override
	public void update(Observable o, Object arg) {
		Belt belt = (Belt) o;
		this.belt = belt;
		PlateEvent plate_event = (PlateEvent) arg;
	}

	public double getTotalBeltProfit() {
		double tProfit = 0.0;
		for (int i = 0; i < belt.getSize(); i++) {
			if (belt.getPlateAtPosition(i) != null) {
				tProfit += belt.getPlateAtPosition(i).getProfit();
			}
		}
		return tProfit;
	}

	public double getAverageBeltProfit() {
		int tNumber = 0;
		for (int i = 0; i < belt.getSize(); i++) {
			if (belt.getPlateAtPosition(i) != null) {
				tNumber++;
			}
		}

		if (tNumber == 0) {
			return 0.0;
		}

		return this.getTotalBeltProfit() / tNumber;
	}

}
