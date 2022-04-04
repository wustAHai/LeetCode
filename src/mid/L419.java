package mid;

/**
 * @author chenz at 12:12 on 2021/12/18 .
 */
public class L419 {
    public int countBattleships(char[][] board) {
        int ans = 0;
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            int temp = 0;
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'X'){
                    if (j == 0){
                        temp++;
                    }else if (board[i][j-1]!='X'){
                        temp++;
                    }
                }
            }
           ans =  Math.max(ans,temp);
        }
        for (int i = 0; i < n; i++) {
            int temp = 0;
            for (int j = 0; j < m; j++) {
                if (board[j][i] == 'X'){
                    if (j == 0){
                        temp++;
                    }else if (board[j-1][i]!='X'){
                        temp++;
                    }
                }
            }
            ans =  Math.max(ans,temp);
        }
        return  ans;
    }
}
