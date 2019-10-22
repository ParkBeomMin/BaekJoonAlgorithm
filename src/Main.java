import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		int[] visited = new int[n + 1];
		int[][] graph = new int[n + 1][n + 1];
		int[] cnt = new int[1];
		for (int i = 0; i < m; i++) {
			String[] input = br.readLine().split(" ");
			graph[Integer.parseInt(input[0])][Integer.parseInt(input[1])] = 1;
			graph[Integer.parseInt(input[1])][Integer.parseInt(input[0])] = 1;
		}
		dfs(graph, visited, 1, cnt);
		System.out.println(cnt[0]-1);
	}

	static void dfs(int[][] graph, int[] visited, int p, int[] cnt) {
		visited[p] = 1;
		cnt[0] += 1;
		for (int i = 1; i < graph.length; i++) {
			if (graph[p][i] == 1 && visited[i] == 0) {

				dfs(graph, visited, i, cnt);
			}
		}
	}
}
