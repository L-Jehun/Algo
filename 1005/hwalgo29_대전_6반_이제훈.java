import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Main {
 
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); //접시 수
        int d = Integer.parseInt(st.nextToken()); // 초밥 가짓수
        int k = Integer.parseInt(st.nextToken()); // 연속해서 먹는 접시의 수
        int c = Integer.parseInt(st.nextToken()); // 쿠폰 번호
        int[] temp = new int[d + 1];
        int[] arr = new int[N];
        int cnt = 0, max;
        
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }   
        for (int i = 0; i < k; i++) {
            if (temp[arr[i]] == 0) cnt++;
            temp[arr[i]]++;
        }
        max = cnt;
 
        for (int i = 1; i < N; i++) {
            if (max <= cnt) {
                if (temp[c] == 0) max = cnt + 1;
                else max = cnt;
            }
            temp[ arr[i-1] ]--;
            if (temp[arr[i-1]] == 0) cnt--;
            if (temp[arr[(i+k-1) % N]] == 0) cnt++;
            temp[arr[(i+k-1)%N]]++;
        }    
        System.out.println(max);
    }
}
       
     