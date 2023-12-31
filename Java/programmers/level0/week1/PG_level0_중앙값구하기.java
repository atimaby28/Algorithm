package level0.week1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class PG_level0_중앙값구하기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = null;
		
		int k = Integer.parseInt(br.readLine());
		
		int[] array = new int[k];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < array.length; i++) {
			array[i] = Integer.parseInt(st.nextToken());
		}
		
		int result = solution(array);
		
		bw.write(result + "\n");
		
		bw.flush();
		bw.close();

	}
	
    public static int solution(int[] array) {
        int answer = 0;
        
        Arrays.sort(array);

        answer = array[array.length / 2];
        
        return answer;
    }

}