import java.awt.print.Printable;

/*this program will feature a neural network that will try and solve the farmer 
 * and his fox,goose and grains problem, since there is no feature for natural 
 * language processing yet we will try and solve this problem using a set of defined
 * inputs and outputs that i will put in the game and then the neural net will try
 * and use them to come up with a definite answer using them , for every wrong answer
 * it gives the net will update itself and repeat the game. If it finally gets a correct answer,s
 * then the neural net will repeat the game five times to see whether it can get the correct answer
 * again this time five times without any wrong answer in between.*/
public class FarmerGame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double fox,grain,goose,cost = 0,error = 0,LR = 1, bias=1;
		fox=-1;
		goose=-1;
		grain=-1;
		
		//create an object neuron
	NN n1= new NN(40,3);
	double[] output = new double[12];
	double[] error1 = new double[output.length];//put errors in an array
	double [] expected = {0,1,0};
	
		output=n1.network(error1, cost, LR, bias, fox,goose,grain);
		for (int i = 0; i < output.length; i++) {
			System.out.println("Output from network is..."+output[i]);		
		}
	
		for (int i = 0; i < expected.length; i++) {
			error1[i]=output[i]-expected[i];
		}//for loop to get my error
		
		double sum=0;
		for (int i = 0; i < error1.length; i++) {
			sum=sum+error1[i];
		}//for loop to get sum of my error
		
		cost = Math.pow(sum, 2);	
		System.out.println("Your cost is"+cost);
		
		while (cost>0) {
			output=n1.network(error1, cost, LR, bias, fox,goose,grain);
			for (int i = 0; i < output.length; i++) {
				System.out.println("Output from network is..."+output[i]);		
			}
			
			for (int i = 0; i < expected.length; i++) {
				error1[i]=output[i]-expected[i];
			}//for loop to get my error
			
			 sum=0;
			for (int i = 0; i < error1.length; i++) {
				sum=sum+error1[i];
			}//for loop to get sum of my error
			
			cost = Math.pow(sum, 2);	
			System.out.println("Your cost is"+cost);
			
		}
	
		if (cost==0) {
			output=n1.network(error1, cost, LR, bias, fox,goose,grain);
			for (int i = 0; i < output.length; i++) {
				System.out.println("Output from network is..."+output[i]);		
			}
		}
	}//end of main
	
	

}
