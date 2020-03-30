package a4novice;

public class TunaPortion implements IngredientPortion {
	private double amount;
	private Ingredient tuna = new Tuna();

	public TunaPortion(double amount) {
		if (amount <= 0) {
			throw new RuntimeException();
		}
		this.amount = amount;
	}

	public Ingredient getIngredient() {
		return tuna;
	}

	public String getName() {
		return tuna.getName();
	}

	public double getAmount() {
		return amount;
	}

	public double getCalories() {
		return amount * tuna.getCaloriesPerOunce();
	}

	public double getCost() {
		return amount * tuna.getPricePerOunce();
	}

	public boolean getIsVegetarian() {
		return tuna.getIsVegetarian();
	}

	public boolean getIsRice() {
		return tuna.getIsRice();
	}

	public boolean getIsShellfish() {
		return tuna.getIsShellfish();
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

