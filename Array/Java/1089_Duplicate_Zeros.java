//Time: O(n) Space: O(1)
class Solution {
	public void duplicateZeros(int[] arr) {
		int i;
		int countZeros = 0;
		for(i = 0; i < arr.length - countZeros; i++) {
			if(arr[i] == 0)
				countZeros++;
		}

		for(i = i - 1; countZeros > 0; i--) {
			if(i < arr.length - countZeros)
				arr[i + countZeros] = a[i];
			if(arr[i] == 0)
				arr[i + --countZeros] = 0;
		}
	}
}