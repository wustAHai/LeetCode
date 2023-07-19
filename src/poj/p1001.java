package poj;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author chenz at 22:53 on 2023/3/6 .
 */
public class p1001 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] ints = new int[150];
        while (scanner.hasNext()) {
            String s = scanner.nextLine();
            String substring = s.substring(0, 6);
            String trim = s.substring(7).trim();
            int cnt = Integer.parseInt(trim);
            char[] chars = substring.toCharArray();
            Arrays.fill(ints,0);
            int n = 0;
            int xiao=0;
            for (int i = ints.length-1,j=chars.length-1; i >=0&&j>=0 ; ) {
                if ('.'==chars[j]){
                    xiao=5-j;
                    j--;
                }else {
                    ints[i]=chars[j]-'0';
                    i--;
                    j--;
                }
            }
            for (int i = 145; i <150 ; i++) {
                n*=10;
                n+=ints[i];
            }
            xiao*=cnt;
            cnt --;
            while (cnt>0){
                for (int i = 0; i < ints.length; i++) {
                    ints[i]*=n;
                }
                int r = 0;
                int i = ints.length-1;
                for (; i >=0 ; i--) {
                    ints[i]+=r;
                    r = ints[i]/10;
                    ints[i]%=10;
                }
                cnt--;
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < ints.length; i++) {
                sb.append(ints[i]);
            }
            sb.insert(150-xiao,'.');
            int i = 0;
            int j = sb.length()-1;
            while (sb.charAt(i)=='0'){
                i++;
            }
            while (sb.charAt(j)=='0'){
                j--;
            }
            if (sb.charAt(j)=='.'){
                j--;
            }
            System.out.println(sb.substring(i,j+1));
        }
    }

}
