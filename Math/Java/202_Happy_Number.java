//Hash Set (Time: O(logN) Space: O(logN))
class Solution {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        int sum = n;
        
        while(!set.contains(sum)) {
            set.add(sum);
            int newSum = 0;
            while(sum > 0) {
                int digit = sum % 10;
                sum /= 10;
                newSum += Math.pow(digit, 2);
            }
            sum = newSum;
        }
        return sum == 1;
    }
}

//Two Pointer by LeetCode (Time: O(logN) Space: O(1))
class Solution {
     public int getNext(int n) {
        int totalSum = 0;
        while (n > 0) {
            int d = n % 10;
            n = n / 10;
            totalSum += d * d;
        }
        return totalSum;
    }

    public boolean isHappy(int n) {
        int slowRunner = n;
        int fastRunner = getNext(n);
        while (fastRunner != 1 && slowRunner != fastRunner) {
            slowRunner = getNext(slowRunner);
            fastRunner = getNext(getNext(fastRunner));
        }
        return fastRunner == 1;
    }
}

//Hard Coding Set by LeetCode (Time: O(logN) Space: O(1))
class Solution {
    private static Set<Integer> cycleMembers =
        new HashSet<>(Arrays.asList(4, 16, 37, 58, 89, 145, 42, 20));

    public int getNext(int n) {
        int totalSum = 0;
        while (n > 0) {
            int d = n % 10;
            n = n / 10;
            totalSum += d * d;
        }
        return totalSum;
    }

    public boolean isHappy(int n) {
        while (n != 1 && !cycleMembers.contains(n)) {
            n = getNext(n);
        }
        return n == 1;
    }
}
