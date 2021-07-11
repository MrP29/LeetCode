//If Condition (Time: O(N) Space: O(1))
class Solution {
    public List<String> fizzBuzz(int n) {
        List<String> res = new ArrayList<>();
        for(int i = 1; i <= n; i++) {
            StringBuilder sb = new StringBuilder();
            if(i % 3 == 0)
                sb.append("Fizz");
            if(i % 5 == 0)
                sb.append("Buzz");
            if(sb.length() == 0)
                sb.append(String.valueOf(i));
            res.add(sb.toString());
        }
        return res;
    }
}

//HashMap (Time: O(N) Space: O(1))
class Solution {
    Map<Integer, String> fizzBuzzDict = new HashMap<>() {
        {
            put(3, "Fizz");
            put(5, "Buzz");
        }
    };
    
    public List<String> fizzBuzz(int n) {
        List<String> res = new ArrayList<>();

        for(int i = 1; i <= n; i++) {
            StringBuilder sb = new StringBuilder();
            for(Integer word: fizzBuzzDict.keySet()) {
                if(i % word == 0)
                    sb.append(fizzBuzzDict.get(word));
            }
            if(sb.length() == 0)
                sb.append(String.valueOf(i));
            res.add(sb.toString());
        }
        return res;
    }
}