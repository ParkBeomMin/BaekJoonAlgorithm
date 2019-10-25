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
		int[][] tomato = new int[m][n];
		for (int i = 0; i < m; i++) {
			String[] status = br.readLine().split(" ");
			for (int j = 0; j < n; j++) {
				tomato[i][j] = Integer.parseInt(status[j]);
			}
		}
		bfs(tomato);
	}

	static void bfs(int[][] tomato) {
		int[] dx = { -1, 0, 1, 0 };
		int[] dy = { 0, -1, 0, 1 };
		Queue<Dot> queue = new LinkedList<>();
		for (int i = 0; i < tomato.length; i++) {
			for (int j = 0; j < tomato[i].length; j++) {
				if (tomato[i][j] == 1) {
					queue.add(new Dot(i, j));
				}
			}
		}
		while (!queue.isEmpty()) {
			Dot dot = queue.poll();
			for (int i = 0; i < 4; i++) {
				int x = dot.x + dx[i];
				int y = dot.y + dy[i];
				if (x < 0 || x >= tomato.length || y < 0 || y >= tomato[0].length) {
					continue;
				}
				if (tomato[x][y] != 0) {
					continue;
				} else {
					queue.add(new Dot(x, y));
					tomato[x][y] = tomato[dot.x][dot.y] + 1;
				}
			}
		}
		System.out.print(statusCheck(tomato));
	}

	static int statusCheck(int[][] tomato) {
		int tmp = 0;
		for (int i = 0; i < tomato.length; i++) {
			for (int j = 0; j < tomato[i].length; j++) {
				if (tomato[i][j] == 0) {
					return -1;
				}
				if (tmp < tomato[i][j]) {
					tmp = tomato[i][j];
				}
			}
		}
		return tmp - 1;
	}

	static class Dot {
		int x;
		int y;

		public Dot(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
