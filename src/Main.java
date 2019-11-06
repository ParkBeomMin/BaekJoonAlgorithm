import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	public static void main(String[] args) throws IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		int max = 100000;
		String[] input = br.readLine().split(" ");
		int n = Integer.parseInt(input[0]);
		int k = Integer.parseInt(input[1]);
		bfs(n, k, max);
	}

	static void bfs(int n, int k, int max) {
		Queue<Point> queue = new LinkedList<>();
		int sec = 0;
		boolean[] visited = new boolean[max + 1];
		queue.offer(new Point(n, sec));
		visited[n] = true;
		while (!queue.isEmpty()) {
			Point tmp = queue.poll();
			int x = tmp.x;
			sec = tmp.second;
			if (x == k) {
				break;
			} else {
				if (x - 1 >= 0 && !visited[x - 1]) {
					queue.offer(new Point(x - 1, sec + 1));
					visited[x - 1] = true;
				}
				if (x + 1 <= max && !visited[x + 1]) {
					queue.offer(new Point(x + 1, sec + 1));
					visited[x + 1] = true;
				}
				if (2 * x <= max && !visited[2 * x]) {
					queue.offer(new Point(2 * x, sec + 1));
					visited[2 * x] = true;
				}
			}
		}
		System.out.println(sec);
	}

	static class Point {
		int x;
		int second;

		public Point(int x, int second) {
			this.x = x;
			this.second = second;
		}
	}
}
