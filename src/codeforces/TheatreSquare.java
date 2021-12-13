package codeforces;

import java.util.Scanner;

public class TheatreSquare {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            int a = scanner.nextInt();

            System.out.println((int) (Math.ceil((double) n / a) * Math.ceil((double) m / a)));
        }
    }
}
