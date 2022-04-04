package easy;

/**
 * Created by chenz at 11:26 on 2021/1/23
 */
public class L557 {
    public String reverseWords0(String s) {
        String[] strings = s.split(" ");
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < strings.length; i++) {
            StringBuilder temp = new StringBuilder(strings[i]);
            stringBuilder.append(temp.reverse());
            if (i < strings.length - 1) {
                stringBuilder.append(" ");
            }
        }
        return stringBuilder.toString();
    }

    public String reverseWords(String s) {
        int i = 0;
        StringBuilder stringBuilder = new StringBuilder();
        while (i < s.length()){
            int start = i;
            while (i<s.length() && s.charAt(i)!=' '){
                i++;
            }
            for (int p = start; p < i; p++) {
                stringBuilder.append(s.charAt(i-p-1+start));
            }
            if (i<s.length()){
                i++;
                stringBuilder.append(' ');
            }
        }
        return stringBuilder.toString();
    }
}
