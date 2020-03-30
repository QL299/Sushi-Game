package a3jedi;

public class IngredientPortionImpl implements IngredientPortion{
	
	private Ingredient ing;
	private double amount;
	
	public IngredientPortionImpl(Ingredient ing, double amount) {
		this.ing = ing;
		this.amount = amount;
		if(ing == null | amount <= 0) {
			throw new RuntimeException();
		}
	}

	public Ingredient getIngredient() {
		return ing;
	}

	public double getAmount() {
		return amount;
	}
	
	public double getCalories() {
		return amount * ing.getCaloriesPerOunce();
	}
	
	public double getCost(){
		return amount * ing.getPricePerOunce();
	}
	
	public boolean getIsVegetarian() {
		return ing.getIsVegetarian();
	}
	
	public String getName() {
		return ing.getName();
	}
	
	public IngredientPortion combine(IngredientPortion other) {
		if (other == null) {
			return this;
		} else if (!other.getName().equals(ing.getName())) {
			throw new RuntimeException();
		} else {
			IngredientPortion combine = new IngredientPortionImpl(ing, other.getAmount() + this.getAmount());
			return combine;
		}
	}
	
}
