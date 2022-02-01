package Puzzles;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by yelha on 1/27/2017.
 */
public class ReverseVowels {
    public class Solution {
        public String reverseVowels(String s) {
            char[] sc = s.toCharArray();
            Set<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
            int i = 0, j = sc.length - 1;
            while (i < j) {
                while (!vowels.contains(sc[i]) && i < j) {
                    i++;
                }

                while (!vowels.contains(sc[j]) && i < j) {
                    j--;
                }

                if (i < j) {
                    char temp = sc[i];
                    sc[i] = sc[j];
                    sc[j] = temp;
                    i++;
                    j--;
                }
            }

            return new String(sc);
        }
    }
}