package a4test;

import a4adept.*;

import static org.junit.Assert.*;

import org.junit.Test;

import a4adept.Nigiri.NigiriType;
import a4adept.Sashimi.SashimiType;

public class A4AdeptTest {


	@Test
	public void testSashimiGetName(){
		Sushi sashimi1 = new Sashimi(SashimiType.TUNA);
		Sushi sashimi2 = new Sashimi(SashimiType.SALMON);
		Sushi sashimi3 = new Sashimi(SashimiType.EEL);
		Sushi sashimi4 = new Sashimi(SashimiType.CRAB);
		Sushi sashimi5 = new Sashimi(SashimiType.SHRIMP);

		assertEquals("tuna sashimi", sashimi1.getName());
		assertEquals("salmon sashimi", sashimi2.getName());
		assertEquals("eel sashimi", sashimi3.getName());
		assertEquals("crab sashimi", sashimi4.getName());
		assertEquals("shrimp sashimi", sashimi5.getName());

	}

	@Test
	public void testNigiriGetName(){
		Nigiri nigiri1 = new Nigiri(NigiriType.TUNA);
		Nigiri nigiri2 = new Nigiri(NigiriType.SALMON);
		Nigiri nigiri3 = new Nigiri(NigiriType.EEL);
		Nigiri nigiri4 = new Nigiri(NigiriType.CRAB);
		Nigiri nigiri5 = new Nigiri(NigiriType.SHRIMP);

		assertEquals("tuna nigiri", nigiri1.getName());
		assertEquals("salmon nigiri", nigiri2.getName());
		assertEquals("eel nigiri", nigiri3.getName());
		assertEquals("crab nigiri", nigiri4.getName());
		assertEquals("shrimp nigiri", nigiri5.getName());
	}

	@Test
	public void testSashimiGetCalories(){
		Sushi sashimi1 = new Sashimi(SashimiType.TUNA);
		Sushi sashimi2 = new Sashimi(SashimiType.SALMON);
		Sushi sashimi3 = new Sashimi(SashimiType.EEL);
		Sushi sashimi4 = new Sashimi(SashimiType.CRAB);
		Sushi sashimi5 = new Sashimi(SashimiType.SHRIMP);

		assertEquals(Math.round(0.75*48), sashimi1.getCalories());
		assertEquals(Math.round(0.75*56), sashimi2.getCalories());
		assertEquals(Math.round(0.75*84), sashimi3.getCalories());
		assertEquals(Math.round(0.75*36), sashimi4.getCalories());
		assertEquals(Math.round(0.75*39), sashimi5.getCalories());
	}

	@Test
	public void testNigiriGetCalories(){
		Nigiri nigiri1 = new Nigiri(NigiriType.TUNA);
		Nigiri nigiri2 = new Nigiri(NigiriType.SALMON);
		Nigiri nigiri3 = new Nigiri(NigiriType.EEL);
		Nigiri nigiri4 = new Nigiri(NigiriType.CRAB);
		Nigiri nigiri5 = new Nigiri(NigiriType.SHRIMP);

		assertEquals(Math.round(0.75*48+0.5*37), nigiri1.getCalories());
		assertEquals(Math.round(0.75*56+0.5*37), nigiri2.getCalories());
		assertEquals(Math.round(0.75*84+0.5*37), nigiri3.getCalories());
		assertEquals(Math.round(0.75*36+0.5*37), nigiri4.getCalories());
		assertEquals(Math.round(0.75*39+0.5*37), nigiri5.getCalories());
	}

