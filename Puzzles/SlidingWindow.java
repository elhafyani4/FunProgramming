package Puzzles;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by yelha on 1/27/2017.
 */
public class SlidingWindow {

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0) {
            return new int[0];
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i <= nums.length - k; i++) {
            result.add(Arrays.stream(Arrays.copyOfRange(nums, i, i + k)).max().getAsInt());
        }
        return result.stream().mapToInt(i -> i).toArray();
    }
}