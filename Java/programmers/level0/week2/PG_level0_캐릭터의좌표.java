package level0.week2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class PG_level0_캐릭터의좌표 {

	// public static int[] dx = { -1, 1, 0, 0 };
	// public static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = null;

		int k = Integer.parseInt(br.readLine());
		String[] keyinput = new String[k];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < keyinput.length; i++) {
			keyinput[i] = st.nextToken();
		}

		int[] board = new int[2];

		st = new StringTokenizer(br.readLine());

		board[0] = Integer.parseInt(st.nextToken());
		board[1] = Integer.parseInt(st.nextToken());

		int[] result = solution(keyinput, board);

		bw.write(result[0] + " " + result[1] + "\n");

		bw.flush();
		bw.close();

	}

//	public static int[] solution(String[] keyinput, int[] board) {
//		int[] answer = new int[] { 0, 0 };
//
//		for (int i = 0; i < keyinput.length; i++) {
//			if (keyinput[i].equals("up")) {
//				int ny = answer[1] + 1;
//
//				if (ny <= board[1] / 2) {
//					answer[1] = ny;
//				}
//			} else if (keyinput[i].equals("down")) {
//				int ny = answer[1] - 1;
//
//				if (ny >= (-1 * board[1] / 2)) {
//					answer[1] = ny;
//				}
//			} else if (keyinput[i].equals("left")) {
//				int nx = answer[0] - 1;
//
//				if (nx >= (-1 * board[0] / 2)) {
//					answer[0] = nx;
//				}
//			} else if (keyinput[i].equals("right")) {
//				int nx = answer[0] + 1;
//
//				if (nx <= (board[0] / 2)) {
//					answer[0] = nx;
//				}
//			}
//		}
//		return answer;

	static int[] dx = { -1, 1, 0, 0 }; // L, R, U, D
	static int[] dy = { 0, 0, 1, -1 };
	static String[] move_types = { "left", "right", "up", "down" };

	public static int[] solution(String[] keyinput, int[] board) {
		int x = 0;
		int y = 0;


		for (int i = 0; i < keyinput.length; i++) {
			String element = keyinput[i];
			
			int nx = 0;
			int ny = 0;
			
			for (int j = 0; j < move_types.length; j++) {

				// 이동 후 좌표 구하기
				if (element.equals(move_types[j])) {
					nx = x + dx[j];
					ny = y + dy[j];
					
				}

			}
			// 공간을 벗어나는 경우 무시
			if (nx < -1 * (board[0] / 2) || ny < -1 * (board[1] / 2) 
					|| nx > (board[0] / 2) || ny > (board[1] / 2))
				continue;

			// 이동 수행
			x = nx;
			y = ny;

		}

		int[] answer = { x, y };
		return answer;

	}

}
