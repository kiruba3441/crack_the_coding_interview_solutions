package arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class PermutationChecker {
	// Sorting the string chars -> uses up temporary space, could be a brute
	// force solution
	public static boolean isPermutation(String a, String b) {
		if ((a == null || b == null) || a.length() != b.length()) {
			return false;
		}
		char[] aChars = a.toCharArray();
		char[] bChars = b.toCharArray();
		Arrays.sort(aChars);
		Arrays.sort(bChars);
		return new String(aChars).equals(new String(bChars));
	}

	// Use a HasMap to do a bookkeeping of character count
	public static boolean isPermutation1(String a, String b) {
		Map<Character, Integer> charCount = new HashMap<Character, Integer>();
		for (int i = 0; i < a.length(); i++) {
			Integer result = charCount.get(a.charAt(i));
			if (result == null) {
				result = 1;
			} else {
				result++;
			}
			charCount.put(a.charAt(i), result);
		}
		for (int i = 0; i < b.length(); i++) {
			Integer result = charCount.get(b.charAt(i));
			if (result == null) {
				return false;
			} else {
				result--;
			}
			charCount.put(b.charAt(i), result);
		}

		for (Character key : charCount.keySet()) {
			if (charCount.get(key) != 0) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		String a = "abcdef";
		String b = "fdecba";
		System.out.println(isPermutation(a, b));
		System.out.println(isPermutation1(a, b));
		b = "fdecbaa";
		System.out.println(isPermutation(a, b));
		System.out.println(isPermutation1(a, b));
		
	}
}
