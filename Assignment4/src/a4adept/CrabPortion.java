package a4adept;

public class CrabPortion implements IngredientPortion {
	private double amount;
	private Ingredient crab = new Crab();

	public CrabPortion(double amount) {
		if (amount <= 0) {
			throw new RuntimeException();
		}
		this.amount = amount;
	}

	public Ingredient getIngredient() {
		return crab;
	}

	public String getName() {
		return crab.getName();
	}

	public double getAmount() {
		return amount;
	}

	public double getCalories() {
		return amount * crab.getCaloriesPerOunce();
	}

	public double getCost() {
		return amount * crab.getPricePerOunce();
	}

	public boolean getIsVegetarian() {
		return crab.getIsVegetarian();
	}

	public boolean getIsRice() {
		return crab.getIsRice();
	}

	public boolean getIsShellfish() {
		return crab.getIsShellfish();
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

