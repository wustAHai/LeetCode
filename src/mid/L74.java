package mid;

import java.util.Arrays;

/**
 * Created by chenz at 11:29 on 2021/1/5
 */
public class L74 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int r = matrix.length;
        int c = matrix[0].length;
        if(target<matrix[0][0]||target>matrix[r-1][c-1]){
            return false;
        }
        int i=0;
        int j=r-1;
        int mid = i+ (j-i)/2;
        while (i<j){
            if(matrix[mid][0]==target){
                return true;
            }else if(matrix[mid][0]<target){
                i=mid+1;
            }else {
                j=mid-1;
            }
            mid = i+ (j-i)/2;
        }
        if(matrix[i][0]>target){
            i--;
          return  Arrays.binarySearch(matrix[i],target)>=0;
        }
        return  Arrays.binarySearch(matrix[i],target)>=0;
    }
}
