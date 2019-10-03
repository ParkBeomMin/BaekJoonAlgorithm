import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			int input = Integer.parseInt(br.readLine());
			arr[i] = input;
		}

		quickSort(arr, 0, arr.length - 1);
		for (int i = 0; i < n; i++) {
			System.out.println(arr[i]);
		}
	}

	static void quickSort(int[] arr, int left, int right) {
		int pivot = arr[(left + right) / 2];
		int mLeft = left;
		int mRight = right;
		while (mLeft <= mRight) {
			while (pivot > arr[mLeft]) {
				mLeft++;
			}
			while (pivot < arr[mRight]) {
				mRight--;
			}
			if (mLeft <= mRight) {
				int tmp = arr[mLeft];
				arr[mLeft] = arr[mRight];
				arr[mRight] = tmp;
				mLeft++;
				mRight--;
			}
		}
		if (left < mRight) {
			quickSort(arr, left, mRight);
		}
		if (mLeft < right) {
			quickSort(arr, mLeft, right);
		}
	}
}
