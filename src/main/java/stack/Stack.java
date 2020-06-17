package stack;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Stack<T> implements Stackable<T> {

    private Node head;
    private int counter;

    private class Node {
        T data;
        Node next;
    }

    private class StackIterator implements Iterator<T>{
        Node next;
        StackIterator(){
            next = head;
        }

        @Override
        public boolean hasNext()  {
            return next != null;
        }

        @Override
        public T next() throws NoSuchElementException{
            if (!hasNext()) throw new NoSuchElementException();
            T result = next.data;
            next = next.next;
            return result;
                }

    }
    public Iterator<T> iterator() {
        return new StackIterator();
    }


    @Override
    public void push(T data) {
        Node memorized = head;
        head = new Node();
        head.data = data;
        head.next = memorized;
        counter++;
    }

    @Override
    public T pop() {
        if (head == null) {
            return null;
        }
        T retObj = head.data;
        head = head.next;
        counter--;
        return retObj;
    }

    @Override
    public T peek() {
        if (head == null) {
            return null;
        }
        return head.data;
    }

    @Override
    public boolean empty() {
        return head == null;
    }

    @Override
    public int size() {
        return counter;
    }
    @Override
    public void printAll() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    @Override
    public void clear() {
        head = null;
        counter = 0;
    }
}
