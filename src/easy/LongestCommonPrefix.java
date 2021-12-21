package easy;

public class LongestCommonPrefix {

    public static void main(final String[] args) {
        final LongestCommonPrefix lcp = new LongestCommonPrefix();
        System.out.println(lcp.longestCommonPrefix(new String[]{"flower", "flow", "flight"}));
        System.out.println(lcp.longestCommonPrefix(new String[]{"dog", "racecar", "car"}));
    }

    public String longestCommonPrefix(final String[] strs) {
        if (strs.length == 1) return strs[0];
        final StringBuilder builder = new StringBuilder();
        for (int i = 0; i < strs.length; i++) {
            if (strs[i].length() == 0) return "";
            if (i == 0) {
                builder.append(strs[i]);
                continue;
            }
            String tstr = strs[i];
            if (builder.length() > tstr.length()) {
                builder.delete(tstr.length(), builder.length());
            } else if (builder.length() < tstr.length()) {
                tstr = tstr.substring(0, builder.length());
            }

            for (int j = 0; j < tstr.length(); j++) {
                if ((j == 0) && builder.charAt(j) != tstr.charAt(j))
                    return "";
                if (builder.charAt(j) != tstr.charAt(j)) {
                    builder.delete(j, builder.length());
                    break;
                }
            }
        }
        return builder.toString();
    }
}
