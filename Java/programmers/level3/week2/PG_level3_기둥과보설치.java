package level3.week2;

import java.io.*;
import java.util.*;

public class PG_level3_기둥과보설치 {

    static Set<Structure> structures;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());

        int[][] build_frame = new int[k][4];
        for (int i = 0; i < k; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            build_frame[i][0] = Integer.parseInt(st.nextToken());
            build_frame[i][1] = Integer.parseInt(st.nextToken());
            build_frame[i][2] = Integer.parseInt(st.nextToken());
            build_frame[i][3] = Integer.parseInt(st.nextToken());
        }

        int[][] result = solution(n, build_frame);

        for (int[] res : result) {
            bw.write(res[0] + " " + res[1] + " " + res[2] + "\n");
        }

        bw.flush();
        br.close();
        bw.close();
    }

    public static int[][] solution(int n, int[][] build_frame) {
        structures = new HashSet<>();

        for (int[] b : build_frame) {
            int x = b[0];
            int y = b[1];
            int type = b[2]; // 0: 기둥, 1: 보
            int action = b[3]; // 0: 삭제, 1: 설치

            Structure structure = new Structure(x, y, type);

            if (action == 1) { // 설치
                // 설치 후 기둥과 보가 요건에 충족하는지 설치 후 충족하지 않는다면 다시 삭제
                structures.add(structure);
                if (!isValid()) structures.remove(structure);
            } else { // 삭제
                // 삭제 후 남은 기둥과 보가 요건에 충족하는지 확인 후 충족하지 않는다면 다시 설치
                structures.remove(structure);
                if (!isValid()) structures.add(structure);
            }
        }

        List<Structure> result = new ArrayList<>(structures);

        // return 하는 배열은 x좌표 기준으로 오름차순 정렬하며, x좌표가 같을 경우 y좌표 기준으로 오름차순 정렬해주세요.
        // x, y좌표가 모두 같은 경우 기둥이 보보다 앞에 오면 됩니다.
        result.sort((a, b) -> a.x == b.x ? (a.y == b.y ? a.type - b.type : a.y - b.y) : a.x - b.x);

        int[][] answer = new int[result.size()][3];
        for (int i = 0; i < result.size(); i++) {
            answer[i][0] = result.get(i).x;
            answer[i][1] = result.get(i).y;
            answer[i][2] = result.get(i).type;
        }

        return answer;
    }

    private static boolean isValid() {
        for (Structure s : structures) {
            if (s.type == 0 && !canConstructPillar(s.x, s.y)) return false;
            if (s.type == 1 && !canConstructBeam(s.x, s.y)) return false;
        }
        return true;
    }

    private static boolean canConstructPillar(int x, int y) {
        /*
            y = 0 // 기둥이 바닥에 설치되는 경우
            structures.contains(new Structure(x, y - 1, 0)) // 기둥 바로 아래(x, y-1)에 다른 기둥이 있는 경우
            structures.contains(new Structure(x - 1, y, 1)) // 기둥이 왼쪽 끝이 보와 연결되어 있는 경우
            structures.contains(new Structure(x, y, 1)) // 기둥이 오른쪽 끝이 보와 연결되어 있는 경우
         */
        return y == 0 || structures.contains(new Structure(x, y - 1, 0)) ||
                structures.contains(new Structure(x - 1, y, 1)) || structures.contains(new Structure(x, y, 1));
    }

    private static boolean canConstructBeam(int x, int y) {
        /*
            structures.contains(new Structure(x, y - 1, 0)) // 보의 왼쪽 끝(x, y - 1) 아래에 기둥이 있는 경우
            structures.contains(new Structure(x + 1, y - 1, 0)) // 보의 오른쪽 끝(x + 1, y - 1) 아래에 기둥이 있는 경우
            (structures.contains(new Structure(x - 1, y, 1)) && structures.contains(new Structure(x + 1, y, 1))) //보의 양쪽 끝이 다른 보와 연결되어 있는 경우
         */
        return structures.contains(new Structure(x, y - 1, 0)) || structures.contains(new Structure(x + 1, y - 1, 0)) ||
                (structures.contains(new Structure(x - 1, y, 1)) && structures.contains(new Structure(x + 1, y, 1)));
    }

    static class Structure {
        int x, y, type;

        Structure(int x, int y, int type) {
            this.x = x;
            this.y = y;
            this.type = type;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Structure structure = (Structure) o;
            return x == structure.x && y == structure.y && type == structure.type;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y, type);
        }
    }
}
