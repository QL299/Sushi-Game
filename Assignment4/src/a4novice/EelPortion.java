package a4novice;

public class EelPortion implements IngredientPortion {
	private double amount;
	private Ingredient eel = new Eel();

	public EelPortion(double amount) {
		if (amount <= 0) {
			throw new RuntimeException();
		}
		this.amount = amount;
	}

	public Ingredient getIngredient() {
		return eel;
	}

	public String getName() {
		return eel.getName();
	}

	public double getAmount() {
		return amount;
	}

	public double getCalories() {
		return amount * eel.getCaloriesPerOunce();
	}

	public double getCost() {
		return amount * eel.getPricePerOunce();
	}

	public boolean getIsVegetarian() {
		return eel.getIsVegetarian();
	}

	public boolean getIsRice() {
		return eel.getIsRice();
	}

	public boolean getIsShellfish() {
		return eel.getIsShellfish();
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

