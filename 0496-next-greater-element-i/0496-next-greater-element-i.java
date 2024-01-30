class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {

        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0; i < nums2.length; i++){
            map.put(nums2[i],i);
        }

        int[] collectedGreaterElements = new int[nums2.length];
        Arrays.fill(collectedGreaterElements,-1);

        Stack<Integer> stack = new Stack<>();
        for(int i=0 ; i < nums2.length; i++){
            if(stack.isEmpty()){
                stack.push(i);

            }else{
                while( !stack.isEmpty() && nums2[i] > nums2[stack.peek()]){
                    collectedGreaterElements[stack.pop()] = nums2[i];
                }
                stack.push(i);
            }
        }

        int[] answer = new int[nums1.length];
        int pointer=0;
        for(int val : nums1){
            int index = map.get(val);
            answer[pointer] = collectedGreaterElements[index];
            pointer++;
        }

        return answer;

        // -----------------------------------------------

        // int[] result = new int[nums1.length];
        
        // HashMap<Integer,Integer> map = new HashMap<>();
        // for(int i=0; i < nums2.length; i++){
        //     map.put(nums2[i],i);
        // }

        // for(int i=0; i<nums1.length; i++){
        //     int startIndex = map.get(nums1[i])+1;
        //     int max = nums1[i];

        //     while(startIndex < nums2.length){
        //         if(nums2[startIndex] > max){
        //             max = nums2[startIndex];
        //             break;
        //         }
        //         startIndex++;
        //     }

        //     if(max > nums1[i]){
        //         result[i] = max;
        //     }else{
        //         result[i] = -1;
        //     }

        // }

        // return result;
        
    }
}