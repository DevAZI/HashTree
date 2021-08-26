package RedBlackTree;
public class RBT<K extends Comparable<K>, V> {
	
	private class Node {
		private K key;
		private V val;
		private Node left, right;
		
		public Node(K k, V v) {
			this.key = k;
			this.val = v;
		}		
	}

	private Node root;
	
	public RBT() {
	}

	private Node search(Node node, K k) { // °Ë»ö
		if (node == null) return null;
		int cmp = k.compareTo(node.key);
		if (cmp < 0) return search(node.left, k);
		else if (cmp > 0) return search(node.right, k);
		else return node;
	}
	
	public Node search(K k) { //°Ë»ö°ª
		return search(root, k);
	}
	private Node insert(Node node, K k, V v) { //»ðÀÔ
		if (node == null) return new Node(k, v);
		int cmp = k.compareTo(node.key);
		if (cmp < 0) node.left = insert(node.left, k, v);
		else if (cmp > 0) node.right = insert(node.right, k, v);
		else node.val = v;
		return node;
	}
	
	public void insert(K k, V v) { //»ðÀÔ
		root = insert(root, k, v);
	}
}