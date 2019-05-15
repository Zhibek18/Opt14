package Opt14;
import java.util.Scanner;

public class Runner{
	public static void printSorted(Matrix matrix, int i ){//made a separate method to save original
		matrix = (Matrix)matrix.clone();
		matrix.sortByColumn(i);
		System.out.print("Sorted by "+ i +" column");
		System.out.println(matrix);
	}
	public static void main(String[] args){
		System.out.println("Enter n:");
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		scan.close();
		Matrix matrix = MatrixFactory.createRandomized(n);
		System.out.println(matrix);
		printSorted(matrix, 0);
		matrix.printLongestIncreasingSequence();
		matrix.sumBetweenPositive();
	}
}