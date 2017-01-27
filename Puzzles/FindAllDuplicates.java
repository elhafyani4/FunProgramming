package Puzzles;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yelha on 1/27/2017.
 */
public class FindAllDuplicates {
    public List<Integer> findDuplicates(int[] nums) {
        int n = nums.length;
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int k = nums[i];
            if (nums[Math.abs(k) - 1] > 0) {
                nums[Math.abs(k) - 1] = -nums[Math.abs(k) - 1];
            } else {
                result.add(Math.abs(nums[i]));
            }
        }
        return result;
    }
}