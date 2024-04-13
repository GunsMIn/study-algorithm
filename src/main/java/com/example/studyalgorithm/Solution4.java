package com.example.studyalgorithm;

public class Solution4 {

    //가운데 글자 가져오기
    //홀수 일때 , 짝수 일때 구분
    //"abcde"	"c"
    // 01234     5/2
    //"qwer"	"we"
    // 0123      4/2
    //012345
    public String solution2(String s) {
        String answer = "";
        int length = s.length();
        int middle = length / 2;
        if (length / 2 == 0) {
            return s.substring(middle - 1, middle + 1);
        } else {
            return s.substring(middle, middle + 1);
        }
    }
}
