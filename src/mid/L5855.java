package mid;

import java.util.Arrays;
import java.util.Comparator;

public class L5855 {
    public String kthLargestNumber(String[] nums, int k) {
        Arrays.sort(nums, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length()!=o2.length()){
                    return o2.length()-o1.length();
                }else {
                    for (int i = 0; i < o1.length(); i++) {
                        if (o1.charAt(i)!=o2.charAt(i)){
                            return o2.charAt(i) - o1.charAt(i);
                        }
                    }
                    return 0;
                }
            }
        });
        return nums[k-1];
    }
}
