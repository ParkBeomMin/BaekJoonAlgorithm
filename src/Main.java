import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		int n = Integer.parseInt(br.readLine());
		String[] arrInput = br.readLine().split(" ");
		int m = Integer.parseInt(br.readLine());
		String[] numInput = br.readLine().split(" ");
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(arrInput[i]);
		}
		Arrays.sort(arr);
		for (int i = 0; i < m; i++) {
			search(arr, Integer.parseInt(numInput[i]));
		}
	}

	static void search(int[] arr, int key) {
		int start = 0;
		int end = arr.length-1;
		boolean isFind = false;
		while (start <= end) {
			int mid = (start + end) / 2;
			if (arr[mid] == key) {
				isFind = true;
				break;
			} else if (arr[mid] < key) {
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}
		if(isFind) {
			System.out.println("1");
		}else {
			System.out.println("0");
		}

	}
}
