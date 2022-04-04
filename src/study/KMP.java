package study;

/**
 * @author chenz at 1:00 on 2022/4/4 .
 * <p><a href=https://oi-wiki.org/string/kmp/ >前缀函数与 KMP 算法</a>
 */
public class KMP {

    public static void kmp(String s,String p){
        int[] aux = aux(p);
        System.out.println(p);
        for (int i : aux) {
            System.out.print(i);
        }
        System.out.println();
        int sl = s.length();
        for (int i = 0,j=0; i < sl;) {
            if (s.charAt(i)==p.charAt(j)){
                i++;
                j++;
                if (j==p.length()){
                    j=0;
                    System.out.println("find"+i);
                    System.out.println(s.substring(i-p.length(),i));
                }
            }else {
                if (j==0){
                    i++;
                }else {
                    j=aux[j-1];
                }
            }
        }
    }
    public static int[] aux(String p){
        int[] aux = new int[p.length()];
        int pl = p.length();
        for (int i = 1; i < pl; i++) {
/*            if (p.charAt(i)==p.charAt(aux[i-1])){
                aux[i] = aux[i-1]+1;
            }else {
                int next = aux[i-1]-1;
                while (next>=0){
                    if (p.charAt(i)==p.charAt(aux[next])){
                        aux[i] = aux[next]+1;
                    }else {
                        next= aux[next]-1;
                    }
                }
            }*/
            int next = i-1;
            while (next>=0){
                next = aux[next];
                if (p.charAt(i)==p.charAt(next)){
                    aux[i]=next+1;
                    break;
                }else {
                    --next;
                }
            }
        }
        return aux;
    }

    public static void main(String[] args) {
        String s = "mississippi";
        String p =  "issip";
        kmp(s,p);
    }
}
