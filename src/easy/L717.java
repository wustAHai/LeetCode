package easy;

/**
 * @author chenz at 18:27 on 2022/2/20 .
 */
public class L717 {
    public boolean isOneBitCharacter(int[] bits) {
        for (int i = 0; i < bits.length; ) {
            if (bits[i]==0){
                i++;
            }else {
                i+=2;
                if (i>bits.length-1) {
                    return false;
                }
            }
        }
        return true;
    }
}
