import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Stack<Integer> lStack = new Stack<>();
		Stack<Integer> rStack = new Stack<>();
		int[] nge = new int[n];
		String[] input = br.readLine().split(" ");
		for (int i = 0; i < n; i++) {
			lStack.push(Integer.parseInt(input[i]));
		}
		for (int i = 0; i < n; i++) {
			int lTmp = lStack.pop();
			if (rStack.isEmpty()) {
				nge[n - i - 1] = -1;
			} else {
				while (!rStack.isEmpty()) {
					int rTmp = rStack.pop();
					if (lTmp < rTmp) {
						nge[n - i - 1] = rTmp;
						rStack.push(rTmp);
						rStack.push(lTmp);
						break;
					} else {
						if (rStack.isEmpty()) {
							nge[n - i - 1] = -1;
							break;
						} else {
							rTmp = rStack.pop();
						}

					}
				}
			}
			rStack.push(lTmp);
		}
		for (int i = 0; i < n; i++) {
			System.out.print(nge[i] + " ");
		}

		br.close();
	}

}
