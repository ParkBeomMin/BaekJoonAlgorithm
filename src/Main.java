import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
	public static void main(String[] args) throws IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		int n = Integer.parseInt(br.readLine());
		int answer = 0;
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for (int i = 0; i < n; i++) {
			int num = Integer.parseInt(br.readLine());
			if (num > 0) {
				pq.offer(num);
			} else {
				if (!pq.isEmpty()) {
					answer = pq.poll();
				} else {
					answer = 0;
				}
				System.out.println(answer);
			}
		}

	}

}
