package cracking.coding.interview.stacks;

import algoritms.leetcode.models.MyStack;

public class StackAlgorithms extends MyStack<Integer> {

    // Implement a minimum value method in a stack 3.2
    // Solution keep another stack to keep track of minimum values
    MyStack<Integer> minValueStack;


    public StackAlgorithms() {
        minValueStack = new MyStack<Integer>();
    }

    @Override
    public void push(Integer item) {
        if(item.intValue() <= min()) {
            minValueStack.push(item);
        }
        super.push(item);
    }

    public int min() {
        if(minValueStack.isEmpty()) {
          return Integer.MAX_VALUE;
        }
        else {
           return minValueStack.peek();
        }
    }

    @Override
    public Integer pop() {
       int value = super.pop();
       if(value == min()) {
           minValueStack.pop();
       }
       return value;
    }}


    // CC 3.3


/*
    class FixedMultiStack {

        private int numberOfStacks = 3;
        private int stackCapacity;
        private int[] sizes;
        private int[] values;

        public FixedMultiStack(int stackSize) {
            stackCapacity = stackSize;
            values = new int[stackSize * stackCapacity];
            sizes = new int[numberOfStacks];
        }

        public void push(int stackNum , int value) {
            // check if the stack is full
            if(isFull(stackNum)) {
                System.out.println("Stack Full");
            }

            // Increment the stacksize array
            sizes[stackNum]++;
            // Update the top value


        }

        boolean isFull(int stackNum ) {
            if (sizes[stackNum] == stackCapacity) {
                return true;
            }
            return false;
        }

*/


/*
    }

    public static void main(String[] args) {
        String s = "[()]";
        isParenthesisBalanced(s);
    }

    // CC 3.1 Divide an array into three equal parts
    static void arrayToThreeStacks() {




    }

    // Problem 1 - check if parenthesis are balanced or not
    static void isParenthesisBalanced(String s) {


    }*/



   /* class StackArray {
        int top;
        int capacity;
        int[] stack;
    }
*/
    // Stacks Can Be Implemented in two way
    // One is array and the other is using linked lists

