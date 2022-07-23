package main;

import main.huffman.HuffmanEncoder;
import main.utils.StringDataType;

public class Main {
	public static void main(String[] args) {
		
	String data = "abcddf";
	Integer dt = StringDataType.ASCII;
	HuffmanEncoder encoder = new HuffmanEncoder();
	System.out.println("data: " +data);
	System.out.println(encoder.encode(data, dt).toString());
	
	
	}
	
}
