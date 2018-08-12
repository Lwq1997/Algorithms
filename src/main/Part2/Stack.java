package main.Part2;

/**
 * @Author: Lwq
 * @Date: 2018/8/12 23:14
 * @Version 1.0
 * @Describe
 */
public interface Stack<E> {
    int getSize();
    boolean isEmpty();
    void push(E e);
    E pop();
    E peek();
}
