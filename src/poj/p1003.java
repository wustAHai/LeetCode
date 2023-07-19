package poj;

import java.util.Scanner;

/**
 * @author chenz at 19:29 on 2023/3/8 .
 */
public class p1003 {

    public static void main(String[] args) {
        double[] arr = new double[277];
        for(int i = 1;i<=276;i++){
            arr[i]= 1.0/(i+1)+arr[i-1];
        }
        Scanner scanner = new Scanner(System.in);
        String s;
        while (true){
            s = scanner.nextLine();
            if ("0.00".equals(s)){
                return;
            }
            double a = Double.parseDouble(s);
            for (int i = 1; i < arr.length; i++) {
                if (arr[i]>=a){
                    System.out.println(i+" card(s)");
                    break;
                }
            }
        }
    }
}
