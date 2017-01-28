package Puzzles;

import java.util.Arrays;

/**
 * Created by yelha on 1/27/2017.
 */
public class SortColor {
    public void sortColors(int[] nums) {
        int red = 0;
        int white = 0;
        int blue = 0;

        for (int i = 0; i < nums.length; i++) {
            switch (nums[i]) {
                case 0:
                    red++;
                    break;
                case 1:
                    white++;
                    break;
                case 2:
                    blue++;
                    break;
            }
        }

        if (red > 0) {
            Arrays.fill(nums, 0, red, 0);
        }
        if (white > 0) {
            Arrays.fill(nums, red, red + white, 1);
        }
        if (blue > 0) {
            Arrays.fill(nums, red + white, red + white + blue, 2);
        }


    }
}
