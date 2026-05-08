class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<int[]> stk = new Stack<>();

        for(int i =0;i<temperatures.length;i++){
          while(!stk.isEmpty() && stk.peek()[0] < temperatures[i]){
            temperatures[stk.peek()[1]] = i - stk.peek()[1];
            stk.pop();
          }
          stk.push(new int[]{temperatures[i], i});
        }

        while(!stk.isEmpty()){
          temperatures[stk.peek()[1]] = 0;
          stk.pop();
        }

        return temperatures;
    }
}
