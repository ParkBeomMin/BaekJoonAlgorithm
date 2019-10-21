import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		int n = Integer.parseInt(br.readLine());
		int[][] paper = new int[n][n];
		int[] cnt = new int[3];
		for (int i = 0; i < n; i++) {
			String[] input = br.readLine().split(" ");
			for (int j = 0; j < n; j++) {
				paper[i][j] = Integer.parseInt(input[j]);
			}
		}
		cut(paper, cnt);
		System.out.println(cnt[0]);
		System.out.println(cnt[1]);
		System.out.println(cnt[2]);
	}

	static void cut(int[][] paper, int[] cnt) {
		if (!isCut(paper, -1)) {
			cnt[0]++;
		} else if (!isCut(paper, 0)) {
			cnt[1]++;
		} else if (!isCut(paper, 1)) {
			cnt[2]++;
		} else {
			cut(cut(paper, 0, paper.length / 3, 0, paper.length / 3), cnt); // 좌상단
			cut(cut(paper, 0, paper.length / 3, paper.length / 3, 2 * paper.length / 3), cnt); // 중상단
			cut(cut(paper, 0, paper.length / 3, 2 * paper.length / 3, paper.length), cnt); // 우상단
			cut(cut(paper, paper.length / 3, 2 * paper.length / 3, 0, paper.length / 3), cnt); // 좌중단
			cut(cut(paper, paper.length / 3, 2 * paper.length / 3, paper.length / 3, 2 * paper.length / 3), cnt); // 중중단
			cut(cut(paper, paper.length / 3, 2 * paper.length / 3, 2 * paper.length / 3, paper.length), cnt); // 우중단
			cut(cut(paper, 2 * paper.length / 3, paper.length, 0, paper.length / 3), cnt); // 좌하단
			cut(cut(paper, 2 * paper.length / 3, paper.length, paper.length / 3, 2 * paper.length / 3), cnt); // 중하단
			cut(cut(paper, 2 * paper.length / 3, paper.length, 2 * paper.length / 3, paper.length), cnt); // 우하단

		}
	}

	static int[][] cut(int[][] paper, int rStart, int rEnd, int cStart, int cEnd) {
		int[][] returnArr = new int[paper.length / 3][paper.length / 3];
		for (int i = rStart; i < rEnd; i++) {
			for (int j = cStart; j < cEnd; j++) {
				returnArr[i - rStart][j - cStart] = paper[i][j];
			}
		}
		return returnArr;
	}

	static boolean isCut(int[][] paper, int option) {// false면 안자르고, true면 자르거
		boolean returnBool = true;
		for (int i = 0; i < paper.length; i++) {
			for (int j = 0; j < paper.length; j++) {
				if (paper[i][j] != option) {
					returnBool = false;
					break;
				}
			}
			if (!returnBool) {
				break;
			}
		}
		return !returnBool;
	}

}
