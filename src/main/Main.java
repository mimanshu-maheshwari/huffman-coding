package main;

import main.huffman.HuffmanDecoder;
import main.huffman.HuffmanEncoder;
import main.huffman.HuffmanPacket;
import main.utils.StringDataType;

public class Main {
	public static void main(String[] args) {
		String data = "abcddf";
		System.out.println(data + ": " + data.getBytes().length);
		Integer dt = StringDataType.ASCII;
		HuffmanEncoder encoder = new HuffmanEncoder();
		HuffmanPacket encodedData = encoder.encode(data, dt);
		System.out.println(encodedData.getData() + ": " + encodedData.getData().getBytes().length);
		HuffmanDecoder decoder = new HuffmanDecoder();
		String decodedData = decoder.decode(encodedData);
		System.out.println(decodedData + ": " + decodedData.getBytes().length);
	}
}
