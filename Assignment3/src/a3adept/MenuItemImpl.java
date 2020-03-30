package a3adept;

public class MenuItemImpl implements MenuItem{
	
	private String name;
	private IngredientPortion[] ingredients;
	
	public MenuItemImpl(String name, IngredientPortion[] ingredients) {
		this.name = name;
		this.ingredients = ingredients.clone();
		if(name == null | ingredients == null | ingredients.length <0) {
			throw new RuntimeException();
		}
		for (IngredientPortion a : ingredients) {
			if (a == null) {
				throw new RuntimeException();
			}
		}
	}
	
	public String getName() {
		return name;
	}
	
	public IngredientPortion[] getIngredients() {
		return ingredients.clone();
		}
	
	public int getCalories() {
		double sum = 0.0;
		IngredientPortion[] a = this.getIngredients().clone();
		for (int i = 0; i < a.length; i++) {
			sum = a[i].getCalories() + sum;
		}
		int sum2 = ((int) (sum + 0.5));
		return sum2;
	}

	public double getCost() {
		double cost = 0.0;
		IngredientPortion[] a = this.getIngredients().clone();
		for (int i = 0; i < a.length; i++) {
			cost = a[i].getCost() + cost;
		}
		double cost2 = ((int) ((cost * 100.0) + 0.5)) / 100.0;
		return cost2;
	}

	public boolean getIsVegetarian() {
		boolean vegetarian = true;
		IngredientPortion[] a = this.getIngredients().clone();
		for (int i = 0; i < a.length; i++) {
			if (a[i].getIsVegetarian() == false) {
				vegetarian = false;
			}
		}
		return vegetarian;
	}
		
	
	}
	
