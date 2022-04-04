package mid;

public class L443 {
    public int compress(char[] chars) {
        int left = 0;
        int right = 0;
        StringBuilder sb = new StringBuilder();
        while (left<chars.length){
            while (right<chars.length&&chars[left]==chars[right]){
                right++;
            }
            sb.append(chars[left]);
            if (right-left>1){
                sb.append(right-left);
            }
            left = right;
        }
        for (int i = 0; i < sb.length(); i++) {
            chars[i] = sb.charAt(i);
        }
        return sb.length();
    }
}
