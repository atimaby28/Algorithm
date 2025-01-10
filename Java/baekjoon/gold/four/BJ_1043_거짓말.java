package gold.four;

import java.io.*;
import java.util.*;

public class BJ_1043_거짓말 {

    static int[] parent; // 유니온-파인드 부모 배열

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 사람 수
        int m = Integer.parseInt(st.nextToken()); // 파티 수

        parent = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i; // 초기화: 각 사람은 자기 자신이 부모
        }

        // 진실을 아는 사람들 입력 처리
        st = new StringTokenizer(br.readLine());
        int truthCount = Integer.parseInt(st.nextToken());
        List<Integer> truths = new ArrayList<>();
        for (int i = 0; i < truthCount; i++) {
            truths.add(Integer.parseInt(st.nextToken()));
        }

        // 파티 입력 처리
        List<List<Integer>> parties = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int partySize = Integer.parseInt(st.nextToken());
            List<Integer> party = new ArrayList<>();
            for (int j = 0; j < partySize; j++) {
                party.add(Integer.parseInt(st.nextToken()));
            }
            parties.add(party);
        }

        // 과장된 이야기를 할 수 있는 파티 수 계산
        int result = solution(parties, truths);

        bw.write(result + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    private static int solution(List<List<Integer>> parties, List<Integer> truths) {
        // 유니온-파인드로 파티 참석자 연결
        for (List<Integer> party : parties) {
            for (int i = 1; i < party.size(); i++) {
                union(party.get(0), party.get(i));
            }
        }

        // 진실을 아는 사람 그룹 확장
        for (int i = 1; i < truths.size(); i++) {
            union(truths.get(0), truths.get(i));
        }

        int truthRoot = truths.isEmpty() ? -1 : find(truths.get(0));

        // 과장된 이야기를 할 수 있는 파티 계산
        int count = 0;
        for (List<Integer> party : parties) {
            boolean canLie = true;
            for (int person : party) {
                if (find(person) == truthRoot) {
                    canLie = false;
                    break;
                }
            }
            if (canLie) count++;
        }

        return count;
    }

    // 유니온-파인드: find 함수
    static int find(int x) {
        if (x == parent[x]) return x;
        return parent[x] = find(parent[x]); // 경로 압축
    }

    // 유니온-파인드: union 함수
    static void union(int x, int y) {
        int fx = find(x);
        int fy = find(y);

        if (fx != fy) {
            parent[fy] = fx;
        }
    }
}
