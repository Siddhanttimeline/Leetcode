class Solution {
    public String reverseWords(String s) {
        
        String[] arr = s.trim().split(" ");

        StringBuilder result = new StringBuilder();

        for(int i=arr.length-1; i>=0; i--){         
            if(arr[i].length() != 0){
                result.append(arr[i].trim()).append(" ");
            }
        }

        return result.toString().trim();


    }
}