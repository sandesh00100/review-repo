import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ArrayProblems {
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

    public String urilify(String s, int stringSize){
        char[] cArray = s.toCharArray();
        int currentSize = stringSize;
        for (int i = 0; i < stringSize; i++){
            char curChar = cArray[i];
            if (curChar == ' '){
                shiftUrl(cArray, i+1, currentSize-1);
                cArray[i] = '%';
                cArray[i+1] = '2';
                cArray[i+2] = '0';
                currentSize += 2;
            }
        }
        return String.valueOf(cArray).trim();
    }

    public void shiftUrl(char[] url, int start, int end){
        for (int i = end; i >= start; i--){
            url[i + 2] = url[i];
        }
    }

    public boolean palindromePermutation(String s){
        char[] modCArray = s.replace(" ", "").toLowerCase().toCharArray();
        Arrays.sort(modCArray);
        Set<Character> seenChars = new HashSet<>();

        for (char c: modCArray){
            if (seenChars.contains(c)){
                seenChars.remove(c);
            } else {
                seenChars.add(c);
            }
        }

        if ((modCArray.length % 2 != 0 && seenChars.size() == 1) || (modCArray.length % 2 == 0 && seenChars.size() == 0)) {
            return true;
        }
        return false;
    }

    public boolean oneAway(String s1, String s2){
        char[] c1Array = s1.toCharArray();
        char[] c2Array = s2.toCharArray();

        boolean foundDifference = false;
        if (c1Array.length == c2Array.length){
            for (int i = 0; i < s1.length(); i++){
                if (c1Array[i] != c2Array[i]){
                    if (!foundDifference){
                        foundDifference = true;
                    } else {
                        return false;
                    }
                }
            }
        } else if ((Math.abs(c1Array.length - c2Array.length)) == 1){
            char[] shorterArr = c1Array.length >  c2Array.length ? c2Array : c1Array;
            char[] longerArr = c1Array.length <  c2Array.length ? c2Array : c1Array;
            boolean skippedDifference = false;
            int longerArrIndex = 0;
            for (int i=0; i<shorterArr.length; i++){
                if (shorterArr[i] != longerArr[longerArrIndex]){
                    if (!skippedDifference) {
                        longerArrIndex++;
                        skippedDifference = true;
                        if (shorterArr[i] != longerArr[longerArrIndex]){
                            return false;
                        }
                    } else {
                        return false;
                    }
                }
                longerArrIndex++;
            }
        } else {
            return false;
        }
        return true;
    }

    public String stringCompression(String s){
        char[] cArray = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        char prevChar = cArray[0];
        int count = 1;
        for (int i = 1; i < cArray.length; i++){
            char currentChar = cArray[i];
            if (currentChar == prevChar) {
                count++;
            } else {
                sb.append(prevChar+String.valueOf(count));
                prevChar = currentChar;
                count = 1;
                if (sb.length() > s.length()){
                    return s;
                }
            }

            if (i == cArray.length - 1) {
                sb.append(prevChar+String.valueOf(count));
                prevChar = currentChar;
                count = 1;
                if (sb.length() > s.length()){
                    return s;
                }
            }
        }
        return sb.toString();
    }
}
