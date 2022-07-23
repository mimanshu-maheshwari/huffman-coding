package main.huffman;

import java.util.PriorityQueue;

import main.utils.Node;

public class HuffmanEncoder {

	public HuffmanPacket encode(String data, Integer dt) {
		if (data.length() < 1)
			return null;
		// Step1: Get frequncies of the characters.
		int[] frequencies = populateFrequencies(data, dt);
		// Step2: Create a binary huffman tree.
		Node hbtHead = createHuffmanTree(frequencies);
		// Step3: Create a map to create encoded data.
		Character[] keys = createKeys(hbtHead, dt);
		// Step4: Encode and Return the encoded data as Huffman packet.
		return encodeData(keys, data);
	}

	private int[] populateFrequencies(String data, Integer dt) {
		int[] frequencies = new int[dt.intValue()];
		for (char c : data.toCharArray()) {
			frequencies[c]++;
		}
		return frequencies;
	}

	private Node createHuffmanTree(int[] freq) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		for (char c = 0; c < freq.length; c++) {
			if (freq[c] > 0)
				pq.add(new Node(c, freq[c]));
		}

		if (pq.size() == 1) {
			pq.add(new Node('\0', 1, pq.poll(), null));
		}

		while (pq.size() > 1) {
			Node left = pq.poll();
			Node right = pq.poll();
			pq.add(new Node('\0', left.getFrequency() + right.getFrequency(), left, right));
		}

		return pq.poll();
	}

	private Character[] createKeys(Node head, Integer dt) {
		Character[] keys = new Character[dt];

		createKeysHelper(keys, '\u0000', head);

		return keys;
	}

	private void createKeysHelper(Character[] keys, Character code, Node node) {
		if (node.isLeaf()) {
			keys[node.getValue()]= code.charValue();
		} else {
			createKeysHelper(keys, (char)(code.charValue() << 1) , node.getLeft());
			createKeysHelper(keys, (char)((code << 1) | 1) , node.getRight());
		}
	}

	private HuffmanPacket encodeData(Character[] keys, String data) {

		StringBuilder output = new StringBuilder();
		for (char c : data.toCharArray()) {
			output.append(keys[c].charValue());
		}
		return new HuffmanPacket(output.toString(), keys);

	}

}
