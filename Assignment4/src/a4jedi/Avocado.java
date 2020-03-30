package a4jedi;

public class Avocado implements Ingredient {

	public Avocado() {

	}

	public String getName() {
		return "avocado";
	}

	public double getCaloriesPerDollar() {
		return (45 / 0.22);
	}

	public int getCaloriesPerOunce() {
		return 45;
	}

	public double getPricePerOunce() {
		return 0.22;
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
		return true;
	}

	public boolean getIsRice() {
		return false;
	}

	public boolean getIsShellfish() {
		return false;
	}

}
