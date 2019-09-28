import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);

		int n = Integer.parseInt(br.readLine());
		Stack<String> stack = new Stack<>();
		Stack<String> stack_ = new Stack<>();

		for (int i = 0; i < n; i++) {
			String input = br.readLine();
			for (int j = 0; j < input.length(); j++) {
				stack.push(String.valueOf(input.charAt(j)));

			}

			for (int j = 0; j < input.length(); j++) {
				if (stack.peek().equals(")")) {
					stack_.push(stack.pop());
				} else {
					if (!stack_.isEmpty()) {
						stack.pop();
						stack_.pop();
					}
				}
			}

			if (!stack_.isEmpty() || !stack.isEmpty()) {
				System.out.println("NO");
			} else {
				System.out.println("YES");
			}
			stack.clear();
			stack_.clear();
		}
	}
}
