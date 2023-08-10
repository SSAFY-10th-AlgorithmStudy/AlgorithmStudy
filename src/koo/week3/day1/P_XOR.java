package koo.week3.day1;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 연속된 부분수열 고르기
 * 부분수열에 들어있는 모든 원소를 XOR 연산
 *
 */
public class P_XOR {
    static int m;
    static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        while(n>0){
            answer = 0;
            m = Integer.parseInt(br.readLine());
//            StringBuilder sb = new StringBuilder();
            StringTokenizer st = new StringTokenizer(br.readLine());
//            String[] str = new String[m];
            int[] arr = new int[m];
            for (int i = 0; i < m; i++) {
//                sb.setLength(0);
                int x = Integer.parseInt(st.nextToken());
                arr[i] = x;
//                for (int j = 31; j >= 0 ; j--) {
//                    int mask = 1 << j;
//                    sb.append((x & mask) != 0 ? 1 : 0);
//                }
//                str[i] = sb.toString();
//            }
//            for(String s : str){
//                System.out.println(s);
            }
            perm(0,arr,0);
            System.out.println(answer);
            n--;
        }


    }
    public static void perm(int target, int[] arr,int index){
        if(target == m && index == m){
            return;
        }
        if(target == m){
            perm(0,arr,index+1);
            return;
        }
        System.out.println("target = " + target + " index = "+ index);
        int result = 0;
        if(target == index){
            result = arr[index];
        }else {
            for (int end = index; end <= target; end++) {
                result = result ^ arr[end];
            }
        }
        answer = Math.max(result,answer);
        perm(target+1,arr,index);
    }

}