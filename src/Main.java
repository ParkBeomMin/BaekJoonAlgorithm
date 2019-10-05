import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[10001];
		for (int i = 0; i < n; i++) {
			int input = Integer.parseInt(br.readLine());
			arr[input]++;
		}
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		 
		for (int i = 1; i < arr.length; i++) {
			for(int j = 0; j < arr[i]; j++) {
				bw.write(Integer.toString(i) + "\n");
			}
		}
		bw.close();
		br.close();
	}
}
