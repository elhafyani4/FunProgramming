package Puzzles;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by yelha on 1/27/2017.
 */
public class RansomNote {
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> chars = new HashMap<Character, Integer>();

        for (int i = 0; i < magazine.length(); i++) {
            Character c = magazine.charAt(i);
            if (chars.containsKey(c)) {
                chars.put(c, chars.get(c) + 1);
            } else {
                chars.put(c, 1);
            }
        }

        for (int j = 0; j < ransomNote.length(); j++) {
            Character c = ransomNote.charAt(j);
            if (chars.containsKey(c) && chars.get(c) > 0) {
                chars.put(c, chars.get(c) - 1);
            } else {
                return false;
            }
        }
        return true;

    }
}