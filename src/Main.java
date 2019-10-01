import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		String input = br.readLine();
		int[] result = new int[26];
		for (int i = 0; i < result.length; i++) {
			result[i] = -1;
		}
		for (int i = 0; i < input.length(); i++) {
			for (int j = 0; j < result.length; j++) {
				if (input.charAt(i) == 'a' + j) {
					if (result[j] == -1) {
						result[j] = i;
					}

				}
			}

		}
		for (int i = 0; i < result.length; i++) {
			System.out.print(result[i] + " ");
		}

	}
}
