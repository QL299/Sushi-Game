package a8tests;

import a8jedi.*;

import comp401.sushi.*;
import comp401.sushi.Nigiri.NigiriType;
import comp401.sushi.Sashimi.SashimiType;

import static org.junit.Assert.*;

import java.util.Observer;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class A8JediTest1 {

	// Belt object with six positions created for testing
	
	private final double precision = 0.00001;
	
	private Belt testBelt;
	private Belt smallBelt;

	private Sushi testContentsRed;
	private Sushi testContentsGreen;
	private Sushi testContentsBlue;
	private Sushi testContentsGold;

	private Plate redPlate;
	private Plate greenPlate;
	private Plate bluePlate;
	private Plate goldPlate;
	private Plate noShellNoVeggiePlate;
	private Plate isShellPlate;
	private Plate noShellIsVeggiePlate;


	private Sushi nigiri;
	private Sushi sashimi;
	private Sushi roll;
	private Sushi veggie_roll;
	private Sushi shell_roll;

	private CrabPortion crab = new CrabPortion(0.5);
	private ShrimpPortion shrimp = new ShrimpPortion(0.5);
	private SalmonPortion salmon = new SalmonPortion(0.5);
	private SeaweedPortion seaweed = new SeaweedPortion(0.5);
	private TunaPortion tuna = new TunaPortion(0.5);
	private RicePortion rice = new RicePortion(0.5);
	private EelPortion eel = new EelPortion(0.5);
	private IngredientPortion[] roll_ingredients;
	private IngredientPortion[] veggie_ingredients;
	private IngredientPortion[] shell_ingredients;



	private PlateCounter plateCounter;
	private ProfitCounter profitCounter;
	private SpoilageCollector spoilageCollector;

	@Before
	public void SetUp() throws PlatePriceException {
		// declares Belt object with six positions for testing
		testBelt = new Belt(20);
		smallBelt = new Belt(3);

		// creates Sashimi and Nigiri Sushi objects to set Plate contents
		testContentsRed = new Nigiri(NigiriType.CRAB); // costs $0.62
		testContentsGreen = new Sashimi(SashimiType.EEL);  // costs $1.64

		// creates Ingredients to be added to Rolls
		// Ikura Gunkan
		SalmonPortion salmon = new SalmonPortion(.75);
		SeaweedPortion seaweedMedium = new SeaweedPortion(.3);
		// Tekkamaki
		TunaPortion tuna = new TunaPortion(1.2);
		RicePortion rice = new RicePortion(.6);
		SeaweedPortion seaweedSmall = new SeaweedPortion(.15);

		// creates IngredientPortion arrays to be added to Rolls
		IngredientPortion[] ikuraGunkanIngredients = {salmon, seaweedMedium};
		IngredientPortion[] tekkamakiIngredients = {tuna, rice, seaweedSmall};

		// creates two Roll Sushi objects to set Plate contents
		testContentsBlue = new Roll("Ikura Gunkan", ikuraGunkanIngredients); // costs $1.43
		testContentsGold = new Roll("Ebi Nigiri", tekkamakiIngredients);	 // costs $2.64

		// constructs test Plates
		redPlate = new RedPlate(testContentsRed);
		greenPlate = new GreenPlate(testContentsGreen);
		bluePlate = new BluePlate(testContentsBlue);
		goldPlate = new GoldPlate(testContentsGold, 5.0);

		// sets Plate contents
		redPlate.setContents(testContentsRed);
		greenPlate.setContents(testContentsGreen);
		bluePlate.setContents(testContentsBlue);
		goldPlate.setContents(testContentsGold);
		
		roll_ingredients = new IngredientPortion[]{salmon,eel,tuna};
		veggie_ingredients = new IngredientPortion[]{seaweed,rice};
		shell_ingredients = new IngredientPortion[]{crab,shrimp};

		nigiri = new Nigiri(Nigiri.NigiriType.CRAB);
		sashimi = new Sashimi(Sashimi.SashimiType.EEL);
		roll = new Roll("CoolRoll",roll_ingredients);
		veggie_roll = new Roll("VeggieRoll",veggie_ingredients);
		shell_roll = new Roll("ShellRoll",shell_ingredients);

		noShellNoVeggiePlate = new BluePlate(roll);
		isShellPlate = new RedPlate(shell_roll);
		noShellIsVeggiePlate = new GoldPlate(veggie_roll, 6.0);

		// creates observer classes that observe the testBelt
		plateCounter = new PlateCounter(testBelt);
		profitCounter = new ProfitCounter(testBelt);
		spoilageCollector = new SpoilageCollector(smallBelt);
	}

	@Rule // used for detecting Exceptions
	public final ExpectedException exception = ExpectedException.none();

	public static String[] getTestNames() {

		String[] test_names = new String[3];

		test_names[0] = "countObservers";
		test_names[1] = "testRegisterCustomerExceptions";
		test_names[2] = "testUnregisterCustomer";

		return test_names;
	}

	@Test
	public void countObservers() {
		// makes sure both observer classes are properly notified in the Belt class
		assertEquals(2, testBelt.countObservers());
	}

	@Test
	public void testAgeOfPlateAtPosition() throws BeltPlateException {

		int bluePlateAge = 0;
		testBelt.setPlateAtPosition(bluePlate,0);

		assertEquals(bluePlateAge, testBelt.getAgeOfPlateAtPosition(0));

		testBelt.rotate();
		bluePlateAge++;

		assertEquals(bluePlateAge, testBelt.getAgeOfPlateAtPosition(1));
		assertEquals(-1, testBelt.getAgeOfPlateAtPosition(2));

		int goldPlateAge = 0;
		testBelt.setPlateAtPosition(goldPlate,0);

		assertEquals(goldPlateAge, testBelt.getAgeOfPlateAtPosition(0));
		assertEquals(bluePlateAge, testBelt.getAgeOfPlateAtPosition(1));

		testBelt.rotate();
		goldPlateAge++;
		bluePlateAge++;

		assertEquals(goldPlateAge, testBelt.getAgeOfPlateAtPosition(1));
		assertEquals(bluePlateAge, testBelt.getAgeOfPlateAtPosition(2));
		assertEquals(-1, testBelt.getAgeOfPlateAtPosition(3));

		int greenPlateAge = 0;
		testBelt.setPlateAtPosition(greenPlate,0);

		assertEquals(greenPlateAge, testBelt.getAgeOfPlateAtPosition(0));
		assertEquals(goldPlateAge, testBelt.getAgeOfPlateAtPosition(1));
		assertEquals(bluePlateAge, testBelt.getAgeOfPlateAtPosition(2));

		testBelt.rotate();
		greenPlateAge++;
		goldPlateAge++;
		bluePlateAge++;

		assertEquals(greenPlateAge, testBelt.getAgeOfPlateAtPosition(1));
		assertEquals(goldPlateAge, testBelt.getAgeOfPlateAtPosition(2));
		assertEquals(bluePlateAge, testBelt.getAgeOfPlateAtPosition(3));
		assertEquals(-1, testBelt.getAgeOfPlateAtPosition(4));

		int redPlateAge = 0;
		testBelt.setPlateAtPosition(redPlate,0);

		assertEquals(redPlateAge, testBelt.getAgeOfPlateAtPosition(0));
		assertEquals(greenPlateAge, testBelt.getAgeOfPlateAtPosition(1));
		assertEquals(goldPlateAge, testBelt.getAgeOfPlateAtPosition(2));
		assertEquals(bluePlateAge, testBelt.getAgeOfPlateAtPosition(3));

		testBelt.rotate();
		redPlateAge++;
		greenPlateAge++;
		goldPlateAge++;
		bluePlateAge++;

		assertEquals(redPlateAge, testBelt.getAgeOfPlateAtPosition(1));
		assertEquals(greenPlateAge, testBelt.getAgeOfPlateAtPosition(2));
		assertEquals(goldPlateAge, testBelt.getAgeOfPlateAtPosition(3));
		assertEquals(bluePlateAge, testBelt.getAgeOfPlateAtPosition(4));
		assertEquals(-1, testBelt.getAgeOfPlateAtPosition(5));


		for (int i=0; i < testBelt.getSize(); i++) {
			// it still must return a plate object!
			if (i == 1) {
				assertTrue(testBelt.removePlateAtPosition(i).getClass().equals(RedPlate.class));
			} else if (i == 2) {
				assertTrue(testBelt.removePlateAtPosition(i).getClass().equals(GreenPlate.class));
			} else if (i == 3) {
				assertTrue(testBelt.removePlateAtPosition(i).getClass().equals(GoldPlate.class));
			} else if (i == 4) {
				assertTrue(testBelt.removePlateAtPosition(i).getClass().equals(BluePlate.class));
			} else {
				testBelt.clearPlateAtPosition(i);
			}
			// just as well test this method! probably a bit of overkill here
			assertEquals(-1, testBelt.getAgeOfPlateAtPosition(i));
		}
	}
	// END OF TESTS FOR A8ADEPT
	
	//BEGINNING OF TESTS FOR A8JEDI
	@Test
	public void testThrowOutSpoiled() throws BeltPlateException {
		
		smallBelt.setPlateAtPosition(isShellPlate,0);
		smallBelt.setPlateAtPosition(noShellNoVeggiePlate,1);
		smallBelt.setPlateAtPosition(noShellIsVeggiePlate,2);

		for (int i=0; i < smallBelt.getSize(); i++) {
			smallBelt.rotate();
		}
		double lostCost = crab.getCost() + shrimp.getCost();
		double lostShellfish = crab.getAmount() + shrimp.getAmount();
		double lostSeafood = crab.getAmount() + shrimp.getAmount();
		double lostFood = crab.getAmount() + shrimp.getAmount();
		
		assertTrue(Math.abs(lostCost - spoilageCollector.getTotalSpoiledCost()) < precision);
	//	assertTrue(Math.abs(lostShellfish - spoilageCollector.getTotalSpoiledShellfish()) < precision);
	//	assertTrue(Math.abs(lostSeafood - spoilageCollector.getTotalSpoiledSeafood()) < precision);
	//	assertTrue(Math.abs(lostFood - spoilageCollector.getTotalSpoiledFood()) < precision);
		
		/* for (int i=0; i < smallBelt.getSize(); i++) {
			smallBelt.rotate();
		}
		lostCost += salmon.getCost() + eel.getCost() + tuna.getCost();
		lostSeafood += salmon.getAmount() + eel.getAmount() + tuna.getAmount();
		lostFood += salmon.getAmount() + eel.getAmount() + tuna.getAmount();
		
		assertTrue(Math.abs(lostCost - spoilageCollector.getTotalSpoiledCost()) < precision);
		assertTrue(Math.abs(lostShellfish - spoilageCollector.getTotalSpoiledShellfish()) < precision);
		assertTrue(Math.abs(lostSeafood - spoilageCollector.getTotalSpoiledSeafood()) < precision);
		assertTrue(Math.abs(lostFood - spoilageCollector.getTotalSpoiledFood()) < precision);
		
		for (int i=0; i < smallBelt.getSize(); i++) {
			smallBelt.rotate();
		}
		lostCost += rice.getCost() + seaweed.getCost();
		lostFood += rice.getAmount() + seaweed.getAmount();
		
		assertTrue(Math.abs(lostCost - spoilageCollector.getTotalSpoiledCost()) < precision);
		assertTrue(Math.abs(lostShellfish - spoilageCollector.getTotalSpoiledShellfish()) < precision);
		assertTrue(Math.abs(lostSeafood - spoilageCollector.getTotalSpoiledSeafood()) < precision);
		assertTrue(Math.abs(lostFood - spoilageCollector.getTotalSpoiledFood()) < precision);
		
		for (int i=0; i < smallBelt.getSize(); i++) {
			assertEquals(null,smallBelt.getPlateAtPosition(i)); 
		} */
	} 

	@Test
	public void testExtendsObserver() {
		assertTrue(spoilageCollector instanceof Observer);
	}
	//END OF TESTS FOR A8JEDI 
} 
