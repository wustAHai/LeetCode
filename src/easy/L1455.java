package easy;

/**
 * @author chenz at 18:41 on 2022/8/21 .
 */
public class L1455 {
    public int isPrefixOfWord(String sentence, String searchWord) {
        String[] s = sentence.split(" ");
        for (int i = 0; i < s.length; i++) {
            if (s[i].startsWith(searchWord)){
                return i+1;
            }
        }
        return -1;
    }
}
