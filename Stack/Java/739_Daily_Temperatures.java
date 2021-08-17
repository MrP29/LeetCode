//Using Stack (Time: O(N) Space: O(N))
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> temp = new Stack<>();
        
        int n = temperatures.length;
        int[] answer = new int[n];
        for(int i = 0; i < n; i++) {
            while(!temp.isEmpty() && temperatures[temp.peek()] < temperatures[i])
                answer[temp.peek()] = i - temp.pop();
            
            temp.push(i);
        }
        return answer;
    }
}

//Using Two Stacks (Time: O(N) Space: O(N))
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> temp = new Stack<>();
        Stack<Integer> index = new Stack<>();
        
        int n = temperatures.length;
        int[] answer = new int[n];
        for(int i = 0; i < n; i++) {
            while(!temp.isEmpty() && temp.peek() < temperatures[i]) {
                answer[index.peek()] = i - index.pop();
                temp.pop();
            }
            
            temp.push(temperatures[i]);
            index.push(i);
        }
        return answer;
    }
}

//Brute Force (Time: O(N^2) Space: O(1))
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] answer = new int[temperatures.length];
        
        for(int i = 0; i < temperatures.length - 1; i++) {
            int j = i + 1;
            while(j < temperatures.length && temperatures[j] <= temperatures[i]) {
                j++;
            }
            answer[i] = j < temperatures.length ? j - i : 0;
        }
        return answer;
    }
}
