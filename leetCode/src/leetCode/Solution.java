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

}
