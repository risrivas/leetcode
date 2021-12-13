package easy;

public class PalindromeNumber {

    public static void main(String[] args) {
        PalindromeNumber number = new PalindromeNumber();
        System.out.println(number.isPalindrome(123321));
        System.out.println(number.isPalindrome(1238321));
    }

    public boolean isPalindrome(int x) {
        if (x < 0 || ((x % 10 == 0) && x != 0)) return false;

        int rev = 0;
        while (x > rev) {
            rev = (rev * 10) + (x % 10);
            x /= 10;
        }

        return (x == rev) || (x == (rev / 10));
    }

    public boolean isPalindrome1(int x) {
        if (x < 0 || ((x % 10 == 0) && x != 0)) return false;
        if (x == 0) return true;
        int length = (int) (Math.log10(x) + 1);
        int left = getLeft(x, ((length % 2) != 0) ? (length / 2 + 1) : length / 2);
        int right = getRight(x, length / 2);
        return left == right;
    }

    private int getRight(int x, int mid) {
        int rev = 0;
        for (int i = 0; i < mid; i++) {
            int digit = x % 10;
            rev = (rev * 10) + digit;
            x /= 10;
        }
        return rev;
    }

    private int getLeft(int x, int mid) {
        int divisor = (int) Math.pow(10, mid);
        x /= divisor;
        return x;
    }
}
