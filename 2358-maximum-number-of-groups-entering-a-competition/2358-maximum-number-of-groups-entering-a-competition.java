class Solution {
    public int maximumGroups(int[] grades) {
        int n = grades.length;
        int ans = (int) (-1 + Math.sqrt(1+8*n))/2;
        return ans;

    }
}