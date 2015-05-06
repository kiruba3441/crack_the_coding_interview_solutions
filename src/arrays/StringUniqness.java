package arrays;

import java.util.BitSet;
import java.util.HashSet;
import java.util.Set;

public class StringUniqness {
	// O(n) plus extra memory of O(n)
	public static boolean isStringUnique1(String input) {
		Set<Character> availableCharSet = new HashSet<Character>();
		for (int i = 0; i < input.length(); i++) {
			Character c = input.charAt(i);
			if (availableCharSet.contains(c)) {
				return false;
			}
			availableCharSet.add(c);
		}
		return true;
	}

	// O(n2) solution -> no extra memory
	public static boolean isStringUnique2(String input) {
		for (int i = 0; i < input.length(); i++) {
			for (int j = 0; j < input.length(); j++) {
				if (i != j && input.charAt(i) == input.charAt(j)) {
					return false;
				}
			}
		}
		return true;
	}

	// O(n) Optimal -> constant xtra memory
	public static boolean isStringUnique(String input) {
		BitSet charSet = new BitSet(256);
		for (int i = 0; i < input.length(); i++) {
			int c = input.charAt(i) - '0';
			if (charSet.get(c)) {
				return false;
			}
			charSet.set(c);
		}
		return true;
	}

	public static void main(String[] args) {
		String input = "abcde";
		System.out.println(isStringUnique(input));
		System.out.println(isStringUnique1(input));
		System.out.println(isStringUnique2(input));
		input = "aaacd#$$%";
		System.out.println(isStringUnique(input));
		System.out.println(isStringUnique1(input));
		System.out.println(isStringUnique2(input));
		
	}

}
