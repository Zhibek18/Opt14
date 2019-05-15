package Opt14;
import java.util.Scanner;

public class Matrix implements Cloneable{
	private int [][] matrix;
	private final int N;

	public Matrix(int m){
		matrix = new int[m][m];
		N = m;
	}
	public int getSize(){
		return N;
	}

	public void test(Scanner scan){ // array input for testing
		System.out.println("Введите массив:");
		for (int i = 0; i < N; i++)
			for (int j = 0; j < N; j++){
				matrix[i][j] = scan.nextInt();
			}
	}
	public int getElement(int i, int j){
		return matrix[i][j];
	}
	public void setElement(int i, int j, int value){
		matrix[i][j] = value;
	}
	public String toString(){
		String s = "\n Matrix:" + N + "x" + N + "\n";
		for (int[] vector : matrix ){
			for (int value : vector){
				s+= value + " ";
			}
			s+= "\n";
		}
		return s;
	}

	public void sortByColumn(int j){
		int[] tmp = new int [N];
		boolean isSorted = false;
		while (!isSorted){
			isSorted = true;
			for (int i = 1; i < N; i++){
				if (matrix[i][j] < matrix[i-1][j]){
					isSorted = false;
					tmp = matrix[i];
					matrix[i] = matrix[i-1];
					matrix[i-1] = tmp;
				}
			}
		}
		
	}
	public void printLongestIncreasingSequence(){ // prints longest increasing sequence of elements
		int maxLength = 1;
		int iMaxBeg = 0, jMaxBeg = 0;
		int iBeg = 0, jBeg = 0;
		int length = 1;
		int prev = matrix[0][0];
		for (int i = 0; i < N;i++){
			for (int j = 0; j < N; j++){
				if ((i == 0)&&(j == 0))
					continue;

				if (matrix[i][j] > prev){
					length++;
				}
				else{
					if (length > maxLength){
						maxLength = length;
						iMaxBeg = iBeg;
						jMaxBeg = jBeg;
					}
					length = 1;
					iBeg = i;
					jBeg = j;
				}
				prev = matrix[i][j];
			}

		}
		System.out.println("The longest increasing sequence");
		int k;
		int l = 0;
		for (int i = iMaxBeg; i < N; i++){
			if (i == iMaxBeg)
				k = jMaxBeg;
			else 
				k = 0;
			for (int j = k; j < N; j++){
				if (l == maxLength){
					System.out.println();
					return;
				}
				System.out.print(matrix[i][j] + " ");
				l++;

			}
		}
	}

	public void sumBetweenPositive(){ //finds sum of elements placed between two positive numbers in a row
		boolean add;
		int sum = 0;
		int positiveCount;
		System.out.println("Sum between positive:");
		for (int i = 0; i < N; i++){
			add = false;
			positiveCount = 0;
			sum = 0;
			System.out.print("Sum between positive i = " + i);
			for (int j = 0; j < N; j++){
				if ((positiveCount < 3)&&(matrix[i][j] > 0)){
					add = !add;
					positiveCount++;
				}
				else{
					if (add)
						sum += matrix[i][j];
				}
			}
			System.out.println(" sum =" + sum);
		}
	}

	public Matrix clone(){
		Matrix copy = null;
		try{
			copy = (Matrix)super.clone();
			copy.matrix = (int[][])matrix.clone();
		}catch (CloneNotSupportedException e){
			e.printStackTrace();
		}
		
		return copy;

	}
}