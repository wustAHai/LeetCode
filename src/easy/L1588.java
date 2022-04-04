package easy;

public class L1588 {
    public int sumOddLengthSubarrays(int[] arr) {
        int k = 1;
        int sum = 0;
        while(k<=arr.length){
            int temp = 0;
            int count = 0;
            int i = 0;
            while (count<k){
                temp+=arr[i];
                count ++;
                i++;
            }
            sum += temp;
            while (i<arr.length){
                temp-=arr[i-k];
                temp += arr[i];
                sum +=temp;
                i++;
            }
            k = 2*k+1;
        }
        return sum;
    }
}
