package easy;

public class L171 {
    public int titleToNumber(String columnTitle) {
        int sum=0;
        int n = 1;
        for (int i = columnTitle.length()-1; i > -1 ; i--) {
            sum += (columnTitle.charAt(i)-'A'+1)*n;
            n = n*26;
        }
        return sum;
    }
}
