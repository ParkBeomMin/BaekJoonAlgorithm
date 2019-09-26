import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		InputStreamReader k = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(k);
		int n = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < n; i++) {
			int num = Integer.parseInt(br.readLine());
			int[] dp_zero = new int[num+1];
			int[] dp_one = new int[num+1];
			
			for (int j = 0; j <= num; j++) {
				if(j == 0) {
					dp_zero[j] = 1;
					dp_one[j] = 0;
				}else if(j == 1) {
					dp_zero[j] = 0;
					dp_one[j] = 1;
				}else {
					dp_zero[j] = dp_zero[j-1] + dp_zero[j-2];
					dp_one[j] = dp_one[j-1] + dp_one[j-2];	
				}
				
			}
			System.out.println(dp_zero[num] + " " + dp_one[num]);
		}
	}
}
