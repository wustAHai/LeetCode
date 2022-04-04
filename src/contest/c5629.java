package contest;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class c5629 {
    public String reformatNumber(String number) {
        List<Character> characters = new ArrayList<>();
        for (int i = 0; i < number.length(); i++) {
            if (Character.isDigit(number.charAt(i))) {
                characters.add(number.charAt(i));
            }
        }
        StringBuilder sb = new StringBuilder();
        while (characters.size() > 4) {
            sb.append(characters.remove(0));
            sb.append(characters.remove(0));
            sb.append(characters.remove(0));
            sb.append('-');
        }
        if (characters.size() == 4) {
            sb.append(characters.remove(0));
            sb.append(characters.remove(0));
            sb.append('-');
            sb.append(characters.remove(0));
            sb.append(characters.remove(0));
        } else if (characters.size() == 3) {
            sb.append(characters.remove(0));
            sb.append(characters.remove(0));
            sb.append(characters.remove(0));
        } else if (characters.size() == 2) {
            sb.append(characters.remove(0));
            sb.append(characters.remove(0));
        } else if (characters.size() == 1) {
            sb.append(characters.remove(0));
        }
        return sb.toString();
    }

    @Test
    public void test() {
        System.out.println(reformatNumber("123 4-567"));
    }
}
