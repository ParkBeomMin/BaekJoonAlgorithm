import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		String[] input = br.readLine().split(" ");
		int n = Integer.parseInt(input[0]);
		int feel = Integer.parseInt(input[1]);
		double good = 0;
		double bad = 0;
		double[] probs = new double[4];
		String[] probInput = br.readLine().split(" ");
		for (int i = 0; i < probs.length; i++) {
			probs[i] = Double.parseDouble(probInput[i]);
		}
		if (feel == 0) {// 좋은날
			good = probs[0];
			bad = probs[1];
		} else {
			good = probs[2];
			bad = probs[3];
		}

		for (int i = 0; i < n - 1; i++) {
			double goodTmp = good;
			double badTmp = bad;
			good = goodTmp * probs[0] + badTmp * probs[2];
			bad = goodTmp * probs[1] + badTmp * probs[3];
		}

		System.out.println(Math.round(good * 1000));
		System.out.println(Math.round(bad * 1000));
	}

}
