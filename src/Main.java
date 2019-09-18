import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		System.out.print(comb(M - 1, M - N));
	}

	static int comb(int n, int m) {
		if (n == m || m == 0) {
			return 1;
		} else {
			return comb(n - 1, m - 1) + comb(n - 1, m);
		}
	}

}
