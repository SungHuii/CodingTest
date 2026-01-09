package boj.알고리즘;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ChessboardPainting {

  public static void main(String[] args) throws IOException {
    /*
     * 문제
     * 지민이는 자신의 저택에서 MN개의 단위 정사각형으로 나누어져 있는 M×N 크기의 보드를 찾았다. 어떤 정사각형은 검은색으로 칠해져 있고, 나머지는 흰색으로 칠해져 있다.
     * 지민이는 이 보드를 잘라서 8×8 크기의 체스판으로 만들려고 한다.
     *
     * 체스판은 검은색과 흰색이 번갈아서 칠해져 있어야 한다. 구체적으로, 각 칸이 검은색과 흰색 중 하나로 색칠되어 있고, 변을 공유하는 두 개의 사각형은 다른 색으로 칠해져 있어야 한다.
     * 따라서 이 정의를 따르면 체스판을 색칠하는 경우는 두 가지뿐이다. 하나는 맨 왼쪽 위 칸이 흰색인 경우, 하나는 검은색인 경우이다.
     *
     * 보드가 체스판처럼 칠해져 있다는 보장이 없어서, 지민이는 8×8 크기의 체스판으로 잘라낸 후에 몇 개의 정사각형을 다시 칠해야겠다고 생각했다.
     * 당연히 8*8 크기는 아무데서나 골라도 된다. 지민이가 다시 칠해야 하는 정사각형의 최소 개수를 구하는 프로그램을 작성하시오.
     *
     * 입력
     * 첫째 줄에 N과 M이 주어진다. N과 M은 8보다 크거나 같고, 50보다 작거나 같은 자연수이다. 둘째 줄부터 N개의 줄에는 보드의 각 행의 상태가 주어진다. B는 검은색이며, W는 흰색이다.
     *
     * 출력
     * 첫째 줄에 지민이가 다시 칠해야 하는 정사각형 개수의 최솟값을 출력한다.
     * */

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());

    boolean[][] board = new boolean[n][m];

    for (int i = 0; i < n; i++) {
      String line = br.readLine();
      for (int j = 0; j < m; j++) {
        if (line.charAt(j) == 'W') {
          board[i][j] = true;
        } else {
          board[i][j] = false;
        }
      }
    }
    
    int min = 64; // 8*8 체스판의 최대 수정 횟수는 64
    
    for (int i = 0; i <= n - 8; i++) {
      for (int j = 0; j <= m - 8; j++) {
        int count = check(i, j, board);
        if (min > count) {
          min = count;
        }
      }
    }
    
    System.out.println(min);
  }
  
  private static int check(int startRow, int startCol, boolean[][] board) {
    int count = 0;
    boolean checkColor = true; // 'W'를 true로 가정하고 시작
    
    for (int i = startRow; i < startRow + 8; i++) {
      for (int j = startCol; j < startCol + 8; j++) {
        if (board[i][j] != checkColor) {
          count++;
        }
        checkColor = !checkColor; // 다음 칸은 색이 바뀌어야 함
      }
      checkColor = !checkColor; // 다음 줄로 넘어갈 때도 색이 바뀌어야 함 (W B W B ... -> B W B W ...)
    }

    // 첫 칸이 W인 경우(count)와 B인 경우(64 - count) 중 더 작은 값 반환
    return Math.min(count, 64 - count);
  }
  
  /*
   * 문제 레벨 : 실버 3
   * 제한 시간 : 20분
   * 걸린 시간 : 20분 초과 (AI 도움을 받아 해결)
   * 해결 과정 :
   * 1차 시도
   * 8x8 크기로 잘라내어 확인해야 한다는 점(슬라이딩 윈도우)은 파악했으나,
   * 단순히 W와 B의 개수 차이만 비교하려 했다. (W-B의 값이 가장 작은 수를 반환하려 함)
   * 하지만 개수가 같더라도 체스판 패턴(색이 번갈아 나오는 규칙)이 맞지 않을 수 있다는 점을 고려하지 못함.
   *
   * 2차 시도
   * 체스판 패턴을 검증하는 로직을 추가하려 했으나 구현이 까다로웠음.
   * 특히 행이 바뀔 때 색이 반전되어야 한다는 점과,
   * 맨 왼쪽 위가 '흰색'으로 시작하는 경우와 '검은색'으로 시작하는 경우 두 가지를 모두 생각 해야한다는 점을 고려하지 못함.
   *
   * 최종 해결
   * 1. 전체 보드에서 가능한 모든 8x8 영역을 이중 for문으로 순회한다.
   * 2. 각 영역에 대해 check 함수를 호출하여 다시 칠해야 하는 최소 개수를 구한다.
   * 3. check 함수에서는 첫 칸을 'W'로 가정하고 패턴과 다른 칸의 개수(count)를 센다.
   *    - 이때 행이 바뀔 때마다 기준 색을 반전시켜 체스판 규칙을 적용한다.
   * 4. 최종적으로 'W'로 시작했을 때의 비용(count)과 'B'로 시작했을 때의 비용(64 - count) 중 더 작은 값을 반환한다.
   * 5. 모든 영역의 결과 중 최솟값을 출력한다.
   */
}