package Puzzles;

/**
 * Created by yelha on 1/27/2017.
 */
public class MaxConsecutiveOne {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        int count = 0;
        for (int i : nums) {
            if (i == 1) {
                count++;
            } else {
                count = 0;
            }

            if (count > max) {
                max = count;
            }
        }
        return max;
    }
}