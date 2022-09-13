public class LoopDetectionINLL {
    static Node head;

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static void printList() {
        Node currentNode = head;
        while (currentNode != null) {
            System.out.print(currentNode.data);
            currentNode = currentNode.next;
            System.out.print("-->");
        }
    }

    public static void getMeetingPoint() {
        Node fast = head;
        Node slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                System.out.println("");
                System.out.println("slow and fast meet as node::" + slow.data);
                removeLoop(slow);
            }
        }
    }

    public static void removeLoop(Node slow) {
        Node temp = head;
        System.out.println("slow.next ::"+slow.next.data );
        System.out.println("temp.next ::"+temp.next.data);
        while (slow.next != temp.next) {
            System.out.println("inside while::");
            temp = temp.next;
            slow = slow.next;
        }
        slow.next = null;//break the link

    }

    public static void main(String[] args) {
        //LoopDetectionINLL ll = new LoopDetectionINLL();
        LoopDetectionINLL.head = new Node(1);
        LoopDetectionINLL.head.next = new Node(2);
        LoopDetectionINLL.head.next.next = new Node(3);
        LoopDetectionINLL.head.next.next.next = new Node(4);
        LoopDetectionINLL.head.next.next.next.next = new Node(5);
        LoopDetectionINLL.head.next.next.next.next.next=head.next.next;
        LoopDetectionINLL.getMeetingPoint();
        LoopDetectionINLL.printList();

    }
}
