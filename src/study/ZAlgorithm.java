package study;

/**
 * @author chenz at 9:18 on 2022/4/3 .
 * <p><a href=https://oi-wiki.org/string/z-func/#_3 >Z 函数（扩展 KMP）</a>
 */

public class  ZAlgorithm {

    /**
     * 暴力 O(n^2)
    * */
    public static int[] zFunc(String str){
        int length = str.length();
        int[] z = new int[length];
        for (int i = 1; i < length; i++) {
            while (i+z[i]<length&&str.charAt(i+z[i])==str.charAt(z[i])){
                z[i]++;
            }
        }
        return z;
    }


    /**
     * 改进 O(n)
     * */
    public static int[] zFunc1(String str){
        int length = str.length();
        int[] z = new int[length];
        int l=0;
        int r=0;
        //l->r  = 0->r-l  i->r =i-l->r-l
        for (int i = 1; i < length; i++) {
            if (i>r){
                while (i+z[i]<length&&str.charAt(i+z[i])==str.charAt(z[i])){
                    z[i]++;
                }
            }else {
                z[i] = Math.min(z[i-l],r-i+1);
                if (z[i-l]>=r-i+1){
                    while (i+z[i]<length&&str.charAt(i+z[i])==str.charAt(z[i])){
                        z[i]++;
                    }
                }
            }
            if (z[i]+i-1>r){
                l=i;
                r=z[i]+i-1;
            }
        }
        return z;
    }

    public static void main(String[] args) {
        String str = "aaabaab";
        int[] ints = zFunc(str);
        for (int i = 0; i < ints.length; i++) {

            System.out.print(ints[i]);
            if (i!=ints.length-1){
                System.out.print(", ");
            }
        }
    }
}
