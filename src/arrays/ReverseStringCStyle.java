package arrays;

public class ReverseStringCStyle {

	public static char[] reverseString(char[] input) {
		if (input != null && input.length > 1) {
			int i = 0;
			int j = input.length - 2;// last char will be '\n' no need to swap
										// it
			while (i < j) {
				// lame swap but simple to understand
				char temp = input[i];
				input[i] = input[j];
				input[j] = temp;
				i++;
				j--;
			}
		}
		return input;
	}

	public static void main(String[] args) {
		String input = "abcd\n";
		System.out.println(reverseString(input.toCharArray()));	
	}
}
