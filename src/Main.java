import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		String[] input = br.readLine().split("-");
		int sum = 0;
		for(int i = 0; i < input.length; i++) {
			String tmp = input[i];
			if(i == 0) {
				if(tmp.contains("+")) {
					for(String num : tmp.split("\\+")) {
						sum += Integer.parseInt(num);
					}
				}else {
					sum += Integer.parseInt(tmp);
				}
			}else {
				if(tmp.contains("+")) {
					for(String num : tmp.split("\\+")) {
						sum -= Integer.parseInt(num);
					}
				}else {
					sum -= Integer.parseInt(tmp);
				}
			}
		}
		
		System.out.print(sum);
	}
}
