class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();
        int prevElement = 0;

        for(String log : logs){

            String[] parts = log.split(":");

            int functionID = Integer.parseInt(parts[0]);
            String action = parts[1];
            int time = Integer.parseInt(parts[2]);


            if(action.equals("start")){
            
                if(!stack.isEmpty()){
                    int id = stack.peek();
                    int dif = time - prevElement;
                    result[id] += dif;
                }

                stack.push(functionID);
                prevElement = time;

            }else{
                int id = stack.pop();
                int dif = time - prevElement + 1;
                result[id] += dif;
                prevElement = time+1;

            }

        }

        return result;

    }
}