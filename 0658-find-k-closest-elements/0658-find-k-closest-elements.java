class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        
        int low = 0;
        int high = arr.length - 1;

        while( high - low >= k ){

            if( Math.abs(arr[low] - x) > Math.abs(arr[high] - x) ){
                low++;
            }else{
                high--;
            }

        }

        ArrayList<Integer> list = new ArrayList<>();
        for(int i = low; i <=high; i++){
            list.add(arr[i]);
        }

        return list;
    }
}