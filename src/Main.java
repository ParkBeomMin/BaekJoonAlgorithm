import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		int[] arr = new int[N];
		for(int i = 0; i < N; i++) {
			arr[i] = scan.nextInt();
		}
		int max = -1000000;
		int min = 1000000;
		for(int i = 0; i < N; i++) {
			if(max <= arr[i]) {
				max = arr[i];
			}
			if(min >= arr[i]) {
				min = arr[i];
			}
		}
		System.out.print(min + " " + max);
	}
}