	@Test
	public void testSashimiGetIngredients(){
		Sushi sashimi1 = new Sashimi(SashimiType.SHRIMP);
		Sushi sashimi2 = new Sashimi(SashimiType.SALMON);
		Sushi sashimi3 = new Sashimi(SashimiType.EEL);
		Sushi sashimi4 = new Sashimi(SashimiType.CRAB);
		Sushi sashimi5 = new Sashimi(SashimiType.TUNA);

		IngredientPortion[] ipa = sashimi1.getIngredients();
		assertNotNull(ipa);
		assertEquals(1, ipa.length);
		assertNotNull(ipa[0]);
		assertTrue(ipa[0].getIngredient().equals(new Shrimp()));
		assertEquals(0.75, ipa[0].getAmount(), 0.0001);

		ipa = sashimi2.getIngredients();
		assertNotNull(ipa);
		assertEquals(1, ipa.length);
		assertNotNull(ipa[0]);
		assertTrue(ipa[0].getIngredient().equals(new Salmon()));
		assertEquals(0.75, ipa[0].getAmount(), 0.0001);

		ipa = sashimi3.getIngredients();
		assertNotNull(ipa);
		assertEquals(1, ipa.length);
		assertNotNull(ipa[0]);
		assertTrue(ipa[0].getIngredient().equals(new Eel()));
		assertEquals(0.75, ipa[0].getAmount(), 0.0001);

		ipa = sashimi4.getIngredients();
		assertNotNull(ipa);
		assertEquals(1, ipa.length);
		assertNotNull(ipa[0]);
		assertTrue(ipa[0].getIngredient().equals(new Crab()));
		assertEquals(0.75, ipa[0].getAmount(), 0.0001);

		ipa = sashimi5.getIngredients();
		assertNotNull(ipa);
		assertEquals(1, ipa.length);
		assertNotNull(ipa[0]);
		assertTrue(ipa[0].getIngredient().equals(new Tuna()));
		assertEquals(0.75, ipa[0].getAmount(), 0.0001);
	}

