package mid;

import org.junit.Test;

/**
 * Created by chenz at 7:52 on 2021/2/12
 */
public class JZ12 {
    public boolean exist(char[][] board, String word) {
        char[] words = word.toCharArray();
        int r = board.length;
        int c = board[0].length;
        System.out.println(r + "   " + c);
        boolean[][] visited = new boolean[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (dfs(board, i, j, words, 0, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, int i, int j, char[] words, int index, boolean[][] visited) {
        if (index == words.length) {
            return true;
        }
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || visited[i][j]) {
            return false;
        }
        if (index > words.length || words[index] != board[i][j]) {
            return false;
        }
        index++;
        visited[i][j] = true;
        boolean ans = dfs(board, i + 1, j, words, index, visited) || dfs(board, i - 1, j, words, index, visited) ||
                dfs(board, i, j - 1, words, index, visited) || dfs(board, i, j + 1, words, index, visited);
        visited[i][j] = false;
        return ans;
    }

}
