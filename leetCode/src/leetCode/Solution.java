package leetCode;

import java.util.Arrays;
import java.util.HashSet;

public class Solution {
	public int lengthOfLongestSubstring(String s) {

		HashSet<Character> set = new HashSet<Character>();
		int longestSubstring = 0;
		int currentSubstring = 0;

		for (Character c : s.toCharArray()) {
			if (!set.contains(c)) {
				set.add(c);
				currentSubstring++;
			} else {
				if (currentSubstring > longestSubstring) {
					longestSubstring = currentSubstring;
				}
				set.clear();
				set.add(c);
				currentSubstring = 1;
			}
		}

		if (currentSubstring > longestSubstring) {
			longestSubstring = currentSubstring;
		}
		return longestSubstring;
	}

	/**
	 * Given an array nums of n integers and an integer target, find three integers
	 * in nums such that the sum is closest to target. Return the sum of the three
	 * integers. You may assume that each input would have exactly one solution.
	 * 
	 * @param nums
	 * @param target
	 * @return
	 */
	public int threeSumClosest(int[] num, int target) {
		int result = num[0] + num[1] + num[num.length - 1];
		Arrays.sort(num);
		for (int i = 0; i < num.length - 2; i++) {
			int start = i + 1, end = num.length - 1;
			while (start < end) {
				int sum = num[i] + num[start] + num[end];
				if (sum > target) {
					end--;
				} else {
					start++;
				}
				if (Math.abs(sum - target) < Math.abs(result - target)) {
					result = sum;
				}
			}
		}
		return result;
	}

	public String generateTheString(int n) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n - 1; i++) {
			sb.append('a');
		}
		if (n % 2 == 0) {
			sb.append('b');
		} else {
			sb.append('a');
		}
		return sb.toString();
	}

	public int reverse(int x) {

		int curVal = x;
		if (x < 0) {
			curVal *= -1;
		}

		String strVal = String.valueOf(curVal);
		StringBuilder sb = new StringBuilder(strVal);
		sb.reverse();
		int val = 0;
		try {
			val = Integer.parseInt(sb.toString());
		} catch (Exception e) {
			return val;
		}

		if (x < 0) {
			val *= -1;
		}

		return val;
	}

	public boolean buddyStrings(String A, String B) {
		if (A.length() != B.length() || A.length() == 0) {
			return false;
		}

		char[] aCharArr = A.toCharArray();
		char[] bCharArr = B.toCharArray();
		int arrLen = aCharArr.length;

		int changeIndex = -1;

		for (int i = 0; i < arrLen; i++) {
			char curAChar = aCharArr[i];
			char curBChar = bCharArr[i];

			if (curAChar != curBChar) {
				if (changeIndex >= 0) {
					char tempChar = aCharArr[changeIndex];
					aCharArr[changeIndex] = curAChar;
					aCharArr[i] = tempChar;
					break;

				}
				changeIndex = i;
			}

		}

		if (changeIndex < 0) {
			char[] charArrCopy = aCharArr.clone();
			Arrays.sort(charArrCopy);
			for (int i = 0; i < charArrCopy.length; i++) {
				if (i < charArrCopy.length - 1) {
					if (charArrCopy[i] == charArrCopy[i + 1]) {
						return true;
					}
				}
			}
			return false;
		}

		for (int i = 0; i < arrLen; i++) {
			char curAChar = aCharArr[i];
			char curBChar = bCharArr[i];

			if (curAChar != curBChar) {
				return false;
			}
		}

		return true;
	}


}
