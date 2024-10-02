package com.sweetsnowywitch.test3;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

// console input in 3 lines in order: values, tests, report
public class test3 {

    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws FileNotFoundException, IOException, ParseException {
        var console = new Scanner(System.in);
        var parser = new JSONParser();

        var valuesPath = console.nextLine();
        var valuesData = (JSONObject) parser.parse(new FileReader(valuesPath));
        var values = (JSONArray) valuesData.get("values");

        var testsPath = console.nextLine();
        var testsData = (JSONObject) parser.parse(new FileReader(testsPath));
        var tests = (JSONArray) testsData.get("tests");

        var reportPath = console.nextLine();
        var report = new JSONObject();
        var rawReports = new JSONArray();
        var fileWriter = new FileWriter(reportPath);

        for (var value : values) {
            var valueObj = (JSONObject) value;
            rawReports = getReports(tests, valueObj, rawReports);
        }
        report.put("tests", rawReports);
        report.writeJSONString(fileWriter);
        fileWriter.close();
        console.close();
    }

    @SuppressWarnings("unchecked")
    private static JSONArray getReports(JSONArray tests, JSONObject valueObj, JSONArray reports) {
        for (var test : tests) {
            var testObj = (JSONObject) test;
            var testValues = testObj.get("values");
            if (testObj.get("id").equals(valueObj.get("id"))) {
                testObj.put("value", valueObj.get("value"));
                reports.add(testObj);
            }
            if (testValues != null) {
                reports = getReports((JSONArray)testValues, valueObj, reports);
            }
        }
        return reports;
    }
}
