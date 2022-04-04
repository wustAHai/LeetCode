package easy;

/**
 * @author chenz at 23:05 on 2022/1/5 .
 */
public class L1576 {
    public String modifyString(String s) {
        char[] chars = s.toCharArray();
        int n = chars.length-1;
        for (int i = 1; i < n; i++) {
            char temp = 'a';
            if (chars[i]=='?'){
                while (temp==chars[i-1]||temp==chars[i+1]){
                    temp++;
                }
                chars[i]=temp;
            }
        }
        if (chars[0]=='?'){
            char temp = 'a';
            while (n>1&&temp==chars[1]){
                temp++;
            }
            chars[0]=temp;
        }
        if (chars[n]=='?'){
            char temp = 'a';
            while (n-1>=0&&temp==chars[n-1]){
                temp++;
            }
            chars[n]=temp;
        }
        return new String(chars);
    }

}
