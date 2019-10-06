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
		User[] users = new User[n];
		for (int i = 0; i < n; i++) {
			String[] input = br.readLine().split(" ");
			users[i] = new User(i, Integer.parseInt(input[0]), input[1]);
		}
		Arrays.sort(users);
		for (int i = 0; i < users.length; i++) {
			bw.write(users[i].age + " " + users[i].name + "\n");
		}

		bw.close();
		br.close();
	}

	static class User implements Comparable<User> {
		int num;
		int age;
		String name;

		public User(int num, int age, String name) {
			this.num = num;
			this.age = age;
			this.name = name;
		}

		@Override
		public int compareTo(User o) {
			if (this.age >= o.age) {
				if (this.age == o.age) {
					if (this.num >= o.num) {
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
