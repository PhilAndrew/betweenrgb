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
	
	public RGBColor(RGBColor c){
		red = c.red;
		green = c.green;
		blue = c.blue;
	}

	public int getRed() {
		return red;
	}

	public int getGreen() {
		return green;
	}

	public int getBlue() {
		return blue;
	}

	
	// functions needed for tests
	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final RGBColor other = (RGBColor) obj;
		if (this.red != other.red) {
			return false;
		}
		if (this.green != other.green) {
			return false;
		}
		if (this.blue != other.blue) {
			return false;
		}
		return true;
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 19 * hash + this.red;
		hash = 19 * hash + this.green;
		hash = 19 * hash + this.blue;
		return hash;
	}
	
	
	
}
