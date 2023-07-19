package top500;

public class T4寻找连个正序数组的中位数 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // TODO: 2022/7/11
        int length1 = nums1.length;
        int length2 = nums2.length;
        int totalLength = length1+length2;
        if (totalLength%2==1){
            return (double) getKthElement(nums1,nums2,totalLength/2+1);
        }else {
            return ((double) getKthElement(nums1,nums2,totalLength/2+1) + (double) getKthElement(nums1,nums2,totalLength/2))/2;
        }
    }
    public int getKthElement(int[] nums1, int[] nums2, int k){
        int index1 = 0;
        int index2 = 0;
        int length1 = nums1.length;
        int length2 = nums2.length;
        while (true){
            if (index1 == length1){
                return nums2[index2+k-1];
            }
            if (index2 == length2){
                return nums1[index1+k-1];
            }
            if (k==1){
                return Math.min(nums1[index1+k],nums2[index2+k]);
            }
            //n[k] 是第 k+1 小的数 n[k-1]是第k小的数
            int half = k/2;
            int newIndex1 = Math.min(index1+half,length1)-1;
            int newIndex2 = Math.min(index2+half,length2)-1;
            if (nums1[newIndex1] <= nums2[newIndex2]){
                k-=newIndex1-index1+1;
                index1 = newIndex1 +1;
            }else {
                k-=newIndex2-index2+1;
                index2 = newIndex2 +1;
            }
        }
    }
}
