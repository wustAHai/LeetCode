package easy;

import java.util.HashSet;

/**
 * @author chenz at 9:20 on 2022/4/10 .
 */
public class L804 {
   String[] arr= {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
    public int uniqueMorseRepresentations(String[] words) {
        HashSet<String> set = new HashSet<>();
        for (String word : words) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < word.length(); i++) {
                sb.append(arr[word.charAt(i)-'a']);
            }
            set.add(sb.toString());
        }
        return  set.size();
    }

    public static void main(String[] args) {
        System.out.println(1.14/3*2);
    }
}
