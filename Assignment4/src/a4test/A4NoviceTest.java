package a4test;

import static org.junit.Assert.*;


import org.junit.Test;

import a4novice.*;

public class A4NoviceTest {
	double amount1 = 1.34;
	double amount2 = 0.24;
	
	@Test
	public void testAvocado() {
		String name = "avocado";
		double price = 0.22;
		int cals = 45;
		boolean veg = true;
		boolean rice = false;
		boolean shell = false;
		
		Ingredient i = new Avocado();
		assertEquals(name, i.getName());
		assertEquals(price, i.getPricePerOunce(), 0.01);
		assertEquals(cals, i.getCaloriesPerOunce());
		assertEquals(cals/price, i.getCaloriesPerDollar(), 0.01);
		assertEquals(veg, i.getIsVegetarian());
		assertEquals(rice, i.getIsRice());
		assertEquals(shell, i.getIsShellfish());
	}

	@Test
	public void testCrab() {
		String name = "crab";
		double price = 0.75;
		int cals = 36;
		boolean veg = false;
		boolean rice = false;
		boolean shell = true;
		
		Ingredient i = new Crab();
		assertEquals(name, i.getName());
		assertEquals(price, i.getPricePerOunce(), 0.01);
		assertEquals(cals, i.getCaloriesPerOunce());
		assertEquals(cals/price, i.getCaloriesPerDollar(), 0.01);
		assertEquals(veg, i.getIsVegetarian());
		assertEquals(rice, i.getIsRice());
		assertEquals(shell, i.getIsShellfish());
	}
	
	@Test
	public void testEel() {
		String name = "eel";
		double price = 2.18;
		int cals = 84;
		boolean veg = false;
		boolean rice = false;
		boolean shell = false;
		
		Ingredient i = new Eel();
		assertEquals(name, i.getName());
		assertEquals(price, i.getPricePerOunce(), 0.01);
		assertEquals(cals, i.getCaloriesPerOunce());
		assertEquals(cals/price, i.getCaloriesPerDollar(), 0.01);
		assertEquals(veg, i.getIsVegetarian());
		assertEquals(rice, i.getIsRice());
		assertEquals(shell, i.getIsShellfish());
	}

	@Test
	public void testRice() {
		String name = "rice";
		double price = 0.12;
		int cals = 37;
		boolean veg = true;
		boolean rice = true;
		boolean shell = false;
		
		Ingredient i = new Rice();
		assertEquals(name, i.getName());
		assertEquals(price, i.getPricePerOunce(), 0.01);
		assertEquals(cals, i.getCaloriesPerOunce());
		assertEquals(cals/price, i.getCaloriesPerDollar(), 0.01);
		assertEquals(veg, i.getIsVegetarian());
		assertEquals(rice, i.getIsRice());
		assertEquals(shell, i.getIsShellfish());
	}
	
	@Test
	public void testSalmon() {
		String name = "salmon";
		double price = 0.72;
		int cals = 56;
		boolean veg = false;
		boolean rice = false;
		boolean shell = false;
		
		Ingredient i = new Salmon();
		assertEquals(name, i.getName());
		assertEquals(price, i.getPricePerOunce(), 0.01);
		assertEquals(cals, i.getCaloriesPerOunce());
		assertEquals(cals/price, i.getCaloriesPerDollar(), 0.01);
		assertEquals(veg, i.getIsVegetarian());
		assertEquals(rice, i.getIsRice());
		assertEquals(shell, i.getIsShellfish());
	}
	
	@Test
	public void testSeaweed() {
		String name = "seaweed";
		double price = 2.95;
		int cals = 113;
		boolean veg = true;
		boolean rice = false;
		boolean shell = false;
		
		Ingredient i = new Seaweed();
		assertEquals(name, i.getName());
		assertEquals(price, i.getPricePerOunce(), 0.01);
		assertEquals(cals, i.getCaloriesPerOunce());
		assertEquals(cals/price, i.getCaloriesPerDollar(), 0.01);
		assertEquals(veg, i.getIsVegetarian());
		assertEquals(rice, i.getIsRice());
		assertEquals(shell, i.getIsShellfish());
	}

	@Test
	public void testShrimp() {
		String name = "shrimp";
		double price = 0.55;
		int cals = 39;
		boolean veg = false;
		boolean rice = false;
		boolean shell = true;
		
		Ingredient i = new Shrimp();
		assertEquals(name, i.getName());
		assertEquals(price, i.getPricePerOunce(), 0.01);
		assertEquals(cals, i.getCaloriesPerOunce());
		assertEquals(cals/price, i.getCaloriesPerDollar(), 0.01);
		assertEquals(veg, i.getIsVegetarian());
		assertEquals(rice, i.getIsRice());
		assertEquals(shell, i.getIsShellfish());
	}

