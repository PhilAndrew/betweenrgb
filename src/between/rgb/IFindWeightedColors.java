package between.rgb;

import java.util.List;

/**
 * How to interpolate between n colors by a fractional contribution for each color?
 * http://stackoverflow.com/questions/38478754/how-to-interpolate-between-n-colors-by-a-fractional-contribution-for-each-color
 */
public interface IFindWeightedColors {
    /**
     * Given a list of weighted RGB colors, return the combination of those colors by weights.
     * @param colors The list of Weighted RGB colors
     * @return The RGBColor which is the color created after combining these colors.
     */
    RGBColor colorFrom(List<WeightedRGBColor> colors);
}
