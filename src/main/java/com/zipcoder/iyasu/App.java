package com.zipcoder.iyasu;

import java.io.*;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class App {

    private static DecimalFormat decimalFormat = new DecimalFormat("0.00");

    public static void main( String[] args ) throws IOException {
        String path = "./src/main/books.txt";
        String outPath  = "./src/main/out.txt";
    }

    public static String formatLine(String line) {
        String formattedLine = null;
        return formattedLine;
    }


    public static ArrayList filetoList(String path) throws IOException {
        ArrayList list = new ArrayList();
        return list;
    }


    public static void listToFile(ArrayList<String> list, String path) throws IOException {

    }

    public static String convertPriceToEuros(double price){
        return "EUR" + decimalFormat.format(price * 0.92).toString();
    }

    public static String formatToDollars(Double price){
        return "$" + decimalFormat.format(price).toString();
    }

}