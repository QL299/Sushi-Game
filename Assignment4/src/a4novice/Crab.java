package a4novice;

public class Crab implements Ingredient {

	public Crab() {
		
	}
	
	public String getName() {
		return "crab";
	}
	
	public double getCaloriesPerDollar() {
		return (36 / 0.75);
	}

	public int getCaloriesPerOunce() {
		return 36;
	}

	public double getPricePerOunce() {
		return 0.75;
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
		return true;
	}
}
