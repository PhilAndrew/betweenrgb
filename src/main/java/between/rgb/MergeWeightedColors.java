/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package between.rgb;

import java.util.List;

/**
 *
 * @author Kuzmovych
 */
public class MergeWeightedColors implements IMergeWeightedColors {

	@Override
	public RGBColor colorFrom(List<WeightedRGBColor> colors) {
		int red = (int) Math.round(colors.stream().mapToDouble((c) -> c.getRed() * c.getWeight()).sum());
		int green = (int) Math.round(colors.stream().mapToDouble((c) -> c.getGreen() * c.getWeight()).sum());
		int blue = (int) Math.round(colors.stream().mapToDouble((c) -> c.getBlue() * c.getWeight()).sum());

		return new RGBColor(red, green, blue);
	}

}
