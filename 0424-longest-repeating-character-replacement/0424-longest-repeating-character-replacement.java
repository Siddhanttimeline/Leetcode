class Solution {
    public int characterReplacement(String s, int k) {
        int left = 0;
        int right = 0;
        int ans = 0;
        int maxFreq = 0;
        int n = s.length();
        HashMap<Character,Integer> map = new HashMap<>();

        while( right < n){
            char ch = s.charAt(right);
            int windowLength = right - left + 1;
            map.put( ch , map.getOrDefault(ch,0) + 1 );
            maxFreq = Math.max( maxFreq, map.get(ch) );

            if( windowLength - maxFreq <= k ){
                ans = Math.max( ans , windowLength );
                right++;
            }else{
                char chLeft = s.charAt(left);
                map.put( chLeft , map.get(chLeft) - 1 );
                if(map.get(chLeft) == 0){
                    map.remove(chLeft);
                }
                left++;
                right++;
            }
        }
        return ans;
    }
}