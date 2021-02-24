package easy;

/**
 * Created by chenz at 23:25 on 2021/1/19
 */
public class L520 {
    public boolean detectCapitalUse(String word) {
        if (word.length() <= 1) return true;
        if (Character.isLowerCase(word.charAt(0))) {
            for (int i = 1; i < word.length(); i++) {
                if (Character.isUpperCase(word.charAt(i))) {
                    return false;
                }
            }
            return true;
        } else {
            if (Character.isUpperCase(word.charAt(1))) {
                for (int i = 2; i < word.length(); i++) {
                    if (Character.isLowerCase(word.charAt(i))) {
                        return false;
                    }
                }
                return true;
            } else {
                for (int i = 2; i < word.length(); i++) {
                    if (Character.isUpperCase(word.charAt(i))) {
                        return false;
                    }
                }
                return true;
            }
        }
    }
}
