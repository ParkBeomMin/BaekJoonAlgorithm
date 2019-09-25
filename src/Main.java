import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		InputStreamReader k = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(k);
		String input = br.readLine();
		String[] inputArr = input.split(" ");
		int n = Integer.parseInt(inputArr[0]);
		int m = Integer.parseInt(inputArr[1]);
		int v = Integer.parseInt(inputArr[2]);

		int[][] arr = new int[n][n];
		int[] visit = new int[n];

		for (int i = 0; i < m; i++) {
			String input_ = br.readLine();
			String[] inputArr_ = input_.split(" ");
			int x = Integer.parseInt(inputArr_[0]) - 1;
			int y = Integer.parseInt(inputArr_[1]) - 1;
			arr[x][y] = 1;
			arr[y][x] = 1;
		}

		dfs(arr, visit, v);
		System.out.println();
		visit = new int[n];
		bfs(arr, visit, v);

	}

	static void dfs(int[][] arr, int[] visit, int v) {
		System.out.print(v + " ");
		visit[v - 1] = 1;
		for (int i = 0; i < arr.length; i++) {
			if (arr[v - 1][i] == 1) {
				if (visit[i] != 1) {
					dfs(arr, visit, i + 1);
				}
			}
		}
	}

	static void bfs(int[][] arr, int[] visit, int v) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.offer(v - 1);
		visit[v - 1] = 1;
		System.out.print(v + " ");

		int temp;
		while (!q.isEmpty()) {
			temp = q.poll();
			for (int j = 0; j < visit.length; j++) {
				if (arr[temp][j] == 1 && visit[j] == 0) {
					q.offer(j);
					visit[j] = 1;
					System.out.print((j + 1) + " ");
				}
			}
		}

	}
}
