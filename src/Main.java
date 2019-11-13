import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		String a = br.readLine();
		String b = br.readLine();

		int[][] arr = new int[b.length() + 1][a.length() + 1];
		String answer = "";
		int maxLength = 0;

		for (int i = 1; i <= b.length(); i++) {
			int tmp = 0;
			for (int j = 1; j <= a.length(); j++) {
				if (b.substring(i - 1, i).equals(a.substring(j - 1, j))) {
					tmp = arr[i - 1][j - 1] + 1;
					arr[i][j] = tmp;
				} else {
					arr[i][j] = Math.max(arr[i - 1][j], arr[i][j - 1]);
				}
			}
			if (maxLength < tmp) {
				maxLength = tmp;
			}
		}
		int tmp = a.length();
		for (int i = b.length(); i > 0; i--) {
			for (int j = tmp; j > 0; j--) {
				if (arr[i][j] == maxLength && arr[i][j - 1] == maxLength - 1 && arr[i - 1][j - 1] == maxLength - 1
						&& arr[i - 1][j] == maxLength - 1) {
					answer = a.substring(j - 1, j) + answer;
					maxLength--;
					tmp = j;
					break;
				}
			}
		}

		System.out.print(answer);
	}

}
