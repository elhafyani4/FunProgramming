package Puzzles;

/**
 * Created by yelha on 1/27/2017.
 */
public class NumberCompliment {
    public int findComplement(int num) {
        int i = 0;
        int x = 0;
        while (i < 32) {
            num >>= i;
            int t = ~(num & 1);
            x <<= 1;
            x |= t & 1;

        }
        return x;
    }

}
