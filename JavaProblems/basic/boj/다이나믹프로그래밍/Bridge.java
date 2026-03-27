package boj.다이나믹프로그래밍;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bridge {

  // N, M이 최대 29이므로 30 크기의 DP 테이블 생성
  static int[][] dp = new int[30][30];

  public static void main(String[] args) throws IOException {

    /*
    * 문제 : 다리 놓기 / 실버 5 / 시간 제한 : 0.5초 / 메모리 제한 : 128MB
    *
    * 재원이는 한 도시의 시장이 되었다.
    * 이 도시에는 도시를 동쪽과 서쪽으로 나누는 큰 일직선 모양의 강이 흐르고 있다. 하지만 재원이는 다리가 없어서 시민들이 강을 건너는데 큰 불편을 겪고 있음을 알고 다리를 짓기로 결심하였다.
    * 강 주변에서 다리를 짓기에 적합한 곳을 사이트라고 한다. 재원이는 강 주변을 면밀히 조사해 본 결과 강의 서쪽에는 N개의 사이트가 있고 동쪽에는 M개의 사이트가 있다는 것을 알았다. (N ≤ M)
    * 재원이는 서쪽의 사이트와 동쪽의 사이트를 다리로 연결하려고 한다. (이때 한 사이트에는 최대 한 개의 다리만 연결될 수 있다.)
    * 재원이는 다리를 최대한 많이 지으려고 하기 때문에 서쪽의 사이트 개수만큼 (N개) 다리를 지으려고 한다.
    * 다리끼리는 서로 겹쳐질 수 없다고 할 때 다리를 지을 수 있는 경우의 수를 구하는 프로그램을 작성하라.
    *
    * 입력
    * 입력의 첫 줄에는 테스트 케이스의 개수 T가 주어진다. 그 다음 줄부터 각각의 테스트케이스에 대해 강의 서쪽과 동쪽에 있는 사이트의 개수 정수 N, M (0 < N ≤ M < 30)이 주어진다.
    *
    * 출력
    * 각 테스트 케이스에 대해 주어진 조건하에 다리를 지을 수 있는 경우의 수를 출력한다.
    *
    * 예제 입력
    * 3
    * 2 2
    * 1 5
    * 13 29
    *
    * 예제 출력
    * 1
    * 5
    * 67863915
    * */

    /*
    * 파스칼의 삼각형 공식(nCr = n-1Cr-1 + n-1Cr)
    * https://namu.wiki/w/%ED%8C%8C%EC%8A%A4%EC%B9%BC%EC%9D%98%20%EC%82%BC%EA%B0%81%ED%98%95
    *  */

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    // DP 테이블 초기화 (파스칼의 삼각형처럼 만들기)
    for (int i = 0; i < 30; i++) {
      dp[i][i] = 1;
      dp[i][0] = 1;
    }

    for (int i = 2; i < 30; i++) {
      for (int j = 1; j < i; j++) {
        // nCr = n-1Cr-1 + n-1Cr
        dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
      }
    }

    int t = Integer.parseInt(br.readLine());
    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < t; i ++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int n = Integer.parseInt(st.nextToken());
      int m = Integer.parseInt(st.nextToken());

      // mCn 구하기
      sb.append(dp[m][n]).append('\n');
    }
    System.out.print(sb);
  }
}


/* 재귀 호출 방법
* // 값을 저장할 메모이제이션 배열
    static int[][] memo = new int[30][30];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            // mCn 구하기 (동쪽 m개 중 서쪽 n개 선택)
            sb.append(combination(m, n)).append("\n");
        }
        System.out.print(sb);
    }

    static int combination(int m, int n) {
        // 1. 이미 계산된 값이 있다면 바로 반환 (Memoization)
        if (memo[m][n] > 0) {
            return memo[m][n];
        }

        // 2. 기저 조건 (Base Case)
        // n개를 다 뽑았거나, 뽑을 개수가 없는 경우 (1가지)
        if (n == m || n == 0) {
            return memo[m][n] = 1;
        }

        // 3. 재귀 호출 (점화식)
        return memo[m][n] = combination(m - 1, n - 1) + combination(m - 1, n);
    }
*
* */