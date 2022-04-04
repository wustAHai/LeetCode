package easy;

/**
 * Created by chenz at 22:46 on 2021/1/21
 */
public class L504 {
    public String convertToBase7(int num) {
        if (num == 0) {
            return "0";
        } else if (num > 0) {
            StringBuilder stringBuilder = new StringBuilder();
            while (num > 0) {
                stringBuilder.insert(0, num % 7);
                num /= 7;
            }
            return stringBuilder.toString();
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            num = 0 - num;
            while (num > 0) {
                stringBuilder.insert(0, num % 7);
                num /= 7;
            }
            stringBuilder.insert(0, '-');
            return stringBuilder.toString();
        }
    }
}
