package mid;

import java.util.HashMap;
import java.util.Map;

/**
 * @author chenz at 19:32 on 2021/12/11 . 考点 Map 减少重复计算 二分法
 */
public class L911 {

    static class TopVotedCandidate {
        Map<Integer,Integer> personScore = new HashMap<>();
        Map<Integer,Integer> timePerson = new HashMap<>();
        int [] times;
        public TopVotedCandidate(int[] persons, int[] times) {
            int max = 0;
            int maxPerson = -1;
            this.times =times;
            for (int i = 0; i < times.length; i++) {
                int time = times[i];
                int person = persons[i];
                int score = personScore.getOrDefault(person, 0);
                score++;
                personScore.put(person,score);
                if (score>=max){
                    max = score;
                    maxPerson = person;
                }
                timePerson.put(time,maxPerson);
            }
        }

        public int q(int t) {
            int low =  0;
            int high = times.length-1;
            while (low<=high){
                int mid = (low + high)/2;
                if (times[mid] == t){
                    return timePerson.get(t);
                }else if (times[mid]<t){
                    low = mid + 1;
                }else {
                    high = mid - 1;
                }
            }
            return timePerson.get(times[high]);
        }
    }

    public static void main(String[] args) {
        int [] persons = {0,1,1,0,0,1,0};
        int [] times = {0,5,10,15,20,25,30};
        TopVotedCandidate topVotedCandidate = new TopVotedCandidate(persons, times);
        System.out.println(topVotedCandidate.timePerson.get(25));
        System.out.println(topVotedCandidate.q(25));
    }
}
