package a4novice;

public class SeaweedPortion implements IngredientPortion {
	private double amount;
	private Ingredient seaweed = new Seaweed();

	public SeaweedPortion(double amount) {
		if (amount <= 0) {
			throw new RuntimeException();
		}
		this.amount = amount;
	}

	public Ingredient getIngredient() {
		return seaweed;
	}

	public String getName() {
		return seaweed.getName();
	}

	public double getAmount() {
		return amount;
	}

	public double getCalories() {
		return amount * seaweed.getCaloriesPerOunce();
	}

	public double getCost() {
		return amount * seaweed.getPricePerOunce();
	}

	public boolean getIsVegetarian() {
		return seaweed.getIsVegetarian();
	}

	public boolean getIsRice() {
		return seaweed.getIsRice();
	}

	public boolean getIsShellfish() {
		return seaweed.getIsShellfish();
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

