package between.rgb;

public class WeightedRGBColor {

    private double weight = 0.0d;
    private RGBColor color = null;

    /**
     * Constructor
     * @param w Weight is from 0.0d to 1.0d
     * @param c The RGB color
     */
    WeightedRGBColor(double w, RGBColor c) {
        weight = w;
        color = c;
    }
}
