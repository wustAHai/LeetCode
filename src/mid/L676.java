package mid;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author chenz at 20:01 on 2022/7/11 .
 */
public class L676 {
    class MagicDictionary {

        private Map<Integer, List<String>> map;

        public MagicDictionary() {
            map = new HashMap<>();
        }

        public void buildDict(String[] dictionary) {
            for (String s : dictionary) {
                List<String> list = map.get(s.length());
                if (list == null) {
                    list = new ArrayList<>();
                    list.add(s);
                    map.put(s.length(), list);
                }else {
                    list.add(s);
                }

            }
        }

        public boolean search(String searchWord) {
            List<String> list = map.get(searchWord.length());
            if (list == null){
                return false;
            }else {
                for (String s : list) {
                    int cnt = 0;
                    for (int i = 0; i < s.length(); i++) {
                        if (s.charAt(i)!=searchWord.charAt(i)){
                            cnt++;
                        }
                    }
                    if (cnt==1){
                        return true;
                    }
                }
            }
            return false;
        }
    }
    /**
     * 方法二：使用字典树优化枚举
     */
    // TODO: 2022/7/11  
}
