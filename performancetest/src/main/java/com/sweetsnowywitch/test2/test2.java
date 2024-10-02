package com.sweetsnowywitch.test2;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class test2 {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        var circleLines = Files.readAllLines(Path.of("performancetest\\src\\main\\java\\com\\sweetsnowywitch\\test2\\circle.txt"));
        var dotsLines = Files.readAllLines(Path.of("performancetest\\src\\main\\java\\com\\sweetsnowywitch\\test2\\dots.txt"));

        var сirclePosition = circleLines.get(0).split(" ");
        var circleX = Integer.parseInt(сirclePosition[0]);
        var circleY = Integer.parseInt(сirclePosition[1]);
        var radius = Integer.parseInt(circleLines.get(1));
        var doubleRadius = Math.pow(radius, 2);

        for (var dotsLine : dotsLines) {
            var dotPosition = dotsLine.split(" ");
            var dotX = Integer.parseInt(dotPosition[0]);
            var dotY = Integer.parseInt(dotPosition[1]);
            var doublePosition = Math.pow(circleX - dotX, 2) + Math.pow(circleY - dotY, 2);

            if (doublePosition == doubleRadius) {
                System.out.println(0);
            } else if (doublePosition < doubleRadius) {
                System.out.println(1);
            } else {
                System.out.println(2);
            }
        }
    }
}
