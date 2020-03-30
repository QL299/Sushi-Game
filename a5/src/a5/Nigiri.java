package a5;

public class Nigiri implements Sushi {

	public enum NigiriType {
		TUNA, SALMON, EEL, CRAB, SHRIMP
	};

	private IngredientPortion ingredientPortion;
	private String name;

	public Nigiri(NigiriType type) {
		switch (type) {
		case TUNA:
			ingredientPortion = new TunaPortion(0.75);
			this.name = "tuna sashimi";
			break;
		case SALMON:
			ingredientPortion = new SalmonPortion(0.75);
			this.name = "salmon nigiri";
			break;
		case EEL:
			ingredientPortion = new EelPortion(0.75);
			this.name = "eel nigiri";
			break;
		case CRAB:
			ingredientPortion = new CrabPortion(0.75);
			this.name = "crab nigiri";
			break;
		case SHRIMP:
			ingredientPortion = new ShrimpPortion(0.75);
			this.name = "shrimp nigiri";
			break;
		default:
			throw new RuntimeException("Nigiri needs to be made of a seafood and rice.");

		}

	}

	public String getName() {
		return this.name;
	}

	public IngredientPortion[] getIngredients() {
		IngredientPortion[] ingredientArray = new IngredientPortion[2];
		ingredientArray[0] = ingredientPortion;
		ingredientArray[1] = new RicePortion(0.5);
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
