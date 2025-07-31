package org.example;

//A concrete implementor
//This implementation is a classic LinkedList using nodes
//**NOT thread safe**
public class SinglyLinkedList<T> implements LinkedList<T> {

    private static class Node<T> {
        private final T data;
        private Node<T> next;
        private Node(T data, Node<T> next) {
            this.data = data;
            this.next = next;
        }
    }

    private int size;
    private Node<T> top;
    private Node<T> last;

    @Override
    public void addFirst(T element) {
        if(top == null) {
            last = top = new Node<>(element, null);
        }
        else {
            top = new Node<>(element, top);
        }
        size++;
    }

    @Override
    public T removeFirst() {
        if (top == null) return null;
        T temp = top.data;
        if (top.next == null) {
            top = null;
            last = null;
        }
        else {
            top = top.next;
        }
        size--;
        return temp;
    }

    @Override
    public void addLast(T element) {
        if (last == null) {
            last = top = new Node<>(element, null);
        }
        else {
            last.next = new Node<>(element, null);
            last = last.next;
        }
        size++;
    }

    @Override
    public T removeLast() {
        if (last == null) return null;
        if (top == last) {
            T temp = last.data;
            top = last = null;
            return temp;
        }
        //go to the last element
        Node<T> curr = top;
        while (curr.next != last) {
            curr = curr.next;
        }
        T result = last.data;
        last = curr;
        last.next = null;
        size--;
        return result;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("[");
        Node<T> temp = top;
        while (temp != null) {
            result.append(temp.data);
            if (temp.next != null) {
                result.append(", ");
            }
            temp = temp.next;
            result.append("]");
        }
        return result.toString();
    }
}
