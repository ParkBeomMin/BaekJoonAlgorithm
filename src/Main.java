import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		int arr[][] = new int[N][2];
		for (int i = 0; i < N; i++) {
			arr[i][0] = scan.nextInt();
			arr[i][1] = scan.nextInt();
		}
		scan.close();
		int result[] = new int[N];
		for (int i = 0; i < N; i++) {
			int weight = arr[i][0];
			int height = arr[i][1];
			for (int j = 0; j < N; j++) {
				if (weight < arr[j][0] && height < arr[j][1]) {
					result[i] = result[i] + 1;
				}
			}
		}
		for (int i = 0; i < N; i++) {
			System.out.print(result[i]+1 + " ");
		}

	}
}
