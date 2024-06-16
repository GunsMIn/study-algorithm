package com.example.studyalgorithm;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
public class C2 {


    public int[] solution(String[] purchase) {
        int[] daysInGrades = new int[5]; // 각 등급(브론즈, 실버, 골드, 플래티넘, 다이아몬드)별로 유지된 일수를 저장할 배열
        int[] totalSpending = new int[365]; // 일자별 총 구매액을 저장할 배열

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        // 구매 기록을 순회하며 각 날짜의 구매액을 totalSpending 배열에 추가
        for (String record : purchase) {
            String[] parts = record.split(" ");
            LocalDate date = LocalDate.parse(parts[0], formatter);
            int dayOfYear = date.getDayOfYear() - 1;
            int amount = Integer.parseInt(parts[1]);
            totalSpending[dayOfYear] += amount;
        }

        int sum = 0; // 최근 30일간의 총 구매액을 저장할 변수

        for (int i = 0; i < 365; i++) {
            sum += totalSpending[i];
            if (i >= 30) sum -= totalSpending[i - 30]; // 30일이 지난 후부터는 30일 전 날의 구매액을 빼줌

            int grade = getGrade(sum);
            daysInGrades[grade]++;
        }

        return daysInGrades;
    }


    private int getGrade(int sum) {
        if (sum >= 100000) return 4;
        if (sum >= 50000) return 3;
        if (sum >= 20000) return 2;
        if (sum >= 10000) return 1;
        return 0;
    }
    public static void main(String[] args) {
        C2 calculator = new C2();
        String[] purchase = {"2019/01/30 5000", "2019/04/05 10000", "2019/06/10 20000", "2019/08/15 50000", "2019/12/01 100000"};
        int[] result = calculator.solution(purchase);
        System.out.println("등급별 유지 기간: ");
        for (int grade : result) {
            System.out.print(grade + " ");
        }
    }

}
