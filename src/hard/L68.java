package hard;

import java.util.ArrayList;
import java.util.List;

public class L68 {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        int p = 0;
        int q = 0;
        while (p<words.length){
            int length = 0;
            while (q<words.length&&length<maxWidth){
                if (length==0){
                    length+=words[q].length();
                }else {
                    length+=words[q].length()+1;
                }
                q++;
            }
            if (length>maxWidth){
                q--;
                int realLength = 0;
                int count = q-p;
                for (int i = p; i < q; i++) {
                    realLength += words[i].length();
                }
                int blanks = maxWidth-realLength;
                if (count==1){
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(words[p]);
                    while (stringBuilder.length()<maxWidth){
                        stringBuilder.append(' ');
                    }
                    result.add(stringBuilder.toString());
                }else {
                    StringBuilder stringBuilder = new StringBuilder();
                    int mod =  blanks%(count-1);
                    int avg = blanks/(count-1);
                    for (int i = p; i < q; i++) {
                        stringBuilder.append(words[i]);
                        if (i<p-1){
                            append(stringBuilder,avg);
                        }
                        if (mod>0){
                            append(stringBuilder,1);
                        }
                        mod--;
                    }
                    result.add(stringBuilder.toString());
                }
            }else if (length == maxWidth){
                StringBuilder stringBuilder = new StringBuilder();
                for (int i = p; i < q; i++) {
                    stringBuilder.append(words[i]);
                    if (i<q-1){
                        stringBuilder.append(' ');
                    }
                }
                result.add(stringBuilder.toString());
            }else {
                StringBuilder stringBuilder = new StringBuilder();
                for (int i = p; i < q; i++) {
                    stringBuilder.append(words[i]);
                    if (i<q-1){
                        stringBuilder.append(' ');
                    }
                }
                while (stringBuilder.length()<maxWidth){
                    stringBuilder.append(' ');
                }
                result.add(stringBuilder.toString());
            }
            p = q;
        }
        return result;
    }
    private void  append(StringBuilder stringBuilder ,int c){
        while (c>0){
            stringBuilder.append(' ');
            c--;
        }
    }

    public static void main(String[] args) {
        String[] a = {"This", "is", "an", "example", "of", "text", "justification."};
        L68 l68 = new L68();
        l68.fullJustify(a,16);
    }
}
