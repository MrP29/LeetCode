//Two Pointers (Time: O(n) Space: O(1))
class Solution {
	public boolean isPalindrome(String s) {
		for(int i = 0, j = s.length() - 1; i < j; i++, j--) {
			while(i < j && !Character.isLetterOrDigit(s.charAt(i)))
				i++;
			while(i < j && !Character.isLetterOrDigit(s.charAt(j)))
				j--;

			if(Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j)))
				return false;
		}
		return true;
	}
}

//Use replaceAll string (Time: O(n) Space: O(n))
class Solution {
	public boolean isPalindrome(String s) {
        String filtered = s.toLowerCase();
		filtered = filtered.replaceAll("[^a-z0-9]", "");
        for(int i = 0; i < filtered.length() / 2; i++) {
            if(filtered.charAt(i) != filtered.charAt(filtered.length() - 1 - i))
                return false;
        }
        return true;
	}
}

//Use reverse string (Time: O(n) Space: O(n))
class Solution {
	public coolean isPalindrome(String s) {
		StringBuilder sb = new StringBuilder();
		for(char ch: s.toCharArray()) {
			if(Character.isLetterOrDigit(ch))
				sb.append(Character.toLowerCase(ch));
		}

		String letterDigitString = sb.toString();
		String reversedString = sb.reverse().toString();

		return letterDigitString.equals(reversedString);
	}
}