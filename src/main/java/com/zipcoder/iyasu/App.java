package com.zipcoder.iyasu;

import java.io.*;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.text.*;
import java.util.*;

public class App {

    private static DecimalFormat decimalFormat = new DecimalFormat("0.00");

    public static void main( String[] args ) throws IOException {
        String path = "books.txt";
        String outPath  = "src/main/resources/out.txt";
        listToFile(fileStringToList(fileToString(path)), outPath);
    }

    public static String formatLine(String line) {
        try {
            String[] threeBookParts = line.split(":");
            String formattedLine = "Book Name: " + threeBookParts[0] + "\n";
            formattedLine += "Author: " + threeBookParts[1] + "\n";
            formattedLine += "Price: " + formatToDollars(Double.parseDouble(threeBookParts[2])) + "\n";
            formattedLine += "Price(Euros): " + convertPriceToEuros(Double.parseDouble(threeBookParts[2])) + "\n";
            formattedLine += "--------------------\n";
            return formattedLine;
        } catch (ArrayIndexOutOfBoundsException e) {
            return "ARRAY ERROR MY DUDE";
        }
    }


    public static ArrayList fileStringToList(String fileAsString) throws IOException {
        String[] tempArray = fileAsString.split("\n");
        return new ArrayList(Arrays.asList(tempArray));
    }


    public static void listToFile(ArrayList<String> list, String path) throws IOException {
        FileWriter fileWriter = new FileWriter(path, true);
        try {
            for (int i = 0; i < list.size(); i++) {
                fileWriter.write(formatLine(list.get(i)) + "\n");
            }
        }
        finally {fileWriter.close();}
    }

    public static String convertPriceToEuros(double price){
        return "EUR" + decimalFormat.format(price * 0.92);
    }

    public static String formatToDollars(Double price){
        return "$" + decimalFormat.format(price);
    }

    public static String fileToString(String filename) {
        StringBuilder result = new StringBuilder("");
        ClassLoader classLoader = App.class.getClassLoader();
        File file = new File(classLoader.getResource(filename).getFile());
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                result.append(line).append("\n");
            }
            scanner.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result.toString();
    }

}