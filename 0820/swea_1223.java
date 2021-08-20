package com.ssafy.hwalgo14;

import java.io.*;
import java.util.*;

class swea_1223 {	

	// 1. 중위식을 후위식 바꾸기( String 2개 선언)
	// 2. 숫자가 나오면 스택에 넣고 연산자가 나오면 숫자 2개를 pop 하여 결과를 다시 push

	public static void main(String []args) throws NumberFormatException, IOException {
		BufferedReader br = new  BufferedReader(new InputStreamReader(System.in));
		Stack<Character> op = new Stack<>(); // 연산자 저장
		Stack<Integer> num = new Stack<>();
		
		for(int test_case=1;test_case<=10;test_case++) {
			int N = Integer.parseInt(br.readLine());
			String sik = br.readLine();
			String sik2 = "";
			
			for (int i=0;i<sik.length();i++) { //후위식 으로 변환
				char c = sik.charAt(i);
				if(0<=c-'0' && c-'0'<=9) sik2 += c; //숫자 일때 넣기 0~9인 정수 
				else { // 숫자가 아니면
					if(c=='*') op.push(c); //곱 일 경우
					
					else {
						while(!op.isEmpty() && (op.peek()=='*' || op.peek()=='+')){
							sik2+=op.pop();
						}
						op.push(c);
					}
				}
			}		
			while(!op.isEmpty()) sik2 += op.pop(); //연산자 출력
			
			for (int i=0;i<N;i++) {
				char c = sik2.charAt(i);
				if(0<=c-'0' && c-'0'<=9) num.push(c-'0');
				else {
					int num1 = num.pop();
					int num2 = num.pop();
					
					if(c=='*') num.push(num1*num2);
					else if(c=='+') num.push(num1+num2);
				}
			}
			System.out.printf("#"+test_case+" "+num.pop());	
			
			
		}
	
	}
}


