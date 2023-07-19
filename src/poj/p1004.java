package poj;

import java.util.Scanner;

/**
 * @author chenz at 19:50 on 2023/3/8 .
 */
public class p1004 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int cnt = 0;
        double v = 0.0;
        while (cnt<12){
            cnt++;
            String s = scanner.nextLine();
             v += Double.parseDouble(s);
        }
        v/=12;
        int a = (int) (v*1000+5)/10;
        System.out.println("$"+a/100.0);
    }
}
