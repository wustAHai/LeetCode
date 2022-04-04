package mid;

import org.junit.Test;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * Created by chenz at 13:32 on 2021/1/4
 */
public class L71 {
    public String simplifyPath(String path) {
        StringBuilder stringBuilder = new StringBuilder();
        Deque<String> strings = new LinkedList<>();
        String[] paths = path.split("/");
        for (int i = 0; i < paths.length; i++) {
            if ("".equals(paths[i]) || ".".equals(paths[i])) {
                continue;
            }
            if ("..".equals(paths[i])) {
                if (strings.size() > 0) {
                    strings.removeLast();
                }
            } else {
                strings.add(paths[i]);
            }
        }
        while (strings.size() > 0) {
            stringBuilder.append("/");
            stringBuilder.append(strings.removeFirst());
        }
        if (stringBuilder.length() == 0) {
            stringBuilder.append("/");
        }
        return stringBuilder.toString();
    }

}
