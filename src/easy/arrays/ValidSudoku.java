package easy.arrays;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ValidSudoku {

    public static void main(String[] args) {
        char[][] sudoku = new char[][]{
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };

        System.out.println(isValidSudoku(sudoku));

    }

    private static boolean isValidSudoku(char[][] board) {
        Map<Integer, Set<Integer>> rows = new HashMap<>();
        Map<Integer, Set<Integer>> cols = new HashMap<>();
        Map<Integer, Set<Integer>> boxes = new HashMap<>();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == '.') continue;
                int num = board[i][j] - '0';

                // rows
                Set<Integer> rowSet = rows.getOrDefault(i, new HashSet<>());
                if (rowSet.contains(num)) return false;
                else rowSet.add(num);
                rows.put(i, rowSet);

                // cols
                Set<Integer> colSet = cols.getOrDefault(j, new HashSet<>());
                if (colSet.contains(num)) return false;
                else colSet.add(num);
                cols.put(j, colSet);

                // boxes
                Set<Integer> boxSet = boxes.getOrDefault(((i / 3) * 3) + j / 3, new HashSet<>());
                if (boxSet.contains(num)) return false;
                else boxSet.add(num);
                boxes.put(((i / 3) * 3) + j / 3, boxSet);
            }
        }

        return true;
    }

}