	@Test
	public void testNigiriGetIngredients(){
		Ingredient rice = new Rice();

		Sushi nigiri1 = new Nigiri(NigiriType.SHRIMP);
		Sushi nigiri2 = new Nigiri(NigiriType.SALMON);
		Sushi nigiri3 = new Nigiri(NigiriType.EEL);
		Sushi nigiri4 = new Nigiri(NigiriType.CRAB);
		Sushi nigiri5 = new Nigiri(NigiriType.TUNA);

		IngredientPortion[] ipa = nigiri1.getIngredients();
		assertNotNull(ipa);
		assertEquals(2, ipa.length);
		assertNotNull(ipa[0]);
		assertNotNull(ipa[1]);
		if (ipa[0].getIsRice()) {
			assertTrue(ipa[0].getIngredient().equals(rice));
			assertEquals(0.5, ipa[0].getAmount(), 0.0001);
			assertTrue(ipa[1].getIngredient().equals(new Shrimp()));
			assertEquals(0.75, ipa[1].getAmount(), 0.0001);
		} else {
			assertTrue(ipa[1].getIngredient().equals(rice));
			assertEquals(0.5, ipa[1].getAmount(), 0.0001);
			assertTrue(ipa[0].getIngredient().equals(new Shrimp()));
			assertEquals(0.75, ipa[0].getAmount(), 0.0001);
		}

		ipa = nigiri2.getIngredients();
		assertNotNull(ipa);
		assertEquals(2, ipa.length);
		assertNotNull(ipa[0]);
		assertNotNull(ipa[1]);
		if (ipa[0].getIsRice()) {
			assertTrue(ipa[0].getIngredient().equals(rice));
			assertEquals(0.5, ipa[0].getAmount(), 0.0001);
			assertTrue(ipa[1].getIngredient().equals(new Salmon()));
			assertEquals(0.75, ipa[1].getAmount(), 0.0001);
		} else {
			assertTrue(ipa[1].getIngredient().equals(rice));
			assertEquals(0.5, ipa[1].getAmount(), 0.0001);
			assertTrue(ipa[0].getIngredient().equals(new Salmon()));
			assertEquals(0.75, ipa[0].getAmount(), 0.0001);
		}

		ipa = nigiri3.getIngredients();
		assertNotNull(ipa);
		assertEquals(2, ipa.length);
		assertNotNull(ipa[0]);
		assertNotNull(ipa[1]);
		if (ipa[0].getIsRice()) {
			assertTrue(ipa[0].getIngredient().equals(rice));
			assertEquals(0.5, ipa[0].getAmount(), 0.0001);
			assertTrue(ipa[1].getIngredient().equals(new Eel()));
			assertEquals(0.75, ipa[1].getAmount(), 0.0001);
		} else {
			assertTrue(ipa[1].getIngredient().equals(rice));
			assertEquals(0.5, ipa[1].getAmount(), 0.0001);
			assertTrue(ipa[0].getIngredient().equals(new Eel()));
			assertEquals(0.75, ipa[0].getAmount(), 0.0001);
		}

		ipa = nigiri4.getIngredients();
		assertNotNull(ipa);
		assertEquals(2, ipa.length);
		assertNotNull(ipa[0]);
		assertNotNull(ipa[1]);
		if (ipa[0].getIsRice()) {
			assertTrue(ipa[0].getIngredient().equals(rice));
			assertEquals(0.5, ipa[0].getAmount(), 0.0001);
			assertTrue(ipa[1].getIngredient().equals(new Crab()));
			assertEquals(0.75, ipa[1].getAmount(), 0.0001);
		} else {
			assertTrue(ipa[1].getIngredient().equals(rice));
			assertEquals(0.5, ipa[1].getAmount(), 0.0001);
			assertTrue(ipa[0].getIngredient().equals(new Crab()));
			assertEquals(0.75, ipa[0].getAmount(), 0.0001);
		}

		ipa = nigiri5.getIngredients();
		assertNotNull(ipa);
		assertEquals(2, ipa.length);
		assertNotNull(ipa[0]);
		assertNotNull(ipa[1]);
		if (ipa[0].getIsRice()) {
			assertTrue(ipa[0].getIngredient().equals(rice));
			assertEquals(0.5, ipa[0].getAmount(), 0.0001);
			assertTrue(ipa[1].getIngredient().equals(new Tuna()));
			assertEquals(0.75, ipa[1].getAmount(), 0.0001);
		} else {
			assertTrue(ipa[1].getIngredient().equals(rice));
			assertEquals(0.5, ipa[1].getAmount(), 0.0001);
			assertTrue(ipa[0].getIngredient().equals(new Tuna()));
			assertEquals(0.75, ipa[0].getAmount(), 0.0001);
		}
	}

	@Test
	public void testRollGetIngredients(){
		//Roll Variables
		String name = "yummy";
		double tuna_amt = 1.2;
		double rice_amt = 0.66;
		double seaweed_amt = 0.25;
		double avocado_amt = 0.75;

		IngredientPortion[] ingredientPortion = {new RicePortion(rice_amt), new SeaweedPortion(seaweed_amt), 
				new AvocadoPortion(avocado_amt), new TunaPortion(tuna_amt)};
		Roll roll1 = new Roll(name,ingredientPortion);

		IngredientPortion[] roll_ingredients = roll1.getIngredients();
		assertNotNull(roll_ingredients);
		assertEquals(4, roll_ingredients.length);
		assertNotNull(roll_ingredients[0]);
		assertNotNull(roll_ingredients[1]);
		assertNotNull(roll_ingredients[2]);
		assertNotNull(roll_ingredients[3]);

		boolean found_rice = false;
		boolean found_tuna = false;
		boolean found_seaweed = false;
		boolean found_avocado = false;

		Ingredient rice = new Rice();
		Ingredient seaweed = new Seaweed();
		Ingredient avocado = new Avocado();
		Ingredient tuna = new Tuna();

		for (IngredientPortion i : roll_ingredients) {
			if (i.getIngredient().equals(rice)) {
				assertEquals(rice_amt, i.getAmount(), 0.0001);
				found_rice = true;
			} else if (i.getIngredient().equals(seaweed)) {
				assertEquals(seaweed_amt, i.getAmount(), 0.0001);
				found_seaweed = true;
			} else if (i.getIngredient().equals(avocado)) {
				assertEquals(avocado_amt, i.getAmount(), 0.0001);
				found_avocado = true;
			} else if (i.getIngredient().equals(tuna)) {
				assertEquals(tuna_amt, i.getAmount(), 0.0001);
				found_tuna = true;
			}
		}
		assertTrue(found_rice);
		assertTrue(found_seaweed);
		assertTrue(found_avocado);
		assertTrue(found_tuna);
	}

