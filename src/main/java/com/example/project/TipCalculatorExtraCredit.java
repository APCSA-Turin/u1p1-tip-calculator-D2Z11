// IGNORE THIS FILE!!!


package com.example.project;
import java.util.Scanner;
// https://www.w3schools.com/java/java_arraylist.asp
import java.util.ArrayList;

public class TipCalculatorExtraCredit {
    public static double roundToTwoPlaces(double num) {
        // https://stackoverflow.com/questions/11701399/round-up-to-2-decimal-places-in-java
        return Math.round(num * 100.0) / 100.0;
    }

    //WRITE YOUR PROGRAM IN calculateTip
    public static String calculateTip(int people, int percent, double cost) { //You must use these  variable in your calculations
        //DO NOT DELETE ANY OF THE CODE BELOW      
        StringBuilder result = new StringBuilder();
        Scanner readIn = new Scanner(System.in);

        // Learned this in an earlier lesson + w3schools: https://www.w3schools.com/java/java_arraylist.asp
        ArrayList<String> items = new ArrayList<String>();
        

        // ## EXTRA CREDIT ##
        System.out.println("Enter an item or type -1 to finish:");
        // .trim is same in Javascript
        String in = readIn.nextLine();
        items.add(in);
        // While is very similar to many languages
        while (!in.equals("-1")) {
            System.out.println("Enter an item or type -1 to finish:");
            in = readIn.nextLine();
            items.add(in);
        }
        // Remove -1 (also it's not zero-indexed so make it zero-indexed)
        items.remove(items.size() - 1);

        // NOTE: Why did I put roundToTwoPlaces in the string and not in the variable? It was sometimes giving incorrect results because the double didn't have enough detail/digits
        result.append("-------------------------------\n");
        result.append("Total bill before tip: $" + cost + '\n'); //concatenate to this string. DO NOT ERASE AND REWRITE
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

        // "best practices" 😒
        readIn.close();

        // return result.toString();
        // ## EXTRA CREDIT ##
        System.out.print(result.toString());
        //items.size() you can figure this out using intellisense (looking at the options for arraylists)
        for (int i = 0; i < items.size(); i++) {
            System.out.println(items.get(i));
        }
        return "";
    }
     //TEST YOUR PROGRAM IN main
     public static void main(String[] args) {
        //try different values for people, percent, and cost to test your program before running test cases
        int people = 12;
        int percent = 15;
        double cost = 566.97;      
        System.out.println(calculateTip(people,percent,cost));
    }
}
        
