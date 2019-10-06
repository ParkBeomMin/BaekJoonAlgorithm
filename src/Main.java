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
		Point[] points = new Point[n];
		for(int i = 0; i < n; i++) {
			String[] input = br.readLine().split(" ");
			points[i] = new Point(Integer.parseInt(input[0]), Integer.parseInt(input[1]));
		}
		Arrays.sort(points);
		for(int i = 0; i < n; i++) {
			System.out.println(points[i].x + " " + points[i].y);
		}

		bw.close();
		br.close();
	}

	static class Point implements Comparable<Point> {
		int x;
		int y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public int compareTo(Point o) {
			if (this.x >= o.x) {
				if (this.x == o.x) {
					if (this.y >= o.y) {
						return 1;
					} else {
						return -1;
					}
				} else {
					return 1;
				}

			} else {
				return -1;
			}
		}
	}
}
