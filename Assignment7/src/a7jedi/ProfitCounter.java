package a7jedi;

import java.util.Observable;
import java.util.Observer;

import comp401.sushi.Plate;

public class ProfitCounter implements Observer {

	private Belt belt;

	public ProfitCounter(Belt b) {
		b.addObserver(this);
	}

	@Override
	public void update(Observable o, Object arg) {
		Belt belt = (Belt) o;
		this.belt = belt;
		PlateEvent plate_event = (PlateEvent) arg;
	}

	public double getTotalBeltProfit() {
		double total_Profit = 0.0;
		for (int i = 0; i < belt.getSize(); i++) {
			if (belt.getPlateAtPosition(i) != null) {
				total_Profit += belt.getPlateAtPosition(i).getProfit();
			}
		}
		return total_Profit;
	}

	public double getAverageBeltProfit() {
		int aNumber = 0;
		for (int i = 0; i < belt.getSize(); i++) {
			if (belt.getPlateAtPosition(i) != null) {
				aNumber++;
			}
		}
		if (aNumber == 0) {
			return 0.0;
		}
		return this.getTotalBeltProfit() / aNumber;
	}

}
