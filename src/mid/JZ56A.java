package mid;

/**
 * Created by chenz at 15:25 on 2021/3/9
 */
public class JZ56A {
    public int[] singleNumbers(int[] nums) {
        int x=nums[0];
        for (int i = 1; i < nums.length; i++) {
            x^=nums[i];
        }
        int div=1;
        while ((div&x)==0){
            div<<=1;
        }
        int a=0;
        int b=0;
        for (int n :
                nums) {
            if ((div&n)==0){
                a^=n;
            }else {
                b^=n;
            }
        }
        return  new int[]{a,b};
    }
}
