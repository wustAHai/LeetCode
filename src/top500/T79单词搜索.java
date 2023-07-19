package top500;

/**
 * @author chenz at 22:33 on 2023/3/9 .
 */
public class T79单词搜索 {
    int [][] dir = {{0,1},{0,-1},{1,0},{-1,0}};
    boolean[][] visited;
    public boolean exist(char[][] board, String word) {
        visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j]==word.charAt(0)){
                    boolean b = dfs(board,word,0,i,j,visited);
                    if (b){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, int index, int i, int j, boolean[][] visited) {
        if (index==word.length()-1){
            return true;
        }
        visited[i][j]=true;
        for (int[] ints : dir) {
            int x = i+ints[0];
            int y = j+ints[1];
            if (x>=0&&x<board.length&&y>=0&&y<board[0].length&&!visited[x][y]&&word.charAt(index+1)==board[x][y]){
                boolean dfs = dfs(board, word, index + 1, x, y, visited);
                if (dfs){
                    return true;
                }
            }
        }
        visited[i][j]=false;
        return false;
    }
}
