package org.example;

//A concrete implementor
//This implementation uses arrays to implement LinkedList

//Please note, code below is quickly thrown together & lacks many checks and fixes to make it truly usable
//**NOT thread safe**
public class ArrayLinkedList<T> implements LinkedList<T> {

    private static final int DEFAULT_SIZE = 2;
    private T[] data;
    int size;

    @SuppressWarnings("unchecked")
    public ArrayLinkedList() {
        data = (T[]) new Object[DEFAULT_SIZE];
    }

    @Override
    public void addFirst(T element) {
        ensureCapacity(++size);
        shiftOneRight();
        data[0] = element;
    }

    @Override
    public T removeFirst() {
        if (size == 0) return null;

        T first = data[0];
        size--;
        shiftOneLeft();
        return first;
    }

    @Override
    public void addLast(T element) {
        ensureCapacity(++size);
        data[size-1] = element;
    }

    @Override
    public T removeLast() {
        if (size == 0) return null;
        return data[size--];
    }

    @Override
    public int getSize() {
        return size;
    }

    @SuppressWarnings("unchecked")
    private void ensureCapacity(int newSize) {
        if (data.length > newSize) return;

        T[] temp = (T[]) new Object[data.length + DEFAULT_SIZE];
        System.arraycopy(data, 0, temp, 0, data.length);
        data = temp;
    }

    private void shiftOneRight() {
        System.arraycopy(data, 0, data, 1, size);
    }

    private void shiftOneLeft() {
        System.arraycopy(data, 1, data, 0, size);
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("[");
        for (int i = 0; i < size; i++) {
            result.append(data[i]);
            if (i != size - 1) result.append(",");
        }
        result.append("]");
        return result.toString();
    }
}
