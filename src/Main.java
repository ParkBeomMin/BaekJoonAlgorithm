import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
	public static void main(String[] args) throws IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		int n = Integer.parseInt(br.readLine());
		int answer = 0;
		PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				if (Math.abs(o1) >= Math.abs(o2)) { // 너(o2)가 나(o1)보다 작냐? 맞으면 앞으로(오름차순)
					if (Math.abs(o1) == Math.abs(o2)) {
						if (o1 >= o2) {
							return 1;
						} else {
							return -1;
						}
					} else {
						return 1;
					}
				} else {
					return -1;
				}
			}

		});
		for (int i = 0; i < n; i++) {
			int num = Integer.parseInt(br.readLine());
			if (num != 0) {
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
