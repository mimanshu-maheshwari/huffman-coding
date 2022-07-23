package main.utils;

public class Node implements Comparable<Node> {

	private Character value;
	private Integer frequency;
	private Node left;
	private Node right;

	public Node(Character value, Integer frequency, Node left, Node right) {
		this.value = value;
		this.frequency = frequency;
		this.left = left;
		this.right = right;
	}

	public Node(Character value, Integer frequency) {
		this.value = value;
		this.frequency = frequency;
		this.left = null;
		this.right = null;
	}

	public Character getValue() {
		return value;
	}

	public void setValue(Character value) {
		this.value = value;
	}

	public Integer getFrequency() {
		return frequency;
	}

	public void setFrequency(Integer frequency) {
		this.frequency = frequency;
	}

	public Node getLeft() {
		return left;
	}

	public void setLeft(Node left) {
		this.left = left;
	}

	public Node getRight() {
		return right;
	}

	public void setRight(Node right) {
		this.right = right;
	}

	@Override
	public int compareTo(Node o) {
		int result = Integer.compare(this.frequency, o.getFrequency());
		if (result == 0) {
			result = Integer.compare(this.value, o.getValue());
		}
		return result;
	}

	public boolean isLeaf() {
		return this.left == null && this.right == null;
	}

}
