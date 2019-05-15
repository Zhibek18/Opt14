package Opt14;
import java.util.Random;

public class MatrixFactory{ // filles matrix with random numbers
	public static Matrix createRandomized(int n){
		final int M = 10;
		Random rnd = new Random();
		Matrix matrix = new Matrix(n);
		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++){
				matrix.setElement(i, j, rnd.nextInt(M*2)-M);
			}
		return matrix;
	}
}