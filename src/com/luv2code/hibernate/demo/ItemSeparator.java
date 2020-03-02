package com.luv2code.hibernate.demo;

public class ItemSeparator {
	
	
	String rawInput;
	    
	String[] rawData =null;

	ItemSeparator(String rawInput){

	    rawInput=this.rawInput;        
	    System.out.println("This raw input" +rawInput);
	//rawData = rawInput.split("[$]");	       
	   
	//String [] rawData = rawInput.split("[$]");
	}
	    
	String getName(){

	     return rawData[0];
	}
	
    Double getPrice(){

    	Double d = Double.valueOf(rawData[1]);

	    return d;
    }
    
    Integer getQuantity(){

	    Integer d = Integer.valueOf(rawData[2]);

	    return d;
	}
}
