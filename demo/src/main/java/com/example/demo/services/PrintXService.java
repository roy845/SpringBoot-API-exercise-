package com.example.demo.services;

public class PrintXService {
	public static String printX(int diagonal) {
		
		if (diagonal < 0) {
	        throw new IllegalArgumentException("Diagonal cannot be negative.");
	    }
		
	    StringBuilder output = new StringBuilder();
	    for (int i = 0; i < diagonal; i++) {
	        StringBuilder line = new StringBuilder(" ".repeat(diagonal));
	        line.setCharAt(i, 'X');
	        line.setCharAt(diagonal - i - 1, 'X');
	        output.append(line.toString());
	        if (i < diagonal - 1) {
	            output.append("\n");
	        }
	    }
	    System.out.println(output.toString());
	    System.out.println("\n\n");
	    return output.toString();
	}
}
