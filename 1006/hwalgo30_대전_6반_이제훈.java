import java.io.*;
import java.util.StringTokenizer;
     
public class Solution {

	static int[][] arr1;
	static int[][] arr2;
	static int N, X, cnt;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		for (int tc = 1; tc <= T; tc++) {
			
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			X = Integer.parseInt(st.nextToken());
			arr1 = new int[N][N];
			arr2 = new int[N][N];
			cnt= 0;
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					int data = Integer.parseInt(st.nextToken());
					arr1[i][j] = data;
					arr2[j][i] = data;
				}
			}

			for (int i = 0; i < N; i++) {
				if (checked(arr1, i)) cnt++;
				if (checked(arr2, i)) cnt++;	
			}
			System.out.println("#" + tc + " " + cnt);
		}
	}

	private static boolean checked(int[][] map, int idx) {
		int cnt= 1;
		int height = map[idx][0];

		for (int i = 1; i < N; i++) {
			if (height == map[idx][i]) cnt++;
			else if (map[idx][i] - height == 1) {
				if (cnt< X) return false;
				 else {
					cnt= 1;
					height = map[idx][i];
				}
			}else if (height - map[idx][i] == 1) {
				if (N < X + i) return false;
				
				for (int j = 1; j < X; j++) {
					if (height - map[idx][++i] != 1) return false;
				}
				height = map[idx][i];
				cnt= 0;
			} else return false;
		}
		return true;
	}
}