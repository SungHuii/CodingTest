/*
문제: 점수 내림차순, 점수 같으면 ID 오름차순 정렬
설명
학생들의 (id, score)가 들어있는 2차원 배열이 있다.
이 배열을 점수(score) 기준으로 내림차순 정렬하되,
점수가 같으면 id 기준으로 오름차순 정렬해야 한다.
 */
import java.util.*;

public class AscDesc {
    public static void main(String[] args) {
        int[][] scores = {
            {1, 90},
            {4, 70},
            {3, 90},
            {2, 80},
            {5, 90}
        };

        int[][] sorted = sortByScoreDescIdAsc(scores);

        for (int[] s : sorted) {
            System.out.println(s[0] + " " + s[1]);
        }
    }

    /**
     * TODO:
     * 1) 점수(score)를 기준으로 내림차순 정렬한다.
     * 2) 점수가 같을 경우 id를 기준으로 오름차순 정렬한다.
     */
    public static int[][] sortByScoreDescIdAsc(int[][] arr) {
        /*
        int[] id = new int[arr.length];
        int[] score = new int[arr[0].length];

        int index = 0;
        for (int i = 0; i < id.length; i++) {
            id[index++] += arr[i][0];
            for (int j = 0; j < score.length; j++) {
                score[index++] += arr[0][j];
            }
        }
        
        System.out.println(id);
        System.out.println(score);
        return arr; // 정렬된 배열 반환
        */
        Arrays.sort(arr, (a, b) -> {
            // score 내림 차순
            if (a[1] != b[1]) return Integer.compare(b[1], a[1]);

            // score가 같다면 id 오름차순
            return Integer.compare(a[0], b[0]);
        });
        return arr;
    }
}
