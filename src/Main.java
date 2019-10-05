import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[8001];
		int[] sorted = new int[n];
		int sortedIndex = 0;
		int maxCnt = 0;
		int maxCntNum = -1;
		boolean isSecond = false;
		for (int i = 0; i < n; i++) {
			int input = Integer.parseInt(br.readLine());
			arr[input + 4000]++;
		}
		for (int i = 0; i < arr.length; i++) {
			if (maxCnt < arr[i]) {
				maxCnt = arr[i];
				maxCntNum = i;
				isSecond = true;

			} else if (maxCnt == arr[i]) {
				if (isSecond) {
					maxCntNum = i;
					isSecond = false;
				}
			}
		}

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i]; j++) {
				sorted[sortedIndex] = i - 4000;
				sortedIndex++;
			}
		}
		double sum = 0;
		for (int i = 0; i < sorted.length; i++) {
			sum += sorted[i];
		}
		double average = sum / sorted.length;
		bw.write(String.valueOf((int) Math.round(average)) + "\n");
		bw.write(String.valueOf(sorted[sorted.length / 2]) + "\n");
		bw.write(String.valueOf(maxCntNum - 4000) + "\n");
		bw.write(String.valueOf(Math.abs(sorted[sorted.length - 1] - sorted[0])));

		bw.close();
		br.close();
	}
}
