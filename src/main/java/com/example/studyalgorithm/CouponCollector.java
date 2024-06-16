package com.example.studyalgorithm;
import java.util.ArrayList;
import java.util.HashMap;

public class CouponCollector {

    static class Customer {
        int coupons = 0; // 쿠폰 수
        boolean isFreeNext = false; // 다음 주문이 무료인지
    }

    public static ArrayList<Integer> solution(int[] people) {
        HashMap<Integer, Customer> customerMap = new HashMap<>();
        ArrayList<Integer> freeSpaghettiCustomers = new ArrayList<>();

        for (int id : people) {
            Customer customer = customerMap.computeIfAbsent(id, k -> new Customer());

            if (customer.isFreeNext) {
                freeSpaghettiCustomers.add(id);
                customer.coupons = 0; // 쿠폰 리셋
                customer.isFreeNext = false; // 무료 상태 해제
                continue; // 이 주문에서는 쿠폰을 추가하지 않음
            }

            customer.coupons++; // 쿠폰 수 증가
            if (customer.coupons == 3) {
                customer.isFreeNext = true; // 다음 주문에서 무료로 설정
            }
        }

        if (freeSpaghettiCustomers.isEmpty()) {
            freeSpaghettiCustomers.add(-1); // 무료로 받은 손님이 없는 경우
        }

        return freeSpaghettiCustomers;
    }


    public static void main(String[] args) {
        int[] people1 = {1,3,3,2,4,3,3,2,4,2,2,4};
        int[] people2 = {1,1,3,3,3,3,1,3,3,3,3,2};
        int[] people3 = {1,2,3,4};

        System.out.println(solution(people1)); // [3, 2]
        System.out.println(solution(people2)); // [3, 3]
        System.out.println(solution(people3)); // [-1]
    }
}
