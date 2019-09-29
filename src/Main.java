import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		String[] input = br.readLine().split(" ");
		int n = Integer.parseInt(input[0]);
		int k = Integer.parseInt(input[1]);
		Queue<Integer> queue = new LinkedList<>();
		Queue<Integer> result = new LinkedList<>();
		for (int i = 1; i <= n; i++) {
			queue.offer(i);
		}
		int turn = 1;
		while (!queue.isEmpty()) {
			if (turn == k) {
				result.offer(queue.poll());
				turn = 1;
			} else {
				queue.offer(queue.poll());
				turn++;
			}
		}
		System.out.print("<");
		while (!result.isEmpty()) {
			if(result.size() == 1) {
				System.out.print(result.poll());
			}else {
				System.out.print(result.poll() + ", ");	
			}
		}
		System.out.print(">");


	}
}
