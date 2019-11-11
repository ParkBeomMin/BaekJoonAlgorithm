import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		int n = Integer.parseInt(br.readLine());
		int[][] arr = new int[n][n];
		int[] visited = new int[n];
		for (int i = 0; i < n; i++) {
			String[] input = br.readLine().split(" ");
			for (int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(input[j]);
			}
		}

		for (int i = 0; i < n; i++) {
			dfs(arr, visited, i);
			for (int j = 0; j < n; j++) {
				if (visited[j] == 1) {
					arr[i][j] = 1;
				}
			}
			visited = new int[n];
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}

	static void dfs(int[][] arr, int[] visited, int x) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[x][i] == 1 && visited[i] == 0) {
				visited[i] = 1;
				dfs(arr, visited, i);
			}
		}
	}
}
