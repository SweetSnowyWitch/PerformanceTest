package com.sweetsnowywitch.test1;


import java.util.Scanner;

// n > 1, m > 1
public class test1 {

    public static void main(String[] args) {
        var console = new Scanner(System.in);
        var input = console.nextLine().split(" ");
        console.close();
        var result = new StringBuilder();
        var n = Integer.parseInt(input[0]);
        var m = Integer.parseInt(input[1]);
        var i = 1;
        for (;;) {
            result.append(i);
            i += m - 1;
            if (i > n) {
                i = i % n;
                if (i == 1) {
                    break;
                }
            }
        }
        System.out.println(result.toString());
    }
}
