//Array (Time: O(N) Space: O(N))
class Solution {
    int[] original;
    int[] shuffled;

    Random random = new Random();

    public Solution(int[] nums) {
        original = nums;
        shuffled = nums.clone();
    }
    
    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return original;
    }
    
    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        for(int i = 0; i < shuffled.length - 1; i++)
            swap(i, random.nextInt(shuffled.length - i) + i);
        return shuffled;
    }
    
    private void swap(int left, int right) {
        int temp = shuffled[left];
        shuffled[left] = shuffled[right];
        shuffled[right] = temp;
    }
}

//ArrayList (Time: O(N^2) Space: O(N))
class Solution {
    private int[] original;
    private Random random = new Random();
    
    public Solution(int[] nums) {
        original = nums.clone();
    }
    
    public int[] reset() {
        return original;
    }
    
    public int[] shuffle() {
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < original.length; i++) {
            list.add(original[i]);
        }
        
        int[] shuffled = new int[original.length];
        for(int i = 0; i < original.length; i++) {
            int removeIndex = random.nextInt(list.size());
            shuffled[i] = list.get(removeIndex);
            list.remove(removeIndex);
        }
        return shuffled;
    }
}

//Array (Time: O(N) Space: O(N))
class Solution {
    int[] original;
    int[] shuffled;

    Random random = new Random();
    
    public Solution(int[] nums) {
        original = nums;
        shuffled = nums.clone();
    }
    
    // /** Resets the array to its original configuration and return it. * /
    public int[] reset() {
        return original;
    }
    
    // /** Returns a random shuffling of the array. * /
    public int[] shuffle() {
        int first = random.nextInt(original.length);
        int second = random.nextInt(original.length);
        while(second == first)
            second = random.nextInt(original.length);
        
        swap(shuffled, first, second);
        return shuffled;
    }
    
    private void swap(int[] arr, int left, int right) {
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */