package greedy;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class 회의실배정 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = null;

        int n = Integer.parseInt(br.readLine());

        int[][] list = new int[n][2];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            list[i][0] = Integer.parseInt(st.nextToken());
            list[i][1] = Integer.parseInt(st.nextToken());
        }


        int result = solution(list);

        bw.write(result + "\n");

        bw.flush();
        bw.close();

    }

    private static int solution(int[][] list) {
        int answer = 0;

        ArrayList<Room> rooms = new ArrayList<>();

        for (int[] room : list) {
            rooms.add(new Room(room[0], room[1]));
        }

        Collections.sort(rooms);

        int endTime = Integer.MIN_VALUE;

        for (Room room : rooms) {
            if(room.start >= endTime) {
                endTime = room.end;
                answer++;
            }
        }

        return answer;
    }
}

class Room implements Comparable<Room>{
    int start, end;

    Room(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(Room r) {
        if(this.end == r.end) {
            return Integer.compare(this.start, r.start);
        } else {
            return Integer.compare(this.end, r.end);
        }
    }

}
/*
5
1 4
2 3
3 5
4 6
5 7
 */
