package mid;

/**
 * @author chenz at 19:28 on 2022/10/17 .
 */
public class L904 {
    public int totalFruit(int[] fruits) {
        int type = 0;
        int[] a = new int[3];
        int[] b = new int[3];
        int max = 0;
        for (int i = 0; i < fruits.length; i++) {
            if (type == 0) {
                a[0] = fruits[i];
                a[1] = i;
                a[2]++;
                type++;
            } else if (type == 1) {
                if (fruits[i] == a[0]) {
                    a[1] = i;
                    a[2]++;
                } else {
                    type++;
                    b[0] = fruits[i];
                    b[1] = i;
                    b[2]++;
                }
            } else {
                if (a[0] == fruits[i]) {
                    a[1] = i;
                    a[2]++;
                } else if (b[0] == fruits[i]){
                    b[1] = i;
                    b[2]++;
                }else {
                    if (a[1]>b[1]){
                        a[2]=a[1]-b[1];
                        b[0]=fruits[i];
                        b[1]=i;
                        b[2]=1;
                    }else {
                        b[2]=b[1]-a[2];
                        a[0]=fruits[i];
                        a[1]=i;
                        a[2]=1;
                    }
                }
            }
            max = Math.max(a[2]+b[2],max);
        }
        return max;
    }
}
