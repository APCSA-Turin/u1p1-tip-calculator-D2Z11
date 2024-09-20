package com.example.project;
import java.util.Scanner;

public class TipCalculator {
    public static String roundToTwoPlaces(double num) {
        // https://stackoverflow.com/questions/11701399/round-up-to-2-decimal-places-in-java
        double rounded = Math.round(num * 100.0) / 100.0;
        String roundedStr = String.valueOf(rounded);
        // https://stackoverflow.com/questions/51462081/how-to-split-string-in-java-based-on-period
        // Append a "0" if there is only one digit after the period -> ex: $15.0 should be $15.00
        if (roundedStr.split("\\.")[1].length() == 1) {
            roundedStr += '0';
        }
        return roundedStr;
    }

    //WRITE YOUR PROGRAM IN calculateTip
    public static String calculateTip(int people, int percent, double cost) { //You must use these  variable in your calculations
        //DO NOT DELETE ANY OF THE CODE BELOW      
        StringBuilder result = new StringBuilder();
        Scanner readIn = new Scanner(System.in);

        // NOTE: Why did I put roundToTwoPlaces in the string and not in the variable? It was sometimes giving incorrect results because the double didn't have enough detail/digits
        result.append("-------------------------------\n");
        result.append("Total bill before tip: $" + roundToTwoPlaces(cost) + '\n'); //concatenate to this string. DO NOT ERASE AND REWRITE
        result.append("Total percentage: " + percent + "%\n");
        double tip = cost * (percent / 100.0);
        result.append("Total tip: $" + roundToTwoPlaces(tip) + '\n');
        double total = (tip + cost);
        result.append("Total Bill with tip: $" + roundToTwoPlaces(total) + '\n');
        double perPersonBeforeTip = (cost / people);
        result.append("Per person cost before tip: $" + roundToTwoPlaces(perPersonBeforeTip) + '\n');
        double perPersonForTip = (tip / people);
        result.append("Tip per person: $" + roundToTwoPlaces(perPersonForTip) + '\n');
        double totalCostPerPersonIncludingTip = (total / people);
        result.append("Total cost per person: $" + roundToTwoPlaces(totalCostPerPersonIncludingTip) + '\n');
        result.append("-------------------------------\n");

        // Best practices to close readIn
        readIn.close();

        return result.toString();
    }
     //TEST YOUR PROGRAM IN main
     public static void main(String[] args) {
        //try different values for people, percent, and cost to test your program before running test cases
        int people = 2;
        int percent = 15;
        double cost = 31;
        System.out.println(calculateTip(people,percent,cost));
    }
}
