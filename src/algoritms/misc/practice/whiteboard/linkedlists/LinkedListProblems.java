package algoritms.misc.practice.whiteboard.linkedlists;

public class LinkedListProblems {


    public static void main(String[] args) {

        LinkedList llist = new LinkedList();
        llist.push(4);
        llist.push(3);
        llist.push(2);
        llist.push(1);

        llist.printReverse(llist.head);
    }

    // Java program to print reverse of a linked list
    static class LinkedList
    {
        Node head;  // head of list

        /* Linked list Node*/
        class Node
        {
            int data;
            Node next;
            Node(int d) {data = d; next = null; }
        }

        /* Function to print reverse of linked list */
        void printReverse(Node head)
        {
            if (head == null) {
                return;
            }

            // print list of head node
            printReverse(head.next);

           /* The recursion will get "stacked" right here!
                The code below this area will not get called
            until we go back up through the recursive stack.*/
            System.out.print(head.data+" ");

        }

        /* Utility Functions */

        /* Inserts a new Node at front of the list. */
        public void push(int new_data)
        {
        /* 1 & 2: Allocate the Node &
                  Put in the data*/
            Node new_node = new Node(new_data);

            /* 3. Make next of new Node as head */
            new_node.next = head;

            /* 4. Move the head to point to new Node */
            head = new_node;
        }

        /*Drier function to test the above methods*/


    }
}
