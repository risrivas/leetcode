package easy.stacks;

import java.util.Stack;

/**
 * A string is a valid parentheses string (denoted VPS) if it meets one of the following:
 * <p>
 * It is an empty string "", or a single character not equal to "(" or ")",
 * It can be written as AB (A concatenated with B), where A and B are VPS's, or
 * It can be written as (A), where A is a VPS.
 * We can similarly define the nesting depth depth(S) of any VPS S as follows:
 * <p>
 * depth("") = 0
 * depth(C) = 0, where C is a string with a single character not equal to "(" or ")".
 * depth(A + B) = max(depth(A), depth(B)), where A and B are VPS's.
 * depth("(" + A + ")") = 1 + depth(A), where A is a VPS.
 * For example, "", "()()", and "()(()())" are VPS's (with nesting depths 0, 1, and 2), and ")(" and "(()" are not VPS's.
 * <p>
 * Given a VPS represented as string s, return the nesting depth of s.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: s = "(1+(2*3)+((8)/4))+1"
 * Output: 3
 * Explanation: Digit 8 is inside of 3 nested parentheses in the string.
 * Example 2:
 * <p>
 * Input: s = "(1)+((2))+(((3)))"
 * Output: 3
 * <p>
 * Constraints:
 * <p>
 * 1 <= s.length <= 100
 * s consists of digits 0-9 and characters '+', '-', '*', '/', '(', and ')'.
 * It is guaranteed that parentheses expression s is a VPS.
 */
public class MaxDepth {

    public static void main(String[] args) {
        System.out.println(maxDepth("(1+(2*3)+((8)/4))+1"));
        System.out.println(maxDepth("(1)+((2))+(((3)))"));
        System.out.println(maxDepth(""));
        System.out.println(maxDepth("C"));
    }

    private static int maxDepth(String s) {
        if (s == null || s.isEmpty()) return 0;
        if (s.length() == 1 && !("(".equals(s) || ")".equals(s))) return 0;

        int max = 0;
        final Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                max = Math.max(stack.size(), max);
                stack.pop();
            }
        }

        // if (!stack.empty()) throw new RuntimeException("error");

        return max;
    }

}
