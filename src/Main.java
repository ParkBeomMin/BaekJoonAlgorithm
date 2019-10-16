import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class Main {
	public static void main(String[] args) throws IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		String[] input = br.readLine().split(" ");
		int n = Integer.parseInt(input[0]);
		int m = Integer.parseInt(input[1]);
		MyDeque deque = new MyDeque();
		int result = 0;
		int[] finds = new int[m];
		String[] findsInput = br.readLine().split(" ");
		for (int i = 0; i < m; i++) {
			finds[i] = Integer.parseInt(findsInput[i]);
		}
		for (int i = 1; i <= n; i++) {
			deque.offerLast(i);
		}
		for (int i = 0; i < m; i++) {
			result += deque.minMove(finds[i]);
			deque.initMoveCnt();
		}
		System.out.print(result);
	}

	static class MyDeque {
		Deque<Integer> deque;
		int leftMove;
		int rightMove;

		public MyDeque() {
			this.deque = new LinkedList<>();
			this.leftMove = 0;
			this.rightMove = 0;
		}

		void initMoveCnt() {
			this.leftMove = 0;
			this.rightMove = 0;
		}

		void offerLast(int value) {
			this.deque.offerLast(value);
		}

		int minMove(int key) {
			if (this.findLeftMove(key) <= this.findRightMove(key)) {
				this.leftMove(this.leftMove);
				this.pollFirst();
				return this.leftMove;
			} else {
				this.rightMove(this.rightMove);
				this.pollFirst();
				return this.rightMove;
			}
		}

		int findLeftMove(int key) {
			while (true) {
				if (this.findValue(key)) {
					break;
				}
				leftMove();
			}
			rightMove(this.leftMove);
			return this.leftMove;
		}

		int findRightMove(int key) {
			while (true) {
				if (this.findValue(key)) {
					break;
				}
				rightMove();
			}
			leftMove(this.rightMove);
			return this.rightMove;
		}

		void leftMove() {
			this.deque.offerLast(this.deque.pollFirst());
			this.leftMove++;
		}

		void leftMove(int cnt) {
			while (cnt > 0) {
				this.leftMove();
				this.leftMove--;
				cnt--;
			}
		}

		void rightMove() {
			this.deque.offerFirst(this.deque.pollLast());
			this.rightMove++;
		}

		void rightMove(int cnt) {
			while (cnt > 0) {
				this.rightMove();
				this.rightMove--;
				cnt--;
			}
		}

		int pollFirst() {
			return this.deque.pollFirst();
		}

		boolean findValue(int key) {
			boolean isFind = false;
			if (this.deque.peekFirst() == key) {
				isFind = true;
			}
			return isFind;
		}
	}
}
