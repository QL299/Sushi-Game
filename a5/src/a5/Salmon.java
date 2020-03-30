package a5;

public class Salmon implements Ingredient {

	public Salmon() {

	}

	public String getName() {
		return "salmon";
	}

	public double getCaloriesPerDollar() {
		return (56 / 0.72);
	}

	public int getCaloriesPerOunce() {
		return 56;
	}

	public double getPricePerOunce() {
		return 0.72;
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
