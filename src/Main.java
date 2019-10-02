import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		String input = br.readLine();
		Stack<Character> stack = new Stack<>();
		Stack<Character> rightStack = new Stack<>();
		while (!input.equals(".")) { // 종료 조건
			for (int i = 0; i < input.length(); i++) {
				if (input.charAt(i) == '(' || input.charAt(i) == ')' || input.charAt(i) == '['
						|| input.charAt(i) == ']') {
					stack.push(input.charAt(i));
				}
			}
			boolean isBalance = isBalance(stack, rightStack);
			if (isBalance) {
				System.out.println("yes");
			} else {
				System.out.println("no");
			}
			stack.clear();
			rightStack.clear();
			input = br.readLine();
		}
	}

	static boolean isBalance(Stack<Character> stack, Stack<Character> rStack) {
		while (!stack.isEmpty()) {
			char tmp = stack.pop();
			if (tmp == '(' || tmp == '[') {
				if (!rStack.isEmpty()) {
					char rightTmp = rStack.pop();
					if (tmp == '(') {
						if (rightTmp == ']') {
							rStack.push(rightTmp);
							break;
						}
					} else {
						if (rightTmp == ')') {
							rStack.push(rightTmp);
							break;
						}
					}
				} else {
					stack.push(tmp);
					break;
				}
			} else if (tmp == ')' || tmp == ']') {
				rStack.push(tmp);
			}

		}
		if (stack.isEmpty() && rStack.isEmpty()) {
			return true;
		} else {
			return false;

		}
	}
}
