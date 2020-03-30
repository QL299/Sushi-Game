package a4jedi;

public class Sashimi implements Sushi {

	public enum SashimiType {
		TUNA, SALMON, EEL, CRAB, SHRIMP
	};

	private IngredientPortion ingredientPortion;
	private String name;

	public Sashimi(SashimiType type) {

		switch (type) {
		case TUNA:
			this.ingredientPortion = new TunaPortion(0.75);
			this.name = "tuna sashimi";
			break;
		case SALMON:
			this.ingredientPortion = new SalmonPortion(0.75);
			this.name = "salmon sashimi";
			break;
		case EEL:
			this.ingredientPortion = new EelPortion(0.75);
			this.name = "eel sashimi";
			break;
		case CRAB:
			this.ingredientPortion = new CrabPortion(0.75);
			this.name = "crab sashimi";
			break;
		case SHRIMP:
			this.ingredientPortion = new ShrimpPortion(0.75);
			this.name = "shrimp sashimi";
			break;
		default:
			throw new RuntimeException();
		}

	}

	public String getName() {
		return this.name;
	}

	public IngredientPortion[] getIngredients() {
		IngredientPortion[] ingredientArray = new IngredientPortion[1];
		ingredientArray[0] = ingredientPortion;
		return ingredientArray;
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
