package easy.strings;

public class StrStr {

    public static void main(String[] args) {
        System.out.println(strStr("mississippi", "pi"));
        System.out.println(strStr("hello", "ll"));
        System.out.println(strStr("hello", ""));
        System.out.println(strStr("aaaaa", "bba"));
    }

    public static int strStr(String haystack, String needle) {
        if (needle == null || needle.isEmpty()) return 0;

        if (haystack.equals(needle)) return 0;
        int nsize = needle.length();

        for (int i = 0; (i + nsize) <= haystack.length(); i++) {
            String haySubStr = haystack.substring(i, i + nsize);
            if (haySubStr.equals(needle)) return i;
        }

        return -1;
    }
}
