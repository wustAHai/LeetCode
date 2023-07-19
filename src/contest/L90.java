package contest;

import javax.naming.NamingEnumeration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author chenz at 22:50 on 2022/10/29 .
 */
public class L90 {
    public String oddString(String[] words) {
        int n  = words.length;
        int m  = words[0].length();
        int [][] arr = new int[n][m-1];
        for (int i = 0; i < words.length; i++) {
            char[] chars = words[i].toCharArray();
            for (int j = 1; j <m; j++) {
                arr[i][j - 1] = chars[j] - chars[j - 1];
            }
        }
        if (func(arr,0,1)){
            for (int i = 2; i < n; i++) {
                if (!func(arr,0,i)){
                    return words[i];
                }
            }

        }else {
            if (func(arr,0,2)){
                return words[1];
            }else {
                return words[0];
            }
        }
        return null;
    }

    boolean func(int[][]arr , int i ,int j){
        for (int k = 0; k < arr[i].length; k++) {
            if (arr[i][k]!=arr[j][k]){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        new L90().oddString(new String[] {"wwe","yyg","ssa","ttb","ddd","ssa","xxf","ssa","ttb","xxf","xxf","zzh","wwe","yyg","xxf"});
    }

    public List<String> twoEditWords(String[] queries, String[] dictionary) {
        char[][] charr  = new char[dictionary.length][];
        for (int i = 0; i < dictionary.length; i++) {
            charr[i] = dictionary[i].toCharArray();
        }
        List<String> list = new ArrayList<>();
        for (int i = 0; i < queries.length; i++) {
            char[] chars = queries[i].toCharArray();
            for (int i1 = 0; i1 < charr.length; i1++) {
                if (func1(chars,charr[i1])){
                    list.add(queries[i]);
                    break;
                }
            }
        }
        return list;
    }

    private boolean func1(char[] chars, char[] chars1) {
        int i = 0;
        for (int i1 = 0; i1 < chars.length; i1++) {
            if (chars[i1]!=chars1[i1]){
                i++;
                if (i>2){
                    return false;
                }
            }
        }
        return true;
    }
    public int destroyTargets(int[] nums, int space) {
        return Arrays.stream(nums).min().getAsInt();
    }
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        StringBuilder sb = new StringBuilder();
        for (String s : word1) {
            sb.append(s);
        }
        StringBuilder sb2 = new StringBuilder();
        for (String s : word2) {
            sb2.append(s);
        }
        return  sb.toString().equals(sb2.toString());
    }
}
