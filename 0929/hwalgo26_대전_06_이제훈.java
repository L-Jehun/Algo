import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
		static int N,M;
		static ArrayList<Integer> [] big;
		static int[] count;
		static int temp;
		static boolean[] isVisited;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
	        for (int tc = 1; tc <= T; tc++) {
	        	N = Integer.parseInt(br.readLine()); // 학생 수
	            M = Integer.parseInt(br.readLine()); // 관계 수
	            
	            big=new ArrayList[N+1];
	            count = new int[N+1];
	            for (int i = 1; i <N+1; i++) {
					big[i]=new ArrayList<>();
				}
	            for (int i = 0; i < M; i++) {
	            	st = new StringTokenizer(br.readLine());
					int a=Integer.parseInt(st.nextToken());
					int b=Integer.parseInt(st.nextToken());
					big[a].add(b);
				}
	            for (int i = 1; i <=N; i++) {
					temp=0;
					isVisited=new boolean[N+1];
					dfs(i,i);
					count[i]+=temp;//나보다 큰 애들 
				}
	            
	            int total=0;
				for (int i = 1; i <=N; i++) {
//					System.out.print(count[i]+" ");
					if(count[i]==N)total+=1;
				}
				System.out.printf("#%d %d\n",tc,total);
	            
	        }
	}
	private static void dfs(int current, int start) {
		// TODO Auto-generated method stub
		temp+=1;
		for (int i = 0; i < big[current].size(); i++) {
			int next=big[current].get(i);
			if(isVisited[next])continue;
			isVisited[next]=true;
			count[next]+=1;
			dfs(next,start);
		}
	}
}