package easy;

import java.util.Arrays;

/**
 * @author chenz at 9:43 on 2022/2/13 .
 */
public class L1189 {
    public int maxNumberOfBalloons(String text) {
        int[] arr = new int[5];
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (ch=='a'){
                arr[0]++;
            }else if (ch=='b'){
                arr[1]++;
            }else if (ch=='l'){
                arr[2]++;
            }else if (ch=='o'){
                arr[3]++;
            }else if (ch =='n'){
                arr[4]++;
            }
        }
        arr[2]/=2;
        arr[3]/=2;
        Arrays.sort(arr);
        return arr[0];
    }
}
