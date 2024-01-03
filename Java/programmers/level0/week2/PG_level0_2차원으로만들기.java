package level0.week2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class PG_level0_2차원으로만들기 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		 
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		 
		int k = Integer.parseInt(br.readLine());
		 
		int[] num_list = new int[k];
		 
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < num_list.length; i++) {
			num_list[i] = Integer.parseInt(st.nextToken());
		}
		 
		int n = Integer.parseInt(br.readLine());
		 
		int[][] result = solution(num_list, n);
		
		for (int i = 0; i < result.length; i++) {
			for (int j = 0; j < result[i].length; j++) {
				sb.append(result[i][j]);
			}
		}

		bw.write(result + "\n");
		
		bw.flush();
		bw.close();

	}
	
    public static int[][] solution(int[] num_list, int n) {
        int[][] answer = new int[num_list.length / n][n];
        
        int idx = 0;
        for (int i = 0; i < num_list.length / n; i++) {
			for (int j = 0; j < n; j++) {
				answer[i][j] = num_list[idx++];
			}
		}
        
//        for(int i=0; i<length; i++){
//            answer[i/n][i%n]=num_list[i];
//        }
        
        return answer;
    }

}
