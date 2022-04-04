package mid;

public class L1963 {
    public int minSwaps(String s) {
        char[] chars = s.toCharArray();
        int max = 0;
        int temp =0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i]==']'){
                temp++;
            }else {
                temp --;
            }
            max = Math.max(max,temp);
        }
        return  (max+1)/2;
    }
}
