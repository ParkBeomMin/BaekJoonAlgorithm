import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) throws IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		String[] input = br.readLine().split(" ");
		int n = Integer.parseInt(input[0]);
		int m = Integer.parseInt(input[1]);
		int[] arr = new int[m];
		dfs(arr, 0, n);
		bw.close();
	}

	static void dfs(int[] arr, int p, int n) throws IOException {
		if (p == arr.length) {
			for (int i = 0; i < arr.length; i++) {
				bw.write(arr[i] + " ");
			}
			bw.write("\n");
		} else {
			for (int i = 1; i <= n; i++) {
				arr[p] = i;
				dfs(arr, p + 1, n);
			}
		}
	}
}
