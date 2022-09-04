package mid;

/**
 * @author chenz at 19:49 on 2022/8/30 .
 */
public class L2391 {
    public int garbageCollection(String[] garbage, int[] travel) {
        int cost = 0;
        int m=-1;
        int p=-1;
        int g=-1;
        for (int i = 0; i < garbage.length; i++) {
            cost+=garbage[i].length();
            if (garbage[i].contains("M")){
                m=i;
            }
            if (garbage[i].contains("P")){
                p=i;
            }
            if (garbage[i].contains("G")){
                g=i;
            }
        }
        int sum = 0;
        int max = Math.max(m,Math.max(p,g));
        for (int i = 0; i < travel.length&&i+1<=max; i++) {
            sum+= travel[i];
            if (i+1==m){
                cost+=sum;
            }
            if(i+1==p){
                cost+=sum;
            }
            if(i+1==g){
                cost+=sum;
            }
        }
        return cost;
    }
}
