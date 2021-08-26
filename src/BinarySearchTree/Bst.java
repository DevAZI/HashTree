package BinarySearchTree;
public class Bst<K extends Comparable<K>, V> {
	
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
	
	public Bst() {
	}

	private Node search(Node node, K k) {
		if (node == null) return null;
		int cmp = k.compareTo(node.key);
		if (cmp < 0) return search(node.left, k);
		else if (cmp > 0) return search(node.right, k);
		else return node;
	}
	
	public Node search(K k) {
		return search(root, k);
	}
	
	private Node insert(Node node, K k, V v) {
		if (node == null) return new Node(k, v);
		int cmp = k.compareTo(node.key);
		if (cmp < 0) node.left = insert(node.left, k, v);
		else if (cmp > 0) node.right = insert(node.right, k, v);
		else node.val = v;
		return node;
	}
	
	public void insert(K k, V v) {
		root = insert(root, k, v);
	}
	
	private Node min(Node node) {
		if(node.left == null) return node;
		else return min(node.left);
	}
	
	private Node deleteMin(Node node) {
		if(node.left == null) return node.right;
		node.left = deleteMin(node.left);
		return node;
	}
	
	private Node delete(Node node, K k) {
		if(node == null) return null;
		int cmp = k.compareTo(node.key);
		if(cmp < 0) node.left = delete(node.left, k);
		else if(cmp > 0) node.right = delete(node.right, k);
		else {
			if(node.right == null) return node.left;
			if(node.left == null) return node.right;
			Node t = node;
			node = min(t.right);
			node.right = deleteMin(t.right);
			node.left = t.left;
		}
		return node;
	}
	
	public void delete(K k) {
		root = delete(root, k);
	}
	
	public static void main(String[] args) {
		Bst<String, Integer> bst = new Bst<String, Integer>();
		String[] keys = {"E", "X", "A", "M", "P", "L", "E"};
		Integer[] values = {4, 7,   6,   5,   2  ,3  ,  8};
		
		for(int i=0;i<keys.length;i++) {
			bst.insert(keys[i], values[i]);
		}
		
		if(bst.search("E") == null)
			System.out.println("없어용");
		else 
			System.out.println(bst.search("E").val + "dd");
		
		bst.delete("E");
		System.out.println(bst.root.key + " - " + bst.root.val);
		
		if(bst.search("E") == null)
			System.out.println("없어용");
		else 
			System.out.println(bst.search("E").val);
	}

}

