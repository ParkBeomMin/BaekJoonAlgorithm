import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class Main {
	public static void main(String[] args) throws IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		int testCase = Integer.parseInt(br.readLine());
		for (int i = 0; i < testCase; i++) {
			String command = br.readLine();
			int n = Integer.parseInt(br.readLine());
			Deque<Integer> deque = new LinkedList<>();
			String input = br.readLine();
			input = input.substring(1, input.length() - 1);
			String[] inputs = input.split(",");
			boolean isError = false;
			boolean isReverse = false;
			for (int j = 0; j < inputs.length; j++) {
				if (inputs[j].length() != 0) {
					deque.offerLast(Integer.parseInt(inputs[j]));
				}
			}
			for (int j = 0; j < command.length(); j++) {
				if (command.substring(j, j + 1).equals("R")) {
					isReverse = !isReverse;
				} else {
					if (deque.isEmpty()) {
						isError = true;
					} else {
						if (isReverse) {
							deque.pollLast();
						} else {
							deque.pollFirst();
						}
					}
				}
			}
			if (isError) {
				System.out.print("error");
			} else {
				System.out.print("[");
				while (!deque.isEmpty()) {
					if (isReverse) {
						if (deque.size() == 1) {
							System.out.print(deque.pollLast());
						} else {
							System.out.print(deque.pollLast() + ",");
						}
					} else {
						if (deque.size() == 1) {
							System.out.print(deque.pollFirst());
						} else {
							System.out.print(deque.pollFirst() + ",");
						}
					}
				}
				System.out.print("]");
			}
			System.out.println();
			deque.clear();

		}
	}

}
