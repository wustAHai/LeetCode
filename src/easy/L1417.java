package easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chenz at 18:34 on 2022/8/12 .
 */
public class L1417 {
    public String reformat(String s) {
        char[] chars = s.toCharArray();
        List<Character> integers = new ArrayList<>();
        List<Character> characters = new ArrayList<>();
        for (char aChar : chars) {
            if (Character.isDigit(aChar)){
                integers.add(aChar);
            }else {
                characters.add(aChar);
            }
        }
        if (Math.abs(integers.size()-characters.size())>1){
            return "";
        }
        return append(integers,characters);
    }

    String append(List<Character> ch1,List<Character> ch2){
        if (ch1.size()<ch2.size()){
            return append(ch2,ch1);
        }
        StringBuilder sb = new StringBuilder();
        int i = 0;
        int j = 0;
        while (i<ch1.size()||j<ch2.size()){
            if (i>j){
                sb.append(ch2.get(j++));
            }else {
                sb.append(ch1.get(i++));
            }
        }
        return sb.toString();
    }

}
