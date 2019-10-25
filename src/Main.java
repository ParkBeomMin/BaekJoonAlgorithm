import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		int n = Integer.parseInt(br.readLine());
		int[][] cost = new int[n][n];
		boolean[][] visited = new boolean[n][n];
		for (int i = 0; i < n; i++) {
			String[] input = br.readLine().split(" ");
			for (int j = 0; j < n; j++) {
				cost[i][j] = Integer.parseInt(input[j]);
			}
		}

		dfs(cost, visited, 0, 0);
		System.out.println(min);

	}

	static void dfs(int[][] cost, boolean[][] visited, int depth, int sum) {
		int[] dx = { 0, -1, 0, 1, 0 };
		int[] dy = { 0, 0, -1, 0, 1 };
		if (depth == 3) {
			min = Math.min(min, sum);
		} else {
			for (int i = 1; i < cost.length - 1; i++) {
				for (int j = 1; j < cost.length - 1; j++) {
					if (check(visited, i, j)) {
						for (int k = 0; k < 5; k++) {
							visited[i + dx[k]][j + dy[k]] = true;
						}
						for (int k = 0; k < 5; k++) {
							sum += cost[i + dx[k]][j + dy[k]];
						}
						dfs(cost, visited, depth + 1, sum);
						for (int k = 0; k < 5; k++) {
							visited[i + dx[k]][j + dy[k]] = false;
							sum -= cost[i + dx[k]][j + dy[k]];
						}
					}
				}
			}
		}
	}

	static boolean check(boolean[][] visited, int x, int y) {
		boolean tmp = true;
		int[] dx = { 0, -1, 0, 1, 0 };
		int[] dy = { 0, 0, -1, 0, 1 };
		for (int i = 0; i < 5; i++) {
			if (visited[x + dx[i]][y + dy[i]]) {
				tmp = false;
			}
		}
		return tmp;
	}
}
