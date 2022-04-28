package doit;

import java.util.Scanner;

public class BFmatch {
    static int bfMatch(String txt, String pat) {
        int pt = 0;        // txt 커서
        int pp = 0;        // pat 커서

        while (pt != txt.length() && pp != pat.length()) {
            if (txt.charAt(pt) == pat.charAt(pp)) {
                pt++;
                pp++;
            } else {
                pt = pt - pp + 1;    // 일치하지 않을 경우 텍스트에서 한칸 옮김
                pp = 0;
            }
        }
        if (pp == pat.length())
            return pt - pp;
        return -1;
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.print("텍스트 : ");
        String s1 = stdIn.next();

        System.out.print("패턴 : ");
        String s2 = stdIn.next();

        int idx = bfMatch(s1, s2);

        if (idx == -1)
            System.out.println("텍스트에 패턴이 없습니다.");
        else {
            // 일치하는 문자 바로 앞까지의 길이를 구합니다.
            int len = 0;
            for (int i = 0; i < idx; i++)
                len += s1.substring(i, i + 1).getBytes().length;
            len+=s2.length();

            System.out.println((idx+1) + "번째 문자부터 일치합니다.");
            System.out.println("텍스트 :"+ s1);
            System.out.printf(String.format("패턴 : %%%ds\n", len), s2);
        }
    }
}