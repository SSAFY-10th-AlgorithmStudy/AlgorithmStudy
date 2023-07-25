package week6.day1;

import utils.PrintUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 접근법 : arraylist 형식으로 각 정점마다 add 하여 결과 출력할 때 해당 list를 돌면서 체크
 */
public class P_경로찾기_11403 {
    static ArrayList<Integer>[] list;
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        list = new ArrayList[n];


        for (int i = 0; i < n; i++) {
            list[i] = new ArrayList<Integer>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int data = Integer.parseInt(st.nextToken());
                if(data == 1) {
                    list[i].add(j);
                }
            }
        }

        BFS();
    }

    public static void BFS(){
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited;
        StringBuilder sb=  new StringBuilder();

        for (int i = 0; i < n; i++) {
            visited = new boolean[n];
            queue.add(i);
            while (!queue.isEmpty()){
                int cur = queue.poll();
                for( int temp : list[cur]){
                    if(visited[temp]){
                        continue;
                    }
                    visited[temp] = true;
                    queue.add(temp);
                }
            }
            for (int j = 0; j < n; j++) {
                if(visited[j]) sb.append("1 ");
                else sb.append("0 ");

            }sb.replace(2*n*(i+1)-1, 2*n*(i+1), "\n");

        }
        System.out.println(sb.toString());
    }

}
