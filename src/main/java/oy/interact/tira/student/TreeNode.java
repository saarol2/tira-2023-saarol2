package oy.interact.tira.student;

public class TreeNode<K extends Comparable<K>, V> {
    K key;
    V value;
    TreeNode<K, V> leftChild;
    TreeNode<K, V> rightChild;
    int size;
    
    public TreeNode(K key, V value) {
        this.key = key;
        this.value = value;
        this.leftChild = null;
        this.rightChild = null;
        this.size = 1;
    }

    public K getKey() {
		return key;
	}

	public V getValue() {
		return value;
	}

}