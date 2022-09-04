package easy;

/**
 * @author chenz at 12:36 on 2022/6/25 .
 */
public class L2309 {
    public String greatestLetter(String s) {
        int[] a = new int[26];
        int[] A = new int[26];
        String ans = "";
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if ( Character.isUpperCase(ch)){
                A[ch -'A'] =1;
            }else {
                a[ch - 'a'] =1;
            }
        }
        for (int i = 25; i >=0; i--) {
            if (A[i]==1&&a[i]==1){
                char c= (char) ('A'+i);
                ans+= c;
                break;
            }
        }
        return ans;
    }
}
