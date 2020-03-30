package a4adept;

public class Shrimp implements Ingredient {

    public Shrimp() {
		
	}
	
	public String getName() {
		return "shrimp";
	}
	
	public double getCaloriesPerDollar() {
		return (39 / 0.55);
	}

	public int getCaloriesPerOunce() {
		return 39;
	}

	public double getPricePerOunce() {
		return 0.55;
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