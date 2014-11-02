package Algorithm;

import java.util.HashSet;

public class ExpandZeros{
	
	/*Write an algorithm such that if an element in an MxN matrix is 0, its entire row
	 *and column are set to 0.
	 */

	public static void expandZeros(int[][] matrix, int rows, int columns){
		if(rows == 0 || columns == 0 || matrix == null){
			return;
		}
		HashSet<Integer> zeroRows = new HashSet<Integer>();
		HashSet<Integer> zeroColumns = new HashSet<Integer>();
		for(int row = 0; row < rows; row++){
			for(int column = 0; column < columns; column++){
				if(matrix[row][column] == 0){
					if(!zeroRows.contains(row)){
						zeroRows.add(row);
					}
					if(!zeroColumns.contains(column)){
						zeroColumns.add(column);
					}
				}
			}
			if(zeroRows.size() ==  rows && zeroColumns.size() == columns){
				break;
			}
		}
		for(int row = 0; row < rows; row++){
			for( int column = 0; column < columns; column++){
				if(zeroRows.contains(row) || zeroColumns.contains(column)){
					matrix[row][column] = 0;
				}
			}
		}
	}
	
	public static int[][] createMatrix(int[] inputArray,int rows, int columns){
		if(rows == 0 || columns == 0 || inputArray == null){
			return null;
		}
		if(rows*columns != inputArray.length){
			return null;
		}
		int inputArrayIndex = 0; 
		int[][] newMatrix = new int[rows][columns];
		for(int i = 0; i < rows; i++){
			for(int j = 0; j < columns;j++){
				newMatrix[i][j] = inputArray[inputArrayIndex];
				inputArrayIndex++;
			}
		}
		return newMatrix;
	}
	
	public static void printMatrix(int[][] matrix, int rows, int columns){
		if(matrix == null){
			return;
		}
		for(int i = 0; i < rows;i++){
			System.out.print("| ");
			for(int j = 0; j < columns; j++){
				System.out.print( matrix[i][j] + " "); 
			}
			System.out.println("|");
		}
	}
}