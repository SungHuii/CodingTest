package boj.정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Statistics {

  public static void main(String[] args) throws IOException {
    /*
    * 통계학 / 실버2 / 시간 제한 2초 / 메모리 제한 256MB
    * 문제
    * 수를 처리하는 것은 통계학에서 상당히 중요한 일이다. 통계학에서 N개의 수를 대표하는 기본 통계값에는 다음과 같은 것들이 있다. 단, N은 홀수라고 가정하자.
    * 1. 산술평균 : N개의 수들의 합을 N으로 나눈 값
    * 2. 중앙값 : N개의 수들을 증가하는 순서로 나열했을 경우 그 중앙에 위치하는 값
    * 3. 최빈값 : N개의 수들 중 가장 많이 나타나는 값
    * 4. 범위 : N개의 수들 중 최댓값과 최솟값의 차이
    * N개의 수가 주어졌을 때, 네 가지 기본 통계값을 구하는 프로그램을 작성하시오.
    *
    * 입력
    * 첫째 줄에 수의 개수 N(1 ≤ N ≤ 500,000)이 주어진다. 단, N은 홀수이다. 그 다음 N개의 줄에는 정수들이 주어진다. 입력되는 정수의 절댓값은 4,000을 넘지 않는다.
    *
    * 출력
    * 첫째 줄에는 산술평균을 출력한다. 소수점 이하 첫째 자리에서 반올림한 값을 출력한다.
    * 둘째 줄에는 중앙값을 출력한다.
    * 셋째 줄에는 최빈값을 출력한다. 여러 개 있을 때에는 최빈값 중 두 번째로 작은 값을 출력한다.
    * 넷째 줄에는 범위를 출력한다.
    * */

    /*
    // 기존 코드 (시간 초과 및 로직 오류 발생)
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    StringBuilder sb = new StringBuilder();

    int arr[] = new int[n];

    for (int i = 0; i < n; i ++) {
      arr[i] = Integer.parseInt(br.readLine());
    }

    // 산술 평균
    double sum = 0.0;
    for (int i = 0; i < arr.length; i++) {
      sum += arr[i];
    }
    sum = Math.round(sum / n);
    sb.append(sum + "\n");

    // 중앙값
    int middleValue = 0;
    int sortedArr[] = new int[n];
    Arrays.stream(sortedArr).sorted().toArray();

    middleValue = sortedArr[n / 2];
    sb.append(middleValue + "\n");

    // 최빈값
    int max = 0;
    for (int i = 0; i < arr.length; i++) {
      int count = 0;
      for (int j = 0; j < arr.length; j++) {
        if (arr[i] == arr[j]) {
          count++;
        }
        max = count;
      }
    }
    sb.append(max + "\n");

    // 범위
    int range = 0;
    int maxv = 0;
    int minv = 0;
    for (int i = 0; i < arr.length; i++) {
      for (int j = 0; j < arr.length; j++) {
        if (arr[i] > arr[j]) {
          maxv = arr[i];
        }
        if (arr[i] < arr[j]) {
          minv = arr[i];
        }
      }
    }
    range = maxv - minv;
    sb.append(range);
    System.out.println(sb);
    */

    // 개선된 코드 (O(N log N))
    // 입력 받기
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    StringBuilder sb = new StringBuilder();

    int[] arr = new int[n];
    int sum = 0;

    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(br.readLine());
      sum += arr[i];
    }

    // 1. 산술평균
    // Math.round는 소수점 첫째 자리에서 반올림하여 정수로 반환
    sb.append(Math.round((double) sum / n)).append('\n');

    // 정렬 (O(N log N))
    Arrays.sort(arr);

    // 2. 중앙값
    sb.append(arr[n / 2]).append('\n');

    // 3. 최빈값
    // 위에서 정렬한 상태이므로 한 번 순회해서 최빈값을 찾을 수 있음
    int count = 0;
    int maxCount = -1;
    int mode = arr[0];
    boolean check = false; // 두 번째로 작은 값을 찾기 위한 플래그

    for (int i = 0; i < n - 1; i++) {
      if (arr[i] == arr[i + 1]) {
        count++;
      } else {
        count = 0;
      }

      if (maxCount < count) {
        maxCount = count;
        mode = arr[i];
        check = true; // 새로운 최빈값이 등장했으므로 첫 번째 값임
      } else if (maxCount == count && check) {
        mode = arr[i];
        check = false; // 두 번째로 작은 값을 찾았으므로 플래그 해제 (이후 같은 빈도수는 무시)
      }
    }
    sb.append(mode).append('\n');

    // 4. 범위
    sb.append(arr[n - 1] - arr[0]).append('\n');

    System.out.println(sb);
  }
}
