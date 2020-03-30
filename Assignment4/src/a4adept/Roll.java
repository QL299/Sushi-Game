package a4adept;

public class Roll implements Sushi {

	private IngredientPortion[] ingredientPortion;
	private String Name;

	public Roll(String name, IngredientPortion[] roll_ingredients) {
		this.Name = name;
		this.ingredientPortion = roll_ingredients.clone();

		if (ingredientPortion == null) {
			throw new RuntimeException();
		}

		for (int i = 0; i < ingredientPortion.length; i++) {
			if (ingredientPortion[i] == null) {
				throw new RuntimeException();
			}
		}
	}

	public String getName() {
		return this.Name;
	}

	public IngredientPortion[] getIngredients() {
		return ingredientPortion;
	}

	public int getCalories() {
		double sum = 0.0;
		for (int i = 0; i < this.getIngredients().length; i++) {
			sum = sum + this.getIngredients()[i].getCalories();
		}

		return (int) Math.round(sum);
	}

	public double getCost() {
		double sum = 0.0;
		for (int i = 0; i < this.getIngredients().length; i++) {
			sum = sum + this.getIngredients()[i].getCost();
		}
		return Math.round(sum * 100) / 100.00;
	}

	public boolean getHasRice() {

		boolean HasRice = false;
		for (int i = 0; i < this.getIngredients().length; i++) {
			if (this.getIngredients()[i].getIsRice()) {
				HasRice = true;
			}
		}
		return HasRice;
	}

	public boolean getHasShellfish() {
		boolean HasShellfish = false;
		for (int i = 0; i < this.getIngredients().length; i++) {
			if (this.getIngredients()[i].getIsShellfish()) {
				HasShellfish = true;
			}
		}
		return HasShellfish;
	}

	public boolean getIsVegetarian() {
		boolean Vegetarian = true;
		for (int i = 0; i < this.getIngredients().length; i++) {
			if (!this.getIngredients()[i].getIsVegetarian()) {
				Vegetarian = false;
			}
		}
		return Vegetarian;
	}

}
