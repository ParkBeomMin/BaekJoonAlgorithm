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
		int col = Integer.parseInt(input[0]);
		int row = Integer.parseInt(input[1]);
		int h = Integer.parseInt(input[2]);
		int[][][] farm = new int[row][col][h];
		for (int k = 0; k < h; k++) {
			for (int i = 0; i < row; i++) {
				String[] tomatos = br.readLine().split(" ");
				for (int j = 0; j < col; j++) {
					farm[i][j][k] = Integer.parseInt(tomatos[j]);
				}
			}
		}

		bfs(farm, row, col, h);

	}

	static void bfs(int[][][] farm, int row, int col, int h) {
		int[] dx = { -1, 1, 0, 0, 0, 0 };
		int[] dy = { 0, 0, -1, 1, 0, 0 };
		int[] dz = { 0, 0, 0, 0, -1, 1 };

		boolean[][][] visited = new boolean[row][col][h];
		Queue<Point> queue = new LinkedList<>();
		for (int k = 0; k < h; k++) {
			for (int i = 0; i < row; i++) {
				for (int j = 0; j < col; j++) {
					if (farm[i][j][k] == 1) {
						queue.offer(new Point(i, j, k));
					}
				}
			}
		}

		while (!queue.isEmpty()) {
			Point tmp = queue.poll();
			int x = tmp.x;
			int y = tmp.y;
			int z = tmp.z;
			visited[x][y][z] = true;
			for (int i = 0; i < 6; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				int nz = z + dz[i];
				if (nx < 0 || nx >= row || ny < 0 || ny >= col || nz < 0 || nz >= h) {
					continue;
				}
				if (farm[nx][ny][nz] != 0) {
					continue;
				} else {
					farm[nx][ny][nz] = farm[x][y][z] + 1;
					queue.offer(new Point(nx, ny, nz));
				}
			}
		}

		System.out.println(check(farm, row, col, h));
	}

	static int check(int[][][] farm, int n, int m, int h) {
		int tmp = 0;
		for (int k = 0; k < h; k++) {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if (farm[i][j][k] == 0) {
						return -1;
					} else {
						if (tmp < farm[i][j][k]) {
							tmp = farm[i][j][k];
						}
					}
				}
			}
		}

		return tmp - 1;
	}

	static class Point {
		int x;
		int y;
		int z;

		public Point(int x, int y, int z) {
			this.x = x;
			this.y = y;
			this.z = z;
		}
	}
}
