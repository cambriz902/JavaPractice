/* Given an image represented by an NxN matrix, where 
 * each pixel in the image is 4 bytes, write a method to
 * rotate the image by 90 degrees. Can you do this in place?
 */

public class RotateMatrix{

  public static void main(String[] args){
    int[][] testMatrix = createSquareMatrix(4);
    printMatrix(testMatrix);
    System.out.println();
    rotateNinetyDegrees(testMatrix);
    printMatrix(testMatrix);

  }

  public static void rotateNinetyDegrees(int[][] matrix){
    if(matrix == null) {
      return;
    }
    for(int i = 0; i < matrix.length; i++){
      for(int j = i; j < matrix[0].length; j++){
        int x = matrix[i][j];
        matrix[i][j] = matrix[j][i];
        matrix[j][i] = x;
      }
    }
  }

  public static void printMatrix(int[][] matrix){
    if(matrix == null){
      return; 
    }
    int size = matrix[0].length;
    for(int i = 0; i < size - 1; i++){
      System.out.print("| ");
      for(int j = 0; j < size - 1; j++){
        System.out.print(matrix[i][j] + " |");
      }
      System.out.println("");
    }
    return;
  }

  public static int[][] createSquareMatrix(int size){
    int[][] newMatrix = new int[size][size];
    int value = 0;
    for(int i = 0; i < (size - 1); i++){
      for(int j = 0; j < (size - 1); j++){
        newMatrix[i][j]  = value;
        value++;
      }
    }
    return newMatrix;
  }



}