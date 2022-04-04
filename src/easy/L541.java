package easy;

import java.util.Arrays;

/**
 * Created by chenz at 16:00 on 2021/1/22
 */
public class L541 {
    public String reverseStr0(String s, int k) {
        StringBuilder stringBuilder = new StringBuilder();
        boolean reverse = true;
        int length = s.length();
        int counter = 0;
        StringBuilder temp = new StringBuilder();
        for (int i = 0; i < length; i++) {
            char ch = s.charAt(i);
            counter++;
            temp.append(ch);
            if (i == length - 1 || counter == k) {
                if (reverse) {
                    stringBuilder.append(temp.reverse());
                } else {
                    stringBuilder.append(temp);
                }
                counter = 0;
                reverse = !reverse;
                temp = new StringBuilder();
            }
        }
        return stringBuilder.toString();
    }
    public String reverseStr(String s, int k) {
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i+=2*k) {
            reverse(chars,i,Math.min(i+k,chars.length)-1);
        }
        return new String(chars);
    }

    private void reverse(char[] chars, int left, int right) {
        while (left<right){
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }
    }
}
