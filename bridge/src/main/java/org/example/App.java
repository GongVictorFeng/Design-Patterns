package org.example;

public class App 
{
    public static void main( String[] args )
    {
        //FifoCollection<Integer> collection = new Queue<>(new SinglyLinkedList<>());
        FifoCollection<Integer> collection = new Queue<>(new ArrayLinkedList<>());
        collection.offer(10);
        collection.offer(40);
        collection.offer(99);
        collection.offer(21);

        System.out.println(collection.poll());
        System.out.println(collection.poll());
        System.out.println(collection.poll());
        System.out.println(collection.poll());
        System.out.println(collection.poll());
    }
}
