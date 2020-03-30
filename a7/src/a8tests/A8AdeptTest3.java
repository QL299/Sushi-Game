/**
 * @author X
 * 
 *
 */
package a8tests;

import a8adept.*;
import comp401.sushi.*;
import comp401.sushi.Nigiri.NigiriType;
import comp401.sushi.Sashimi.SashimiType;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class A8AdeptTest3 {
    // Belt object with six positions created for testing
    private Belt testBelt;
    private Plate tempPlate;

    private Sushi testContentsRed;
    private Sushi testContentsGreen;
    private Sushi testContentsBlue;
    private Sushi testContentsGold;
    private Sushi testVegetarian;

    private Plate redPlate;
    private Plate greenPlate;
    private Plate bluePlate;
    private Plate goldPlate;
    private Plate vegetarianPlate;

    @Before
    public void SetUp() throws PlatePriceException {
        // declares Belt object with six positions for testing
        testBelt = new Belt(6);

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
        IngredientPortion[] vegetarianIngredients = {rice,seaweedMedium};

        // creates two Roll Sushi objects to set Plate contents
        testContentsBlue = new Roll("Ikura Gunkan", ikuraGunkanIngredients); // costs $1.43
        testContentsGold = new Roll("Ebi Nigiri", tekkamakiIngredients);     // costs $2.64
        testVegetarian = new Roll("Go Green", vegetarianIngredients);        // costs $0.96

        // constructs test Plates
        redPlate = new RedPlate(testContentsRed);
        greenPlate = new GreenPlate(testContentsGreen);
        bluePlate = new BluePlate(testContentsBlue);
        goldPlate = new GoldPlate(testContentsGold, 5.0);
        vegetarianPlate = new GreenPlate(testVegetarian);

        // sets Plate contents
        redPlate.setContents(testContentsRed);
        greenPlate.setContents(testContentsGreen);
        bluePlate.setContents(testContentsBlue);
        goldPlate.setContents(testContentsGold);
        vegetarianPlate.setContents(testVegetarian);
    }

    @Test
    public void testGetAgeOfPlateAtPosition() 
            throws BeltPlateException,BeltFullException{

        testBelt.setPlateAtPosition(vegetarianPlate,0);

        //age of plate without rotation is 0 
        assertEquals(0,testBelt.getAgeOfPlateAtPosition(0));
        assertEquals(-1,testBelt.getAgeOfPlateAtPosition(1));
        assertEquals(-1,testBelt.getAgeOfPlateAtPosition(2));
        assertEquals(-1,testBelt.getAgeOfPlateAtPosition(3));
        assertEquals(-1,testBelt.getAgeOfPlateAtPosition(4));
        assertEquals(-1,testBelt.getAgeOfPlateAtPosition(5));

        testBelt.rotate();
        assertEquals(-1,testBelt.getAgeOfPlateAtPosition(0));
        assertEquals(1,testBelt.getAgeOfPlateAtPosition(1));
        assertEquals(-1,testBelt.getAgeOfPlateAtPosition(2));
        assertEquals(-1,testBelt.getAgeOfPlateAtPosition(3));
        assertEquals(-1,testBelt.getAgeOfPlateAtPosition(4));
        assertEquals(-1,testBelt.getAgeOfPlateAtPosition(5));

        testBelt.setPlateNearestToPosition(bluePlate, 0);

        testBelt.rotate();
        assertEquals(-1,testBelt.getAgeOfPlateAtPosition(0));
        assertEquals(1,testBelt.getAgeOfPlateAtPosition(1));
        assertEquals(2,testBelt.getAgeOfPlateAtPosition(2));
        assertEquals(-1,testBelt.getAgeOfPlateAtPosition(3));
        assertEquals(-1,testBelt.getAgeOfPlateAtPosition(4));
        assertEquals(-1,testBelt.getAgeOfPlateAtPosition(5));

        testBelt.setPlateAtPosition(goldPlate, 0);

        testBelt.rotate();
        assertEquals(-1,testBelt.getAgeOfPlateAtPosition(0));
        assertEquals(1,testBelt.getAgeOfPlateAtPosition(1));
        assertEquals(2,testBelt.getAgeOfPlateAtPosition(2));
        assertEquals(3,testBelt.getAgeOfPlateAtPosition(3));
        assertEquals(-1,testBelt.getAgeOfPlateAtPosition(4));
        assertEquals(-1,testBelt.getAgeOfPlateAtPosition(5));

        testBelt.setPlateAtPosition(greenPlate, 0);

        testBelt.rotate();
        assertEquals(-1,testBelt.getAgeOfPlateAtPosition(0));
        assertEquals(1,testBelt.getAgeOfPlateAtPosition(1));
        assertEquals(2,testBelt.getAgeOfPlateAtPosition(2));
        assertEquals(3,testBelt.getAgeOfPlateAtPosition(3));
        assertEquals(4,testBelt.getAgeOfPlateAtPosition(4));
        assertEquals(-1,testBelt.getAgeOfPlateAtPosition(5));

        testBelt.rotate();
        assertEquals(-1,testBelt.getAgeOfPlateAtPosition(0));
        assertEquals(-1,testBelt.getAgeOfPlateAtPosition(1));
        assertEquals(2,testBelt.getAgeOfPlateAtPosition(2));
        assertEquals(3,testBelt.getAgeOfPlateAtPosition(3));
        assertEquals(4,testBelt.getAgeOfPlateAtPosition(4));
        assertEquals(5,testBelt.getAgeOfPlateAtPosition(5));

        testBelt.rotate();
        assertEquals(6,testBelt.getAgeOfPlateAtPosition(0));
        assertEquals(-1,testBelt.getAgeOfPlateAtPosition(1));
        assertEquals(-1,testBelt.getAgeOfPlateAtPosition(2));
        assertEquals(3,testBelt.getAgeOfPlateAtPosition(3));
        assertEquals(4,testBelt.getAgeOfPlateAtPosition(4));
        assertEquals(5,testBelt.getAgeOfPlateAtPosition(5));

        //remove and return the original plate
        tempPlate = testBelt.removePlateAtPosition(0);
        assertEquals(vegetarianPlate,tempPlate);

        testBelt.rotate();
        assertEquals(6,testBelt.getAgeOfPlateAtPosition(0));
        assertEquals(-1,testBelt.getAgeOfPlateAtPosition(1));
        assertEquals(-1,testBelt.getAgeOfPlateAtPosition(2));
        assertEquals(-1,testBelt.getAgeOfPlateAtPosition(3));
        assertEquals(4,testBelt.getAgeOfPlateAtPosition(4));
        assertEquals(5,testBelt.getAgeOfPlateAtPosition(5));

        tempPlate = testBelt.removePlateAtPosition(0);
        assertEquals(bluePlate,tempPlate);

        testBelt.rotate();

        tempPlate = testBelt.removePlateAtPosition(0);
        assertEquals(goldPlate,tempPlate);

        testBelt.rotate();
        assertEquals(6,testBelt.getAgeOfPlateAtPosition(0));
        assertEquals(-1,testBelt.getAgeOfPlateAtPosition(1));
        assertEquals(-1,testBelt.getAgeOfPlateAtPosition(2));
        assertEquals(-1,testBelt.getAgeOfPlateAtPosition(3));
        assertEquals(-1,testBelt.getAgeOfPlateAtPosition(4));
        assertEquals(-1,testBelt.getAgeOfPlateAtPosition(5));

        tempPlate = testBelt.removePlateAtPosition(0);
        assertEquals(greenPlate,tempPlate);
    }
}
