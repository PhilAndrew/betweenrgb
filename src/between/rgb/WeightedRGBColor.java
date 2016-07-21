package between.rgb;

public class WeightedRGBColor extends RGBColor {

	private double weight = 0.0d;

	/**
	 * Constructor
	 *
	 * @param w Weight is from 0.0d to 1.0d
	 * @param c The RGB color
	 */
	WeightedRGBColor(double w, RGBColor c) {
		super(c);
		weight = w;
	}

	WeightedRGBColor(double w, int r, int g, int b) {
		super(r, g, b);
		weight = w;
	}

	public double getWeight() {
		return weight;
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
		final WeightedRGBColor other = (WeightedRGBColor) obj;
		if (Double.doubleToLongBits(this.weight) != Double.doubleToLongBits(other.weight)) {
			return false;
		}
		if ((RGBColor) this != (RGBColor) other) {
			return false;
		}

		return true;
	}

	@Override
	public int hashCode() {
		int hash = 3;
		hash = 59 * hash + (int) (Double.doubleToLongBits(this.weight) ^ (Double.doubleToLongBits(this.weight) >>> 32));
		hash = 59 * hash + super.hashCode();
		return hash;
	}

}
