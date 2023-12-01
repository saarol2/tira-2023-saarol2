package oy.interact.tira.student;

import java.util.Comparator;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Predicate;

import oy.interact.tira.util.Pair;
import oy.interact.tira.util.TIRAKeyedOrderedContainer;
import oy.interact.tira.util.Visitor;

public class BinarySearchTreeContainer<K extends Comparable<K>, V> implements TIRAKeyedOrderedContainer<K, V> {
    private TreeNode<K, V> root;
    private int size;

    private Comparator<K> comparator;

    public BinarySearchTreeContainer(Comparator<K> comparator) {
		this.comparator = comparator;
        this.root = null;
        this.size = 0;
	}

    @Override
    public void add(K key, V value) throws OutOfMemoryError, IllegalArgumentException {
        if (size > Integer.MAX_VALUE){
            throw new OutOfMemoryError("Out of memory!");
        }
        if (key == null || value == null){
            throw new IllegalArgumentException("Key or value cannot be null");
        }
        if (root == null){
            root = new TreeNode<>(key, value);
            size++;
        }
        else{
            if (root.insert(key, value, comparator)){
                size++;
            }
        }
    }

    @Override
    public V get(K key) throws IllegalArgumentException {
        if (key.equals(null)) {
            throw new IllegalArgumentException("Key cannot be null");
        }
        if (root == null){
            return null;
        }
        return root.getV(key, comparator);
    }

    @Override
    public V remove(K key) throws IllegalArgumentException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'remove'");
    }

    @Override
    public V find(Predicate<V> searcher) {
        if (root == null){
            return null;
        }
        else{
            return root.findV(searcher);
        }
    }
    
    @Override
    public int size() {
        return size;
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
        root.toSortedArray(array, arrayIndex);
        return array;
    }
    
    @Override
    public Pair<K, V> getIndex(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= size){
            throw new IndexOutOfBoundsException("index should be more than 0 and less than BST size");
        }
        AtomicInteger atomicInt = new AtomicInteger(0);
        return root.getPairFromIndex(index, atomicInt);
    }

    @Override
    public int indexOf(K itemKey) {
        AtomicInteger indexCounter = new AtomicInteger(-1);
        if (root == null){
            return -1;
        }
        return root.getIndexOf(itemKey, indexCounter, comparator);
    }

    @Override
    public int findIndex(Predicate<V> searcher) {
        AtomicInteger indexCount = new AtomicInteger(-1);
        if (root == null){
            return -1;
        }
        return root.findIndexOf(searcher, indexCount);
    }

    @Override
    public void accept(Visitor<K, V> visitor) throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'accept'");
    }
}