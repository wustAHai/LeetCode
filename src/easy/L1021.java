package easy;

/**
 * @author chenz at 22:01 on 2022/10/21 .
 */
public class L1021 {
    public String removeOuterParentheses(String s) {
        char[] chars = s.toCharArray();
        int i = 0;
        int j = 0;
        int n = 0;
        StringBuilder sb = new StringBuilder();
        while (i<chars.length){
            j=i;
            do {
                if (chars[j]=='('){
                    n++;
                }else {
                    n--;
                }
                j++;
            }while (n!=0);
            if (j-i+1>2){
                sb.append(chars,i+1,j-i-1);
            }else {
                sb.append(chars,i,j-i);
            }
            i=j;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        L1021 l1021 = new L1021();
        System.out.println();l1021.removeOuterParentheses("(()())(())");
    }
}
