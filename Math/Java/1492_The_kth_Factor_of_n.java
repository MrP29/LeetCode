//Brute Force (Time: O(N) Space: O(1))
class Solution {
    public int kthFactor(int n, int k) {
        for(int i = 1; i <= n / 2; i++) {
            if(n % i == 0)
                k--;
                
            if(k == 0)
                return i;
        }
        return k == 1 ? n : -1;
    }
}

//Using Max Heap (Time: O(sqrt(N)logK) Space: O(MIN(k, sqrt(N))
class Solution {
    public int kthFactor(int n, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
        
        for(int i = 1; i <= Math.sqrt(n); i++) {
            if(n % i == 0) {
                pq.add(i);
                
                if(i != n / i) {
                    pq.add(n / i);
                }
            }
            while(pq.size() > k)
                pq.remove();
        }
        
        return pq.size() == k ? pq.remove() : -1;
    }
}

//Mathematics by LeetCode (Time: O(sqrt(N)) Space: O(min(k, sqrt(N)))
class Solution {
    public int kthFactor(int n, int k) {
        List<Integer> divisors = new ArrayList();
        int sqrtN = (int) Math.sqrt(n);
        for(int i = 1; i <= sqrtN; i++) {
            if(n % i == 0) {
                k--;
                divisors.add(i);
                if(k == 0)
                    return i;
            }
        }
        
        if(sqrtN * sqrtN == n)
            k++;
        
        int nDiv = divisors.size();
        return (k <= nDiv) ? n / divisors.get(nDiv - k) : -1;
    }
}