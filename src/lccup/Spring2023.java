package lccup;

import java.util.*;

/**
 * @author chenz at 15:00 on 2023/4/22 .
 */
public class Spring2023 {
    public int[] supplyWagon(int[] supplies) {
        List<Integer> list = new ArrayList<>();
        for (int supply : supplies) {
            list.add(supply);
        }
        while (list.size()!=supplies.length/2){
            int minI = 0;
            int min =   Integer.MAX_VALUE;
            for (int i = 0; i < list.size()-1; i++) {
                int temp = list.get(i)+list.get(i+1);
                if (temp<min){
                    min = temp;
                    minI = i;
                }
            }
            list.set(minI,min);
            list.remove(minI+1);
        }
        int[] ret = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            ret[i] = list.get(i);
        }
        return ret;
    }

    public int adventureCamp(String[] expeditions) {
        Set<String> set = new HashSet<>();
        String[] split = stringSplit(expeditions[0]);
        for (String s : split) {
            set.add(s);
        }
        int ret = -1;
        int max = 0;
        for (int i = 1; i <expeditions.length ; i++) {
            String[] strings = stringSplit(expeditions[i]);
            int tempCnt = 0;
            for (String string : strings) {
                if (!set.contains(string)){
                    tempCnt++;
                    set.add(string);
                }
            }
            if (tempCnt>max){
                max = tempCnt;
                ret = i;
            }
        }
        return  ret;
    }

    String[] stringSplit(String s){
        if (s==null||"".equals(s)){
            return new String[0];
        }
        String[] split = s.split("->");
        return split;
    }

    public int fieldOfGreatestBlessing(int[][] forceField) {
        long[][] filed = new long[forceField.length][forceField[0].length];
        for (int i = 0; i < forceField.length; i++) {
            for (int i1 = 0; i1 < forceField[i].length; i1++) {
               filed[i][i1] = forceField[i][i1]*2L;
            }
        }
        Arrays.sort(filed, new Comparator<long[]>() {
            @Override
            public int compare(long[] o1, long[] o2) {
                long l =  o1[0]-o1[2]/2 - o2[0]+o2[2]/2;
                if (l>0){
                    return 1;
                }else if (l==0){
                    return 0;
                }else {
                    return -1;
                }
            }
        });
        long  left = 0;
        long  pre = -1;
        int ret = 0;
        for (int i = 0; i < filed.length; i++) {
            left = Math.max(0,filed[i][0]-filed[i][2]/2);
            if (left == pre){
                continue;
            }
            List<long[]> list = new ArrayList<>();
            for (long[] ints : filed) {
                if (left>= ints[0]-ints[2]/2&&left<=ints[0]+ints[2]/2){
                    list.add(new long[]{Math.max(0,ints[1]-ints[2]/2),ints[1]+ints[2]/2});
                }
            }
            if (list.size()<2){
                continue;
            }
            list.sort(new Comparator<long[]>() {
                @Override
                public int compare(long[] o1, long[] o2) {
                   if (o1[0]-o2[0]>0){
                       return 1;
                   }else if (o1[0]-o2[0]==0){
                       return 0;
                   }else {
                       return -1;
                   }
                }
            });
            PriorityQueue<Long> priorityQueue = new PriorityQueue<>();
            for (long[] ints : list) {
                long l = ints[0];
                long r = ints[1];
                while (!priorityQueue.isEmpty()&&priorityQueue.peek()<l){
                    priorityQueue.poll();
                }
                priorityQueue.offer(r);
                ret = Math.max(ret,priorityQueue.size());
            }
            pre = left;
        }
        return ret;
    }

    public static void main(String[] args) {
        int[][] arr = {{4,4,6},{7,5,3},{1,6,2},{5,6,3}};
        Spring2023 spring2023 = new Spring2023();
        System.out.println(spring2023.fieldOfGreatestBlessing(arr));
    }
    public String[] sortPeople(String[] names, int[] heights) {
        Map<Integer,String> map = new HashMap<>(heights.length);
        for (int i = 0; i < heights.length; i++) {
            map.put(heights[i],names[i]);
        }
        Arrays.sort(heights);
        String[] s = new String[heights.length];
        for (int i = heights.length-1; i >=0 ; i--) {
            s[heights.length-i-1]=map.get(heights[i]);
        }
        return s;
    }

    public int longestStrChain(String[] words) {
        List<Pair>[] lists = new ArrayList[16];
        for (int i = 0; i < lists.length; i++) {
            lists[i] = new ArrayList<>();
        }
        for (int i = 0; i < words.length; i++) {
            lists[words[i].length()-1].add(new Pair(words[i],1));
        }
        int ret = 1;
        for (int i = 1; i < 16; i++) {
            for (Pair pair : lists[i]) {
                for (Pair pair1 : lists[i - 1]) {
                    if (match(pair,pair1)){
                        ret = Math.max(ret,pair1.getLen()+1);
                        pair.setLen(Math.max(pair.getLen(),pair1.getLen()+1));
                    }
                }
            }
        }
        return ret;
    }

    private boolean match(Pair pair, Pair pair1) {
        String ls = pair.getS();
        String ss = pair1.getS();
        int i = 0;
        int j = 0;
        boolean isDiff = false;
        for (;i<ls.length()&&j<ss.length();){
            if (ls.charAt(i)==ss.charAt(j)){
                i++;
                j++;
            }else {
                if (isDiff){
                    return false;
                }
                i++;
                isDiff = true;
            }
        }
        return true;
    }

    public class Pair{
        private String s;
        private int len;

        public String getS() {
            return s;
        }

        public void setS(String s) {
            this.s = s;
        }

        public int getLen() {
            return len;
        }

        public void setLen(int len) {
            this.len = len;
        }

        public Pair(String s, int len) {
            this.s = s;
            this.len = len;
        }
    }
}

