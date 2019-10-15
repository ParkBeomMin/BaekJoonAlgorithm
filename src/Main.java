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
		int[] visited = new int[n + 1];

		dfs(arr, visited, 0);
	}

	static void dfs(int[] arr, int[] visited, int pos) {
		if (pos == arr.length) {
			for (int i = 0; i < arr.length; i++) {
				System.out.print(arr[i] + " ");
			}
			System.out.println();
		} else {
			for (int i = 1; i < visited.length; i++) {
				if (visited[i] == 0) {
					visited[i] = 1;
					if ((pos != 0 && (arr[pos - 1] < i)) || pos == 0) {
						arr[pos] = i;
						dfs(arr, visited, pos + 1);
					}
					visited[i] = 0;
				}
			}
		}
	}
}
