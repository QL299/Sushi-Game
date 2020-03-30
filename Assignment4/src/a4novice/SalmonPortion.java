package a4novice;

public class SalmonPortion implements IngredientPortion {
	private double amount;
	private Ingredient salmon = new Salmon();

	public SalmonPortion(double amount) {
		if (amount <= 0) {
			throw new RuntimeException();
		}
		this.amount = amount;
	}

	public Ingredient getIngredient() {
		return salmon;
	}

	public String getName() {
		return salmon.getName();
	}

	public double getAmount() {
		return amount;
	}

	public double getCalories() {
		return amount * salmon.getCaloriesPerOunce();
	}

	public double getCost() {
		return amount * salmon.getPricePerOunce();
	}

	public boolean getIsVegetarian() {
		return salmon.getIsVegetarian();
	}

	public boolean getIsRice() {
		return salmon.getIsRice();
	}

	public boolean getIsShellfish() {
		return salmon.getIsShellfish();
	}

	public IngredientPortion combine(IngredientPortion other) {
		IngredientPortion combine;
		if (other == null) {
			combine = new AvocadoPortion(amount);
		} else if (!other.getName().equals(this.getName())) {
			throw new RuntimeException();
		} else {
			combine = new AvocadoPortion(amount + other.getAmount());
		}
		return combine;
	}

}

