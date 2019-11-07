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
			String tmp = br.readLine();
			for (int j = 0; j < m; j++) {
				maze[i][j] = Integer.parseInt(tmp.substring(j, j + 1));
			}
		}
		bfs(maze, n, m);

	}

	static void bfs(int[][] maze, int n, int m) {
		int[] dx = { -1, 1, 0, 0 };
		int[] dy = { 0, 0, -1, 1 };
		int answer = -1;
		int distance = 0;
		boolean[][][] visited = new boolean[n][m][2]; // 맨 마지막 0이면, 벽 안뚫고 간거!
		Queue<Point> queue = new LinkedList<>();
		queue.offer(new Point(0, 0, 1, false));
		visited[0][0][0] = true;
		while (!queue.isEmpty()) {
			Point tmp = queue.poll();
			int x = tmp.x;
			int y = tmp.y;
			boolean b = tmp.isCracked;
			distance = tmp.distance;
			if (x == n - 1 && y == m - 1) {
				answer = distance;
				break;
			}
			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
					continue;
				}
				if (maze[nx][ny] == 1) {
					if (!b && !visited[nx][ny][1]) { // 벽을 부숨
						queue.offer(new Point(nx, ny, distance + 1, true));
						visited[nx][ny][1] = true;
					}
				} else {
					if (!b && !visited[nx][ny][0]) { // 벽을 안부수고 가는 경우
						queue.offer(new Point(nx, ny, distance + 1, b));
						visited[nx][ny][0] = true;
					}
					if (b && !visited[nx][ny][1]) { // 벽을 부수고 가는 경우
						queue.offer(new Point(nx, ny, distance + 1, b));
						visited[nx][ny][1] = true;
					}
				}

			}
		}
		System.out.println(answer);
	}

	static class Point {
		int x;
		int y;
		boolean isCracked;
		int distance;

		public Point(int x, int y, int distance, boolean isCracked) {
			this.x = x;
			this.y = y;
			this.isCracked = isCracked;
			this.distance = distance;
		}
	}
}
