package contest;

/**
 * @author chenz at 22:29 on 2022/8/20 .
 */
public class L85 {


    public int minimumRecolors(String blocks, int k) {
        char[] chars = blocks.toCharArray();
        int minW = Integer.MIN_VALUE;
        int i = 0;
        int temp = 0;
        while (i < k) {
            if (chars[i++] == 'W') {
                temp++;
            }
        }
        minW = temp;
        while (i < blocks.length()) {
            if (chars[i - k] == 'W') {
                temp--;
            }
            if (chars[i] == 'W') {
                temp++;
            }
            minW = Math.min(temp, minW);
            i++;
        }
        return minW;
    }

    public int secondsToRemoveOccurrences(String s) {
        int ans = 0;
        char[] chars = s.toCharArray();
        while (judge(chars)) {
            ans++;
            for (int i = 1; i < chars.length; i++) {
                if (chars[i - 1] == '0' && chars[i] == '1') {
                    chars[i - 1] = '1';
                    chars[i] = '0';
                    i++;
                }
            }
        }
        return ans;
    }

    boolean judge(char[] chars) {
        for (int i = 1; i < chars.length; i++) {
            if (chars[i - 1] == '0' && chars[i] == '1') {
                return true;
            }
        }
        return false;
    }

    public String shiftingLetters(String s, int[][] shifts) {
        char[] chars = s.toCharArray();
        int[] a = new int[s.length()+1];
        for (int[] shift : shifts) {
            if (shift[2]==0){
                a[shift[0]]--;
                a[shift[1]+1]++;
            }else {
                a[shift[0]]++;
                a[shift[1]+1]--;
            }
        }

        for (int i = 1; i <a.length ; i++) {
            a[i]+=a[i-1];
        }

        for (int i = 0; i < chars.length; i++) {
            int t =chars[i]-'a';
            chars[i] = (char) (((a[i]+t) % 26+26 ) % 26 + 'a');
        }
        return String.valueOf(chars);
    }

    public static void main(String[] args) {
        L85 l85 = new L85();
        int[][] ints = {{0,1,0},{1,2,1},{0,2,1}};
        l85.shiftingLetters("abc",ints);
    }
}
