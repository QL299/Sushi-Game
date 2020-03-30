package a4novice;

public class RicePortion implements IngredientPortion {

	private double amount;
	private Ingredient rice = new Rice();

	public RicePortion(double amount) {

		if (amount <= 0) {
			throw new RuntimeException();
		}
		this.amount = amount;

	}

	public Ingredient getIngredient() {
		return rice;
	}

	public String getName() {
		return rice.getName();
	}

	public double getAmount() {
		return amount;
	}

	public double getCalories() {
		return amount * rice.getCaloriesPerOunce();
	}

	public double getCost() {
		return amount * rice.getPricePerOunce();
	}

	public boolean getIsVegetarian() {
		return rice.getIsVegetarian();
	}

	public boolean getIsRice() {
		return rice.getIsRice();
	}

	public boolean getIsShellfish() {
		return rice.getIsShellfish();
	}

	public IngredientPortion combine(IngredientPortion other) {
		IngredientPortion combine;
		if (other == null) {
			combine = new RicePortion(amount);
		} else if (!other.getName().equals(this.getName())) {
			throw new RuntimeException();
		} else {
			combine = new RicePortion(amount + other.getAmount());
		}
		return combine;
	}

}