	@Test
	public void testTuna() {
		String name = "tuna";
		double price = 1.77;
		int cals = 48;
		boolean veg = false;
		boolean rice = false;
		boolean shell = false;
		
		Ingredient i = new Tuna();
		assertEquals(name, i.getName());
		assertEquals(price, i.getPricePerOunce(), 0.01);
		assertEquals(cals, i.getCaloriesPerOunce());
		assertEquals(cals/price, i.getCaloriesPerDollar(), 0.01);
		assertEquals(veg, i.getIsVegetarian());
		assertEquals(rice, i.getIsRice());
		assertEquals(shell, i.getIsShellfish());
	}
	
	@Test
	public void testAvocadoPortion() {
		double amt = Math.random() + 1.0;

		IngredientPortion p = new AvocadoPortion(amt);
		Ingredient i = new Avocado();
		
		assertTrue(i.equals(p.getIngredient()));
		assertEquals(amt, p.getAmount(), 0.00001);
		assertEquals(amt*i.getPricePerOunce(), p.getCost(), 0.0001);
		assertEquals(amt*i.getCaloriesPerOunce(), p.getCalories(), 0.0001);
		assertEquals(i.getIsVegetarian(), p.getIsVegetarian());
		assertEquals(i.getIsRice(), p.getIsRice());
		assertEquals(i.getIsShellfish(), p.getIsShellfish());
	}

	@Test
	public void testCrabPortion() {
		double amt = Math.random() + 1.0;

		IngredientPortion p = new CrabPortion(amt);
		Ingredient i = new Crab();
		
		assertTrue(i.equals(p.getIngredient()));
		assertEquals(amt, p.getAmount(), 0.00001);
		assertEquals(amt*i.getPricePerOunce(), p.getCost(), 0.0001);
		assertEquals(amt*i.getCaloriesPerOunce(), p.getCalories(), 0.0001);
		assertEquals(i.getIsVegetarian(), p.getIsVegetarian());
		assertEquals(i.getIsRice(), p.getIsRice());
		assertEquals(i.getIsShellfish(), p.getIsShellfish());
	}
	
	@Test
	public void testEelPortion() {
		double amt = Math.random() + 1.0;

		IngredientPortion p = new EelPortion(amt);
		Ingredient i = new Eel();
		
		assertTrue(i.equals(p.getIngredient()));
		assertEquals(amt, p.getAmount(), 0.00001);
		assertEquals(amt*i.getPricePerOunce(), p.getCost(), 0.0001);
		assertEquals(amt*i.getCaloriesPerOunce(), p.getCalories(), 0.0001);
		assertEquals(i.getIsVegetarian(), p.getIsVegetarian());
		assertEquals(i.getIsRice(), p.getIsRice());
		assertEquals(i.getIsShellfish(), p.getIsShellfish());
	}

	@Test
	public void testRicePortion() {
		double amt = Math.random() + 1.0;

		IngredientPortion p = new RicePortion(amt);
		Ingredient i = new Rice();
		
		assertTrue(i.equals(p.getIngredient()));
		assertEquals(amt, p.getAmount(), 0.00001);
		assertEquals(amt*i.getPricePerOunce(), p.getCost(), 0.0001);
		assertEquals(amt*i.getCaloriesPerOunce(), p.getCalories(), 0.0001);
		assertEquals(i.getIsVegetarian(), p.getIsVegetarian());
		assertEquals(i.getIsRice(), p.getIsRice());
		assertEquals(i.getIsShellfish(), p.getIsShellfish());
	}

	@Test
	public void testSalmonPortion() {
		double amt = Math.random() + 1.0;

		IngredientPortion p = new SalmonPortion(amt);
		Ingredient i = new Salmon();
		
		assertTrue(i.equals(p.getIngredient()));
		assertEquals(amt, p.getAmount(), 0.00001);
		assertEquals(amt*i.getPricePerOunce(), p.getCost(), 0.0001);
		assertEquals(amt*i.getCaloriesPerOunce(), p.getCalories(), 0.0001);
		assertEquals(i.getIsVegetarian(), p.getIsVegetarian());
		assertEquals(i.getIsRice(), p.getIsRice());
		assertEquals(i.getIsShellfish(), p.getIsShellfish());
	}

