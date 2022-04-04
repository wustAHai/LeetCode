package mid;

/**
 * Created by chenz at 9:49 on 2021/3/24
 */
public class L456 {
    public boolean find132pattern(int[] nums) {
        int i=0;
        int j=0;
        int k=0;
        boolean flag=false;
        while (i<nums.length){
            j=i+1;
            flag=false;
            while (j<nums.length){
                if (nums[j]<=nums[i]){
                    i=j;
                    flag=true;
                    break;
                }else {
                    k=j+1;
                    while (k<nums.length){
                        if (nums[k]>nums[i]&&nums[j]>nums[k]){
                            return true;
                        }
                        k++;
                    }
                }
                j++;
            }
            if (!flag){
                i++;
            }
        }
        return false;
    }
}
