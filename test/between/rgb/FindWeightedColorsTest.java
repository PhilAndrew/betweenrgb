/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package between.rgb;

import java.util.Arrays;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Kuzmovych
 */
public class FindWeightedColorsTest {

	private final MergeWeightedColors MergeClassInstance = new MergeWeightedColors();
	private final FindWeightedColors FindClassInstance = new FindWeightedColors();

	public FindWeightedColorsTest() {
	}

	@BeforeClass
	public static void setUpClass() {
	}

	@AfterClass
	public static void tearDownClass() {
	}

	@Before
	public void setUp() {
	}

	@After
	public void tearDown() {
	}

	/**
	 * Test of colorsFrom method, of class FindWeightedColors.
	 */
	@Test
	public void testColorsFrom() {
		try {
			runFindTest(new RGBColor(0, 0, 0),
					new RGBColor(0, 0, 0));
			runFindTest(new RGBColor(0, 128, 255),
					new RGBColor(0, 128, 255));
			runFindTest(new RGBColor(0, 62, 125),
					new RGBColor(0, 62, 125),
					new RGBColor(255, 65, 90));
			runFindTest(new RGBColor(128, 120, 63),
					new RGBColor(0, 120, 50),
					new RGBColor(255, 120, 76));
			runFindTest(new RGBColor(40, 68, 255),
					new RGBColor(0, 80, 255),
					new RGBColor(200, 20, 255));
			runFindTest(new RGBColor(40, 68, 255),
					new RGBColor(0, 70, 12),
					new RGBColor(0, 80, 255),
					new RGBColor(200, 20, 255));
			runFindTest(new RGBColor(159, 139, 51),
					new RGBColor(18, 98, 249),
					new RGBColor(72, 195, 45),
					new RGBColor(138, 2, 46),
					new RGBColor(253, 223, 7));
			runFindTest(new RGBColor(159, 139, 51),
					new RGBColor(18, 98, 249),
					new RGBColor(72, 195, 45),
					new RGBColor(138, 2, 46),
					new RGBColor(253, 223, 7),
					new RGBColor(79, 45, 73));
			
		} catch (IllegalArgumentException e) {
			fail("Unexpected exception: " + e);
		}
	}
	

	private void runFindTest(RGBColor color, RGBColor... colorsContributingToThisColor) {
		List<WeightedRGBColor> resultWeightedColors = FindClassInstance.colorsFrom(color, Arrays.asList(colorsContributingToThisColor));
		RGBColor resultColor = MergeClassInstance.colorFrom(resultWeightedColors);
		assertEquals(color, resultColor);
	}


	/**
	 * Test of canColorsBeCombinedToMakeThisColor method, of class
	 * FindWeightedColors.
	 */
	@Test
	public void testCanColorsBeCombinedToMakeThisColor() {
		runCheckTest(true, new RGBColor(0, 0, 0),
				new RGBColor(0, 0, 0));
		runCheckTest(true, new RGBColor(0, 128, 255),
				new RGBColor(0, 128, 255));
		runCheckTest(true, new RGBColor(128, 120, 63),
				new RGBColor(0, 120, 50),
				new RGBColor(255, 120, 76));
		runCheckTest(true, new RGBColor(40, 68, 255),
				new RGBColor(0, 80, 255),
				new RGBColor(200, 20, 255));
		runCheckTest(true, new RGBColor(40, 68, 255),
				new RGBColor(0, 70, 12),
				new RGBColor(0, 80, 255),
				new RGBColor(200, 20, 255));
		runCheckTest(true, new RGBColor(159, 139, 51),
				new RGBColor(18, 98, 249),
				new RGBColor(72, 195, 45),
				new RGBColor(138, 2, 46),
				new RGBColor(253, 223, 7));
		
		runCheckTest(false, new RGBColor(50, 100, 200), 
				new RGBColor(0, 0, 0));
		runCheckTest(false, new RGBColor(50, 100, 200), 
				new RGBColor(40, 30, 12));
		runCheckTest(false, new RGBColor(50, 100, 200), 
				new RGBColor(99, 125, 33));
		runCheckTest(false, new RGBColor(0, 0, 0), 
				new RGBColor(255, 255, 255));
		runCheckTest(false, new RGBColor(152, 69, 195), 
				new RGBColor(25, 36, 45), 
				new RGBColor(36, 45, 15));
		runCheckTest(false, new RGBColor(152, 69, 195), 
				new RGBColor(25, 36, 45), 
				new RGBColor(89, 36, 45), 
				new RGBColor(25, 58, 45), 
				new RGBColor(25, 12, 45), 
				new RGBColor(39, 36, 25), 
				new RGBColor(11, 88, 135));
	}
	
	private void runCheckTest(boolean expectedResult, RGBColor color, RGBColor... colorsContributingToThisColor) {
		boolean result = FindClassInstance.canColorsBeCombinedToMakeThisColor(color, Arrays.asList(colorsContributingToThisColor));
		assertEquals(expectedResult, result);
	}

	
	
}