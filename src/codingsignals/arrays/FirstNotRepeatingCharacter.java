package codingsignals.arrays;

import java.util.ArrayList;
import java.util.List;

public class FirstNotRepeatingCharacter {

    public static void main(String[] args) {
        System.out.println(firstNotRepeatingCharacter("abadcaba"));
        System.out.println(firstNotRepeatingCharacter("abacabaabacaba"));
    }

    static char firstNotRepeatingCharacter(String s) {
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }

        List<Character> unique = new ArrayList<>();
        for (int i = 0; i < count.length; i++) {
            if (count[i] == 1) unique.add((char) ('a' + i));
        }

        if (unique.isEmpty()) return '_';
        int idx = Integer.MAX_VALUE;
        for (char c : unique) {
            idx = Math.min(s.indexOf(c), idx);
        }

        return s.charAt(idx);
    }
}
