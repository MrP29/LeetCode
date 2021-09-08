//Iteration (Time: O(N^2) Space: O(N))
class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> ans = new ArrayList<>();
        ans.add(1);

        for(int i = 1; i <= rowIndex; i++) {
            ans.add(1);
            for(int j = i - 1; j > 0; j--) {
                ans.set(j, ans.get(j) + ans.get(j - 1));
            }
        }
        return ans;
    }
}

//Iteration (Time: O(N^2) Space: O(N))
class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> ans = new ArrayList<>();
        ans.add(1);
          
        for(int i = 1; i <= rowIndex; i++) {
            int prev = 1;
            int j = 1;
            while(j <= i / 2) {
                int next = ans.get(j);
                ans.set(j++, prev + next);
                prev = next;
            }
            
            while(j <= i) {
                if(j < ans.size())
                    ans.set(j, ans.get(i - j++));
                else
                    ans.add(ans.get(i - j++));
            }
        }
        return ans;
    }
}

//Recursion with Dynamic Programming (Time: O(N^2) Space: O(N))
class Solution {
    int[][] dp;
    
    public List<Integer> getRow(int rowIndex) {
        dp = new int[rowIndex + 1][rowIndex + 1];
        List<Integer> list = new ArrayList();
        
        for(int i = 0; i <= rowIndex; i++)
            list.add(helper(rowIndex, i));
        
        return list;
    }
    
    private int helper(int row, int col) {
        if(col == 0 || col == row)
            return 1;
        
        if(dp[row][col] != 0)
            return dp[row][col];
        
        dp[row][col] = helper(row - 1, col - 1) + helper(row - 1, col);
        
        return dp[row][col];
    }
}

//Mathematical calculation by LeetCode (Time: O(N) Space: O(N))
//Pascal's rule
class Solution {
  public List<Integer> getRow(int n) {
    List<Integer> row =
        new ArrayList<>() {
          {
            add(1);
          }
        };
    for (int k = 1; k <= n; k++) {
      row.add((int) ((row.get(row.size() - 1) * (long) (n - k + 1)) / k));
    }
    return row;
  }
}
