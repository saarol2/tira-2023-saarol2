package oy.interact.tira.student;

import oy.interact.tira.util.StackInterface;

public class StackImplementation <E> implements StackInterface <E> {
    private static final int DEFAULT_STACK_SIZE = 10;
    private Object[] itemArray;
    private int top;

    public StackImplementation(){
        itemArray = new Object[DEFAULT_STACK_SIZE];
        top = -1;
    }

    public StackImplementation(int capacity){
        itemArray = new Object[capacity];
        top = -1;
    }

    @Override
    public int capacity() {
        return itemArray.length;
    }

    @Override
    public void push(E element) throws OutOfMemoryError, NullPointerException {
        if (element == null) {
            throw new NullPointerException("Element cannot be null");
        }
        if (top == itemArray.length - 1){
            try{
                reallocate(itemArray.length * 2);
            }
            catch (OutOfMemoryError e) {
                throw new OutOfMemoryError("Failed to allocate additional memory for the stack");
            }
        }
        itemArray[++top] = element;
    }

    private void reallocate(int newCapacity){
        Object[] newItemArray = new Object[newCapacity];
        for(int i = 0; i< itemArray.length; i++){
            newItemArray[i] = itemArray[i];
        }
        itemArray = newItemArray;
    }

    @Override
    public E pop() throws IllegalStateException {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        E element = (E) itemArray[top];
        itemArray[top--] = null;
        return element;
    }

    @Override
    public E peek() throws IllegalStateException {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        if (top == -1){
            return null;
        }
        return (E) itemArray[top];
    }

    @Override
    public int size() {
        return top + 1;
    }

    @Override
    public boolean isEmpty() {
        return top == -1;
    }

    @Override
    public void clear() {
        itemArray = new Object[DEFAULT_STACK_SIZE];
        top = -1;
    }
    
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i <= top; i++){
            sb.append(itemArray[i]);
            if (i < top){
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

}
