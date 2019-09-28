import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);

		int n = Integer.parseInt(br.readLine());
		int[] wine = new int[10001];
		long[] dp = new long[10001];
		for (int i = 1; i <= n; i++) {
			wine[i] = Integer.parseInt(br.readLine());
		}
		dp[1] = wine[1];
		dp[2] = wine[1] + wine[2];
		for (int i = 3; i <= n; i++) {
			dp[i] = Math.max(dp[i - 1], Math.max(dp[i - 2] + wine[i], dp[i - 3] + wine[i - 1] + wine[i]));
		}
		System.out.print(dp[n]);

	}
}