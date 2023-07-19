package easy;

/**
 * @author chenz at 19:12 on 2022/9/27 .
 */
public class 判定是否互为字符重排 {
    public boolean CheckPermutation(String s1, String s2) {
        if(s1.length()!=s2.length()){
            return false;
        }
        int[] arr = new int[26];
        char[] chars = s1.toCharArray();
        for (char aChar : chars) {
            ++arr[aChar-'a'];
        }
        chars = s2.toCharArray();
        for (char aChar : chars) {
            --arr[aChar-'a'];
        }
        for (int i : arr) {
            if (i!=0){
                return false;
            }
        }
        return true;
    }
}
