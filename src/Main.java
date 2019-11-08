import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class Main {
	public static void main(String[] args) throws IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		String[] input = br.readLine().split(" ");
		int v = Integer.parseInt(input[0]);
		int e = Integer.parseInt(input[1]);
		int start = Integer.parseInt(br.readLine());
		int[] dist = new int[v];
		boolean[] visited = new boolean[v];
		PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> {
			return a.weight > b.weight ? 1 : -1;
		});
		ArrayList<ArrayList<Node>> graph = new ArrayList<>();
		for (int i = 0; i < v; i++) {
			graph.add(new ArrayList<>());
		}
		for (int i = 0; i < e; i++) {
			String[] tmp = br.readLine().split(" ");
			int x = Integer.parseInt(tmp[0]);
			int y = Integer.parseInt(tmp[1]);
			int w = Integer.parseInt(tmp[2]);
			graph.get(x - 1).add(new Node(y - 1, w));
		}
		for (int i = 0; i < dist.length; i++) {
			dist[i] = Integer.MAX_VALUE;
		}

		dist[start - 1] = 0;
		pq.offer(new Node(start - 1, 0));
		while (!pq.isEmpty()) {
			Node tmp = pq.poll();
			if (visited[tmp.index]) {
				continue;
			}
			visited[tmp.index] = true;
			if (tmp.weight < dist[tmp.index]) {
				dist[tmp.index] = tmp.weight;
			}
			for (Node node : graph.get(tmp.index)) {
				if (dist[node.index] > dist[tmp.index] + node.weight) {
					dist[node.index] = dist[tmp.index] + node.weight;
					pq.offer(new Node(node.index, dist[node.index]));
				}
			}
		}

		for (int i = 0; i < dist.length; i++) {
			if (dist[i] == Integer.MAX_VALUE) {
				System.out.println("INF");
			} else {
				System.out.println(dist[i]);
			}
		}
	}

	static class Node {
		int index;
		int weight;

		public Node(int index, int weight) {
			this.index = index;
			this.weight = weight;
		}
	}
}
