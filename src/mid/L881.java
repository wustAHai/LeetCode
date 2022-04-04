package mid;

import java.util.Arrays;

public class L881 {
    public int numRescueBoats(int[] people, int limit) {
        int p = 0;
        int q = people.length-1;
        Arrays.sort(people);
        int n =0;
        while (p<=q){
            if (people[p]+people[q]<=limit){
                p++;
                q--;
            }else {
                q--;
            }
            n++;
        }
        return n;
    }
}
