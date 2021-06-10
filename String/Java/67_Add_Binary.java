//Using StringBuilder (Time: O(Max(n, m)) Space: O(Max(n, m)))
class Solution {
    public String addBinary(String a, String b) {
        if(a.length() < b.length())
            return addBinary(b, a);
        
        int aIndex = a.length() - 1;
        int bIndex = b.length() - 1;
        int carry = 0;       
        StringBuilder str = new StringBuilder();
        
        while(aIndex >= 0) {
            if(a.charAt(aIndex--) == '1')
                carry++;
            if(bIndex >= 0 && b.charAt(bIndex--) == '1')
                carry++;
            if(carry % 2 == 0)
                str.append(0);
            else
                str.append(1);
            carry /= 2;

        }
        
        if(carry == 1)
            str.append(1);
        str = str.reverse();
        return str.toString();
    }
}

//Using Char Array(Time: O(Max(n, m)) Space: O(Max(n, m)))
class Solution {
    public String addBinary(String a, String b) {
        if(a.length() < b.length())
            return addBinary(b, a);
        
        int aIndex = a.length() - 1;
        int bIndex = b.length() - 1;
        int carry = 0;
        char[] aChar = a.toCharArray();
        char[] bChar = b.toCharArray();
        
        while(aIndex >= 0) {
            if(a.charAt(aIndex) == '1')
                carry++;
            if(bIndex >= 0 && b.charAt(bIndex--) == '1')
                carry++;
            aChar[aIndex--] = carry % 2 == 0 ? '0' : '1';
            carry /= 2;
        }        
        return carry == 1 ? 1 + String.valueOf(aChar) : String.valueOf(aChar);
    }
}

//XOR(From LeedCode answer) (Time: O(Max(n, m)) Space: O(Max(n, m)))
class Solution {
  public String addBinary(String a, String b) {
    BigInteger x = new BigInteger(a, 2);
    BigInteger y = new BigInteger(b, 2);
    BigInteger zero = new BigInteger("0", 2);
    BigInteger carry, answer;
    while (y.compareTo(zero) != 0) {
      answer = x.xor(y);
      carry = x.and(y).shiftLeft(1);
      x = answer;
      y = carry;
    }
    return x.toString(2);
  }
}