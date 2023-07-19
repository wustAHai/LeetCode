package mid;

/**
 * @author chenz at 19:59 on 2022/9/13 .
 */
public class L670 {
    public int maximumSwap(int num) {
        String s  = ""+num;
        char[] chars = s.toCharArray();
        int len = chars.length;
        char[] max = new char[len+1];
        for (int i = len-1; i >= 0; i--) {
            char ch = chars[i];
            max[len- i] = (char) Math.max(ch,max[len-i-1]);
        }
        for (int i = 0; i < len; i++) {
            if (chars[i]<max[len-i]){
                for (int j = len-1; j >=0 ; j--) {
                   if (chars[j]==max[len-i]){
                       chars[j] = chars[i];
                       chars[i] = max[len-i];
                       break;
                   }
                }
                break;
            }
        }
        return Integer.parseInt(String.valueOf(chars)) ;
    }
}
