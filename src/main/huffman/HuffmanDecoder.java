package main.huffman;

import java.util.HashMap;
import java.util.Map;

public class HuffmanDecoder {

	public String decode(HuffmanPacket packet) {
		// Step1: decode the keys
		Map<Character, Character> keys = generateKeys(packet.getKeys());
		// Step2: decode and return value
		return decodeData(keys, packet.getData());

	}

	private Map<Character, Character> generateKeys(Character[] inKeys) {
		Map<Character, Character> keys = new HashMap<>();
		for (char c = 0; c < inKeys.length; c++) {
			if (inKeys[c] != null) {
				keys.put(inKeys[c], c);
			}
		}
		return keys;
	}

	private String decodeData(Map<Character, Character> keys, String input) {
		StringBuilder output = new StringBuilder();
		for (char c : input.toCharArray()) {
			output.append(keys.get(c));
		}
		return output.toString();
	}

}
