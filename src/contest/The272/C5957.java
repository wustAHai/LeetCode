package contest.The272;

/**
 * @author chenz at 10:34 on 2021/12/19 .
 */
public class C5957 {
    public String addSpaces(String s, int[] spaces) {
        char[] chars = s.toCharArray();
        StringBuilder ans = new StringBuilder();
        int j = 0;
        for (int i = 0; i < chars.length; i++) {
            if (j<spaces.length&&spaces[j]==i){
                ans.append(' ');
                j++;
            }
            ans.append(chars[i]);
        }
        return ans.toString();
    }
}
