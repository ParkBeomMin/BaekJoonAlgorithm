import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		int n = Integer.parseInt(br.readLine());
		int[][] cartolina = new int[n][n];
		int[] num = new int[2];
		for (int i = 0; i < n; i++) {
			String[] input = br.readLine().split(" ");
			for (int j = 0; j < n; j++) {
				cartolina[i][j] = Integer.parseInt(input[j]);
			}
		}
		cut(cartolina, num);
		System.out.println(num[0]);
		System.out.println(num[1]);
	}

	static void cut(int[][] arr, int[] num) {
		if (arr.length == 1 || isWhite(arr) || isBlue(arr)) {
			if (isWhite(arr)) {
				num[0]++;
			} else if (isBlue(arr)) {
				num[1]++;
			}
			return;
		} else {
			cut(createCutArray(arr, arr.length / 2, 0), num);
			cut(createCutArray(arr, arr.length / 2, 1), num);
			cut(createCutArray(arr, arr.length / 2, 2), num);
			cut(createCutArray(arr, arr.length / 2, 3), num);
		}
	}

	static int[][] createCutArray(int[][] arr, int n, int flag) {
		int[][] cutArr = new int[n][n];
		switch (flag) {
		case 0: { // 좌상단
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					cutArr[i][j] = arr[i][j];
				}
			}
			break;
		}
		case 1: { // 우상단
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					cutArr[i][j] = arr[i + n][j];
				}
			}
			break;
		}
		case 2: { // 좌하단
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					cutArr[i][j] = arr[i][j + n];
				}
			}
			break;
		}
		case 3: { // 우하단
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					cutArr[i][j] = arr[i + n][j + n];
				}
			}
			break;
		}
		}

		return cutArr;
	}

	static boolean isWhite(int[][] arr) {
		boolean flag = true;
		int tmp = 0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				if (tmp != arr[i][j]) {
					flag = false;
					break;
				}
				if (!flag) {
					break;
				}
			}
		}
		return flag;
	}

	static boolean isBlue(int[][] arr) {
		boolean flag = true;
		int tmp = 1;
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				if (tmp != arr[i][j]) {
					flag = false;
					break;
				}
			}
			if (!flag) {
				break;
			}
		}
		return flag;
	}
}
