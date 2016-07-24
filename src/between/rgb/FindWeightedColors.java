package between.rgb;

import static java.lang.Math.abs;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.math3.linear.*;

/**
 *
 * @author Kuzmovych
 */
public class FindWeightedColors implements IFindWeightedColors {

	@Override
	public List<WeightedRGBColor> colorsFrom(RGBColor color, List<RGBColor> colorsContributingToThisColor) {
		List<WeightedRGBColor> solution = findSolution(color, colorsContributingToThisColor);
		return solution;
	}

	@Override
	public Boolean canColorsBeCombinedToMakeThisColor(RGBColor color, List<RGBColor> colorsContributingToThisColor) {
		return !findSolution(color, colorsContributingToThisColor).isEmpty();
	}

	@Override
	public Boolean checkSolution(RGBColor color, List<WeightedRGBColor> weightedColors) {
		RGBColor colorToCheck = new MergeWeightedColors().colorFrom(weightedColors);
		return colorToCheck.equals(color);
	}
	
	private List<WeightedRGBColor> findSolution(RGBColor color, List<RGBColor> colorsContributingToThisColor) {

		double matrix[][] = new double[4][colorsContributingToThisColor.size()];
		double vector[] = {1, color.getRed(), color.getGreen(), color.getBlue()};

		for (int i = 0; i < colorsContributingToThisColor.size(); i++) {
			matrix[0][i] = 1;
			matrix[1][i] = (double) colorsContributingToThisColor.get(i).getRed();
			matrix[2][i] = (double) colorsContributingToThisColor.get(i).getGreen();
			matrix[3][i] = (double) colorsContributingToThisColor.get(i).getBlue();
		}

		RealMatrix realMatrix = MatrixUtils.createRealMatrix(matrix);
		RealVector realVector = MatrixUtils.createRealVector(vector);
		RealVector solution = new QRDecomposition(realMatrix).getSolver().solve(realVector);

		if (!solutionIsCorrect(solution, color, colorsContributingToThisColor)) {
			return new ArrayList<>();
		}
		List<WeightedRGBColor> resultWeightedColors = new ArrayList<>(colorsContributingToThisColor.size());
		for (int i = 0; i < colorsContributingToThisColor.size(); i++) {
			resultWeightedColors.add(new WeightedRGBColor(solution.getEntry(i), colorsContributingToThisColor.get(i)));
		}

		RGBColor checkColor = new MergeWeightedColors().colorFrom(resultWeightedColors);
		if (checkColor.equals(color)) {
			return resultWeightedColors;
		} else {
			return new ArrayList<>();
		}

	}

	private boolean solutionIsCorrect(RealVector solution, RGBColor color, List<RGBColor> colorsContributingToThisColor) {
		double solutionSum = 0;
		for (int i = 0; i < colorsContributingToThisColor.size(); i++) {
			solutionSum += solution.getEntry(i);
		}
		return solution.getMinValue() > -10e-10 && abs(1 - solutionSum) < 10e-4;
	}

	
	
}