	@Test
	public void testRollGetCost(){
		//Roll Variables
		String name = "yummy";
		double tuna_amt = 1.2;
		double rice_amt = 0.66;
		double seaweed_amt = 0.25;
		double avocado_amt = 0.75;

		IngredientPortion[] ingredientPortion = {new RicePortion(rice_amt), new SeaweedPortion(seaweed_amt), 
				new AvocadoPortion(avocado_amt), new TunaPortion(tuna_amt)};

		Roll roll1 = new Roll(name,ingredientPortion);

		assertEquals(3.11, roll1.getCost(), 0.0001);
	}

	@Test
	public void testRollHasRice(){
		//Roll Variables
		String name = "yummy";
		double tuna_amt = 1.2;
		double rice_amt = 0.66;
		double seaweed_amt = 0.25;
		double avocado_amt = 0.75;

		IngredientPortion[] ingredientPortion = {new RicePortion(rice_amt), new SeaweedPortion(seaweed_amt), 
				new AvocadoPortion(avocado_amt), new TunaPortion(tuna_amt)};
		Roll roll1 = new Roll(name,ingredientPortion);

		assertTrue(roll1.getHasRice());
	}

	@Test
	public void testRollHasNoRice(){
		//Roll Variables
		String name = "yummy";
		double tuna_amt = 1.2;
		double seaweed_amt = 0.25;
		double avocado_amt = 0.75;

		IngredientPortion[] ingredientPortion = {new SeaweedPortion(seaweed_amt), 
				new AvocadoPortion(avocado_amt), new TunaPortion(tuna_amt)};
		Roll roll3 = new Roll(name,ingredientPortion);
		assertFalse(roll3.getHasRice());
	}

	@Test
	public void testRollGetName(){
		//Roll Variables
		String name = "yummy";
		double tuna_amt = 1.2;
		double rice_amt = 0.66;
		double seaweed_amt = 0.25;
		double avocado_amt = 0.75;

		IngredientPortion[] ingredientPortion = {new RicePortion(rice_amt), new SeaweedPortion(seaweed_amt), 
				new AvocadoPortion(avocado_amt), new TunaPortion(tuna_amt)};
		Roll roll1 = new Roll(name,ingredientPortion);

		assertEquals(name, roll1.getName());
	}

	@Test
	public void testRollArrayClone(){
		//Roll Variables
		String name = "yummy";

		AvocadoPortion avoPort = new AvocadoPortion(0.75);
		AvocadoPortion avoPort2 = new AvocadoPortion(0.12);

		IngredientPortion[] ingredientPortion = {avoPort};
		
		Roll roll1 = new Roll(name,ingredientPortion);

		IngredientPortion[] roll1Ingred = roll1.getIngredients();

		assertNotNull(roll1Ingred);
		assertEquals(1, roll1Ingred.length);
		assertNotEquals(ingredientPortion, roll1Ingred);
		assertNotNull(roll1Ingred[0]);
		assertEquals(0.75, roll1Ingred[0].getAmount(), 0.0001);

		ingredientPortion[0] = avoPort2;
		roll1Ingred = roll1.getIngredients();
		assertEquals(0.75, roll1Ingred[0].getAmount(), 0.0001);
	}

}
