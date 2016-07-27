/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package between.rgb;

import java.util.Arrays;
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
public class MergeWeightedColorsTest {

	private final MergeWeightedColors MergeClassInstance = new MergeWeightedColors();

	public MergeWeightedColorsTest() {
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
	 * Test of colorFrom method, of class MergeWeightedColors.
	 */
	@Test
	public void testColorFrom() {
		System.out.println("colorFrom");
		
		try {
			runTest(new RGBColor(0, 128, 255),
					new WeightedRGBColor(1.0d, new RGBColor(0, 128, 255)));
			runTest(new RGBColor(0, 62, 125),
					new WeightedRGBColor(1.0d, new RGBColor(0, 62, 125)),
					new WeightedRGBColor(0.0d, new RGBColor(255, 65, 90)));
			runTest(new RGBColor(128, 120, 63),
					new WeightedRGBColor(0.5d, new RGBColor(0, 120, 50)),
					new WeightedRGBColor(0.5d, new RGBColor(255, 120, 76)));
			runTest(new RGBColor(40, 68, 255),
					new WeightedRGBColor(0.8d, new RGBColor(0, 80, 255)),
					new WeightedRGBColor(0.2d, new RGBColor(200, 20, 255)));
			runTest(new RGBColor(159, 139, 51),
					new WeightedRGBColor(0.1d, new RGBColor(18, 98, 249)),
					new WeightedRGBColor(0.2d, new RGBColor(72, 195, 45)),
					new WeightedRGBColor(0.3d, new RGBColor(138, 2, 46)),
					new WeightedRGBColor(0.4d, new RGBColor(253, 223, 7)));
		} catch (IllegalArgumentException e) {
			fail("Unexpected exception: " + e);
		}
	}

	private void runTest(RGBColor expResult, WeightedRGBColor... colors) {
		RGBColor result = MergeClassInstance.colorFrom(Arrays.asList(colors));
		assertEquals(expResult, result);
	}

}
