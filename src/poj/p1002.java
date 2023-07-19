package poj;

import java.util.*;

/**
 * @author chenz at 20:16 on 2023/3/7 .
 */
public class p1002 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n  = Integer.parseInt(scanner.nextLine());
        TreeMap<String,Integer> map = new TreeMap<String,Integer>();
        while (n>0){
            String s = scanner.nextLine();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c=='-'){
                    continue;
                }
                if (c>='A'&&c<='Y'){
                    if(c<='R') sb.append((c-'A')/3+2);
                    if(c=='S') sb.append(7);
                    if (c>='T'&&c<='V') sb.append(8);
                    if (c>='W') sb.append(9);
                }else {
                    sb.append(c);
                }
            }
            sb.insert(3,'-');
            String s1 = sb.toString();
            Integer integer = map.get(s1);
            if (integer == null){
                map.put(s1,1);
            }else {
                map.put(s1,1+integer);
            }
            n--;
        }
        Set<String> strings = map.keySet();
        boolean no = true;
        for (String string : strings) {
            Integer integer = map.get(string);
            if (integer>1){
                no = false;
                System.out.println(string+" "+integer);
            }
        }
        if (no){
            System.out.println("No duplicates.");
        }
    }
}
