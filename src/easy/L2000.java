package easy;

/**
 * @author chenz at 19:34 on 2022/2/2 .
 */
public class L2000 {
    public String reversePrefix(String word, char ch) {
        int index = -1;
        for (int i = 0; i < word.length(); i++) {
            if (ch == word.charAt(i)){
                index = i;
                break;
            }
        }
        if (index == -1){
            return word;
        }
        return new StringBuilder(word.substring(0,index+1)).reverse().toString()+word.substring(index+1);
    }
}
