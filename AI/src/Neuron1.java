/**This class will house the sigmoid function that will be used to calculate output of each neuron
 * 
 */

/**
 * @author hp
 *
 */
public class Neuron1 {

	public double  sigmoid(double weighted) {
		double output;
		output=1/(1+Math.pow(weighted, 2.72));
		return output;
	}//sigmoid method
	
	public static double[] [] sigmoid2(double [][] array, double row, double colmun) {
		for (int i = 0; i <row; i++) {
			for (int j = 0; j < colmun; j++) {
				array[i][j]=1/(1+Math.pow(2.72,array[i][j]*-1));
			}
		}
		return array;
	}
	
	public static double[] [] dsigmoid2(double [][] array, double row, double colmun) {
		for (int i = 0; i <row; i++) {
			for (int j = 0; j < colmun; j++) {
				array[i][j]=array[i][j]*(1-array[i][j]);
			}
		}
		return array;
	}
}
