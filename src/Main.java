import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Main {
	public static void main(String[] args) throws IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		int n = Integer.parseInt(br.readLine());
		int[][] area = new int[n][n];
		int[][] visited = new int[n][n];
		List<Integer> group = new ArrayList<>();
		int groupId = 0;
		for (int i = 0; i < n; i++) {
			String input = br.readLine();
			for (int j = 0; j < n; j++) {
				area[i][j] = Integer.parseInt(input.substring(j, j + 1));
			}
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (area[i][j] == 1 && visited[i][j] == 0) {
					groupId++;
					dfs(area, visited, group, groupId, i, j);
				}
			}
		}
		int[] result = new int[groupId];
		Collections.sort(group);
		for (int i = 1; i <= groupId; i++) {
			for (int j = 0; j < group.size(); j++) {
				if (group.get(j) == i) {
					result[i-1]++;
				}
			}
		}
		Arrays.sort(result);
		System.out.println(result.length);
		for (int groupNum : result) {
			System.out.println(groupNum);
		}

	}

	static void dfs(int[][] area, int[][] visited, List<Integer> group, int groupId, int x, int y) {
		int[] dx = { -1, 0, 1, 0 }; // 좌상우하
		int[] dy = { 0, -1, 0, 1 };
		visited[x][y] = 1;
		group.add(groupId);

		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (nx >= 0 && ny >= 0 && nx < area.length && ny < area.length) {
				if (area[nx][ny] == 1 && visited[nx][ny] == 0) {
					dfs(area, visited, group, groupId, nx, ny);
				}

			}
		}

	}

}
