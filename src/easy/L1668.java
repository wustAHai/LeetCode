package easy;

/**
 * @author chenz at 22:45 on 2022/11/3 .
 */
public class L1668 {
    public int maxRepeating(String sequence, String word) {
        int i =0 ;
        StringBuilder sb  = new StringBuilder(word);
        int n = sequence.length()/word.length();
        for (;  i<=n&&sequence.contains(sb) ; i++) {
            sb.append(word);
        }
        return i;
    }

    public static void main(String[] args) {
        new L1668().maxRepeating("ababc","ab");
    }
}
