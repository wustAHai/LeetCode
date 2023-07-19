package easy;

/**
 * @author chenz at 19:18 on 2022/10/8 .
 */
public class L1784 {
    public boolean checkOnesSegment(String s) {
        int l = s.length();
        if(l==1){
            return true;
        }
        int i = 0;
        for(;i<l;i++){
            if(s.charAt(i)!='1'){
                break;
            }
        }
        if(i==l){
            return true;
        }
        for(;i<l;i++){
            if(s.charAt(i)=='1'){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new L1784().checkOnesSegment("101100000"));
    }
}
