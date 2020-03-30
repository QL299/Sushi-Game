/**
 * @author X
 *
 */

package a8tests;

import a8jedi.*;
import comp401.sushi.*;
import comp401.sushi.Nigiri.NigiriType;
import comp401.sushi.Sashimi.SashimiType;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class A8JediTest2 {
    // Belt object with six positions created for testing
    private Belt testBelt;
    private SpoilageCollector trashObserver;//
    private double totalCost;//total spoiled food cost
    private double totalSeafoodAmount;//spoiled seafood amount
    private double totalShellfishAmount;//spoiled shellfish amount
    private double totalFoodAmount;//spoiled food amount
    private double precision;

    private Sushi testContentsRed;
    private Sushi testContentsRed2;
    private Sushi testContentsGreen;
    private Sushi testContentsBlue;
    private Sushi testContentsGold;
    private Sushi testVegetarian;

    private Plate redPlate;
    private Plate greenPlate;
    private Plate bluePlate;
    private Plate goldPlate;
    private Plate shrimpPlate;
    private Plate vegetarianPlate;

    @Before
    public void SetUp() throws PlatePriceException {
        precision=  0.0000001;
        // declares Belt object with six positions for testing
        testBelt = new Belt(6);

        trashObserver = new SpoilageCollector(testBelt);

        // creates Sashimi and Nigiri Sushi objects to set Plate contents
        testContentsRed = new Nigiri(NigiriType.CRAB); // costs $0.62
        testContentsRed2 = new Sashimi(SashimiType.SHRIMP);// costs $0.4125
        testContentsGreen = new Sashimi(SashimiType.EEL);  // costs $1.64

        // creates Ingredients to be added to Rolls
        // salmon roll
        SalmonPortion salmon = new SalmonPortion(.75);
        SeaweedPortion seaweedMedium = new SeaweedPortion(.3);
        // tuna roll
        TunaPortion tuna = new TunaPortion(1.2);
        RicePortion rice = new RicePortion(.6);
        SeaweedPortion seaweedSmall = new SeaweedPortion(.15);

        //vege roll
        RicePortion rice1 = new RicePortion(.6);
        SeaweedPortion seaweedMedium1 = new SeaweedPortion(.3);

        // creates IngredientPortion arrays to be added to Rolls
        IngredientPortion[] salmonRollIngredients = {salmon, seaweedMedium};
        IngredientPortion[] tunaRollIngredients = {tuna, rice, seaweedSmall};
        IngredientPortion[] vegetarianRollIngredients = {rice1,seaweedMedium1};

        // creates three Roll Sushi objects to set Plate contents
        testContentsBlue = new Roll("salmon roll", salmonRollIngredients); // costs $1.43
        testContentsGold = new Roll("tuna roll", tunaRollIngredients);     // costs $2.64
        testVegetarian = new Roll("vege roll", vegetarianRollIngredients);        // costs $0.96

        // constructs test Plates
        redPlate = new RedPlate(testContentsRed);
        greenPlate = new GreenPlate(testContentsGreen);
        bluePlate = new BluePlate(testContentsBlue);
        goldPlate = new GoldPlate(testContentsGold, 5.0);
        shrimpPlate = new RedPlate(testContentsRed2);
        vegetarianPlate = new GreenPlate(testVegetarian);
        
        //fails here for some reason
    }
    @Test
    public void testGetTotalSpoiledCost()throws BeltPlateException{

        //set up belt
    	//something immediately wrong
    	//stops working at notify observers
        testBelt.setPlateAtPosition(redPlate, 0);  
        testBelt.setPlateAtPosition(greenPlate, 1);
        testBelt.setPlateAtPosition(bluePlate, 2);
        testBelt.setPlateAtPosition(goldPlate, 3);
        testBelt.setPlateAtPosition(vegetarianPlate, 4);
        testBelt.setPlateAtPosition(shrimpPlate, 5);

        //plate were set and age are 0
        assertEquals(0,testBelt.getAgeOfPlateAtPosition(0));
        assertEquals(0,testBelt.getAgeOfPlateAtPosition(1));
        assertEquals(0,testBelt.getAgeOfPlateAtPosition(2));
        assertEquals(0,testBelt.getAgeOfPlateAtPosition(3));
        assertEquals(0,testBelt.getAgeOfPlateAtPosition(4));
        assertEquals(0,testBelt.getAgeOfPlateAtPosition(5));

        //spoiled cost and amount are 0.0
        assertEquals(0.0, trashObserver.getTotalSpoiledCost(),precision);
        assertEquals(0.0, trashObserver.getTotalSpoiledShellfish(),precision);
        assertEquals(0.0, trashObserver.getTotalSpoiledSeafood(),precision);
        assertEquals(0.0, trashObserver.getTotalSpoiledFood(),precision);

        //rotate less than one round and check no plate spoiled 
        for(int i =0;i<testBelt.getSize()-1;i++){//rotate belt size -1 times
            testBelt.rotate();
        }
        //spoiled cost and amount are 0.0
        assertEquals(0.0, trashObserver.getTotalSpoiledCost(),precision);
        assertEquals(0.0, trashObserver.getTotalSpoiledShellfish(),precision);
        assertEquals(0.0, trashObserver.getTotalSpoiledSeafood(),precision);
        assertEquals(0.0, trashObserver.getTotalSpoiledFood(),precision);

        //no plate removed
        assertEquals(5,testBelt.getAgeOfPlateAtPosition(0));
        assertEquals(5,testBelt.getAgeOfPlateAtPosition(1));
        assertEquals(5,testBelt.getAgeOfPlateAtPosition(2));
        assertEquals(5,testBelt.getAgeOfPlateAtPosition(3));
        assertEquals(5,testBelt.getAgeOfPlateAtPosition(4));
        assertEquals(5,testBelt.getAgeOfPlateAtPosition(5));

        // rotate up to one round,plate with shellfish spoiled.
        testBelt.rotate();

        totalCost += (0.75*0.75+0.5*0.12)+(0.75*0.55);//crab nigiri+ shrimp sashimi;
        totalShellfishAmount += 0.75+0.75;//0.75 crab+0.75shrimp;
        totalSeafoodAmount += 0.75+0.75;//0.75 crab+0.75shrimp;
        totalFoodAmount += (0.75+0.5)+0.75;//crab nigiri+shrimp sashimi;

        //check shellfish spoiled 
        assertEquals(totalCost,trashObserver.getTotalSpoiledCost(),precision);
        assertEquals(totalShellfishAmount, trashObserver.getTotalSpoiledShellfish(),precision);
        assertEquals(totalSeafoodAmount, trashObserver.getTotalSpoiledSeafood(),precision);
        assertEquals(totalFoodAmount, trashObserver.getTotalSpoiledFood(),precision);

        //test spoiled plate got removed
        assertEquals(-1,testBelt.getAgeOfPlateAtPosition(0));
        assertEquals(6,testBelt.getAgeOfPlateAtPosition(1));
        assertEquals(6,testBelt.getAgeOfPlateAtPosition(2));
        assertEquals(6,testBelt.getAgeOfPlateAtPosition(3));
        assertEquals(6,testBelt.getAgeOfPlateAtPosition(4));
        assertEquals(-1,testBelt.getAgeOfPlateAtPosition(5));

        //rotate less than two round,no more plate spoiled
        for(int i =0;i<testBelt.getSize()-1;i++){
            testBelt.rotate();
        }
        //no more plate spoiled and no more plate got removed
        assertEquals(totalCost,trashObserver.getTotalSpoiledCost(),precision);
        assertEquals(totalShellfishAmount, trashObserver.getTotalSpoiledShellfish(),precision);
        assertEquals(totalSeafoodAmount, trashObserver.getTotalSpoiledSeafood(),precision);
        assertEquals(totalFoodAmount, trashObserver.getTotalSpoiledFood(),precision);

        assertEquals(11,testBelt.getAgeOfPlateAtPosition(0));
        assertEquals(11,testBelt.getAgeOfPlateAtPosition(1));
        assertEquals(11,testBelt.getAgeOfPlateAtPosition(2));
        assertEquals(11,testBelt.getAgeOfPlateAtPosition(3));
        assertEquals(-1,testBelt.getAgeOfPlateAtPosition(4));
        assertEquals(-1,testBelt.getAgeOfPlateAtPosition(5));

        //rotate up to two round
        testBelt.rotate();

        totalCost += (0.75*2.18)+(0.75*0.72+0.3*2.95)+
                (1.2*1.77+0.6*0.12+0.15*2.95);//eel sashimi+ salmon roll+tuna roll
        totalSeafoodAmount += 0.75+0.75+1.2;//0.75 eel+0.75 salmon+1.2 tuna
        totalFoodAmount += 0.75+(0.75+0.3)+(1.2+0.6+0.15);//eel sashimi+salmon roll+tuna roll

        //check seafood spoiled
       // assertEquals(totalCost,trashObserver.getTotalSpoiledCost(),precision);
        assertEquals(totalShellfishAmount, trashObserver.getTotalSpoiledShellfish(),precision);
        assertEquals(totalSeafoodAmount, trashObserver.getTotalSpoiledSeafood(),precision);
        //total food amount wrong? need to go through each checkifspoiled plate
        //see if food amount is adding up correctly?
        assertEquals(totalFoodAmount, trashObserver.getTotalSpoiledFood(),precision);

        //test spoiled plate got removed
        assertEquals(-1,testBelt.getAgeOfPlateAtPosition(0));
        assertEquals(-1,testBelt.getAgeOfPlateAtPosition(1));
        assertEquals(-1,testBelt.getAgeOfPlateAtPosition(2));
        assertEquals(-1,testBelt.getAgeOfPlateAtPosition(3));
        assertEquals(12,testBelt.getAgeOfPlateAtPosition(4));
        assertEquals(-1,testBelt.getAgeOfPlateAtPosition(5));

        //rotate less than three round,no more plate spoiled
        for(int i =0;i<testBelt.getSize()-1;i++){
            testBelt.rotate();
        }
        //no more plate spoiled and no more plate got removed        
        assertEquals(totalCost,trashObserver.getTotalSpoiledCost(),precision);
        assertEquals(totalShellfishAmount, trashObserver.getTotalSpoiledShellfish(),precision);
        assertEquals(totalSeafoodAmount, trashObserver.getTotalSpoiledSeafood(),precision);
        assertEquals(totalFoodAmount, trashObserver.getTotalSpoiledFood(),precision);

        assertEquals(-1,testBelt.getAgeOfPlateAtPosition(0));
        assertEquals(-1,testBelt.getAgeOfPlateAtPosition(1));
        assertEquals(-1,testBelt.getAgeOfPlateAtPosition(2));
        assertEquals(17,testBelt.getAgeOfPlateAtPosition(3));
        assertEquals(-1,testBelt.getAgeOfPlateAtPosition(4));
        assertEquals(-1,testBelt.getAgeOfPlateAtPosition(5));

        //rotate up to three round, vegetarian sushi spoiled
        testBelt.rotate();

        totalCost += 0.6*0.12+0.3*2.95;//vege roll
        totalFoodAmount += 0.6+0.3;//vege roll
        //check vegetarian spoiled
        assertEquals(totalCost,trashObserver.getTotalSpoiledCost(),precision);
        assertEquals(totalShellfishAmount, trashObserver.getTotalSpoiledShellfish(),precision);
        assertEquals(totalSeafoodAmount, trashObserver.getTotalSpoiledSeafood(),precision);
        assertEquals(totalFoodAmount, trashObserver.getTotalSpoiledFood(),precision);

        //test spoiled plate got removed
        assertEquals(-1,testBelt.getAgeOfPlateAtPosition(0));
        assertEquals(-1,testBelt.getAgeOfPlateAtPosition(1));
        assertEquals(-1,testBelt.getAgeOfPlateAtPosition(2));
        assertEquals(-1,testBelt.getAgeOfPlateAtPosition(3));
        assertEquals(-1,testBelt.getAgeOfPlateAtPosition(4));
        assertEquals(-1,testBelt.getAgeOfPlateAtPosition(5));
    }
}
