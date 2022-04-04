package easy;

public class L5843 {
    public int numOfStrings(String[] patterns, String word) {
        int n = 0;
        for (int i = 0; i < patterns.length; i++) {
            if (word.contains(patterns[i])){
                n++;
            }
        }
        return n;
    }
}
