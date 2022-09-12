public class LinkedListPalindrome {
    static Node head;

    class Node {
        Node next;
        int data;

        Node(int data) {
            this.data = data;
            this.next = null;

        }
    }

    public void addFirst(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node currentNode = head;
        head = newNode;
        newNode.next = currentNode;
    }

    public void printList() {
        if (head == null) {
            System.out.println("List is empty!!");
        }
        Node currentNode = head;
        while (currentNode != null) {
            System.out.print(currentNode.data + "-->");
            currentNode = currentNode.next;
        }
        System.out.println("null");
    }

    public Node reverseList(Node head) {
        Node previousNode = null;
        Node currentNode = head;
        while (currentNode != null) {
            Node nextNode = currentNode.next;
            currentNode.next = previousNode;
            //update pointers
            previousNode = currentNode;
            currentNode = nextNode;
        }
        //head.next = null;
        //head = previousNode;
        return previousNode;

    }

    public Node getMiddleNode(Node head) {
        Node fast = head;
        Node slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;

        }
        return slow;
    }

    public static void main(String[] args) {
        LinkedListPalindrome ll = new LinkedListPalindrome();
        ll.addFirst(1);
        ll.addFirst(2);
        ll.addFirst(2);
        ll.addFirst(1);
        System.out.println("given list is as below::");
        ll.printList();

        boolean isListPalindorm = checkIfListIsPalindrom(ll);
        if (isListPalindorm) {
            System.out.println("Given List is palindrome!!!");
        } else {
            System.out.println("Given List is not palindrome!!!");
        }

    }

    private static boolean checkIfListIsPalindrom(LinkedListPalindrome ll) {
        Node head = LinkedListPalindrome.head;
        Node middle = ll.getMiddleNode(head);///get the middle of the list
        System.out.println("Mid of the list::" + middle.data);
        Node secondHalfStart = ll.reverseList(middle.next);//make the second half as reverse
        System.out.println("head of second half of the list::" + secondHalfStart.data);
        Node firstHalfStart = head;//head of first half
        System.out.println("head of first half of the list::" + firstHalfStart.data);
        while (secondHalfStart != null) {//compare from second half head
            if (secondHalfStart.data != firstHalfStart.data) {
                return false;
            }
            secondHalfStart = secondHalfStart.next;
            firstHalfStart = firstHalfStart.next;
        }
        return  true;
    }
}
