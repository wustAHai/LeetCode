package easy;

/**
 * @author chenz at 19:21 on 2023/1/3 .
 */
public class L2042 {
    public boolean areNumbersAscending(String s) {
        String[] s1 = s.split(" ");
        int i = -1;
        for (String s2 : s1) {
            if (Character.isDigit(s2.charAt(0))){
                Integer integer = Integer.valueOf(s2);
                if (integer<=i){
                    return false;
                }
                i = integer;
            }
        }
        return true;
    }
}
