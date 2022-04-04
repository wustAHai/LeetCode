package mid;

import java.util.Arrays;

/**
 * Created by chenz at 11:29 on 2021/1/5
 */
public class L74 {
/*    public boolean searchMatrix(int[][] matrix, int target) {
        int r = matrix.length;
        int c = matrix[0].length;
        if (target < matrix[0][0] || target > matrix[r - 1][c - 1]) {
            return false;
        }
        int i = 0;
        int j = r - 1;
        int mid = i + (j - i) / 2;
        while (i < j) {
            if (matrix[mid][0] == target) {
                return true;
            } else if (matrix[mid][0] < target) {
                i = mid + 1;
            } else {
                j = mid - 1;
            }
            mid = i + (j - i) / 2;
        }
        if (matrix[i][0] > target) {
            i--;
            return Arrays.binarySearch(matrix[i], target) >= 0;
        }
        return Arrays.binarySearch(matrix[i], target) >= 0;
    }*/
    public boolean searchMatrix(int[][] matrix, int target) {
        int m =  matrix.length;
        int n =  matrix[0].length;
        int low=0;
        int high=m*n-1;
        int mid=0;
        while (low<=high){
            mid=(high-low)/2+low;
            int temp=matrix[mid/n][mid%n];
            if (temp==target){
                return true;
            }else if (temp>target){
                high=mid-1;
            }else {
                low=mid+1;
            }
        }
        return false;
    }

}
