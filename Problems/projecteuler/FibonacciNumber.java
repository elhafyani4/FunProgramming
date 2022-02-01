package Puzzles;

public class FibonacciNumber {

	/**
	 * @param args
	 */
	// First Two Integer in Fibonacci Numbers
	private static int f1 = 1;
	private static int f2 = 2;
	private static int fn;
	private static int fn1;
	private static int Total;

	public static void main(String[] args) {
		System.out.println(getTotalEvenFibanocciNumber(f1, f2));
	}


	public static int getTotalEvenFibanocciNumber(int f1, int f2){

		while(fn1 < 4000000){
			fn = f2;
			fn1 = f1 + f2;
			if(fn1%2==0){
				Total += fn1;
			}
			getTotalEvenFibanocciNumber(fn, fn1);
		}

		return Total + 2;
	}

}
