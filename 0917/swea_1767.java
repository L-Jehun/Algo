import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
	static class Core {
		int y, x;

		public Core(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}
	private static int N, cell[][], minWireCnt, maxCore;
	private static int dx[] = {0, 0, -1, 1}; // 상 하 좌 우 
	private static int dy[] = {-1, 1, 0, 0};
	private static List<Core> list;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());

			cell = new int[N][N];
			list = new ArrayList<>();
			
			StringTokenizer st;
			for( int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					int core = Integer.parseInt(st.nextToken());
					if( core == 1) { 
						cell[i][j] = core;
						if(i == 0 || j == 0 || i == N-1 || j == N-1) {//가장자리에 붙어있을경우 리스트 추가 X
							continue;
						}
						list.add(new Core(i,j));
					}
				}
			}

			minWireCnt = Integer.MAX_VALUE;
			maxCore = Integer.MIN_VALUE;
			connect(0, 0, 0);

			System.out.println("#" + tc + " " + minWireCnt);
		} 

	}
	private static void connect(int idx, int corecnt, int wirecnt) { //dfs
		if(idx == list.size()) {
			if(maxCore < corecnt) { 
				maxCore = corecnt;
				minWireCnt = wirecnt;
			} else if( maxCore == corecnt) {
				minWireCnt = Math.min(wirecnt, minWireCnt);
			}
			return;
		}
		int x = list.get(idx).x;
		int y = list.get(idx).y;
		for( int dir = 0; dir < 4; dir++) {
			int count = 0;
			int nx = x;
			int ny = y;

			while( true ) {
				nx += dx[dir];
				ny += dy[dir];
				if(in(ny, nx)) break;	
				if(cell[ny][nx] == 1) {
					count = 0;
					break;
				}
				count++;
			}		
			int fill_x = x;
			int fill_y = y;
			for( int i = 0; i < count; i++) {
				fill_y += dy[dir];
				fill_x += dx[dir];
				cell[fill_y][fill_x] = 1;
			}

			
			if(count == 0) connect(idx+1, corecnt, wirecnt);
			else {
				connect(idx+1, corecnt+1, wirecnt+count);
				fill_x = x;
				fill_y = y;
				for( int i = 0; i < count; i++) {
					fill_y += dy[dir];
					fill_x += dx[dir];
					cell[fill_y][fill_x] = 0;
				}
			}
		}
	}

	private static boolean in(int ny, int nx) {//내부에 있는지 판별
		if(ny < 0 || ny >= N || nx < 0 || nx >= N) return true;
		return false;
	}
}