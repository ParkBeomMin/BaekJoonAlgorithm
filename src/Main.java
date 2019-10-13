import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int n = Integer.parseInt(input[0]);
		int m = Integer.parseInt(input[1]);
		int[] visited = new int[n+1];
		int[] arr = new int[m];
		makeSequence(arr, 0, visited, n, m);
		br.close();
	}
	
	static void makeSequence(int[] arr, int index, int[] visited, int n, int m) {
		if(index == m) {
			for(int i = 0; i < arr.length; i++) {
				System.out.print(arr[i] + " ");
			}
			System.out.println();
		}else {
			for(int i = 1; i <= n; i++) {
				if(visited[i] == 0) { // 방문하지 않았다면 
					visited[i] = 1;
					arr[index] = i;
					makeSequence(arr, index+1, visited, n, m);
					visited[i] = 0;
				}
			}
		}
	}
}
