package Algorany;

import java.util.*;

public class DoDookJil {

    public int solution(int[] money) {
        int n = money.length;
        if (n == 1) {
            return money[0];
        }
        if (n == 2) {
            return Math.max(money[0], money[1]);
        }
        // 첫 번째 집을 터는 경우
        int[] dp1 = new int[n];
        dp1[0] = money[0];
        dp1[1] = Math.max(money[0], money[1]);
        for (int i = 2; i < n - 1; i++) {
            dp1[i] = Math.max(dp1[i - 1], dp1[i - 2] + money[i]); // 안 터는 경우, 터는 경우
        }

        // 첫 번째 집을 털지 않는 경우
        int[] dp2 = new int[n];
        dp2[1] = money[1];
        dp2[2] = Math.max(money[1], money[2]);
        for (int i = 3; i < n; i++) {
            dp2[i] = Math.max(dp2[i - 1], dp2[i - 2] + money[i]);
        }

        return Math.max(dp1[n - 2], dp2[n - 1]);
    }

    public static void main(String[] args) {
        DoDookJil d = new DoDookJil();
        d.solution(new int[]{1, 2, 3, 1}); // 4
    }
}
//각 집들은 서로 인접한 집들과 방범장치가 연결되어 있기 때문에 인접한 두 집을 털면 경보가 울립니다.
//
//각 집에 있는 돈이 담긴 배열 money가 주어질 때, 도둑이 훔칠 수 있는 돈의 최댓값을 return 하도록 solution 함수를 작성하세요.
//
//제한사항
//이 마을에 있는 집은 3개 이상 1,000,000개 이하입니다.
//money 배열의 각 원소는 0 이상 1,000 이하인 정수입니다.