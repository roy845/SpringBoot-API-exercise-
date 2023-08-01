package com.example.demo;
import static org.junit.Assert.assertEquals;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.example.demo.services.PrintXService;

public class PrintXTest {
	  @Rule
	    public ExpectedException exceptionRule = ExpectedException.none();

    @Test
    public void testPrintX0() {
    	
    	String expectedFor0 = "";
    
        
        assertEquals(expectedFor0, PrintXService.printX(0));
    }

    
    
    @Test
    public void testPrintX1() {
    	
  
    	String expectedFor1 = "X";
    		
        assertEquals(expectedFor1, PrintXService.printX(1));
       
    }
    
    @Test
    public void testPrintX3() {
    	
    
    	String expectedFor3 = 
    		    "X X\n" +
    		    " X \n" + 
    		    "X X";
        
      
        assertEquals(expectedFor3, PrintXService.printX(3));

    }
    
    @Test
    public void testDiagonalEven() {
    	String expectedOutput = 
    		    "X  X\n" +
    		    " XX \n" +
    		    " XX \n" +
    		    "X  X";
        assertEquals(expectedOutput, PrintXService.printX(4));
    }


    
    @Test
    public void testPrintX5() {
    	
    	String expectedFor5 = 
    		    "X   X\n" +
    		    " X X \n" + 
    		    "  X  \n" +
    		    " X X \n" +
    		    "X   X";
        
        assertEquals(expectedFor5, PrintXService.printX(5));
    }
    
    @Test
    public void testNegativeDiagonal() {
        exceptionRule.expect(IllegalArgumentException.class);
        exceptionRule.expectMessage("Diagonal cannot be negative.");
        PrintXService.printX(-5);
    }
}
