import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		InputStreamReader k = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(k);
		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			int n = Integer.parseInt(br.readLine());
			long[] dp = new long[101];
			dp[0] = 1;
			dp[1] = 1;
			dp[2] = 1;
			for (int j = 3; j < 101; j++) {
				dp[j] = dp[j - 2] + dp[j - 3];
			}
			System.out.println(dp[n - 1]);
		}

	}
}
