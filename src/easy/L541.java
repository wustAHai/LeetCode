package easy;

/**
 * Created by chenz at 16:00 on 2021/1/22
 */
public class L541 {
    public String reverseStr(String s, int k) {
        StringBuilder stringBuilder=new StringBuilder();
        boolean reverse = true;
        int length = s.length();
        int counter =0;
        StringBuilder temp = new StringBuilder();
        for (int i = 0; i < length; i++) {
            char ch = s.charAt(i);
            counter++;
            temp.append(ch);
            if (i==length-1||counter==k){
                if (reverse){
                    stringBuilder.append(temp.reverse());
                }else {
                    stringBuilder.append(temp);
                }
                counter=0;
                reverse=!reverse;
                temp = new StringBuilder();
            }
        }
        return  stringBuilder.toString();
    }
}
