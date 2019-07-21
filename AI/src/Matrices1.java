import java.util.Arrays;


/**
 * 
 */

/**
 * @author hp
 *
 */
public class Matrices1 {
 public double row1,column1;
 private static double row2,column2;
 public double[] [] array;
	public Matrices1 (double row, double column){
		row1=row;
		column1=column;
		array= new double[(int) row1][(int)column1];
		
	}//constructor for creating matrix
	
	public  double[][] initialize(double [][] array) {
		/*this method will be used to initialize the matrix with random values*/
		for (int i = 0; i < row1; i++) {
			for (int j = 0; j <column1; j++) {
			array[i][j]=Math.random();
			}
		}
		return array;
	}//end of initialize method
	
	public  void add(double number) {
		/*will add a certain number to the values in the matrix*/
		for (int i = 0; i < row1; i++) {
			for (int j = 0; j <column1; j++) {
				array[i][j]= array[i][j]+number;
			}
		}//end of for loop
		
	}
	
	public static double[] [] multiply(double [][]array,double number,double row, double column) {
		/*will add a certain number to the values in the matrix*/
		for (int i = 0; i < row; i++) {
			for (int j = 0; j <column; j++) {
				array[i][j]= array[i][j]*number;
			}
		}//end of for loop
		return array;
	}
	
	public static double[][] add(double number,double[][] array,double row, double column) {
		/*will add a certain number to the values in the matrix*/
		for (int i = 0; i < row; i++) {
			for (int j = 0; j <column; j++) {
				array[i][j]= array[i][j]+number;
			}
		}//end of for loop
		return array;
	}
	
	public  void elementwise(double[] [] array2) {
		/*will multiply a matrix with another matrix*/
		for (int i = 0; i < row1; i++) {
			for (int j = 0; j < column1; j++) {
				array[i][j]=array[i][j]+array2[i][j];
			}//end of forloop
		}//end of forloop
	}//end of method
	
	public static  double[] [] elementwiseSub(double[] [] array2, double row, double column,double[][]array) {
		/*will multiply a matrix with another matrix*/
		double[][] array3= new double[(int) row][(int) column];
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
				array3[i][j]=array[i][j]-array2[i][j];
			}//end of forloop
		}//end of forloop
		return array3;
	}//end of method

	public static  double[] [] elementwise(double[] [] array2, double row, double column,double[][]array) {
		/*will multiply a matrix with another matrix*/
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
				array[i][j]=array[i][j]+array2[i][j];
			}//end of forloop
		}//end of forloop
		return array;
	}//end of method
  
	public static double[] [] matrixProduct(double [][] array1, double[][] array2, double row, double column,double columns ) {
		double [][] array3= new double[(int) row][(int) column];
		for (int i = 0; i < row; i++) {
			for (int j = 0; j <column; j++) {
				double sum=0;
				for (int k = 0; k <columns ; k++) {
					sum+=array1[i][k]*array2[k][j];
				}
				array3[i][j]=sum;
				
			}
		}
		
		return array3;
	}//end of matrix product
	
	public static double[] [] Transpose (double [][] array, double row,double column) {
		double [][] transpose = new double[(int) column][(int) row];
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
				transpose[j][i]=array[i][j];
			}
		}
		return transpose;
	}//transpose our matrix
}
