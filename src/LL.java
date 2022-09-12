/*Custom singular  Linkedlist*/
public class LL {
    Node head;
    int size;

    public static void main(String args[]) {
        LL list = new LL();
        list.addFirst("3");
        list.addFirst("2");
        list.addFirst("1");
        list.printList();
        list.getListSize();
        //list.deleteFirst();
        //list.deletLast();
        //list.printList();
        //list.getListSize();
        list.reversListBasicApproach();
        list.printList();
        // list.head=list.reversListRecursiveApproach(list.head);
        //list.printList();
        //list.reversListIterativeApproach();
        //list.printList();
    }

    /**
     * Node Class
     * data and next pointer
     */
    public class Node {
        String data;
        Node next;

        Node(String data) {
            this.data = data;
            this.next = null;
        }
    }

    //Adding element at first position
    public void addFirst(String data) {
        Node newNode = new Node(data);//new node to be added at start of list
        size++;
        if (head == null) {//when list is empty
            head = newNode; //head will point to newNode
            return;
        }
        newNode.next = head; //when list has element, newNode next will point to existing head
        head = newNode;//head will now point to newNode instead of existing head node
    }

    //delete starting element/node of list
    public void deleteFirst() {
        if (head == null) {//list is empty
            return;
        }
        if (head.next == null) {//only one element
            head = null;
        }
        size--;
        head = head.next;
    }

    //delete last element/node of list, we need 2 pointer previous and second last
    public void deletLast() {
        if (head == null) {//when list is empty
            return;
        }
        if (head.next == null) {//if list ahs only one element
            head = null;
        }
        Node currentNode = head.next;//to give last pointer
        Node previousNode = head;//to give second last pointer

        size--;
        while (currentNode.next != null) {//when list is not empty
            currentNode = currentNode.next;//current node will keep on pointing to next node until next pointer becomes null
            previousNode = previousNode.next;
        }
        previousNode.next = null;
    }

    //adding element at Last position
    public void addLast(String data) {
        Node newNode = new Node(data);//newNode created to add at last
        size++;
        if (head == null) {///when list is empty
            head = newNode;
            return;
        }
        Node currentNode = head;//created pointer called current node which will start from head
        if (currentNode.next == null) {//when list has only one element
            newNode.next = currentNode;
            newNode.next = null;
            return;
        }
        while (currentNode.next != null) {//when list is not empty
            currentNode = currentNode.next;//current node will keep on pointing to next node until next pointer becomes null
        }
        currentNode.next = newNode;//when next pointer of currentNode is null then currentNode's next pointer will point to newNode instead of null
        newNode.next = null;//and newNode.next pointer will now become null
    }

    //print element of list
    public void printList() {
        Node currentNode = head;
        if (head == null) {
            System.out.println("List is empty!!!");
        }

        while (currentNode != null) {//keep on traversing through list until currentNode is not null
            System.out.print(currentNode.data + "-->"); //printing data
            currentNode = currentNode.next;//incrementing currentNode pointer
        }
        System.out.println("null");//last node next will be null
        System.out.println("head in printList::" + head.data);
    }

    //retriev the size of the list
    public void getListSize() {
        System.out.println("");
        System.out.println("size of list is::" + size);
        System.out.println("head in getListSize::" + head.data);
    }

    //consider set of 3 previous-head  current-head.next  next=current.next
    //iterative approach
    public void reversListIterativeApproach() {
        System.out.println("head in reversList start::" + head.data);
        if (head == null || head.next == null) {//when list is empty or has one element only
            return;
        }
        Node previousNode = head;
        Node currentNode = head.next;
        while (currentNode != null) {
            Node nextNode = currentNode.next;
            currentNode.next = previousNode;
            //update pointers
            previousNode = currentNode;
            currentNode = nextNode;
        }
        head.next = null;//make start of head.next as null i.e. delete starting linkage of head
        head = previousNode;//make last node as head
        System.out.println("");
        System.out.println("head in reversList END::" + head.data);

    }

    //iterate through list and add elemnts in array and print array in reverse
    public void reversListBasicApproach() {
        System.out.println("head in reversListBasicApproach start::" + head.data);
        String ar[] = new String[size + 1];
        int i = 0;
        if (head == null || head.next == null) {//when list is empty or has one element only
            return;
        }

        while (head.next != null && i < size) {
            ar[i] = head.data;
            head = head.next;
            i++;
        }
        System.out.println("size of array::" + ar.length);

        if (head != null) {//for adding last element in array
            //  System.out.println("i is2::"+i);
            ar[i] = head.data;
        }

        for (int j = size - 1; j >= 0; j--) {
            //  System.out.println("j is::"+j);
            System.out.print(ar[j] + "-->");
        }
        System.out.println("");
        System.out.println("head in reversListBasicApproach END::" + head.data);

    }

    public Node reversListRecursiveApproach(Node Head) {
        //System.out.println("head in reversListRecursiveApproach start::"+head.data);
        if (head == null || head.next == null) {//when list is empty or has one element only
            return head;
        }
        Node newHead = reversListRecursiveApproach(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

}
