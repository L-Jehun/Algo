package com.ssafy.hwalgo17;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
 
class Pos {
    int x;
    int y;
    
    public Pos(int x,int y) {
        this.x = x;
        this.y = y;
    }
}

public class Baek_10026 {
    static char[][] map;
    static boolean[][] isVisited;
    
    static int[] dx = {-1,0,1, 0};//북동남서
    static int[] dy = { 0,1,0,-1};
    static int N, cnt1 = 0, cnt2 = 0;
    
    static Queue<Pos> q = new LinkedList<Pos>();
           
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        
        map = new char[N][N];
        isVisited = new boolean[N][N];
        //Case 1 정상
        for(int i=0; i<N; i++) {
            char[] str = br.readLine().toCharArray();
            for(int j=0; j<N; j++) {
                map[i][j] = str[j];
            }
        }
        
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(!isVisited[i][j]) {
                    bfs(new Pos(i,j));
                    cnt1++;
                }
            }
        }
        //case2 적록
        isVisited = new boolean[N][N];
        
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(map[i][j] == 'R') {
                    map[i][j] = 'G';
                }
            }
        }
        
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(!isVisited[i][j]) {
                    bfs(new Pos(i,j));
                    cnt2++;
                }
            }
        }
        
        
        //출력
        System.out.println(cnt1 + " " + cnt2);
    }
    
    static void bfs(Pos d) {
        char color = map[d.x][d.y];
        isVisited[d.x][d.y] = true;
        q.add(d);
 
 
        while(!q.isEmpty()) {
            Pos t = q.remove();
            int x1 = t.x;
            int y1 = t.y;
            
            for(int i=0; i<4; i++) {
                int x2 = x1 + dx[i];
                int y2 = y1 + dy[i];
                
                if(x2 >= 0 && x2 < N && y2 >= 0 && y2 < N && map[x2][y2] == color && !isVisited[x2][y2]) {//범위안 , 색같 , 이미 방문X
                    q.add(new Pos(x2,y2));
                    isVisited[x2][y2] = true;
                }
                    
            }
        }
    }
}
 
