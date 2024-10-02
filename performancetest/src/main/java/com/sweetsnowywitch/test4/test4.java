package com.sweetsnowywitch.test4;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Scanner;

public class test4 {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        var console = new Scanner(System.in);
        var numsPath = console.nextLine();
        var numsLines = Files.readAllLines(Path.of(numsPath));
        var nums = new int[numsLines.size()];
        for (var i = 0; i < numsLines.size(); i++) {
            nums[i] = Integer.parseInt(numsLines.get(i));
        }
        Arrays.sort(nums);
        var median = nums[numsLines.size() / 2];
        var result = 0;
        for (var num : nums) {
            result += Math.abs(num - median);
        }
        console.close();
        System.out.println(result);
    }
}
