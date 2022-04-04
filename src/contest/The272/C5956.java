package contest.The272;

/**
 * @author chenz at 10:30 on 2021/12/19 .
 */
public class C5956 {
    public String firstPalindrome(String[] words) {
        for (String word : words) {
            if (isFind(word)){
                return word;
            }
        }
        return "";
    }

    private boolean isFind(String word) {
        int l = word.length();
        int m = l/2;
        for (int i = 0; i < m; i++) {
            if (word.charAt(i)!=word.charAt(l-i-1)){
                return false;
            }
        }
        return true;
    }

}
