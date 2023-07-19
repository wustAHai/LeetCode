package easy;

/**
 * @author chenz at 20:08 on 2022/10/19 .
 */
public class L1700 {
    public int countStudents(int[] students, int[] sandwiches) {
        int num0=0;
        for (int student : students) {
            if (student==0){
                num0++;
            }
        }
        int num1 = students.length-num0;
        for (int i = 0; i < sandwiches.length; i++) {
            if (sandwiches[i]==0&&num0>0){
                num0--;
            }else if (sandwiches[i]==1&&num1>0){
                num1--;
            }else {
                return num0+num1;
            }
        }
        return 0;
    }
}
