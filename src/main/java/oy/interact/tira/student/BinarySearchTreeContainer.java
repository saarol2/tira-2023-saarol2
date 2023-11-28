package oy.interact.tira.student;

import java.util.Comparator;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Predicate;

import oy.interact.tira.util.Pair;
import oy.interact.tira.util.TIRAKeyedOrderedContainer;
import oy.interact.tira.util.Visitor;

public class BinarySearchTreeContainer<K extends Comparable<K>, V> implements TIRAKeyedOrderedContainer<K, V> {
    TreeNode<K, V> root;
    int count;

    private Comparator<K> comparator;

    public BinarySearchTreeContainer(Comparator<K> comparator) {
		this.comparator = comparator;
        this.root = null;
        this.count = 0;
	}

    @Override
    public void add(K key, V value) throws IllegalArgumentException {
        if (key == null || value == null) {
            throw new IllegalArgumentException("Key or value cannot be null");
        }
        root = addHelper(root, key, value);
        count++;
    }

    private TreeNode<K, V> addHelper(TreeNode<K, V> current, K key, V value) {
        if (current == null) {
            return new TreeNode<>(key, value);
        }
        int compare = comparator.compare(key, current.key);
        if (compare < 0) {
            current.leftChild = addHelper(current.leftChild, key, value);
        } else if (compare > 0) {
            current.rightChild = addHelper(current.rightChild, key, value);
        } else {
            current.value = value;
            return current;
        }
        current.size = 1 + calculateSize(current.leftChild) + calculateSize(current.rightChild);
        return current;
    }

    @Override
    public V get(K key) throws IllegalArgumentException {
        if (key == null) {
            throw new IllegalArgumentException("Key cannot be null");
        }
        return getHelper(root, key);
    }

    private V getHelper(TreeNode<K, V> node, K key) {
        if (node == null) {
            return null;
        }
        int compareResult = comparator.compare(key, node.key);
        if (compareResult < 0) {
            return getHelper(node.leftChild, key);
        } else if (compareResult > 0) {
            return getHelper(node.rightChild, key);
        } else {
            return node.value;
        }
    }   

    @Override
    public V remove(K key) throws IllegalArgumentException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'remove'");
    }

    @Override
    public V find(Predicate<V> searcher) {
        return findValue(root, searcher);
    }

    private V findValue(TreeNode<K, V> node, Predicate<V> searcher) {
        if (node == null) {
            return null;
        }
        if (searcher.test(node.value)) {
            return node.value;
        }
        V leftResult = findValue(node.leftChild, searcher);
        if (leftResult != null) {
            return leftResult;
        }
        return findValue(node.rightChild, searcher);
    }
    
    @Override
    public int size() {
        return calculateSize(root);
    }

    private int calculateSize(TreeNode<K, V> node) {
        if (node == null) {
            return 0;
        }
        return 1 + calculateSize(node.leftChild) + calculateSize(node.rightChild);
    }

    @Override
    public int capacity() {
        return Integer.MAX_VALUE;
    }

    @Override
    public void ensureCapacity(int capacity) throws OutOfMemoryError, IllegalArgumentException {
        if (capacity <= 0 || capacity < size()) {
            throw new IllegalArgumentException("Invalid capacity");
        }
    }

    @Override
    public void clear() {
        root = null;
    }

    @Override
    public Pair<K, V>[] toArray() {
        Pair<K, V>[] array = new Pair[size()];
        AtomicInteger arrayIndex = new AtomicInteger(0);
        toSortedArray(root, array, arrayIndex);
        return array;
    }

    private void toSortedArray(TreeNode<K, V> node, Pair<K, V>[] array, AtomicInteger currentIndex) {
        if (node == null) {
            return;
        }
        toSortedArray(node.leftChild, array, currentIndex);
        array[currentIndex.getAndIncrement()] = new Pair<>(node.key, node.value);
        toSortedArray(node.rightChild, array, currentIndex);
    }
    
    @Override
    public Pair<K, V> getIndex(int index) throws IndexOutOfBoundsException {
        if (index < 0 ||index >= count){
            return null;
        }
        return getIndexHelper(root, index);
    }

    private Pair<K,V> getIndexHelper(TreeNode<K,V> node, int index){
        if (node == null){
            return null;
        }
        int leftChildSize = calculateSize(node.leftChild);
        if (index < leftChildSize){
            return getIndexHelper(node.leftChild, index);
        }
        else if(index == leftChildSize){
            return new Pair<>(node.key, node.value);
        }
        else{
            return getIndexHelper(node.rightChild, index - leftChildSize - 1);
        }
    }

    @Override
    public int indexOf(K itemKey) {
    }

    @Override
    public int findIndex(Predicate<V> searcher) {
    }

    @Override
    public void accept(Visitor<K, V> visitor) throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'accept'");
    }
}