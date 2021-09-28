import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek_11401{
		static long MOD = 1000000007;
	public static void main(String[] args) throws IOException {
		//페르마의 소정리 + 거듭제곱 분할정복 + nCr 구하기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		System.out.println(nCr(N,K,MOD));
		}
	private static long nCr(int n, int k, long MOD) {
		if(k==0) {
            return 1;
        }
		long[] fac = new long[n+1];
		fac[0] = fac[1] = 1;
		for(int i=2;i<fac.length;i++) {
            fac[i] = (fac[i-1]*i)%MOD;
        }//펙토리얼 계산 끝
		long l1 = fac[n];
        long l2 = pow(fac[n-k],MOD-2); //페르마 소정리
        long l3 = pow(fac[k],MOD-2);// 페르마 소정리
        return ((l1*l2)%MOD*(l3)%MOD)%MOD;
	}
	static long pow(long a, long b) {// 거듭제곱 분할정복
        if(b==1) {
            return a;
        }
        long half = pow(a,b/2);
        if(b%2==0) {
            return (half*half)%MOD;
            
        }else {
            //나머지 연산의 분배 법칙
            return ((half*half)%MOD*(a)%MOD)%MOD;
        }
    }		
}
