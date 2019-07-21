/**
 * 
 */

/**
 * @author hp
 *
 */
public class NN1 {

	private double hidden1,output1;
	private double[][] finalweights_HO;
	private double[][] finalweights_IH;
	boolean train;
	public NN1(double hidden, double output) {
		hidden1=hidden;
		output1=output;
	}//end of constructor

	public double[][] network(double ...inputs ) {
		
		
			/*create matrix objects for input,hidden and output neurons*/
			Matrices1 inputs1= new Matrices1(inputs.length, 1);//a matrix for input 1
			Matrices1 hidden2 = new Matrices1(hidden1, inputs.length);//create hidden weights
			Matrices1 output3= new Matrices1(output1, hidden1);//create matrix output matrix weights
			Matrices1 biasH =new Matrices1(hidden1, 1);
			Matrices1 biasO= new Matrices1(output1, 1);
			
			if (train==false) {
				/*initialize the matrix with random values*/
				biasH.add(1);
				biasO.add(1);
				inputs1.array=matrixBuilder(inputs);//convert inputs to an array
		 		hidden2.initialize(hidden2.array);//initialize hidden weights
				output3.initialize(output3.array);//initialize output weights
				System.out.println("fucked up");
			}
			else {
				hidden2.array=finalweights_IH;
				output3.array=finalweights_HO;
			}
			
			/*perform matrix products on each matrix*/
			  double [][] output_IH=Matrices1.matrixProduct(hidden2.array, inputs1.array, hidden2.row1, inputs1.column1, hidden2.column1);//multiply weights and biases
			  output_IH=Matrices1.elementwise(biasH.array, hidden1, 1,output_IH);//add bias to weighted sum
			  output_IH=Neuron1.sigmoid2(output_IH, hidden1,1);//do sigmoid function to the final matrix
			   
				double[][] output_HO=Matrices1.matrixProduct(output3.array, hidden2.array, output3.row1, inputs1.column1, output3.column1);//perform the weighted sum
				output_HO=Matrices1.elementwise(biasO.array, output1, 1, output_HO);//add bias to new matrix
				output_HO=Neuron1.sigmoid2(output_HO, output1,1);//pass the new matrix throught the activation function
				return output_HO;
				//return the output of the network
				
		
		
		
		 
	}//will house the brain of the system
	
	
	public void train(double [] inputs, double [][]targets ,double count) {
		/*this method will be used to trsin our neural network to adjust the weights*/
		
		/*create matrix objects for input,hidden and output neurons*/
		Matrices1 inputs1= new Matrices1(inputs.length, 1);//a matrix for input 1
		Matrices1 hidden2 = new Matrices1(hidden1, inputs.length);//create hidden weights
		Matrices1 output3= new Matrices1(output1, hidden1);//create matrix output matrix weights
		Matrices1 biasH =new Matrices1(hidden1, 1);
		Matrices1 biasO= new Matrices1(output1, 1);
		

		if (count==0) {
			/*initialize the matrix with random values*/
			biasH.add(1);
			biasO.add(1);
			inputs1.array=matrixBuilder(inputs);//convert inputs to an array
	 		hidden2.initialize(hidden2.array);//initialize hidden weights
			output3.initialize(output3.array);//initialize output weights
			/**/
		
		} else {

			biasH.add(1);
			biasO.add(1);
			hidden2.array=finalweights_IH;
			output3.array=finalweights_HO;
			
		}
		
	
		
		/*get the output from hidden layer*/
	  double [][] output_IH=Matrices1.matrixProduct(hidden2.array, inputs1.array, hidden2.row1, inputs1.column1, hidden2.column1);//multiply weights and biases
	  output_IH=Matrices1.elementwise(biasH.array, hidden1, 1,output_IH);//add bias to weighted sum
	  output_IH=Neuron1.sigmoid2(output_IH, hidden1,1);//do sigmoid function to the final matrix
	  
	   /*get output from output layer*/
		double[][] output_HO=Matrices1.matrixProduct(output3.array, output_IH, output3.row1, inputs1.column1, output3.column1);//perform the weighted sum
		output_HO=Matrices1.elementwise(biasO.array, output1, 1, output_HO);//add bias to new matrix
		output_HO=Neuron1.sigmoid2(output_HO, output1,1);//pass the new matrix throught the activation function
		
		/*get the error from the network of output neurons*/
		Matrices1 error_output= new Matrices1(output1, 1);//create error matrix
		error_output.array=Matrices1.elementwiseSub(targets, error_output.row1, 1, output_HO);//get error of network
		error_output.array=Matrices1.multiply(error_output.array,-1, output1, error_output.column1);
		
		/*get error of error of hidden nodes*/
		Matrices1 error_hidden = new Matrices1(hidden1, 1);//create hidden error matrix
		double[][] outputTranspose=Matrices1.Transpose(output3.array, output1, hidden1);//transpose the original weights between hidden and output layer
		error_hidden.array=Matrices1.matrixProduct(outputTranspose, error_output.array, hidden1, 1, output1);//get hidden errors
	
		/*get delta weights for hidden-output neurons*/
		double [][] gradient = Neuron1.dsigmoid2(output_HO, output1, 1);
		gradient=Matrices1.matrixProduct(error_output.array, gradient, output1, error_output.column1, 1);
		gradient=Matrices1.multiply(gradient,1, output1, error_output.column1);
		double [][] hiddenTranspose=Matrices1.Transpose(output_IH, hidden1, 1);
		double[][] deltaweights_HO =Matrices1.matrixProduct(gradient, hiddenTranspose , output1, hidden1, 1);
		output3.array=Matrices1.elementwise(output3.array, output3.row1, output3.column1,deltaweights_HO);
		
		/*get delta weights for input-hidden neurons*/
		double [][] gradient_hidden = Neuron1.dsigmoid2(output_IH, hidden1, 1);
		gradient_hidden=Matrices1.matrixProduct(error_hidden.array, gradient_hidden, hidden1, error_hidden.column1, 1);
		gradient_hidden=Matrices1.multiply(gradient_hidden,1, hidden1, error_hidden.column1);
		double [][] inputTranspose=Matrices1.Transpose(inputs1.array, inputs1.row1, 1);
		double[][] deltaweights_IH =Matrices1.matrixProduct(gradient_hidden, inputTranspose , hidden1, inputs1.row1, 1);
		hidden2.array=Matrices1.elementwise(hidden2.array, hidden2.row1, hidden2.column1,deltaweights_IH);
		
		
		finalweights_HO=output3.array;
		finalweights_IH=hidden2.array;
		train=true;
		
	
	}//train the network to be more effective
	
	
	
	
	
	
	public double[] [] matrixBuilder(double... inputs) {
		double [][] array = new double[inputs.length][1];
		for (int i = 0; i < inputs.length; i++) {
			for (int j = 0; j <1; j++) {
			array [i][j]=inputs[i];			}
		}
		return array;
	}//convert inputs to a matrix
	
	
}
