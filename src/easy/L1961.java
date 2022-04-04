package easy;

public class L1961 {
    public boolean isPrefixString(String s, String[] words) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            sb.append(words[i]);
            if (s.equals(sb.toString())){
                return true;
            }else if (sb.length()>=s.length()){
                return false;
            }
        }
        return false;
    }
}
