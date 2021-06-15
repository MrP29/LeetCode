//Time: O(n^2) Space: O(n)
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

//Time: O(n^2) Space: O(n)
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

//Mathematical calculation by LeetCode (Time: O(n) Space: O(n))
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
