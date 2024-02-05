class Solution {
    public int totalFruit(int[] fruits) {
        int left = 0;
        int right = 0;
        int ans = Integer.MIN_VALUE;
        HashMap<Integer,Integer> map = new HashMap<>();

        while( right < fruits.length ){
            map.put(fruits[right], map.getOrDefault(fruits[right],0)+1);

            while (map.size() > 2) {
                int leftFruit = fruits[left];
                map.put(leftFruit, map.get(leftFruit) - 1);
                if (map.get(leftFruit) == 0) {
                    map.remove(leftFruit);
                }
                left++;
            }

            ans = Math.max(ans , right-left+1);
            right++;
        }

        return ans;
    }
}