package inter;

/**
 * Created by chenz at 15:00 on 2021/2/20
 */
public class T1 {
    public int bitwiseComplement(int N) {
        if(N==0){
            return 1;
        }
        int ans=0;
        int i=1;
        while (N>0){
            ans+=(1-N%2)*i;
            N/=2;
            i*=2;
        }
        return ans;
    }
}
