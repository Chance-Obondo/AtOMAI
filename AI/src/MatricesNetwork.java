
public class MatricesNetwork {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		NN1 network1 = new NN1(10, 3);
		 double[] inputs= new double[3];
		 inputs[0]=0;
		 inputs[1]=1;
		 inputs[2]=1;
		 
		 double[][] target = new double[3][1];
		 target[0][0]=0;//target output i want from network
		 target[1][0]=1;
		 target[2][0]=0;
			
		 for (int i = 0; i <50000; i++) {
				network1.train(inputs, target, i);
			}
		 
		double [][]output=network1.network(1,1,1);
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 1; j++) {
				System.out.println(output[i][j]);
			}//end of forloop
		}
	}

}
