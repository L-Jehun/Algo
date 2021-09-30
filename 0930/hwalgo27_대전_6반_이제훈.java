import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	
	static class Pos {
		int y, x;
		public Pos(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}
	
	static  int[] dy = {-1, 0, 1, 0};
	static  int[] dx = {0, 1, 0, -1}; 
	static  int[][] Tunnel = {	
			{0, 0, 0, 0},
			{1, 1, 1, 1},	
			{1, 0, 1, 0},	
			{0, 1, 0, 1},	
			{1, 1, 0, 0},	
			{0, 1, 1, 0},	
			{0, 0, 1, 1},	
			{1, 0, 0, 1},	
	};
	static int N, M, R, C, L; //세로 가로  홀위치(RC) 소요된 시간
	static int[][] map;
	static boolean[][] isVisited;
	public static void main(String[] args) throws Exception {
		//한시간마다 한칸씩 주위로 퍼져나감
		//주의) L=1일 때 확인
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int t = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= t; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			map = new int[N][M];
			isVisited = new boolean[N][M];
			R = Integer.parseInt(st.nextToken());
			C= Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < M; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}	
			}//입력끝
			
			System.out.println("#" + tc + " " + bfs());
		}
	}
	private static int bfs() {
		int res =1;
		int hour =0;
		isVisited[R][C] = true;
		Queue<Pos> queue = new LinkedList<>();
		queue.offer(new Pos(R, C));
		while (!queue.isEmpty()) {
			if (hour == L - 1) break; //L=1일때 	
			int size = queue.size();
			while (size-- > 0) {
				Pos out = queue.poll();
				
				int[] dirs = Tunnel[map[out.y][out.x]];
				for (int dir = 0; dir < dirs.length; dir++) {
					if (dirs[dir] == 0) continue;
					int ny = out.y + dy[dir];
					int nx = out.x + dx[dir];
					if (ny < 0 || nx < 0 || ny >= N || nx >= M) continue;//맵 내부
					if (map[ny][nx] == 0) continue;							
					if (isVisited[ny][nx]) continue;							
					
					if (Tunnel[map[ny][nx]][(dir + 2) % 4] == 1) { 		
						isVisited[ny][nx] = true;
						queue.offer(new Pos (ny, nx));
						res++;
					}
				}
			}
			hour++;
		}
		return res;
	}
}