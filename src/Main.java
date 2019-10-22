import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		String[] input = br.readLine().split(" ");
		int n = Integer.parseInt(input[0]);
		int m = Integer.parseInt(input[1]);
		int[] arr = new int[m];
		dfs(arr, n, 0);
	}

	static void dfs(int[] arr, int n, int p) {
		if (p == arr.length) {
			for (int i = 0; i < arr.length; i++) {
				System.out.print(arr[i] + " ");
			}
			System.out.println();
		} else {
			for (int i = 1; i <= n; i++) {
				if (p != 0) {
					if (arr[p - 1] <= i) {
						arr[p] = i;
						dfs(arr, n, p + 1);
					}
				} else {
					arr[p] = i;
					dfs(arr, n, p + 1);
				}

			}
		}
	}

}
