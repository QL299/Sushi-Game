package a4novice;

public class AvocadoPortion implements IngredientPortion {
	private double amount;
	private Ingredient avocado = new Avocado();

	public AvocadoPortion(double amount) {
		if (amount <= 0) {
			throw new RuntimeException();
		}
		this.amount = amount;
	}

	public Ingredient getIngredient() {
		return avocado;
	}

	public String getName() {
		return avocado.getName();
	}

	public double getAmount() {
		return amount;
	}

	public double getCalories() {
		return amount * avocado.getCaloriesPerOunce();
	}

	public double getCost() {
		return amount * avocado.getPricePerOunce();
	}

	public boolean getIsVegetarian() {
		return avocado.getIsVegetarian();
	}

	public boolean getIsRice() {
		return avocado.getIsRice();
	}

	public boolean getIsShellfish() {
		return avocado.getIsShellfish();
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
