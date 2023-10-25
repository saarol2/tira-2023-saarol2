package oy.interact.tira.student;

import oy.interact.tira.util.QueueInterface;

public class QueueImplementation <E> implements QueueInterface <E>{
    private static final int DEFAULT_CAPACITY = 10;
    private int head;
    private int tail;
    private int size;
    private Object[] queueArray;

    public QueueImplementation(){
        queueArray = new Object[DEFAULT_CAPACITY];
        size = 0;
        head = 0;
        tail = 0;
    }

    public QueueImplementation(int capacity){
        queueArray = new Object[capacity];
        size = 0;
        head = 0;
        tail = 0;
    }

    @Override
    public int capacity() {
        return queueArray.length;
    }

    @Override
    public void enqueue(E element) throws OutOfMemoryError, NullPointerException {
        if (element == null){
            throw new NullPointerException("Element is null");
        }
        if (size == capacity()) {
            try{
                reallocate(queueArray.length * 2);
            }
            catch (OutOfMemoryError e) {
                throw new OutOfMemoryError("Failed to allocate additional memory for the queue");
            }
        }
        if (tail >= capacity() && head > 0) {
            tail = 0;
        }
        queueArray[tail++] = element;
        size++;
    }


    private void reallocate(int newCapacity) {
        int nextIndex = 0;
        Object[] newQueueArray = new Object[newCapacity];
        for (int i = 0; i < capacity(); i++){
            if (head < capacity()){
                newQueueArray[i] = queueArray[head];
                head++;
            }
            else{
                newQueueArray[i] = queueArray[nextIndex];
                nextIndex++;
            }
        }
        tail = capacity();
        head = 0;
        queueArray = newQueueArray;
    }



    @Override
    public E dequeue() throws IllegalStateException {
        if (isEmpty()){
            throw new IllegalStateException("Queue is empty");
        }
        Object element = queueArray[head];
        head += 1;
        size -= 1;
        if (head >= capacity()){
            head = 0;
        }
        return (E) element;
    }

    @Override
    public E element() throws IllegalStateException {
        if (isEmpty()){
            throw new IllegalStateException("Queue is empty");
        }
        return (E) queueArray[head];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {
        size = 0;
        head = 0;
        tail = 0;
    }
    
    @Override
    public String toString() {
        int index = head;
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < size; i++){
            sb.append(queueArray[index]);
            if (i < size - 1) {
                sb.append(", ");
            }
            index++;
            if (index == queueArray.length){
                index = 0;
            }
        }
        sb.append("]");
        return sb.toString();
    }
}