import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_7465 {

	static int[] parent;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st ;
		
		int T=Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++) {
			int N;
			int M;
			st = new StringTokenizer(br.readLine());
			N= Integer.parseInt(st.nextToken());
			M= Integer.parseInt(st.nextToken());
			parent = new int[N+1]; 
			boolean[] ans = new boolean[N+1]; 
			for(int i=1;i<=N;i++) parent[i]=i; //초기화
			for(int i=0;i<M;i++) {
				st = new StringTokenizer(br.readLine());
				int A = Integer.parseInt(st.nextToken());
				int B = Integer.parseInt(st.nextToken());
				if (find(A) != find(B)) {
					union(A,B);
				}
			}
			int cnt = 0;
			for(int i=1;i<=N;i++) {
				int A = find(i);
				if(!ans[A]) cnt++;
				ans[A]=true;
			}
			System.out.println("#"+tc+" "+cnt);
		}
	}
	static int find(int n) { // 재귀 이용 -> 루트 노드는 부모노드 번호로 자기 자신을 가진다.
		if(n==parent[n]) return n;
		else return parent[n] = find(parent[n]); //각 노드의 부모 노드를 찾아 올라간다.		
	}
	static void union(int n1,int n2) { // 각 원소가 속한 트리의 루트 노드를 찾는다.
		int p1 = find(n1);
		int p2 = find(n2);
		if (p1 != p2) parent[p2]=p1;
	}
}
	