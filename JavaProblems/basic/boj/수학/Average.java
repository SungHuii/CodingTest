package boj.수학;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Average {
    public static void main(String[] args) throws IOException {

        /*문제 / Bronze 1 / 수학
        * 세준이는 기말고사를 망쳤다. 세준이는 점수를 조작해서 집에 가져가기로 했다. 일단 세준이는 자기 점수 중에 최댓값을 골랐다.
        * 이 값을 M이라고 한다. 그리고 나서 모든 점수를 점수/M*100으로 고쳤다.
        * 예를 들어, 세준이의 최고점이 70이고, 수학점수가 50이었으면 수학점수는 50/70*100이 되어 71.43점이 된다.
        * 세준이의 성적을 위의 방법대로 새로 계산했을 때, 새로운 평균을 구하는 프로그램을 작성하시오.
        *
        * 입력
        * 첫째 줄에 시험 본 과목의 개수 N이 주어진다. 이 값은 1000보다 작거나 같다.
        * 둘째 줄에 세준이의 현재 성적이 주어진다. 이 값은 100보다 작거나 같은 음이 아닌 정수이고, 적어도 하나의 값은 0보다 크다.
        *
        * 출력
        * 첫째 줄에 새로운 평균을 출력한다. 실제 정답과 출력값의 절대오차 또는 상대오차가 10^-2 이하이면 정답이다.
        * */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 첫째줄
        StringTokenizer st = new StringTokenizer(br.readLine()); // 둘째줄
        List<Double> scoreList = new ArrayList<>();

        while (st.hasMoreTokens()) {
            scoreList.add(Double.parseDouble(st.nextToken()));
        }
        double max = 0;
        double sum = 0;
        for (double d : scoreList) {
            if (d > max) max = d;
        }
        for (int i = 0; i < n; i++ ) {
            scoreList.set(i, scoreList.get(i) / max * 100);
        }
        for (int i = 0; i < scoreList.size(); i++ ) {
            sum = sum + scoreList.get(i);
        }
        double avg = sum / n;
        System.out.println(avg);

        /*
        * 문제 레벨 : 브론즈 1
        * 제한 시간 : 20분
        * 걸린 시간 : 15분
        * 해결 과정 : 해결 방법 자체는 문제를 읽고 따라하면 되는 수준이라 문제가 없었고,
        * 각 값들을 처리하는 방법에 대해 검색하는 시간이 더 많았음
        * 어려웠던 점(아쉬운 점) : 추출한 값들을 어떻게 처리하는 지 잘모르는 부분이 많아서 시간이 더 걸려서 아쉬웠다.
        * 개선 포인트
        * 1. list.set()으로 리스트를 수정하지 않고도 구현 가능했다.
        * double max = 0;
        * double sum = 0;
        * for (double d : scoreList) {
        *   if (d > max) max = d;
        *   sum += d;
        * }
        * double avg = sum / n * 100.0 / max;
        *
        * 2. 위에서 작성한 루프를 3번에서 2번으로 줄일 수 있었다.
        *  2-1 max를 찾고
        *  2-2
        *  double sum = 0;
        *  for (int i = 0; i < n; i ++) {
        *   double newScore = scoreList.get(i) / max * 100.0;
        *   sum += newScore;
        *  }
        *  이런 식으로 for loop 안에서 새로운 점수를 선언하고 바로 추가하면 for loop를 줄일 수 있었음.
        * */
    }
}
