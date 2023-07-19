package easy;

/**
 * @author chenz at 20:42 on 2022/10/17 .
 */
public class L1089 {
    public void duplicateZeros(int[] arr) {
        int i = 0 ;
        int len = 0;
        for (; i < arr.length ;) {
            if (arr[i]==0){
                len+=2;
            }else {
                len++;
            }
            i++;
            if (len>=arr.length){
                break;
            }
        }
        if (i==arr.length){
            return;
        }
        i--;
        if (arr.length==len){
            for (int j = arr.length-1; i>=0 ;i--) {
                if (arr[i]==0){
                    arr[j--]=0;
                    arr[j--]=0;
                }else {
                    arr[j--]=arr[i];
                }
            }
        }else {
            arr[arr.length-1]=arr[i--];
            for (int j = arr.length-2; i>=0;) {
                if (arr[i]==0){
                    arr[j--]=0;
                    arr[j--]=0;
                }else {
                    arr[j--]=arr[i];
                }
                i--;
            }
        }
    }
}
