package Algorithm;

public class RotateMatrix{
	
	/*Given an image represented by an NxN matrix, where each pixel in the image is
	 *4 bytes, write a method to rotate the image by 90 degrees. Can you do this in
	 *place?
	 */

	//Rotate matrix 90 degrees by creating a newMatrix and filling it in
	public static long[][] ninetyDegrees(long[][] matrix){
		if(matrix == null){
			return null;
		}
		int matrixLength = matrix.length;
		long[][] newMatrix = new long[matrixLength][matrixLength];
		for(int i = 0; i < matrixLength; i++){
			for(int j = 0; j < matrixLength; j++){
				newMatrix[j][matrixLength-(i+1)] = matrix[i][j];
			}
		}
		return newMatrix;
	}

	//Rotate matrix 90 degrees in place
	public static long[][] ninetyDegreesInPlace(long[][] matrix){
		if(matrix == null){
			return null;
		}
		int matrixLength = matrix.length;
		for (int i = 0; i < matrixLength/2; i++){
			for(int j = 0; j <= matrixLength/2;j++){
				int TOP = i;
				int BUTTOM = matrixLength - (1 + i);
				int LEFT = j;
				int RIGHT = matrixLength - (1 + j);

				long temp = matrix[TOP][LEFT];
				matrix[TOP][LEFT] = matrix[RIGHT][TOP];
				matrix[RIGHT][TOP] = matrix[BUTTOM][RIGHT];
				matrix[BUTTOM][RIGHT] = matrix[LEFT][BUTTOM];
				matrix[LEFT][BUTTOM] = temp;
				if(j == matrixLength/2-1  && (matrixLength%2 == 0)){
					j++;
				}
			}
		}
		return matrix;
	}

	//create an NxN matrix
	public static long[][] createMatrix(long[] inputArray){
		if (inputArray == null){
			return null;
		}
		double matrixWidth = Math.pow(inputArray.length,0.5);
		if(matrixWidth%1 != 0){
			return null;
		}
		long[][] matrix = new long[(int)matrixWidth][(int)matrixWidth];
		int arrayIndex = 0;
		for(int i = 0; i < matrixWidth;i++){
			for(int j = 0; j < matrixWidth;j++){
				matrix[i][j] = inputArray[arrayIndex];
				arrayIndex++;
			}
		}
		return matrix;
	}

	//print NxN matrix
	public static void printMatrix(long[][] matrix){
		if(matrix == null){
			return;
		}
		for(int i = 0; i < matrix.length;i++){
			System.out.print("| ");
			for(int j = 0; j < matrix.length; j++){
				System.out.print( matrix[i][j] + " "); 
			}
			System.out.println("|");
		}
	}

}