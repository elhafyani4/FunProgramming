package Puzzles;

/**
 * Created by yelha on 1/27/2017.
 */
public class LicenseKey {
    public String licenseKeyFormatting(String S, int K) {
        int m = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = S.length() - 1; i >= 0; i--) {
            char c = S.charAt(i);
            if (c != '-') {
                if (m % K == 0 && i >= 0 && i < S.length() - 1 && m > 0) {
                    sb.insert(0, '-');
                }
                m++;
                sb.insert(0, Character.toUpperCase(c));

            }
        }

        return sb.toString();
    }
}