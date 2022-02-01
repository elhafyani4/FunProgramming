package Puzzles;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yelha on 1/27/2017.
 */
public class DispearedNumber {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int in = nums[i];
            if (nums[Math.abs(in) - 1] > 0) {
                nums[Math.abs(in) - 1] = -nums[Math.abs(in) - 1];
            }
        }

        for (int k = 0; k < n; k++) {
            if (nums[k] > 0) {
                result.add(k + 1);
            }
        }
        return result;
    }
}