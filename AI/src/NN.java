

/*This class will be used to create the neural network layer and will extend the neuron class.
 * It will contain methods that will be used to connect each neuron to each other and it will 
 * also be used to group neural networks into layers for functionality*/
public class NN extends Neuron{
 int hidden1, output2;
public NN( int hidden, int output) {
	/*this constructor will give us the number of neurons in the hidden and output layer*/

 hidden1=hidden;
 output2=output;
}//end of constructor





public double[] network(double[] error, double cost, double LR, double bias, double ... inputs) {
	/*this is where the network will work its magic*/
	
	
	Neuron[] hiddenlayer = new Neuron[hidden1];
	{
		/*this block will be responsible for creating hidden neurons*/
			for (int i = 0; i < hidden1; i++) {
					hiddenlayer[i]= new Neuron();
						}//end of for-loop
	}//end of block 



	Neuron[] outputlayer= new Neuron[output2];
	{
		/*this block will be used to create output neurons*/
			for (int i = 0; i < output2; i++) {
					outputlayer[i]= new Neuron();
						}//end of for-loop
	}//end of block 
	
	
	double[] output1= new double[hidden1];//array to store output from hidden layer
	double[] output3= new double[output2];//array to store outputs from output layer
	
	for (int i = 0; i < hiddenlayer.length; i++) {
		output1[i]=hiddenlayer[i].sigmoid(0, 0, LR, bias, inputs);
	}//end of for loop
	
	for (int i = 0; i < outputlayer.length; i++) {
		output3[i]=outputlayer[i].sigmoid(cost, error[i], LR, bias, output1);
	}//end of for loop
	
	
	return output3;
	
	
}//end of network



	
}
