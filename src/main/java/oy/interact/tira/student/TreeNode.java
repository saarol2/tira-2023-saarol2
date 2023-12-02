package oy.interact.tira.student;

import java.util.Comparator;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Predicate;

import oy.interact.tira.util.Pair;

public class TreeNode<K extends Comparable<K>, V> {
    private K key;
    private V value;
    private TreeNode<K, V> leftChild;
    private TreeNode<K, V> rightChild;
    private Comparator<K> comparator;
    
    public TreeNode(K key, V value) {
        this.key = key;
        this.value = value;
        this.leftChild = null;
        this.rightChild = null;
    }

    public K getKey() {
		return key;
	}

	public V getValue() {
		return value;
	}

    public boolean insert(K itemKey, V val, Comparator<K> comparator){
        if(value.equals(val)){
            value = val;
            key = itemKey;
            return false;
        }
        boolean result = false;
        if (comparator.compare(itemKey, key) <= 0){
            if(leftChild == null){
                leftChild = new TreeNode<>(itemKey, val);
                result = true;
            }
            else{
                result = leftChild.insert(itemKey, val, comparator);
            }
        }
        else{
            if(rightChild == null){
                rightChild = new TreeNode<>(itemKey, val);
                result = true;
            }
            else{
                result = rightChild.insert(itemKey, val, comparator);
            }
        }
        return result;
    }

    public V getV(K keyItem, Comparator<K> comparator){
        V result = null;
        if (keyItem.equals(key)){
            result = getValue();
        }
        else if(comparator.compare(keyItem, key) <= 0){
            if (leftChild != null){
                result = leftChild.getV(keyItem, comparator);
            }
        }
        else{
            if (rightChild != null){
                result = rightChild.getV(keyItem, comparator);
            }
        }
        return result;
    }

    public V findV(Predicate<V> searcher){
        V val = null;
        if (searcher.test(value)){
            val = getValue();
        }
        if (leftChild != null && val == null){
                val = leftChild.findV(searcher);
            }
        if (rightChild != null && val == null){
            val = rightChild.findV(searcher);
        }
        return val;
    }

    public void toSortedArray(Pair<K, V>[] array, AtomicInteger currentIndex) {
        if (this.value != null && this.key != null) {
            if (leftChild != null) {
                leftChild.toSortedArray(array, currentIndex);
            }
            array[currentIndex.getAndIncrement()] = new Pair<>(key, value);
            if (rightChild != null) {
                rightChild.toSortedArray(array, currentIndex);
            }
        }
    }
    

    public Pair<K, V> getPairFromIndex(int indexNumber, AtomicInteger atomInt) {
        if (value != null && key != null) {
            if (leftChild != null){
                Pair<K, V> leftResult = leftChild.getPairFromIndex(indexNumber, atomInt);
                if (leftResult != null) {
                    return leftResult;
                }
            }
            if (atomInt.getAndIncrement() == indexNumber){
                return new Pair<>(key, value);
            }
            if (rightChild != null){
                Pair<K, V> rightResult = rightChild.getPairFromIndex(indexNumber, atomInt);
                if (rightResult != null) {
                    return rightResult;
                }
            }
        }
        return null;
    }

    public int getIndexOf(K itemKey, AtomicInteger atomInt, Comparator<K> comparator){
        if (value != null && key != null){
            int result = -1;
            if (leftChild != null){
                result = leftChild.getIndexOf(itemKey, atomInt, comparator);
                if (result >= 0){
                    return result;
                }
            }
            atomInt.incrementAndGet();
            if (comparator.compare(itemKey, key) == 0) {
                return atomInt.get();
            }
            if (rightChild != null) {
                result = rightChild.getIndexOf(itemKey, atomInt, comparator);
                if (result >= 0) {
                    return result;
                }
            }
        }
        return -1;
    }

    public int findIndexOf(Predicate<V> searcher, AtomicInteger atomInt){
        if (value != null && key != null){
            int result = -1;
            if (leftChild != null){
                result = leftChild.findIndexOf(searcher, atomInt);
                if (result >= 0){
                    return result;
                }
            }
            atomInt.incrementAndGet();
            if (searcher.test(value)){
                return atomInt.get();
            }
            if (rightChild != null) {
                result = rightChild.findIndexOf(searcher, atomInt);
                if (result >= 0) {
                    return result;
                }
            }
        }
        return -1;
    }
}