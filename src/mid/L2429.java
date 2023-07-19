package mid;

import java.util.Arrays;

/**
 * @author chenz at 11:54 on 2022/10/7 .
 */
public class L2429 {
    public int minimizeXor(int num1, int num2) {
        int i = Integer.bitCount(num2);
        int j = Integer.bitCount(num1);
        if (i==j){
            return num1;
        }else if (i>j){
            char[] chars = Integer.toBinaryString(num1).toCharArray();
            char[] chs = new char[31];
            Arrays.fill(chs,'0');
            for (int k = chs.length-1,h=chars.length-1; h>=0 ; h--,k--) {
                chs[k]=chars[h];
            }
            int diff = i-j;
            for (int k = chs.length-1; diff>0  ; k--) {
                if (chs[k]=='0'){
                    chs[k]='1';
                    diff--;
                }
            }
            return Integer.parseInt(String.valueOf(chs),2);
        }else {
            char[] chars = Integer.toBinaryString(num1).toCharArray();
            int diff = j - i;
            for (int k = chars.length-1; diff>0; k--) {
                if (chars[k]=='1'){
                    diff--;
                    chars[k]='0';
                }
            }
            return Integer.parseInt(String.valueOf(chars),2);
        }
    }

    public static void main(String[] args) {
        int i = 1;
        String s = Integer.toBinaryString(10);
        System.out.println(s);
        L2429 l2429 = new L2429();
        l2429.minimizeXor(25,72);
    }
}
