package contest.The278;

/**
 * @author chenz at 10:29 on 2022/1/30 .
 */
public class S3 {
    public String subStrHash(String s, int power, int modulo, int k, int hashValue) {
        for (int i = 0; i <=s.length()-k; i++) {
            long hash=0;
            long p = 1;
            for (int j = i; j < i+k; j++) {
                hash%=modulo;
                p%=modulo;
                hash+=(s.charAt(j)-'a'+1)*p;
                p*=power;
            }
            if (hash == hashValue){
                return s.substring(i,i+k);
            }
        }
        return null;
    }


    public static void main(String[] args) {
        S3 s3 = new S3();
        System.out.println(s3.subStrHash("xmmhdakfursinye",96,45,15,21));
    }
}

