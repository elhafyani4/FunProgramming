package Puzzles;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Created by yelha on 1/28/2017.
 */
public class ValidParentheses {


    public static boolean isValidParenthesis(String str) {
        if (str.isEmpty()) {
            return true;
        }

        char[] chars = str.toCharArray();
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> openerCloser = new HashMap<>();
        openerCloser.put(')', '(');
        openerCloser.put(']', '[');
        openerCloser.put('}', '{');
        for (int i = 0; i < chars.length; i++) {
            if (openerCloser.keySet().contains(chars[i])) {
                if (openerCloser.get(chars[i]) == stack.peek()) {
                    stack.pop();
                } else {
                    return false;
                }
            } else if (openerCloser.values().contains(chars[i])) {
                stack.push(chars[i]);
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String test = "([a{a}])";
        System.out.println(isValidParenthesis(test));
        test = "([a{a])";
        System.out.println(isValidParenthesis(test));
    }
}
