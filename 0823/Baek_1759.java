package com.ssafy.hwalgo15;
import java.util.*;
import java.io.*;

class Baek_1759 {
    	static char[] words;
    	static int L,C;
    	static boolean[] isSelected;
    public static void main(String[] args) throws NumberFormatException, IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
 
    	L = Integer.parseInt(st.nextToken());
    	C = Integer.parseInt(st.nextToken());
    	
    	isSelected= new boolean[C];
    	words = new char[C];
    	st = new StringTokenizer(br.readLine());
    	for(int i=0;i<C;i++) {
    		words[i]=st.nextToken().charAt(0);
    	}
    	Arrays.sort(words);
    	Combination(0,0);
    }
	private static void Combination(int cnt, int start) {
		if(cnt == L) {
			StringBuilder sb = new StringBuilder();
			int ja =0,mo=0;
			for(int i=0;i<C;i++) {
				if(isSelected[i]) {
					sb.append(words[i]);
					if(words[i]=='a'||words[i]=='i'||words[i]=='o'||words[i]=='e'||words[i]=='u') {
						ja++;
					}else {
						mo++;
					}
				}
			}
			if(ja>=1 && mo >= 2) System.out.println(sb);
		}
		for(int i=start;i<C;i++) {
			isSelected[i]=true;
			Combination(cnt+1, i+1);
			isSelected[i]=false;
		}
	}
}