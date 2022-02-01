package Puzzles;

public class CollatzSequence {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int 	longestChain 		= 0; 		// holding the longest chain.
		int 	tempLongestChain 	= 0;		// holding Temporary longest chain.
		long 	startingNumber 		= 0;		// Starting Number Looking for.
		int 	sequenceHolder 		= 0;		// Temporary Sequence holder
		long 	Num 				= 1000000;	// First Starting Number

		while(Num>1){ 							// stop at 800000

			tempLongestChain = 0;
			sequenceHolder =  (int)Num;

			while(sequenceHolder>1){
				if(sequenceHolder%2==0){
					sequenceHolder = calculateEven(sequenceHolder);
					tempLongestChain++;
				}else{
					sequenceHolder = calculateOdd(sequenceHolder);
					tempLongestChain++;
				}
			}

			if(tempLongestChain>longestChain){
				longestChain = tempLongestChain;
				startingNumber = Num;
				System.out.println(startingNumber +" : " + longestChain);
			}

			Num--;
		}

		System.out.println("Starting Number which is " + startingNumber);

	}

	public static int calculateEven(long n){
		return (int)(n/2);
	}

	public static int calculateOdd(long n){
		return (int)((3*n)+1);
	}

}
