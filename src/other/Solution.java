package other;

import easy.ListNode;

import java.util.*;

/**
 * @author chenz at 17:01 on 2022/3/13 .
 */
public class Solution {
    public boolean isPalindrome(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while (head!=null){
            list.add(head.val);
            head=head.next;
        }
        int p = 0;
        int q = list.size()-1;
        boolean flag = false;
        while (p<=q){
            if (list.get(p)==list.get(q)){
                p++;
                q--;
            }else {
                return isValid(list,p+1,q) || isValid(list,p,q-1);
            }
        }
        return true;
    }
    boolean isValid(List<Integer> list, int p,int q){
        while (p<=q){
            if (list.get(p)==list.get(q)){
                p++;
                q--;
            }else {
                return false;
            }
        }
        return false;
    }

    public int maxInvestment(int[] product, int limit) {
        TreeMap<Integer,Integer> map = new TreeMap<>((a,b)->b-a);
        long ans = 0l;
        for (int i : product) {
            map.put(i,map.getOrDefault(i,0)+1);
        }
        map.put(0,0);
        while (map.size()>1){
            Map.Entry<Integer, Integer> hi = map.pollFirstEntry();
            Map.Entry<Integer, Integer> low = map.pollFirstEntry();
           long val = (long)(hi.getKey()-low.getKey())*hi.getValue();
            if (val<limit){
                limit-=val;
                ans += (long) (low.getKey() + 1 + hi.getKey()) *(hi.getKey()-low.getKey())/2*hi.getValue();
                ans%=1000000007;
                map.put(low.getKey(),low.getValue()+ hi.getValue());
            }else {
                int times =  limit / hi.getValue();
                int left =   limit % hi.getValue();
                ans += (long) (hi.getKey() - times + 1 + hi.getKey()) *times/2*hi.getValue()+ (long) left *(hi.getKey()-times);
                ans%=1000000007;
                return (int) ans%1000000007;
            }
        }
        return (int) ans%1000000007;
    }

}
class DiscountSystem {

    TreeMap<Integer,Activity> activityMap;

    public DiscountSystem() {
        activityMap = new TreeMap<>();
    }

    public void addActivity(int actId, int priceLimit, int discount, int number, int userLimit) {
        Activity activity = new Activity(priceLimit, discount, number, userLimit);
        activityMap.put(actId,activity);
    }

    public void removeActivity(int actId) {
        activityMap.remove(actId);
    }

    public int consume(int userId, int cost) {
        Set<Map.Entry<Integer, Activity>> entries = activityMap.entrySet();
        int maxDiscount = 0;
        int minAcid = -1;
        for (Map.Entry<Integer, Activity> entry : entries) {
            Activity activity = entry.getValue();
            if (cost<activity.priceLimit){
                continue;
            }
            Integer times = activity.userTimes.get(userId);
            if (times==null||activity.number==0){
                continue;
            }
            if (times!=null&&times>=activity.userLimit){
                continue;
            }
            if (activity.discount>maxDiscount){
                maxDiscount = activity.discount;
                minAcid = entry.getKey();
            }
        }
        if (minAcid==-1){
            return cost;
        }
        Activity activity = activityMap.get(minAcid);
        activity.userTimes.put(userId,activity.userTimes.getOrDefault(userId,0)+1);
        activity.number--;
        return cost-maxDiscount;
    }

    class Activity{
        HashMap<Integer,Integer> userTimes;
        int priceLimit;
        int discount;
        int number;
        int userLimit;
        public Activity(int priceLimit, int discount, int number, int userLimit) {
            this.priceLimit = priceLimit;
            this.discount = discount;
            this.number = number;
            this.userLimit = userLimit;
            userTimes = new HashMap<>();
        }
    }
}