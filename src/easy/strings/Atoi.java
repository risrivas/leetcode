package easy.strings;

import java.util.ArrayList;
import java.util.List;

public class Atoi {

    public static void main(String[] args) {
        System.out.println(myAtoi("42"));
        System.out.println(myAtoi("      -42"));
        System.out.println(myAtoi("4193 with words"));
        System.out.println(myAtoi("words and 987"));
        System.out.println(myAtoi("-91283472332"));
    }

    public static int myAtoi(String str) {
        if (str == null) return 0;
        str = str.trim();
        if (str.isEmpty()) return 0;

        int i = 0;
        char first = str.charAt(i);
        boolean isNegative = false;
        if (first == '-') {
            isNegative = true;
            i = 1;
        } else if (first == '+') {
            i = 1;
        } else if (!Character.isDigit(first)) {
            return 0;
        }

        List<Integer> result = new ArrayList<>();

        for (; i < str.length(); i++) {
            char current = str.charAt(i);
            if (Character.isDigit(current)) {
                result.add(Character.getNumericValue(current));
            } else {
                break;
            }
        }

        long ans = 0L;
        for (int j = result.size() - 1, k = 0; j >= 0; j--, k++) {
            int num = result.get(j);
            ans += num * Math.pow(10, k);
        }

        if (isNegative) ans *= -1;

        if (ans > Integer.MAX_VALUE) return Integer.MAX_VALUE;
        if (ans < Integer.MIN_VALUE) return Integer.MIN_VALUE;

        return (int) ans;
    }
}
