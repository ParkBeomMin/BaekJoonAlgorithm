import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		int N = Integer.parseInt(br.readLine());
		MyStack stack = new MyStack();
		while (N > 0) {
			String command = br.readLine();
			switch (command) {
			case "pop": {
				System.out.println(stack.pop());
				break;
			}
			case "top": {
				System.out.println(stack.top());
				break;
			}
			case "size": {
				System.out.println(stack.size());
				break;
			}
			case "empty": {
				System.out.println(stack.empty());
				break;
			}
			default: {
				if (command.contains("push")) {
					int pushNum = Integer.parseInt(command.split(" ")[1]);
					stack.push(pushNum);
				}
				break;
			}
			}
			N--;
		}
	}

	static class MyStack {
		Node bottomNode;
		Node topNode;
		int size;

		MyStack() {
			this.bottomNode = null;
			this.topNode = null;
			this.size = 0;
		}

		void push(int value) {
			Node newNode = new Node(value);
			if (this.empty() == 0) {
				Node tmpNode = this.topNode;
				this.topNode = newNode;
				tmpNode.setTopNode(this.topNode);
				this.topNode.setBottomNode(tmpNode);

			} else {
				this.bottomNode = newNode;
				this.topNode = newNode;
			}
			this.size++;

		}

		int pop() {
			if (this.empty() == 0) {
				this.size--;
				Node tmpNode = this.topNode.getBottomNode();
				int value = this.topNode.getValue();
				this.topNode = tmpNode;
				return value;
			} else {
				return -1;
			}

		}

		int size() {
			return this.size;
		}

		int empty() {
			return size!=0 ? 0 : 1;
		}

		int top() {
			if (this.empty() == 0) {
				return topNode.getValue();
			} else {
				return -1;
			}
		}

	}

	static class Node {
		int value;
		Node top;
		Node bottom;

		public Node(int value) {
			this.value = value;
			this.top = null;
			this.bottom = null;
		}

		void setBottomNode(Node bottomNode) {
			this.bottom = bottomNode;
		}

		void setTopNode(Node topNode) {
			this.top = topNode;
		}

		Node getBottomNode() {
			return this.bottom;
		}

		Node getTopNode() {
			return this.top;
		}

		int getValue() {
			return this.value;
		}

	}
}
