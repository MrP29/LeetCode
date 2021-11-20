//Simulation (Time: O(N) Space: O(1))
class Solution {
    int[][] DIR = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    
    public boolean isRobotBounded(String instructions) {
        int direct = 0;
        int[] origin = {0, 0};
        
        for(char c: instructions.toCharArray()) {
            if(c == 'G') {
                origin[0] += DIR[direct][0];
                origin[1] += DIR[direct][1];
            } else if(c == 'L') {
                direct = (direct + 3) % 4;
            } else {
                direct = (direct + 1) % 4;
            }
        }
        
        return (origin[0] == 0 & origin[1] == 0) || direct != 0;
    }
}