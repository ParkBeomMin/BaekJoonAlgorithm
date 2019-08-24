import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int first[] = {5000000, 3000000, 2000000, 500000, 300000, 100000};
		int second[] = {5120000, 2560000, 1280000, 640000, 320000};
		int T = scan.nextInt();
		int input[][] = new int[T][2];
		int result[] = new int[T];
		for(int i = 0; i < T; i++) {
			for(int j = 0; j < 2; j++) {
				input[i][j] = scan.nextInt();
			}
		}
		scan.close();
		for(int i = 0; i < T; i++) {
			int a = input[i][0];
			int b = input[i][1];
			if(a <= 21 && a > 0) {
				if( a == 1) {
					result[i] += first[0];
				}else if( a > 1 && a <= 3 ) {
					result[i] += first[1];
				}else if( a > 3 && a <= 6 ) {
					result[i] += first[2];
				}else if( a > 6 && a <= 10 ) {
					result[i] += first[3];
				}else if( a > 10 && a <= 15 ) {
					result[i] += first[4];
				}else if( a > 15 && a <= 21 ) {
					result[i] += first[5];
				}
			}
			if(b <= 31 && b > 0) {
				if( b == 1) {
					result[i] += second[0];
				}else if( b > 1 && b <= 3 ) {
					result[i] += second[1];
				}else if( b > 3 && b <= 7 ) {
					result[i] += second[2];
				}else if( b > 7 && b <= 15 ) {
					result[i] += second[3];
				}else if( b > 15 && b <= 31 ) {
					result[i] += second[4];
				}
			}
		}
		
		for(int i = 0; i < T; i++) {
			System.out.println(result[i]);
		}
	}
}
