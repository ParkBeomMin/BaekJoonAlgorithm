import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		InputStreamReader k = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(k);
		int n = Integer.parseInt(br.readLine());
		String nums = br.readLine();
		int result = 0;
		for(int i = 0; i < n; i++) {
			result += Integer.parseInt(String.valueOf(nums.charAt(i)));
		}
		System.out.print(result);
	}
}
