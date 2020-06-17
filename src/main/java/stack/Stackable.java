package stack;

public interface Stackable<T> extends Iterable<T>{
    void push(T data);

    T pop();

    T peek();

    boolean empty();

    int size();

    void printAll();

    void clear();
}
