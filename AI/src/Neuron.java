
import java.util.Arrays;
import java.util.Random;


/*This class will be used to give a single neuron functionality*/
public class Neuron {
double output;
double outputRe,e,weighted,sum;
double[]weights1= new double[1000];


	public double sigmoid(double cost,double error,double LR,double bias, double ... inputs) {
		
			 double[] weights= new double[inputs.length];//generate an array of weights equal to the number of inputs for the neuron
	
			if (weights[1]==0) {
				for (int i = 0; i < weights.length; i++) {
					weights[i]= Math.random();
				}
				
			}//check if weights are 0 and initialize them
			
				if (cost>0) {
					Learning(error, LR, weights,bias, inputs);
					weights=Arrays.copyOf(weights1, weights.length);
					
				}//check if cost is high and adjust weights

			
			
			for (int i = 0; i < weights.length; i++) {
				weighted=weights[i]*inputs[i];//calculate weighted inputs
				sum=sum+weighted;//get sum of the weighted inputs
			}//for loop for calculating weighted inputs
		
			outputRe=1/(1+(Math.pow(2.72, (sum+bias)*-1)));//get an output from the sigmoid function
			

			if (outputRe>0.5) {
				output=1;
			} else {

				output=0;
			}
			
		return output;
	}//this function will be used to represent a single neuron function
	
	
public void Learning(double error, double LR, double[] weights, double bias,double [] inputs) {
	for (int i = 0; i < weights.length; i++) {
		weights1[i]=weights[i]+((error*-1)*inputs[i]*LR);
	}//for loop to adjust weights according to inputs given
	 
}//method that will enable neuron to learn

	
}//end of class
