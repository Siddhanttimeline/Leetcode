class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int count = 0;
        int i = 0;
        int j = 0;
        int sum = 0;

        while (j < arr.length) {
            sum += arr[j];
            // moving the window forward when it is equal to k
            if (j - i + 1 == k) {
                int avg = sum / k;
                if (avg >= threshold) {
                    count++;
                }
                sum -= arr[i];
                i++;
                j++;
            } else if (j - i + 1 < k) {
                j++;
            }
        }

        return count;
    }
}
