package easy;
/**
 * @author chenz at 20:39 on 2022/7/20 .
 */
public class L824 {
    public String toGoatLatin(String sentence) {
        String[] s = sentence.split(" ");
        String a ="a";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length; i++) {
            String s1 = s[i];
            char c = s1.toLowerCase().charAt(0);
            if (c=='a'||c=='e'||c=='i'||c=='o'||c=='u'){
                sb.append(s1);
            }else {
                sb.append(s1.substring(1)).append(s1.charAt(0));
            }
            sb.append("ma").append(a);
            a+='a';
            if (i<s.length-1){
                sb.append(" ");
            }
        }
        return sb.toString();
    }
}
