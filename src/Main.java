import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		InputStreamReader k = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(k);
		String[] input = br.readLine().split(" ");
		int n = Integer.parseInt(input[0]);
		int m = Integer.parseInt(input[1]);
		int result = 51;
		char[][] board = new char[n][m];
		String[] whiteBoard = { "WBWBWBWB", "BWBWBWBW", "WBWBWBWB", "BWBWBWBW", "WBWBWBWB", "BWBWBWBW", "WBWBWBWB",
				"BWBWBWBW" };
		String[] blackBoard = { "BWBWBWBW", "WBWBWBWB", "BWBWBWBW", "WBWBWBWB", "BWBWBWBW", "WBWBWBWB", "BWBWBWBW",
				"WBWBWBWB", };
		for (int i = 0; i < n; i++) {
			String data = br.readLine();
			for (int j = 0; j < m; j++) {
				board[i][j] = data.charAt(j);
			}
		}
		for (int i = 0; i + 7 < n; i++) {
			for (int j = 0; j + 7 < m; j++) {
				result = Math.min(result, Math.min(check(i, j, board, whiteBoard), check(i, j, board, blackBoard)));
			}
		}
		System.out.print(result);
	}

	static int check(int x, int y, char[][] board, String[] checkBoard) {
		int cnt = 0;
		for (int i = x; i < x + 8; i++) {
			for (int j = y; j < y + 8; j++) {
				if (board[i][j] != checkBoard[i - x].charAt(j - y)) {
					cnt++;
				}
			}
		}
		return cnt;
	}
}
