
public class Matrices {

	private double row,column;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Matrices1 matrix = new Matrices1(10, 3);
		Matrices1 matrix2 = new Matrices1(3, 1);
		

		matrix.initialize(matrix.array);
		matrix2.initialize(matrix2.array);
		
		double [][]output=Matrices1.matrixProduct(matrix.array, matrix2.array, matrix.row1, matrix2.column1, matrix.column1);
		for (int i = 0; i < matrix.row1; i++) {
			for (int j = 0; j < matrix2.column1; j++) {
				System.out.println(output[i][j]);
			}//end of forloop
		}//end of forloop
	}

}
