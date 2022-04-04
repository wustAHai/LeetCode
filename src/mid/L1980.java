package mid;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class L1980 {
    public String findDifferentBinaryString0(String[] nums) {
        int n = nums.length;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set.add(stringToInt(nums[i]));
        }
        int a = 0;
        for (int i = 0; i < n+1; i++) {
            if (!set.contains(i)){
                a = i;
                break;
            }
        }
        return intToString(a,n);
    }
    public String findDifferentBinaryString(String[] nums) {
        int n = nums.length;
        char[] chars = new char[n];
        Arrays.fill(chars,'0');
        for (int i = 0; i < n; i++) {
            if (nums[i].charAt(i)=='0'){
                chars[i] = '1';
            }
        }
        return new String(chars);
    }
    private int stringToInt(String s){
        int ans=0;
        for (int i = 0; i < s.length(); i++) {
            ans*=2;
            ans+=s.charAt(i) - '0';
        }
        return ans;
    }

    private String intToString(int a,int n){
        char[] chars = new char[n];
        Arrays.fill(chars,'0');
        for (int i = n-1; i >=0; i--) {
            if (a%2==1){
                chars[i]='1';
            }
            a/=2;
        }
        return new String(chars);
    }

    public static void main(String[] args) {
        L1980 obj = new L1980();
        String[] s= {"00","01"};
        String differentBinaryString = obj.findDifferentBinaryString(s);
        System.out.println(differentBinaryString);
    }
}
