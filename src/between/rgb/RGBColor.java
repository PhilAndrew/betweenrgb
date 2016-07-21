package between.rgb;

public class RGBColor {

    private int red = 0;
    private int green = 0;
    private int blue = 0;

    /**
     * Constructor
     * @param r Red is in range 0 to 255 inclusive
     * @param g Green is in range 0 to 255 inclusive
     * @param b blue is in range 0 to 255 inclusive
     */
    public RGBColor(int r, int g, int b) {
        red = r;
        green = g;
        blue = b;
    }
}
