//Hash Table (Time: O(N) Space: O(1))
class Solution {
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> isomorphic = new HashMap<>();
        Set<Character> values = new HashSet<>();
        
        for(int i = 0; i < s.length(); i++) {
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);
            if(!isomorphic.containsKey(sChar)) {
                isomorphic.put(sChar, tChar);
                if(values.contains(tChar))
                    return false;
                values.add(tChar);
            } else if(isomorphic.get(sChar) != tChar) {
                return false;
            }
        }
        return true;
    }
}

//Array (Assume NULL cannot be in string) (Time: O(N) Space: O(1))
class Solution {
    public boolean isIsomorphic(String s, String t) {
        int[] dictStoT = new int[256];      
        int[] dictTtoS = new int[256];
        
        for (int i = 0; i < s.length(); ++i) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);

            if (dictStoT[c1] == 0 && dictTtoS[c2] == 0) {
                dictStoT[c1] = c2;
                dictTtoS[c2] = c1;
            } else if (!(dictStoT[c1] == c2 && dictTtoS[c2] == c1)) {
                return false;
            }
        }
        return true;
    }
}

//Conversion by LeetCode (Time: O(N) Space: O(N))
class Solution {
    private String transformString(String s) {
        Map<Character, Integer> indexMapping = new HashMap<>();
        StringBuilder builder = new StringBuilder();
        
        for (int i = 0; i < s.length(); ++i) {
            char c1 = s.charAt(i);
            
            if (!indexMapping.containsKey(c1)) {
                indexMapping.put(c1, i);
            }
            
            builder.append(Integer.toString(indexMapping.get(c1)));
            builder.append(" ");
        }
        return builder.toString();
    }
    
    public boolean isIsomorphic(String s, String t) {
        return transformString(s).equals(transformString(t));
    }
}