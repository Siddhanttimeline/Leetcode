class Solution {
    public int bestClosingTime(String customers) {
        
        int totalY = 0;
        for(char ch : customers.toCharArray()){
            if(ch == 'Y'){
                totalY += 1;
            }
        }

        int ans = Integer.MAX_VALUE;
        int currY = 0;
        int currN = 0;
        int hour = 0;

        for(int i=0; i<customers.length(); i++){

            int currentPenality = totalY - currY + currN;

            if(currentPenality < ans ){
                ans = currentPenality;
                hour = i;
            }

            currY += customers.charAt(i) == 'Y' ? 1 : 0;
            currN += customers.charAt(i) == 'N' ? 1 : 0;

        }

        int currentPenality = totalY - currY + currN;
        if( currentPenality < ans ){
            ans = currentPenality;
            hour = customers.length();
        }

        return hour;
    
    }
}