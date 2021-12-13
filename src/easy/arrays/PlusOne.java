package easy.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PlusOne {

    public static void main(String[] args) {
        int[] ex1 = new int[]{9, 9, 9};
        int[] ex_plus1 = plusOne(ex1);
        Arrays.stream(ex_plus1).forEach(System.out::println);
    }

    private static int[] plusOne(int[] digits) {
        if (digits == null || digits.length == 0) return digits;

        // preliminary check, return immediately
        if (digits[digits.length - 1] != 9) {
            digits[digits.length - 1]++;
            return digits;
        }

        List<Integer> result = new ArrayList<>();
        int carry = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] == 9 && carry == 1)
                digits[i] = 0;
            else {
                int digit = digits[i] + carry;
                if (digit <= 9) {
                    digits[i] = digit;
                    carry = 0;
                }
            }
            result.add(digits[i]);
        }
        if (carry == 1) result.add(1);
        Collections.reverse(result);
        return result.stream().mapToInt(i -> i).toArray();
    }
}
