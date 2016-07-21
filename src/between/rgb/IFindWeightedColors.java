package between.rgb;

import java.util.List;

/**
 How to find the fractional weighting of n colors which contribute to a known color C?
 * http://stackoverflow.com/questions/38479403/how-to-find-the-fractional-weighting-of-n-colors-which-contribute-to-a-known-col
 */
public interface IFindWeightedColors {
    /**
     * Given a color and the colors which contribute to making this color, find the weighted contribution
     * of each color in colorsContributingToThisColor and return as a result.
     * @param color The color which is composed from the contributing colors.
     * @param colorsContributingToThisColor The contributing colors with unknown weight.
     * @return List of WeightedRGBColor which is the weights assigned to each color.
     */
    List<WeightedRGBColor> colorsFrom(RGBColor color, List<RGBColor> colorsContributingToThisColor);

    /**
     * Sometimes the colors could not be combined in any weight at all to make the given color, in that
     * case this function should return false.
     * If this is false then the colorsFrom method should return an empty list.
     *
     * @param color The color which is composed from the contributing colors.
     * @param colorsContributingToThisColor The contributing colors with unknown weight.
     * @return Boolean, true if colors can be combined to create the given color.
     */
    Boolean canColorsBeCombinedToMakeThisColor(RGBColor color, List<RGBColor> colorsContributingToThisColor);
}
