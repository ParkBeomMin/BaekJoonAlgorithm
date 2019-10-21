import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		int n = Integer.parseInt(br.readLine());
		String[] inputN = br.readLine().split(" ");
		int m = Integer.parseInt(br.readLine());
		String[] inputM = br.readLine().split(" ");
		int[] cards = new int[n];
		int[] nums = new int[m];
		int index = -1;
		int cnt = 0;
		for (int i = 0; i < n; i++) {
			cards[i] = Integer.parseInt(inputN[i]);
		}
		for (int i = 0; i < m; i++) {
			nums[i] = Integer.parseInt(inputM[i]);
		}
		Arrays.sort(cards);
		for (int i = 0; i < nums.length; i++) {
			int lower = lowerSearch(cards, nums[i]);
			int upper = upperSearch(cards, nums[i]);
			System.out.print(upper - lower + " ");
		}
	}

	static int lowerSearch(int[] cards, int target) {
		int start = 0;
		int end = cards.length;
		while (start < end) {
			int mid = (start + end) / 2;
			if (cards[mid] >= target) {
				end = mid;
			} else {
				start = mid + 1;
			}
		}
		return start;
	}

	static int upperSearch(int[] cards, int target) {
		int start = 0;
		int end = cards.length;
		while (start < end) {
			int mid = (start + end) / 2;
			if (cards[mid] <= target) {
				start = mid + 1;
			} else {
				end = mid;
			}
		}
		return start;
	}
}
