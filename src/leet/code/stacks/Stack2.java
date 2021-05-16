package leet.code.stacks;


// This stack implementation is using a linked list

public class Stack2 {


    public Stack2 next;

    public Stack2 top;
    public int val;


    // Implement push method

    // Implement pop method

    // Define size variable

    public Stack2(int val) {
        this.val = val;
    }

    public void push(int val) {
        Stack2 dummyHead = new Stack2(val);
        dummyHead.next = top;
        top = dummyHead;
    }

    public void pop() {
        if(top == null) {
            return;
        }
        top = top.next;

    }
}
