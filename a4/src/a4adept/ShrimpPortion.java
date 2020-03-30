package a4adept;

public class ShrimpPortion implements IngredientPortion {

	private double amount;
	private Ingredient shrimp = new Shrimp();

	public ShrimpPortion(double amount) {

		if (amount <= 0) {
			throw new RuntimeException();
		}
		this.amount = amount;

	}

	public Ingredient getIngredient() {
		return shrimp;
	}

	public String getName() {
		return shrimp.getName();
	}

	public double getAmount() {
		return amount;
	}

	public double getCalories() {
		return amount * shrimp.getCaloriesPerOunce();
	}

	public double getCost() {
		return amount * shrimp.getPricePerOunce();
	}

	public boolean getIsVegetarian() {
		return shrimp.getIsVegetarian();
	}

	public boolean getIsRice() {
		return shrimp.getIsRice();
	}

	public boolean getIsShellfish() {
		return shrimp.getIsShellfish();
	}

	public IngredientPortion combine(IngredientPortion other) {
		IngredientPortion combine;
		if (other == null) {
			combine = new ShrimpPortion(amount);
		} else if (!other.getName().equals(this.getName())) {
			throw new RuntimeException();
		} else {
			combine = new ShrimpPortion(amount + other.getAmount());
		}
		return combine;
	}

}
