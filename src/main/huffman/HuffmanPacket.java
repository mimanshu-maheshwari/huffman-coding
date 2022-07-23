package main.huffman;

public class HuffmanPacket {
	private String data;
	private Character[] keys;

	public HuffmanPacket(String data, Character[] keys) {
		this.data = data;
		this.keys = keys;
	}

	public String getData() {
		return this.data;
	}

	public Character[] getKeys() {
		return this.keys;
	}

	@Override
	public String toString() {
		StringBuilder output = new StringBuilder("data=");
		output.append(this.data);
		output.append("\nMap=");
		for (char c = 0; c < keys.length; c++) {
			if (keys[c] != null) {
				output.append("[" + c + ":" + keys[c] + "],");
			}
		}
		return output.toString();
	}

}
