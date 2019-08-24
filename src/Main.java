import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		scan.close();
		int result = N;
	for(int i = 0; i < N; i++) {
		int sum = 0;
		if(i / 100000 != 0) {
			sum = i + (i / 100000) + ((i%100000)/10000) + ((i%10000)/1000) + ((i%1000)/100) + ((i%100)/10) + i%10;
		}else if(i / 10000 != 0) {
			sum = i + ((i%100000)/10000) + ((i%10000)/1000) + ((i%1000)/100) + ((i%100)/10) + i%10;
		}else if(i / 1000 != 0) {
			sum = i + ((i%10000)/1000) + ((i%1000)/100) + ((i%100)/10) + i%10;
		}else if(i / 100 != 0) {
			sum = i + ((i%1000)/100) + ((i%100)/10) + i%10;
		}else if( i / 10 != 0) {
			sum = i + ((i%100)/10) + i%10;
		}else {
			sum = i + i%10;
		}
		if(sum == N && result > i) {
			result = i;
		}
	}
	if(result == N) {
		result = 0;
	}
		System.out.print(result);
	}
}
