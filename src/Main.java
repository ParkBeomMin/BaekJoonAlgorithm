import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		for(int i = 0; i < n; i++) {
			String[] input = br.readLine().split(" ");
			int repeatNum = Integer.parseInt(input[0]);
			String normalString = input[1];
			System.out.println(makeRepeatString(normalString, repeatNum));
		}
		br.close();
	}
	
	static String makeRepeatString(String s, int n) {
		String result = "";
		for(int i = 0; i < s.length(); i++) {
			for(int j = 0; j < n; j++) {
				result += s.substring(i, i+1);
			}
		}
		return result;
	}

}
