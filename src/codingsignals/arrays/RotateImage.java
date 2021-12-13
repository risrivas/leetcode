package codingsignals.arrays;

public class RotateImage {

    public static void main(String[] args) {
        int[][] a = new int[][]{
                {1, 2, 3, 4, 5},
                {4, 5, 6, 7, 8},
                {7, 8, 9, 10, 11},
                {7, 18, 19, 1, 11},
                {17, 8, 9, 20, 11},
        };

        rotateImage(a);
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) {
                System.out.printf("%d ", a[i][j]);
            }
            System.out.println();
        }

    }

    static int[][] rotateImage(int[][] a) {
        int n = a.length;
        if (n == 1) return a;

        for (int layer = 0; layer < n / 2; layer++) {
            int first = layer;
            int last = n - 1 - layer;
            for (int i = first; i < last; i++) {
                int offset = i - first;

                int top = a[first][i];
                a[first][i] = a[last - offset][first];
                a[last - offset][first] = a[last][last - offset];
                a[last][last - offset] = a[i][last];
                a[i][last] = top;
            }
        }

        return a;
    }
}
