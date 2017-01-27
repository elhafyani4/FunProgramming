package Puzzles;

public class SquareDifference {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int difference = sqrSum(100) - sumSqr(100);
		System.out.println(difference);


	}


	public static int sumSqr(int n){
		int Sum = 0 ;
		while(n>0){
			Sum += sqr(n);
			n--;
		}
		return Sum;
	}

	public static int sqrSum(int n){
		int Sum = 0 ;
		while(n>0){
			Sum += n;
			n--;
		}
		return sqr(Sum);

	}

	public static int sqr(int n){
		return n*n;
	}

}
