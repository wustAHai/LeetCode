package mid;

/**
 * @author chenz at 19:23 on 2022/2/21 .
 */
public class L838 {
    public String pushDominoes(String dominoes) {
        char[] chars = dominoes.toCharArray();
        int[]R = new int[dominoes.length()];
        int[]L = new int[dominoes.length()];
        R[0] = -1;
        int r= -1;
        for (int i = 1; i < chars.length; i++) {
            if (chars[i-1]=='R'){
                r=i-1;
            }else if (chars[i-1]=='L'){
                r=-1;
            }
            R[i]=r;
        }
        L[dominoes.length()-1]=-1;
        r=-1;
        for (int i = chars.length-2; i >=0 ; i--) {
            if (chars[i+1]=='L'){
                r=i+1;
            }else if (chars[i+1]=='R'){
                r=-1;
            }
            L[i]=r;
        }
        for (int i = 0; i < chars.length; i++) {
            if (chars[i]=='.'){
                if (R[i]<0&&L[i]>0){
                    chars[i]='L';
                }else if (R[i]>0&&L[i]<0){
                    chars[i]='R';
                }else if (R[i]>0&&L[i]>0){
                    if (i-R[i]>L[i]-i){
                        chars[i]='L';
                    }else if (i-R[i]<L[i]-i){
                        chars[i]='R';
                    }
                }
            }
        }
        return new String(chars);
    }
}
