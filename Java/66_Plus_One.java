class Solution {
	public int[] plusOne(int[] digits) {
		boolean up = true;
		for(int i = 0; up && i < digits.length; i++) {
			if(digits[digits.length - 1 - i] == 9) {
				digits[digits.length - 1 - i] = 0;
			} else {
				digits[digits.length - 1 - i]++;
				up = false;
			}
		}

		if(up && digits.length != 100) {
			digits = new int[digits + 1];
			digits[0] = 1;
		}
		
		return digits;
	}
}