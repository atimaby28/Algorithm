package level3.week2;

import java.io.*;
import java.util.StringTokenizer;

public class PG_level3_자물쇠와열쇠 {

    static int lockSize, keySize;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] key = new int[n][m];
        int[][] lock = new int[n][m];


        for (int i = 0; i < key.length; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < key[i].length; j++) {
                key[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < lock.length; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < lock[i].length; j++) {
                lock[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        boolean result = solution(key, lock);

        bw.write(result + "\n");

        bw.flush();
        br.close();
        bw.close();
    }

    public static boolean solution(int[][] key, int[][] lock) {
        boolean answer = false;

        keySize = key.length;
        lockSize = lock.length;

        int expandSize = (lockSize - 1) * 2 + keySize;

        // 1. 확장된 자물쇠 배열 생성
        int[][] expandLock = new int[expandSize][expandSize];

        // 확장 자물쇠 배열에 기존 자물쇠를 옮길 때 주의 해야 할 것은
        // 배열을 순회하는 것은 lockSize가 맞지만, 시작 위치를 잡을 때는 keySize를 사용해서 잡아야 한다
        // 확장 자물쇠 배열은 키 크기의 우 하단 1 x 1을 자물쇠에 걸쳤을 경우부터 시작하기 때문
        for(int i = 0; i < lockSize; i++) {
            for(int j = 0; j < lockSize; j++) {
                expandLock[keySize + i - 1][keySize + j - 1] = lock[i][j];
            }
        }

        // 2. 모든 회전 및 이동 조합 탐색
        for(int rotation = 0; rotation < 4; rotation++) {
            key = rotateKey(key);
            for(int i = 0; i < expandSize - keySize + 1; i++) {
                for(int j = 0; j < expandSize - keySize + 1; j++) {
                    if (tryKey(expandLock, key, i, j)) {
                        return true;
                    }
                }
            }
        }

        return answer;
    }

    // 3. 시계방향으로 90도 회전하는 배열
    private static int[][] rotateKey (int[][] key) {
        int[][] rotatedKey = new int[keySize][keySize];

        for(int i = 0; i < keySize; i++) {
            for(int j = 0; j < keySize; j++) {
                rotatedKey[j][keySize - i - 1] = key[i][j];
            }
        }

        return rotatedKey;
    }

    // 4. 회전한 키를 확장 배열에 맞춰보는 함수
    private static boolean tryKey(int[][] expandedLock, int[][] key, int y, int x) {
        // 열쇠 적용
        for (int i = 0; i < keySize; i++) {
            for (int j = 0; j < keySize; j++) {
                expandedLock[y + i][x + j] += key[i][j];
            }
        }

        // 자물쇠 영역 검증
        boolean isUnlocked = true;
        for (int i = 0; i < lockSize; i++) {
            for (int j = 0; j < lockSize; j++) {
                if (expandedLock[keySize + i - 1][keySize + j - 1] != 1) {
                    isUnlocked = false;
                    break;
                }
            }
            if (!isUnlocked)
                break;
        }

        // 키를 사용하기 전 상태 확장 배열 복구
        for (int i = 0; i < keySize; i++) {
            for (int j = 0; j < keySize; j++) {
                expandedLock[y + i][x + j] -= key[i][j];
            }
        }

        return isUnlocked;
    }
}


/*
3 3
[[0, 0, 0], [1, 0, 0], [0, 1, 1]]
[[1, 1, 1], [1, 1, 0], [1, 0, 1]]
 */

/*
true
 */