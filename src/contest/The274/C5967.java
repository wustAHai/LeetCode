package contest.The274;

/**
 * @author chenz at 10:37 on 2022/1/2 .
 */
public class C5967 {
    public boolean checkString(String s) {
        int lastA = -1;
        int firstB =  -1;
        for (int i = 0; i < s.length(); i++) {
            if(firstB==-1&&s.charAt(i)=='b'){
                firstB = i;
            }
            if (s.charAt(i)=='a'){
                lastA = i;
            }
        }
        if (firstB == -1){
            return true;
        }
        return  lastA < firstB;
    }
}
