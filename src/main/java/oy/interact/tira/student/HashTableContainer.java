package oy.interact.tira.student;

import java.util.function.Predicate;
import oy.interact.tira.util.Pair;
import oy.interact.tira.util.TIRAKeyedContainer;

public class HashTableContainer<K extends Comparable <K>, V> implements TIRAKeyedContainer<K,V> {

    private int count = 0;
    private int standardSize = 20;
    private Pair<K,V>[] array = new Pair[standardSize]; 

    @Override
    public void add(K key, V value) throws OutOfMemoryError, IllegalArgumentException {
        int collisionModifier = 0;
        boolean added = false;
        if (count * 1.65 >= array.length){
            reallocate();
        }
        do{
            int index = indexFor(key, collisionModifier, array.length);
            if (array[index] == null){
                array[index] = new Pair<>(key, value);
                added = true;
                count++;
            }
            else if(array[index].getKey().equals(key)) {
                array[index] = new Pair<>(key, value);
                added = true;
            }
            else{
                collisionModifier++;
            }
        } while (!added);
    }

    private int indexFor(K key, int collision, int arrayLength){
        int hash = key.hashCode();
        //Quadratic probing
        return ((hash + collision * collision) & 0x7FFFFFFF) % arrayLength;
    }

    private void reallocate(){
        int arraySize = (int) (array.length * 1.65);
        Pair<K,V>[] newArray = new Pair[arraySize];
        for(int i = 0; i < array.length; i++){
            Pair<K,V> pair = array[i];
            if (pair != null){
                int collisions = 0;
                int index = indexFor(pair.getKey(), collisions, newArray.length);
                while (newArray[index] != null){
                    collisions++;
                    index = indexFor(pair.getKey(), collisions, newArray.length);
                }
                newArray[index] = pair;
            }
        }
        array = newArray;
    }

    @Override
    public V get(K key) throws IllegalArgumentException {
        if (key.equals(null)){
            throw new IllegalArgumentException("Key can't be null");
        }
        int collisionModifier = 0;
        boolean found = false;
        V val = null;
        do{
            int index = indexFor(key, collisionModifier, array.length);
            if (array[index] != null){
                if (array[index].getKey().equals(key)){
                    val = array[index].getValue();
                    found = true;
                }
                else{
                    collisionModifier++;
                }
            }
            else {
                return null;
            }
        } while (!found);
        return val;
    }

    @Override
    public V remove(K key) throws IllegalArgumentException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'remove'");
    }

    @Override
    public V find(Predicate<V> searcher) {
        int collisionModifier = 0;
        boolean found = false;
        V val = null;
        do{
            int index = indexFor(searcher, collisionModifier);
            if (array[index] != null){
                if (searcher.test(array[index].getValue())){
                    val = array[index].getValue();
                    found = true;
                } else{
                    collisionModifier++;
                }
            }
            else {
                return null;
            }
        }while(!found);
        return val;
    }

    private int indexFor(Predicate<V> searcher, int collision){
        int hashCode = searcher.hashCode();
        return ((hashCode + collision * collision) & 0x7FFFFFFF) % array.length;
    }

    @Override
    public int size() {
        return count;
    }

    @Override
    public int capacity() {
        return array.length;
    }

    @Override
    public void ensureCapacity(int capacity) throws OutOfMemoryError, IllegalArgumentException {
        Pair<K,V>[] newArray = new Pair[capacity];
        for(int i = 0; i < array.length; i++){
            Pair<K,V> pair = array[i];
            if (pair != null){
                int collisions = 0;
                int index = indexFor(pair.getKey(), collisions, newArray.length);
                while (newArray[index] != null){
                    collisions++;
                    index = indexFor(pair.getKey(), collisions, newArray.length);
                }
                newArray[index] = pair;
            }
        }
        array = newArray;
     }

    @Override
    public void clear() {
        array = new Pair[standardSize];
        count = 0;
    }

    @Override
    public Pair<K, V>[] toArray() throws Exception {
        Pair<K,V>[] toArray = new Pair[count];
        int index = 0;
        for (int i = 0; i < array.length; i++){
            if (array[i] != null){
                toArray[index] = array[i];
                index++;
            }
        }
        return toArray;
    }
    
}
