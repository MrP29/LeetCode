//Greedy Top-down (Time: O(N) SPace: O(1))
class Solution {
    public boolean canJump(int[] nums) {
        if(nums.length == 1)
            return true;
        
        int jumped = 0;
        for(int i = 0; i < nums.length - 1; i++) {   
            int distance = i - jumped;
            if(nums[i] > nums[jumped] - distance && nums[jumped] >= distance)
                jumped = i;
            
            if(nums[jumped] + jumped >= nums.length - 1)
                return true;
        }
        return false;
    }
}

//Greedy Botoom-up (Time: O(N) Space: O(1))
class Solution {
    public boolean canJump(int[] nums) {
        int last = nums.length - 1;
        for(int i = nums.length - 1; i >= 0; i--) {
            if(i + nums[i] >= last) {
                last = i;
            }
        }
        return last == 0;
}  

//Dynamic Programming Top-down by LeetCode (Time: O(N^2) Space: O(N))
class Solution {
    int[] nums;
    int[] jump;
    
    public boolean canJump(int[] nums) {
        this.nums = nums;
        this.jump = new int[nums.length];
        this.jump[nums.length - 1] = 1;

        return canJump(0);
    }
    
    private boolean canJump(int index) {
        if(this.jump[index] != 0)
            return this.jump[index] == 1;
        
        int max = Math.min(index + this.nums[index], nums.length - 1);
        for(int next = index + 1; next <= max; next++) {
            if(canJump(next)) {
                this.jump[index] = 1;
                return true;
            }
        }
        
        this.jump[index] = -1;;
        return false;
    }
}

//Dynamic Programming Bottom-up by LeetCode (Time: O(N^2) Space: O(N))
class Solution {
    public boolean canJump(int[] nums) {
        int[] jump = new int[nums.length];
        jump[nums.length - 1] = 1;
        
        for(int i = nums.length - 2; i >= 0; i--) {
            int max = Math.min(i + nums[i], nums.length - 1);
            for(int j = i + 1; j <= max; j++) {
                if(jump[j] == 1) {
                    jump[i] = 1;
                    break;
                }
            }
        }
        return jump[0] == 1;
    }
}

