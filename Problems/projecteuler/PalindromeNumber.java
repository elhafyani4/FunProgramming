package Puzzles;

import java.util.ArrayList;


public class PalindromeNumber {

    /**
     * @param args
     */
    public static void main(String[] args) {

        int i = 999;
        int j = 999;
        int largestNumber = 998001;
        boolean palindrome = false;


        for (int k = largestNumber; k > 0; k--) {
            if (isPalindrome(k)) {
                System.out.println(k + " the largest Fact " + getLargeFact(k) + " result : ");
                printPrimeFactor(k);
            }
        }

        //System.out.println(numberOfPalindromeNumbers(7));


    }


    public static void printPrimeFactor(double i) {
        double temp;
        ArrayList<Integer> primeNumbers = new ArrayList<Integer>();

        int lastPrimeNum = 2;

        while (i > 1) {


            temp = i / lastPrimeNum;


            while ((temp == Math.floor(temp)) && !Double.isInfinite(temp)) {
                primeNumbers.add(lastPrimeNum);
                printArrayList(primeNumbers);
                System.out.println("Prime Number : " + lastPrimeNum);
                i = (int) temp;
                temp = i / lastPrimeNum;

            }


            if (i > 1) {
                lastPrimeNum = getNextPrime(lastPrimeNum);
            }
        }

        System.out.println(lastPrimeNum);

    }

    public static void printArrayList(ArrayList<Integer> arr) {
        System.out.print("[");
        for (Integer ar : arr) {
            System.out.print(ar + ", ");
        }
        System.out.print("]");
    }

	/*public boolean islessThreeDigits(ArrayList<Integer> arr){
		Integer test = 1;
		for(Integer ar: arr){
			if(test<1000){
				test *= ar;
			}
		}
		
	}*/


    public static double numberOfPalindromeNumbers(int n) {

        double result;
        if (n % 2 == 0) { //even number
            System.out.println("Even Number");
            result = 2 * (Math.pow(10.0, n / 2) - 1);
        } else { // odd Number
            System.out.println("Odd Number");
            result = 11 * Math.pow(10.0, (n - 1) / 2) - 2;
        }

        return result;

    }


    public static int getNextPrime(int start) {
        boolean primeFound = false;
        while (!primeFound) {
            start++;
            if (isPrime(start)) {
                primeFound = true;
            }
        }
        return start;
    }

    public static boolean isPrime(int number) {
        for(int i = 2; i<number; i++){
            if (number % i == 0) {
                return false; //number is divisible so its not prime
            }
        }
        return true; //number is prime now
    }

    public static long getLargeFact(long num) {
        long largestFact = 0;
        long[] factors = new long[2];

        int lastPrimeNum = 2;

        for (long i = 2; i * i < num; i++) {
            if (num % i == 0) {
                factors[0] = i;
                factors[1] = num / i;

                for (int k = 0; k < 2; k++) {
                    boolean isPrime = true;
                    for (long j = 2; j * j < factors[k]; j++) {
                        if (factors[k] % j == 0) {
                            isPrime = false;
                            break;
                        }
                    }

                    if (isPrime && factors[k] > largestFact) {
                        largestFact = factors[k];
                    }
                }


            }

        }

        return largestFact;

    }

    public static boolean isPalindrome(int number) {
        int palindrome = number; // copied number into variable
        int reverse = 0;

        while (palindrome != 0) {
            int remainder = palindrome % 10;
            reverse = reverse * 10 + remainder;
            palindrome = palindrome / 10;
        }

        // if original and reverse of number is equal means
        // number is palindrome in Java
        return number == reverse;
    }

}
