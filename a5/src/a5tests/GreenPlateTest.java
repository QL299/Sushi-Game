package a5tests;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import a5.AvocadoPortion;
import a5.IngredientPortion;
import a5.Plate;
import a5.PlatePriceException;
import a5.RedPlate;
import a5.GreenPlate;
import a5.RicePortion;
import a5.Roll;
import a5.Salmon;
import a5.SalmonPortion;
import a5.SeaweedPortion;
import a5.ShrimpPortion;
import a5.Sushi;

public class GreenPlateTest {
	
	@Test
	public void checkException() {
		AvocadoPortion slice = new AvocadoPortion(200);
		RicePortion scoop = new RicePortion(0.03);
		SeaweedPortion section = new SeaweedPortion(0.01);
		ShrimpPortion shrimp = new ShrimpPortion(0.04);
		IngredientPortion[] favs = new IngredientPortion [] {slice, scoop, section, shrimp};
		Roll my_Roll = new Roll ("My Roll", favs);
		try {
			RedPlate my_plate = new RedPlate(my_Roll);
		} catch (PlatePriceException e) {
			System.out.println("Your exception works!");
			e.printStackTrace();
		}
	}
	@Test
	public void checkGetContents() throws PlatePriceException {
		AvocadoPortion slice = new AvocadoPortion(0.02);
		RicePortion scoop = new RicePortion(0.03);
		SeaweedPortion section = new SeaweedPortion(0.01);
		ShrimpPortion shrimp = new ShrimpPortion(0.04);
		IngredientPortion[] favs = new IngredientPortion [] {slice, scoop, section, shrimp};
		Roll my_Roll = new Roll ("My Roll", favs);
		GreenPlate my_plate = new GreenPlate(my_Roll);
		assertEquals(my_Roll.getIngredients()[0], my_plate.getContents().getIngredients()[0]);
	}
	
	@Test 
	public void checkRemoveContents() throws PlatePriceException {
		AvocadoPortion slice = new AvocadoPortion(0.02);
		RicePortion scoop = new RicePortion(0.03);
		SeaweedPortion section = new SeaweedPortion(0.01);
		ShrimpPortion shrimp = new ShrimpPortion(0.04);
		IngredientPortion[] favs = new IngredientPortion [] {slice, scoop, section, shrimp};
		Roll my_Roll = new Roll ("My Roll", favs);
		GreenPlate my_plate = new GreenPlate(my_Roll);
		assertEquals(my_plate.removeContents(), null);
	}
	
	@Test
	public void checkSetContents() throws PlatePriceException {
	AvocadoPortion slice = new AvocadoPortion(0.02);
	RicePortion scoop = new RicePortion(0.03);
	SeaweedPortion section = new SeaweedPortion(0.01);
	ShrimpPortion shrimp = new ShrimpPortion(0.04);
	IngredientPortion[] favs = new IngredientPortion [] {slice, scoop, section, shrimp};
	Roll my_Roll = new Roll ("My Roll", favs);
	GreenPlate my_plate = new GreenPlate(my_Roll);
	AvocadoPortion slice1 = new AvocadoPortion(0.02);
	RicePortion scoop1 = new RicePortion(0.03);
	IngredientPortion[] favs1 = new IngredientPortion [] {slice1, scoop1};
	Roll diet_roll = new Roll ("diet roll", favs1);
	my_plate.setContents(diet_roll);
	assertEquals(my_plate.getContents(), diet_roll);
	}
	
	@Test
	public void checkHasContents() throws PlatePriceException {
		AvocadoPortion slice = new AvocadoPortion(0.02);
		RicePortion scoop = new RicePortion(0.03);
		SeaweedPortion section = new SeaweedPortion(0.01);
		ShrimpPortion shrimp = new ShrimpPortion(0.04);
		IngredientPortion[] favs = new IngredientPortion [] {slice, scoop, section, shrimp};
		Roll my_Roll = new Roll ("My Roll", favs);
		GreenPlate my_plate = new GreenPlate(my_Roll);
		GreenPlate not_my_plate = new GreenPlate(null);
		assertTrue(my_plate.hasContents());
		assertFalse(not_my_plate.hasContents());
	}
	
	@Test 
	public void checkGetPrice() throws PlatePriceException {
		AvocadoPortion slice = new AvocadoPortion(0.02);
		RicePortion scoop = new RicePortion(0.03);
		SeaweedPortion section = new SeaweedPortion(0.01);
		ShrimpPortion shrimp = new ShrimpPortion(0.04);
		IngredientPortion[] favs = new IngredientPortion [] {slice, scoop, section, shrimp};
		Roll my_Roll = new Roll ("My Roll", favs);
		GreenPlate my_plate = new GreenPlate(my_Roll);
		assertEquals(my_plate.getPrice(), 2.0, 0.01);
		
	}
	
	@Test 
	public void checkGetColor() throws PlatePriceException {
		AvocadoPortion slice = new AvocadoPortion(0.02);
		RicePortion scoop = new RicePortion(0.03);
		SeaweedPortion section = new SeaweedPortion(0.01);
		ShrimpPortion shrimp = new ShrimpPortion(0.04);
		IngredientPortion[] favs = new IngredientPortion [] {slice, scoop, section, shrimp};
		Roll my_Roll = new Roll ("My Roll", favs);
		GreenPlate my_plate = new GreenPlate(my_Roll);
		assertEquals(my_plate.getColor(), Plate.Color.GREEN);
	}
	
	@Test 
	public void checkGetProfit() throws PlatePriceException {
		AvocadoPortion slice = new AvocadoPortion(0.02);
		RicePortion scoop = new RicePortion(0.03);
		SeaweedPortion section = new SeaweedPortion(0.01);
		ShrimpPortion shrimp = new ShrimpPortion(0.04);
		IngredientPortion[] favs = new IngredientPortion [] {slice, scoop, section, shrimp};
		Roll my_Roll = new Roll ("My Roll", favs);
		GreenPlate my_plate = new GreenPlate(my_Roll);
		assertEquals(my_plate.getProfit(), 2.0 - my_Roll.getCost(), 0.01);
	}
}
