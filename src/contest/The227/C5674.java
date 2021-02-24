package contest.The227;

import org.junit.Test;

/**
 * Created by chenz at 11:10 on 2021/2/7
 */
public class C5674 {
    public String largestMerge(String word1, String word2) {
        StringBuilder stringBuilder = new StringBuilder();
        int l1 = word1.length();
        int l2 = word2.length();
        int index1 = 0;
        int index2 = 0;
        while (index1 < l1 && index2 < l2) {
            char ch1 = word1.charAt(index1);
            char ch2 = word2.charAt(index2);
            if (ch1 > ch2) {
                stringBuilder.append(ch1);
                index1++;
            } else if (ch1 < ch2) {
                stringBuilder.append(ch2);
                index2++;
            } else {
                int k = word1.substring(index1).compareTo(word2.substring(index2));
                if (k > 0) {
                    stringBuilder.append(ch1);
                    index1++;
                } else if (k < 0) {
                    stringBuilder.append(ch2);
                    index2++;
                } else {
                    stringBuilder.append(ch1);
                    index1++;
                }
            }
        }
        while (index1 < l1) {
            stringBuilder.append(word1.charAt(index1));
            index1++;
        }
        while (index2 < l2) {
            stringBuilder.append(word2.charAt(index2));
            index2++;
        }
        return stringBuilder.toString();
    }

    @Test
    public void testString() {
        String a = "abc";
        String b = "cba";
        System.out.println(largestMerge(a, b));
    }
}