	@Test
	public void testSeaweedPortion() {
		double amt = Math.random() + 1.0;

		IngredientPortion p = new SeaweedPortion(amt);
		Ingredient i = new Seaweed();
		
		assertTrue(i.equals(p.getIngredient()));
		assertEquals(amt, p.getAmount(), 0.00001);
		assertEquals(amt*i.getPricePerOunce(), p.getCost(), 0.0001);
		assertEquals(amt*i.getCaloriesPerOunce(), p.getCalories(), 0.0001);
		assertEquals(i.getIsVegetarian(), p.getIsVegetarian());
		assertEquals(i.getIsRice(), p.getIsRice());
		assertEquals(i.getIsShellfish(), p.getIsShellfish());
	}

	@Test
	public void testShrimpPortion() {
		double amt = Math.random() + 1.0;

		IngredientPortion p = new ShrimpPortion(amt);
		Ingredient i = new Shrimp();
		
		assertTrue(i.equals(p.getIngredient()));
		assertEquals(amt, p.getAmount(), 0.00001);
		assertEquals(amt*i.getPricePerOunce(), p.getCost(), 0.0001);
		assertEquals(amt*i.getCaloriesPerOunce(), p.getCalories(), 0.0001);
		assertEquals(i.getIsVegetarian(), p.getIsVegetarian());
		assertEquals(i.getIsRice(), p.getIsRice());
		assertEquals(i.getIsShellfish(), p.getIsShellfish());
	}

	@Test
	public void testTunaPortion() {
		double amt = Math.random() + 1.0;

		IngredientPortion p = new TunaPortion(amt);
		Ingredient i = new Tuna();
		
		assertTrue(i.equals(p.getIngredient()));
		assertEquals(amt, p.getAmount(), 0.00001);
		assertEquals(amt*i.getPricePerOunce(), p.getCost(), 0.0001);
		assertEquals(amt*i.getCaloriesPerOunce(), p.getCalories(), 0.0001);
		assertEquals(i.getIsVegetarian(), p.getIsVegetarian());
		assertEquals(i.getIsRice(), p.getIsRice());
		assertEquals(i.getIsShellfish(), p.getIsShellfish());
	}


	@Test
	public void testEquals(){
		Avocado avocado1= new Avocado();
		Avocado avocado2= new Avocado();
		Crab crab1= new Crab();
		
		assertTrue(avocado1.equals(avocado2));
		assertFalse(avocado1.equals(crab1));
		assertFalse(crab1.equals(avocado2));
	}
	
	@Test
	public void testCombine(){
		AvocadoPortion ap1 = new AvocadoPortion(amount1);
		AvocadoPortion ap2 = new AvocadoPortion(amount2);
		IngredientPortion ap3 = ap1.combine(ap2);
		CrabPortion cp1= new CrabPortion(2);
		
		assertEquals(amount1+amount2, ap3.getAmount(), 0.0001);
		assertTrue(ap3.getIngredient().equals(new Avocado()));
	}
	
	@Test (expected = RuntimeException.class)
	public void testBadCombine(){
		AvocadoPortion ap1 = new AvocadoPortion(amount1);
		AvocadoPortion ap2 = new AvocadoPortion(amount2);
		IngredientPortion ap3 = ap1.combine(ap2);
		CrabPortion cp1= new CrabPortion(2);
		
		ap1.combine(cp1);
		fail("Expected RuntimeException to be thrown");
	}
	

	@Test
	public void testBadAmount(){
		try {
			IngredientPortion ip = new AvocadoPortion(-2);
			fail("Expected RuntimeException to be thrown");
		} catch (RuntimeException e) {
		}
		try {
			IngredientPortion ip = new CrabPortion(-2);
			fail("Expected RuntimeException to be thrown");
		} catch (RuntimeException e) {
		}
		try {
			IngredientPortion ip = new EelPortion(-2);
			fail("Expected RuntimeException to be thrown");
		} catch (RuntimeException e) {
		}
		try {
			IngredientPortion ip = new RicePortion(-2);
			fail("Expected RuntimeException to be thrown");
		} catch (RuntimeException e) {
		}
		try {
			IngredientPortion ip = new SalmonPortion(-2);
			fail("Expected RuntimeException to be thrown");
		} catch (RuntimeException e) {
		}
		try {
			IngredientPortion ip = new SeaweedPortion(-2);
			fail("Expected RuntimeException to be thrown");
		} catch (RuntimeException e) {
		}
		try {
			IngredientPortion ip = new ShrimpPortion(-2);
			fail("Expected RuntimeException to be thrown");
		} catch (RuntimeException e) {
		}
		try {
			IngredientPortion ip = new TunaPortion(-2);
			fail("Expected RuntimeException to be thrown");
		} catch (RuntimeException e) {
		}
	}
	

}
