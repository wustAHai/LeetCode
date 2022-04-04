package contest.the281;

import easy.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author chenz at 10:24 on 2022/2/20 .
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    public int countEven(int num) {
        int ans = 0;
        for (int i = 2; i <= num; i++) {
            int temp = i;
            int sum = 0;
            while (temp > 0) {
                sum += temp % 10;
                temp /= 10;
            }
            if (sum % 2 == 0) {
                ans++;
            }
        }
        return ans;
    }

    public ListNode mergeNodes(ListNode head) {
        ListNode p = head.next;
        while (p != null && p.next != null) {
            if (p.next.val == 0) {
                if (p.next.next == null) {
                    p.next = null;
                } else {
                    p.next = p.next.next;
                    p = p.next;
                }
            } else {
                p.val += p.next.val;
                p.next = p.next.next;
            }
        }
        return head.next;
    }

    public String repeatLimitedString(String s, int repeatLimit) {
        int[] chs = new int[26];
        for (int i = 0; i < s.length(); i++) {
            chs[s.charAt(i) - 'a']++;
        }
        PriorityQueue<int[]> p = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[0] - o1[0];
            }
        });
        for (int i = 25; i >= 0; i--) {
            if (chs[i] != 0) {
                p.add(new int[]{i, chs[i]});
            }
        }
        StringBuilder sb = new StringBuilder();
        int last = -1;
        while (!p.isEmpty()) {
            int[] poll = p.poll();
            if (poll[0] == last) {
                if (p.isEmpty()) {
                    break;
                } else {
                    int[] poll1 = p.poll();
                    sb.append((char) (poll1[0] + 'a'));
                    last = poll1[0];
                    poll1[1]--;
                    p.add(poll);
                    if (poll1[1] > 0) {
                        p.add(poll1);
                    }
                }
            } else {
                if (poll[1] <= repeatLimit) {
                    for (int i = 0; i < poll[1]; i++) {
                        sb.append((char) (poll[0] + 'a'));
                    }
                } else {
                    for (int i = 0; i < repeatLimit; i++) {
                        sb.append((char) (poll[0] + 'a'));
                    }
                    poll[1] -= repeatLimit;
                    p.add(poll);
                }
                last = poll[0];
            }
        }
        return sb.toString();
    }

    public long coutPairs(int[] nums, int k) {
        int[] gcd = new int[k + 1];
        for (int num : nums) {
            gcd[gcd(num, k)]++;
        }
        long ans = 0;
        ans += (long) gcd[k] * (nums.length - gcd[k]) + (long) (gcd[k] - 1) * gcd[k] / 2;
        for (int i = 2; i * i <= k; i++) {
            if (gcd[i] != 0) {
                for (int j = Math.max( k / i,i); j < k; j++) {
                    if (j * i % k == 0) {
                        if (j!=i){
                            ans += gcd[i] * gcd[j];
                        }else {
                            ans += gcd[i]*(gcd[j]-1)/2;
                        }
                    }
                }
            }
        }
        return ans;
    }

    int gcd(int p, int q) {
        if (q == 0) {
            return p;
        }
        p = p % q;
        return gcd(q, p);
    }
}
