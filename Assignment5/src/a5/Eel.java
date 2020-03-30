package a5;

public class Eel implements Ingredient {

	public Eel() {

	}

	public String getName() {
		return "eel";
	}

	public double getCaloriesPerDollar() {
		return (84 / 2.18);
	}

	public int getCaloriesPerOunce() {
		return 84;
	}

	public double getPricePerOunce() {
		return 2.18;
	}

	public boolean equals(Ingredient other) {
		boolean equal = true;

		if (!this.getName().equals(other.getName())) {
			equal = false;
		} else if (this.getCaloriesPerOunce() != other.getCaloriesPerOunce()) {
			equal = false;
		} else if (!(this.getPricePerOunce() - other.getPricePerOunce() <= 0.01)) {
			equal = false;
		} else if (this.getIsRice() != other.getIsRice()) {
			equal = false;
		} else if (this.getIsShellfish() != other.getIsShellfish()) {
			equal = false;
		} else if (this.getIsVegetarian() != other.getIsVegetarian()) {
			equal = false;
		}

		return equal;
	}

	public boolean getIsVegetarian() {
		return false;
	}

	public boolean getIsRice() {
		return false;
	}

	public boolean getIsShellfish() {
		return false;
	}

}
