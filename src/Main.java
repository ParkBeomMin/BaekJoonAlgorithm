import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		int M = scan.nextInt();
		int[] card = new int[N];
		for(int i = 0; i < N; i++) {
			card[i] = scan.nextInt();
		}
		scan.close();
		Arrays.sort(card);
		int result = 0;
		for(int i = 0; i < N-2; i++) {
			for(int j = i+1; j < N-1; j++) {
				for(int k = j+1; k < N; k++) {
					int sum = card[i] + card[j] + card[k];
					if(sum <= M && result <= sum) {
						result = sum;
					}
				}
			}
		}
		System.out.print(result);
	}
}
