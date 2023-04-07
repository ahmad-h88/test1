package com.techelevator;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.fail;

public class VendingMachineTest {

    private VendingMachine vendingMachine;
    private final PrintStream standardOutput = System.out;
    private final ByteArrayOutputStream outputStreamCaptor= new ByteArrayOutputStream();

    @Before
    public void setup(){
        vendingMachine = new VendingMachine();
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @After
    public void cleanup(){
        System.setOut(standardOutput);
    }

    @Test
    public void displayItemsPrintsItems(){
        String expectedResult = "A1|Potato Crisps|3.05|Chip|5\r\n" +
                "A2|Stackers|1.45|Chip|5\r\n" +
                "A3|Grain Waves|2.75|Chip|5\r\n" +
                "A4|Cloud Popcorn|3.65|Chip|5\r\n" +
                "B1|Moonpie|1.80|Candy|5\r\n" +
                "B2|Cowtales|1.50|Candy|5\r\n" +
                "B3|Wonka Bar|1.50|Candy|5\r\n" +
                "B4|Crunchie|1.75|Candy|5\r\n" +
                "C1|Cola|1.25|Drink|5\r\n" +
                "C2|Dr. Salt|1.50|Drink|5\r\n" +
                "C3|Mountain Melter|1.50|Drink|5\r\n" +
                "C4|Heavy|1.50|Drink|5\r\n" +
                "D1|U-Chews|0.85|Gum|5\r\n" +
                "D2|Little League Chew|0.95|Gum|5\r\n" +
                "D3|Chiclets|0.75|Gum|5\r\n" +
                "D4|Triplemint|0.75|Gum|5";
        vendingMachine.displayItems();
        String actualResult = outputStreamCaptor.toString().trim();
        Assert.assertEquals(expectedResult, actualResult);
    }
}
