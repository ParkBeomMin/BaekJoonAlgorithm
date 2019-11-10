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
		PriorityQueue<Integer> minPq = new PriorityQueue<>((a, b) -> a < b ? 1 : -1);
		PriorityQueue<Integer> maxPq = new PriorityQueue<>();
		for (int i = 0; i < n; i++) {
			int num = Integer.parseInt(br.readLine());
			if (i == 0) {
				answer = num;
			} else {
				if (answer >= num) {
					minPq.offer(num);
				} else {
					maxPq.offer(num);
				}

				if ((minPq.size() + maxPq.size() + 1) % 2 == 0) { // 짝수면 중간값에서 작은 값
					if (minPq.size() > maxPq.size()) {
						int tmp = answer;
						answer = minPq.poll();
						maxPq.offer(tmp);
					}
				} else {
					if (minPq.size() > maxPq.size()) {
						int tmp = answer;
						answer = minPq.poll();
						maxPq.offer(tmp);
					} else if (maxPq.size() > minPq.size()) {
						int tmp = answer;
						answer = maxPq.poll();
						minPq.offer(tmp);
					}
				}
			}
			System.out.println(answer);
		}
	}
}
