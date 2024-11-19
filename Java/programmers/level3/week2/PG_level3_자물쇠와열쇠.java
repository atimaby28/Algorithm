package level3.week2;

public class PG_level3_자물쇠와열쇠 {
    public boolean solution(int[][] key, int[][] lock) {
        int M = key.length;
        int N = lock.length;
        int expandSize = N + 2 * (M - 1);

        // 확장된 자물쇠 배열 생성
        int[][] expandedLock = new int[expandSize][expandSize];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                expandedLock[M - 1 + i][M - 1 + j] = lock[i][j];
            }
        }

        // 모든 회전 및 이동 조합 탐색
        for (int rotation = 0; rotation < 4; rotation++) {
            key = rotateKey(key); // 열쇠를 90도 회전
            for (int x = 0; x <= expandSize - M; x++) {
                for (int y = 0; y <= expandSize - M; y++) {
                    // 열쇠를 현재 위치에 맞추고 확인
                    if (tryKey(expandedLock, key, x, y, N)) {
                        return true;
                    }
                }
            }
        }

        return false; // 모든 조합 실패
    }

    // 열쇠를 시계 방향으로 90도 회전
    private int[][] rotateKey(int[][] key) {
        int M = key.length;
        int[][] rotatedKey = new int[M][M];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < M; j++) {
                rotatedKey[j][M - 1 - i] = key[i][j];
            }
        }
        return rotatedKey;
    }

    // 현재 열쇠 위치로 자물쇠를 열 수 있는지 확인
    private boolean tryKey(int[][] expandedLock, int[][] key, int startX, int startY, int lockSize) {
        int M = key.length;

        // 열쇠 적용
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < M; j++) {
                expandedLock[startX + i][startY + j] += key[i][j];
            }
        }

        // 자물쇠 영역 검증
        boolean isUnlocked = true;
        for (int i = 0; i < lockSize; i++) {
            for (int j = 0; j < lockSize; j++) {
                if (expandedLock[M - 1 + i][M - 1 + j] != 1) {
                    isUnlocked = false;
                    break;
                }
            }
            if (!isUnlocked) break;
        }

        // 열쇠 제거 (원상복구)
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < M; j++) {
                expandedLock[startX + i][startY + j] -= key[i][j];
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