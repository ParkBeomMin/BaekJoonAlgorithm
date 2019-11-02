import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		int testCase = Integer.parseInt(br.readLine());
		for (int t = 0; t < testCase; t++) {

			String[] input = br.readLine().split(" ");
			int m = Integer.parseInt(input[0]);
			int n = Integer.parseInt(input[1]);
			int k = Integer.parseInt(input[2]);
			int[][] farm = new int[m][n];
			int[][] visited = new int[m][n];
			int answer = 0;
			for (int i = 0; i < k; i++) {
				String[] points = br.readLine().split(" ");
				farm[Integer.parseInt(points[0])][Integer.parseInt(points[1])] = 1;
			}
			for (int i = 0; i < m; i++) {
				for (int j = 0; j < n; j++) {
					if (visited[i][j] == 0 && farm[i][j] == 1) {
						dfs(farm, visited, i, j, n, m);
						answer++;
					}
				}
			}
			System.out.println(answer);

		}
	}

	static void dfs(int[][] farm, int[][] visited, int x, int y, int n, int m) {
		int[] dx = { -1, 0, 1, 0 };
		int[] dy = { 0, -1, 0, 1 };
		if (visited[x][y] == 1) {
			return;
		}
		visited[x][y] = 1;
		for (int k = 0; k < 4; k++) {
			int nx = x + dx[k];
			int ny = y + dy[k];
			if (nx >= 0 && nx < m && ny >= 0 && ny < n) {
				if (farm[nx][ny] == 1) {
					dfs(farm, visited, nx, ny, n, m);
				}

			}
		}
	}

}
