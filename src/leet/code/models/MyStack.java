package leet.code.models;

import java.util.EmptyStackException;

public class MyStack<T> {

    private static class MyStackNode<T> {

        private T data;
        private MyStackNode<T> next;

        public MyStackNode(T item) {
            this.data = item;
        }
    }

    private MyStackNode<T> top;

    // push method
    public void push(T item) {

        MyStackNode<T> myStackNode = new MyStackNode<>(item);

        // Point the next one to the top
        myStackNode.next = top;

        // Point the top to the newly added stack node
        top = myStackNode;

    }

    // pop method
    public T pop() {
      if(top == null) {
          throw new EmptyStackException();
      }
      T item = top.data;
      top = top.next;
      return item;
    }

    // peek method
    public T peek() {
        if(top == null) {
            throw  new EmptyStackException();
        }
        return top.data;
    }

    // empty method
    public boolean isEmpty() {
        return top == null;
    }



}
