import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	public static void main(String[] args) throws IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		String[] input = br.readLine().split(" ");
		int n = Integer.parseInt(input[0]);
		int m = Integer.parseInt(input[1]);
		int[][] maze = new int[n][m];
		for (int i = 0; i < n; i++) {
			String rows = br.readLine();
			for (int j = 0; j < m; j++) {
				maze[i][j] = Integer.parseInt(rows.substring(j, j + 1));
			}
		}
		bfs(maze, n, m);

	}

	static void bfs(int[][] maze, int n, int m) {
		int[] dx = { -1, 0, 1, 0 };
		int[] dy = { 0, -1, 0, 1 };
		boolean[][] visited = new boolean[n][m];
		Queue<Point> queue = new LinkedList<>();
		int cnt = 1;
		int result = 0;
		queue.offer(new Point(0, 0, cnt));
		visited[0][0] = true;
		while (!queue.isEmpty()) {
			Point tmp = queue.poll();
			int x = tmp.x;
			int y = tmp.y;
			result = tmp.distance;
			if (x == n - 1 && y == m - 1) {
				break;
			}
			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
					continue;
				}
				if (maze[nx][ny] == 1 && visited[nx][ny] == false) {
					visited[nx][ny] = true;
					queue.offer(new Point(nx, ny, result + 1));
				}
			}
		}
		System.out.println(result);
	}

	static class Point {
		int x;
		int y;
		int distance;

		public Point(int x, int y, int distance) {
			this.x = x;
			this.y = y;
			this.distance = distance;
		}
	}
}
