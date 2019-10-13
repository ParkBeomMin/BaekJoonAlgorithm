import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] arr = new int[n][n];
		for (int i = 0; i < n; i++) {
			String input = br.readLine();
			for (int j = 0; j < input.length(); j++) {
				arr[i][j] = Integer.parseInt(String.valueOf(input.charAt(j)));
			}
		}
		compress(arr);
		br.close();
	}

	static void compress(int[][] arr) {
		if (isZero(arr)) {
			System.out.print("0");
		} else if (isOne(arr)) {
			System.out.print("1");
		} else {
			System.out.print("(");
			compress(divide(arr, 0, arr.length / 2, 0, arr.length / 2));
			compress(divide(arr, 0, arr.length / 2, arr.length / 2, arr.length));
			compress(divide(arr, arr.length / 2, arr.length, 0, arr.length / 2));
			compress(divide(arr, arr.length / 2, arr.length, arr.length / 2, arr.length));
			System.out.print(")");
		}

	}

	static int[][] divide(int[][] arr, int rowStart, int rowEnd, int colStart, int colEnd) {
		int[][] returnArr = new int[arr.length / 2][arr.length / 2];
		for (int i = rowStart; i < rowEnd; i++) {
			for (int j = colStart; j < colEnd; j++) {
				returnArr[i - rowStart][j - colStart] = arr[i][j];
			}
		}
		return returnArr;
	}

	static boolean isZero(int[][] arr) {
		boolean isZero = true;
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				if (arr[i][j] == 1) {
					isZero = false;
					break;
				}
			}
			if (!isZero) {
				break;
			}
		}
		return isZero;
	}

	static boolean isOne(int[][] arr) {
		boolean isOne = true;
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				if (arr[i][j] == 0) {
					isOne = false;
					break;
				}
			}
			if (!isOne) {
				break;
			}
		}
		return isOne;
	}

}
