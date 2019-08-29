import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		int K = scan.nextInt();
		double preference[] = new double[N];
		for (int i = 0; i < N; i++) {
			preference[i] = scan.nextDouble();
		}
		scan.close();
		double result = Double.MAX_VALUE;

		for (int i = K; i <= N; i++) {
			for (int j = 0; j <= N - i; j++) {
				double m = getM(preference, j, i);
				double b = getB(preference, m, j, i);
				result = Math.min(result, b);
			}
		}
		result = Double.parseDouble(String.format("%.11f", result));
		System.out.print(result);

	}

	public static double getM(double[] preference, int pivot, int K) { // 평균구하기
		double sum = 0.0;
		for (int i = 0; i < K; i++) {
			sum += preference[pivot + i];
		}
		return sum / K;
	}

	public static double getB(double[] preference, double m, int pivot, int K) {
		double sum = 0.0;
		for (int i = 0; i < K; i++) {
			sum += Math.pow((preference[pivot + i] - m), 2);
		}
		return Math.sqrt((sum / K));
	}
}
