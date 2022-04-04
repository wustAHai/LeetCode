package mid;

/**
 * @author chenz at 20:22 on 2022/2/25 .
 */
public class L537 {
    public String complexNumberMultiply(String num1, String num2) {
        int[] num = getNum(num1);
        int[] num3 = getNum(num2);
        int a = num[0];
        int b = num[1];
        int  c = num3[0];
        int d = num3[1];
        int e = a*c - b*d;
        int f=a*d+b*c;
        return e+"+"+f+"i";
    }
    int[] getNum(String num){
        char[] chars = num.toCharArray();
        int a = 0;
        int b = 0;
        int i = 0;
        boolean neg = false;
        if (chars[i]=='-'){
            neg = true;
            i++;
        }
        for (; i < num.length() ; i++) {
            if (Character.isDigit(chars[i])){
                a*=10;
                a+=chars[i]-'0';
            }else {
                break;
            }
        }
        if (neg){
            a=-a;
            neg=false;
        }
        i++;
        if (chars[i]=='-'){
            neg = true;
            i++;
        }
        for (; i < num.length() ; i++) {
            if (Character.isDigit(chars[i])){
                b*=10;
                b+=chars[i]-'0';
            }else {
                break;
            }
        }
        if (neg){
            b=-b;
        }
        return  new int[]{a,b};
    }
}
