package mid;

/**
 * @author chenz at 21:27 on 2021/12/9 .
 */
public class L794 {
    boolean win1 = false;
    boolean win2 = false;
    public boolean validTicTacToe(String[] board) {
        char[][] b = new char[3][3];
        for (int i = 0; i < board.length; i++) {
            b[i] = board[i].toCharArray();
        }
        int X = 0;
        int O = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (b[i][j]=='O'){
                    O++;
                }
                if (b[i][j]=='X'){
                    X++;
                }
            }
        }
        if (X<O||X>O+1){
            return false;
        }
        check(b);
        if (win1&&win2){
            return false;
        }
        if (win1&&X==O){
            return false;
        }
        if (win2&&X>O){
            return false;
        }
        return true;
    }

   void check(char[][] b){
        for (int i = 0; i < 3; i++) {
            if (b[i][1]==b[i][2]&&b[i][0]==b[i][1]){
                if (b[i][0]=='X'){
                    win1 = true;
                }
                if (b[i][0]=='O'){
                    win2 = true;
                }
            }

            if (b[1][i]==b[2][i]&&b[1][i]==b[0][i]){
                if (b[0][i]=='X'){
                    win1 = true;
                }
                if (b[0][i]=='O'){
                    win2 = true;
                }
            }
        }
        if (b[0][0]==b[1][1]&&b[0][0]==b[2][2]){
            if (b[0][0]=='X'){
                win1 = true;
            }
            if (b[0][0]=='O'){
                win2 = true;
            }
        }
        if (b[2][0]==b[1][1]&&b[1][1]==b[0][2]){
            if (b[1][1]=='X'){
                win1 = true;
            }
            if (b[1][1]=='O'){
                win2 = true;
            }
        }
    }

}
