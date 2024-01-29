import java.util.ArrayList;

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        int i = 0, j = 0;
        int length1 = nums1.length;
        int length2 = nums2.length;
        ArrayList<Integer> arr = new ArrayList<>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        while (i < length1 && j < length2) {
            if (nums1[i] == nums2[j]) {
                arr.add(nums1[i]);
                i++;
                j++;
            } else if (nums1[i] < nums2[j]) {
                i++;
            } else {
                j++;
            }
        }

        int[] result = new int[arr.size()];
        for (int k = 0; k < arr.size(); k++) {
            result[k] = arr.get(k);
        }

        return result;
    }
}
