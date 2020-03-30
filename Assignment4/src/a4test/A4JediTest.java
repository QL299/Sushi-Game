package a4test;

import a4jedi.*;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class A4JediTest {
	
	@Test
	public void testAddDuplicates() {
		String name = "yummy";
		double tuna_amt = 1.2;
		double rice_amt = 0.33;
		double seaweed_amt = 0.25;
		double avocado_amt = 0.75;

		IngredientPortion[] ingredientPortion = {new RicePortion(rice_amt), new SeaweedPortion(seaweed_amt), 
                new AvocadoPortion(avocado_amt), new TunaPortion(tuna_amt),new RicePortion(rice_amt),};
		Roll roll = new Roll(name,ingredientPortion);

		for (IngredientPortion ip : roll.getIngredients()) {
			if (ip.getIsRice()) {
				assertEquals(rice_amt*2.0, ip.getAmount(), 0.01);
			}
		}
		assertEquals(3.11, roll.getCost(), 0.01);
	}
	
	
	@Test
	public void testAddSeaweedIfNot(){
		String name = "yummy";
		double tuna_amt = 1.2;
		double rice_amt = 0.33;
		double avocado_amt = 0.75;

		IngredientPortion[] ingredientPortion = {new RicePortion(rice_amt),
				new AvocadoPortion(avocado_amt), new TunaPortion(tuna_amt)};

		Roll roll = new Roll(name,ingredientPortion);
		
		// test if seaweed is added if not in roll constructor
		// iterating through returned ingredient portions to see if seaweed is there
		boolean hasSeaweed=false;
		for(IngredientPortion ip: roll.getIngredients()){
			if(ip.getIngredient().equals(new Seaweed())){
				hasSeaweed = true;
			}
		}
		assertTrue(hasSeaweed);
		assertEquals(115, roll.getCalories());
	}

	@Test
	public void testAddEnoughSeaweedIfNot(){
		String name = "yummy";
		double tuna_amt = 1.2;
		double rice_amt = 0.33;
		double seaweed_amt = 0.05;
		double avocado_amt = 0.75;

		IngredientPortion[] ingredientPortion = {new RicePortion(rice_amt),
				new AvocadoPortion(avocado_amt), new TunaPortion(tuna_amt), new SeaweedPortion(seaweed_amt)};

		Roll roll = new Roll(name,ingredientPortion);
		
		// test if seaweed is added if not in roll constructor
		// iterating through returned ingredient portions to see if seaweed is there
		boolean hasSeaweed=false;
		for(IngredientPortion ip: roll.getIngredients()){
			if(ip.getIngredient().equals(new Seaweed())){
				hasSeaweed = true;
			}
		}
		assertTrue(hasSeaweed);
		assertEquals(115, roll.getCalories());
	}
	
}
