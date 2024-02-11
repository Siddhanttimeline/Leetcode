class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        
        int i = 0;
        int j = 0;
        int p = 0;

        int[] result = new int[nums1.length + nums2.length];

        while( i < nums1.length && j < nums2.length ){
            if( nums1[i] < nums2[j] ){
                result[p] = nums1[i];
                i++;
            }else{
                result[p] = nums2[j];
                j++;
            }
            p++;
        }

        while(i < nums1.length){
            result[p] = nums1[i];
            i++;
            p++;
        }

        while(j < nums2.length){
            result[p] = nums2[j];
            j++;
            p++;
        }
        
        int size = result.length;

        double median = 0;

        if (size % 2 == 0) {
            median = (result[size / 2] + result[size / 2 - 1]) / 2.0;
        } else {
            median = result[size / 2];
        }

        return median;

    }
}