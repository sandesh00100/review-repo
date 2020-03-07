package crackingTheCode;

import java.util.Arrays;

public class CrackingTheCode {
	public static void main(String[] args) {
		CrackingTheCode ctc = new CrackingTheCode();
//		System.out.println(ctc.checkIfUnique("abcdefgf"));
//		System.out.println(ctc.checkIfUniqueWithoutSort("abcdefgf"));
		ctc.replaceString(" d fsdf sdfs df                    ");
	}

	/**
	 * Implement an algorithm to determine if a string has all unique characters.
	 * What if you cannot use additional data structures?
	 * 
	 * @param str
	 * @return
	 */
	public boolean checkIfUnique(String str) {
		char[] stringArr = str.toCharArray();
		int strLenght = stringArr.length;

		Arrays.sort(stringArr);
		for (int i = 0; i < strLenght; i++) {
			if (i < strLenght - 2) {
				if (stringArr[i] == stringArr[i + 1]) {
					return false;
				}
			}
		}

		return true;
	}

	/**
	 * without sort
	 * 
	 * @param str
	 * @return
	 */
	public boolean checkIfUniqueWithoutSort(String str) {
		char[] stringArr = str.toCharArray();
		int strLength = stringArr.length;

		for (int i = 0; i < strLength; i++) {
			for (int j = i + 1; j < strLength; j++) {
				if (stringArr[i] == stringArr[j]) {
					return false;
				}
			}
		}
		return true;
	}

	/**
	 * Given two strings, write a method to decide if one is a permutation of the
	 * other
	 * 
	 * @param str1
	 * @param str2
	 * @return
	 */
	public boolean checkForPermutation(String str1, String str2) {
		if (str1.length() != str2.length()) {
			return false;
		}

		char[] str1CharArr = str1.toCharArray();
		char[] str2CharArr = str2.toCharArray();

		Arrays.sort(str1CharArr);
		Arrays.sort(str2CharArr);

		for (int i = 0; i < str1.length(); i++) {
			if (str1CharArr[i] != str2CharArr[i]) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Given two strings, write a method to decide if one is a permutation of the
	 * other
	 * 
	 * @param character
	 */
	public void replaceString(String str) {
		char[] charArr = str.toCharArray();
		boolean endIndexFound = false;
		int endIndex = -1;
		
		for (int i = charArr.length - 1; i >= 0; i--) {

			char currentChar = charArr[i];

			if (!endIndexFound && currentChar != ' ') {

				endIndexFound = true;
				endIndex = i;
			}

			if (i < str.length()-1 && charArr[i] == ' ' && charArr[i+1] != ' ') {
				replaceSpace(charArr, i, endIndex);
				endIndex+=3;
			}

		}
		System.out.println(charArr);
	}

	/**
	 * URLify: Write a method to replace all spaces in a string with '%20: You may
	 * assume that the string has sufficient space at the end to hold the additional
	 * characters, and that you are given the "true" length of the string. (Note: If
	 * implementing in Java, please use a character array so that you can perform
	 * this operation in place.)
	 * 
	 * @param str
	 * @param index
	 */
	public void replaceSpace(char[] str, int startIndex, int endIndex) {
		for (int i = endIndex; i > startIndex ; i--) {
			char currentChar = str[i];
			str[i + 2] = currentChar;
		}
		str[startIndex] = '%';
		str[startIndex + 1] = '2';
		str[startIndex + 2] = '0';
	}
}
