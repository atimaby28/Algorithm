package level0.week2;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

public class PG_level0_최빈값구하기 {

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
        
        HashMap<Integer, Integer> hsmap = new HashMap<>();
        
        for (int key : array) {
        	hsmap.put(key, hsmap.getOrDefault(key, 0) + 1);
		}
        

//		int max = Collections.max(hsmap.values());
//		int cnt = 0;
//		int result = 0;
//		for (Map.Entry<Integer, Integer> entry : hsmap.entrySet()) {
//			if (entry.getValue() == max) {
//				cnt++;
//				result = entry.getKey();
//			}
//		}
//		
//		answer = cnt == 1 ? result : -1;   
        
        return answer;
    }
    

}
