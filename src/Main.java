import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		InputStreamReader k = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(k);
		int n = Integer.parseInt(br.readLine());
		int tmp = 666;
		while(n > 1) {
			tmp++;
			if(String.valueOf(tmp).contains("666")) {
				n--;	
			}
		}
		System.out.print(tmp);

	}
}
