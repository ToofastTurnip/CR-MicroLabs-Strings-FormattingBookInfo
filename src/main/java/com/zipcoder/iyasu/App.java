package com.zipcoder.iyasu;

import java.io.*;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;

public class App {

    private static DecimalFormat decimalFormat = new DecimalFormat("0.00");

    public static void main( String[] args ) throws IOException {
        String path = "./src/main/books.txt";
        String outPath  = "./src/main/out.txt";
    }

    public static String formatLine(String line) {
        String[] threeBookParts = line.split(":");
        String formattedLine = "Book Name: " + threeBookParts[0] + "\n";
        formattedLine += "Author: " + threeBookParts[1] + "\n";
        formattedLine += "Price: " + formatToDollars(Double.parseDouble(threeBookParts[2])) + "\n";
        formattedLine += "Price(Euros): " + convertPriceToEuros(Double.parseDouble(threeBookParts[2])) + "\n";
        formattedLine += "--------------------\n";
        return formattedLine;
    }


    public static ArrayList filetoList(String path) throws IOException {
        String[] tempArray = path.split("\n");
        return new ArrayList(Arrays.asList(tempArray));
    }


    public static void listToFile(ArrayList<String> list, String path) throws IOException {

    }

    public static String convertPriceToEuros(double price){
        return "EUR" + decimalFormat.format(price * 0.92);
    }

    public static String formatToDollars(Double price){
        return "$" + decimalFormat.format(price);
    }

}