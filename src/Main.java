import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

/**
 * https://qlyh8.tistory.com/153 참고함.
 * @author parkbeommin
 *
 */
public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine()); // test case
		for (int i = 0; i < t; i++) {

			int cnt = 0;
			String[] input = br.readLine().split(" ");
			int n = Integer.parseInt(input[0]);
			int m = Integer.parseInt(input[1]);
			String[] priority = br.readLine().split(" ");
			LinkedList<Integer> queue = new LinkedList<>();
			
			for (int j = 0; j < n; j++) {
				queue.add(Integer.parseInt(priority[j]));
			}

			while (!queue.isEmpty()) {
				boolean isPriority = true;
				for (int j = 1; j < queue.size(); j++) {
					if (queue.peek() < queue.get(j)) {
						isPriority = false;
						break;
					}
				}
				if (isPriority) {
					cnt++;
					queue.poll();
					if (m != 0) {
						m -= 1;
					}else {
						break;
					}
				} else {
					queue.add(queue.poll());
					if (m == 0) {
						m = queue.size() - 1;
					} else {
						m -= 1;
					}
				}
			}
			System.out.println(cnt);
			queue.clear();
		}

		br.close();
	}
}
