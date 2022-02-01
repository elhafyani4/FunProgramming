package Puzzles;

/**
 * Created by yelha on 1/27/2017.
 */
public class HammingDistance {
    public int hammingDistance(int x, int y) {
        int res = 0;
        while (x > 0 || y > 0) {

            if ((x & 1) != (y & 1)) {
                res++;
            }
            x >>= 1;
            y >>= 1;
        }

        return res;
    }
}