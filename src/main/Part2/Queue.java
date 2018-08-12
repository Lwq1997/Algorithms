package main.Part2;

/**
 * @Author: Lwq
 * @Date: 2018/8/12 23:56
 * @Version 1.0
 * @Describe
 */
public interface Queue<E> {
    int getSize();
    boolean isEmpty();
    void enqueue(E e);
    E dequeue();
    E getFront();
}
