package mid;

/**
 * @author chenz at 20:30 on 2022/10/8 .
 */
public class L777 {
    public boolean canTransform(String start, String end) {
        //xl-> lx     rx -> xr
        char[] s = start.toCharArray();
        char[] e = end.toCharArray();
        for (int i = 0; i < s.length; ) {
            if (s[i] == e[i]) {
                i++;
            } else {
                if (i + 1 < s.length) {
                    if (e[i]=='X'){
                        int j = i;
                        while (j<s.length&&s[j]=='R'){
                            j++;
                        }
                        if (j==s.length || s[j]=='L'){
                            return false;
                        }
                        s[j]='R';
                        s[i]='X';
                    }else if (e[i]=='L'){
                        int j = i;
                        while (j<s.length&&s[j]=='X'){
                            j++;
                        }
                        if (j==s.length || s[j]=='R'){
                            return false;
                        }
                        s[j]='X';
                        s[i]='L';
                    }else {
                        return false;
                    }
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}
