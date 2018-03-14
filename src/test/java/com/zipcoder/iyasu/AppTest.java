package com.zipcoder.iyasu;


import org.junit.Assert;
import org.junit.Test;
import static com.zipcoder.iyasu.App.*;

/**
 * Unit test for simple App.
 */
public class AppTest {

    @Test
    public void testconvertDollarsToEuros() {
        //: Given
        String expectedEuros = "EUR0.92";

        //: When
        String actualEuros =  convertPriceToEuros(1);

        //:Then
        Assert.assertEquals(expectedEuros, actualEuros);

    }

    @Test
    public void testformatToDollars(){
        //: Given
        String expectedDollars = "$1.00";


        //: When
        String actualDollars = formatToDollars(1.0);

        //: Then
        Assert.assertEquals(expectedDollars, actualDollars);
    }

    @Test
    public void testformatLine(){
        //:Given
        String book = "title:author:1.00";
        String expected = "Book Name: title\n" +
                "Author: author\n" +
                "Price: $1.00\n" +
                "Price(Euros): EUR0.92"+
                // 20 "-"
                "\n--------------------\n";

        //:When
        String actual = formatLine(book);

        //: Then
        Assert.assertEquals(expected, actual);

    }

    @Test
    public void testfileToList(){

    }
}


