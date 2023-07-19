package easy;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author chenz at 19:44 on 2022/9/7 .
 */
public class L1592 {
    public String reorderSpaces(String text) {
        Pattern pattern = Pattern.compile("[a-z]+");
        List<String> list = new ArrayList<>();
        Matcher matcher = pattern.matcher(text);
        int n = 0;
        while (matcher.find()){
           String s = matcher.group();
           list.add(s);
           n+=s.length();
        }
        if (list.size()==1){
            StringBuilder sb = new StringBuilder(list.get(0));
            while (sb.length()<text.length()){
                sb.append(" ");
            }
            return sb.toString();
        }
        int t = (text.length()-n)/(list.size()-1);
        StringBuilder sb = new StringBuilder();
        while (t>0){
            sb.append(" ");
        }
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            ans.append(list.get(i));
            if (i< list.size()-1){
                ans.append(sb);
            }
        }
        while (ans.length()<text.length()){
            ans.append(" ");
        }
        return ans.toString();
    }

    public static void main(String[] args) {
       String s = " a a  ";
        String[] split = s.split("\\s+");
        System.out.println(split);

        Pattern pattern = Pattern.compile("[a-z]+");
        Matcher matcher = pattern.matcher(s);
        while (matcher.find()){
            System.out.println(matcher.group());
        }
    }
}
