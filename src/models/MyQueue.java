package models;
public class MyQueue<T> {

    // Linked List Queue Node
    private static class MyQueueNode<T> {

        private T data;
        private MyQueueNode<T> next;

        public MyQueueNode( T item ){
            this.data = item;
        }

    private MyQueueNode<T> front;
    private MyQueueNode<T> rear;

    // enqueue
    public void enqueue(T item) {
        MyQueueNode<T> queueNode = new MyQueueNode<>(item);

      if(rear == null){
       this.front = this.rear = queueNode;
      }
        // Add the new node at the end of the queue and change rear
        rear.next = queueNode;
        rear = queueNode;
    }

    // dequeue
    public T dequeue() {
        //If Empty queue nothing to remove
        if(this.front == null) {
            return null;
        }
        // save and return the first node
        MyQueueNode<T> firstNode = this.front;

        // mode the front node to the next one
        this.front = this.front.next;

        // for some reason if the front becomes null change rear to null
        if(this.front == null) {
            this.rear = null;
        }
        return firstNode.data;
    }

    // isEmpyty
   public boolean isEmpty() {
       return this.front == null;
    }

    // peek
    public T peek() {
        if(front == null) {
            throw new NullPointerException("Queue Is Null");
        }
        return front.data;
    }
    }
}
