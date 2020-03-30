package a5;

import java.util.HashMap;
import java.util.Map;

public class Roll implements Sushi {

	private String Name;
	private IngredientPortion[] ingredientPortion;

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

		Map<String, IngredientPortion> map = new HashMap<String, IngredientPortion>();
		for (IngredientPortion i : roll_ingredients) {
			if (map.containsKey(i.getName())) {
				map.put(i.getName(), map.get(i.getName()).combine(i));
			} else {
				map.put(i.getName(), i);
			}
		}

		if (!map.containsKey("seaweed") || map.get("seaweed").getAmount() < 0.1) {
			map.put("seaweed", new SeaweedPortion(0.1));
		}

		ingredientPortion = map.values().toArray(new IngredientPortion[0]);
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
		return (Math.round(sum * 100)) / 100.0;
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
