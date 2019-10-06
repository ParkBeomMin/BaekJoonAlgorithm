import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		MyWord[] words = new MyWord[n];
		for (int i = 0; i < n; i++) {
			String input = br.readLine();
			words[i] = new MyWord(input);
		}
		Arrays.sort(words);
		for (int i = 0; i < words.length; i++) {
			String tmp = words[0].word;
			if(i == 0) {
				bw.write(words[i].word + "\n");
			}
			if (i > 0){
				tmp = words[i - 1].word;
				if (!tmp.equals(words[i].word)) {
					bw.write(words[i].word + "\n");
				}
			}
		}

		bw.close();
		br.close();
	}

	static class MyWord implements Comparable<MyWord> {
		String word;

		public MyWord(String word) {
			this.word = word;
		}

		@Override
		public int compareTo(MyWord o) {
			if (this.word.length() >= o.word.length()) {
				if (this.word.length() == o.word.length()) {
					return this.word.compareTo(o.word);
				} else {
					return 1;
				}
			} else {
				return -1;
			}
		}
	}
}
