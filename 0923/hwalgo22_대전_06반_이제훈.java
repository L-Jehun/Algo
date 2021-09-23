import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
// 1. 행렬입력 DFS.
// 2. 출발 ~ 모든 도착지 DFS시작
// 3. COST 값 저장
// 4. 마지막 도착지 ~ 출발점 잇기
// 5. 가장 적은 COST 찾기
// 	 ※ cost>min return -> 가지치기
// 6. Cost 출력
public class JungOl_1681 {

	static int[][]arr;
    static boolean[]isVisited;
    static int min, sum, N;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        isVisited = new boolean[N];
        min = Integer.MAX_VALUE;
        
        for(int i=0;i<N;i++) {
        	StringTokenizer st =new StringTokenizer(br.readLine());
        	for(int j=0;j<N;j++) {
        		arr[i][j] = Integer.parseInt(st.nextToken());
        	}
        }
        	
        	isVisited[0]=true;
        	dfs(0,0,0);
        	System.out.println(min);
	}

	private static void dfs(int now, int sel, int cost) {
		if(cost>min)
			return;
		if(sel == N-1) {
			if(arr[now][0]==0) return;
			cost += arr[now][0];
			min = Math.min(cost, min);
			return;
		}
		
		for(int i=0;i<N;i++) {
			if(isVisited[i]) continue;
			if(arr[now][i]==0) continue;
			isVisited[i]=true;
			dfs(i,sel+1,cost+arr[now][i]);
			isVisited[i]=false;
		}
	}
}
