class Solution {
    public boolean judgeSquareSum(int c) {
        long low = 0;
        long high = (long)Math.sqrt(c);

        while( low<=high ){
            if( low*low + high*high == c){
                return true;
            }else if ( low*low + high*high < c){
                low++;
            }else{
                high--;
            }

        }
        return false;
    }

}