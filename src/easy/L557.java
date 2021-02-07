package easy;

/**
 * Created by chenz at 11:26 on 2021/1/23
 */
public class L557 {
    public String reverseWords(String s) {
        String[] strings = s.split(" ");
        StringBuilder stringBuilder  = new StringBuilder();
        for (int i = 0; i < strings.length; i++) {
            StringBuilder temp =new StringBuilder(strings[i]);
            stringBuilder.append(temp.reverse());
            if (i<strings.length-1){
                stringBuilder.append(" ");
            }
        }
        return stringBuilder.toString();
    }
}
