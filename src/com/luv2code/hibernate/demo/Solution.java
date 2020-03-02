package com.luv2code.hibernate.demo;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    
	
	public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
       
		Scanner sc = new Scanner(System.in);
        String sub = sc.nextLine();
        ItemSeparator itemData = new ItemSeparator(sub);
        System.out.println("Item Name: " + itemData.getName());
        System.out.println("Item Price: " + itemData.getPrice());
        System.out.println("Item Quantity: " + itemData.getQuantity());
    }        
}