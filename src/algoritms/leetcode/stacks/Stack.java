package algoritms.leetcode.stacks;

public class Stack {


    // Stack can be implemented in 2 ways one is dynamic array list // using linked list

    // push - on the lst element

    // pop - remove the last element

    // isEmpty - return true or fasle

    // maxSize

    public Object[] stackArray = new Object[10];

    public int size = 0;

    // push
    public void push(int i) {
        stackArray[size] = (Integer)i;
        size++;
    }


    // pop
    public void pop() {
        stackArray[size] = null;
        size--;
    }

    // isEmpty
    public boolean isEmpty() {
        return size == 0;
    }
}
