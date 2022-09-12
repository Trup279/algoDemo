public class nthNodeSearchProgram {
    Node head;
    int size;

    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public void addFirst(int data) {
        Node currentNode = head;
        Node newNode = new Node(data);
        size++;
        if (head == null) {
            head = newNode;
            return;
        }
        newNode.next=head;
        head = newNode;
    }


    public void addLast(int data) {
        Node currentNode = head;
        size++;
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        while(currentNode.next==null) {
            currentNode.next=newNode;
            newNode.next=null;
            return;
        }
        while(currentNode.next!=null) {
            currentNode=currentNode.next;
        }
        currentNode.next=newNode;
        newNode.next=null;
    }


    public void printList() {
        if(head==null){
            return;
        }
        Node currentNode = head;
        while (currentNode != null) {
            System.out.print(currentNode.data+ "-->");
            currentNode = currentNode.next;

        }
        System.out.println("null");
    }

    public void getListSize(){
        System.out.println("size of the list is::"+size);
    }

    public void searchNthNode(int n){
        int indexToSearch=size-n;
        int i=1;
        Node previousNode=head;
        while (i<indexToSearch){
            previousNode=previousNode.next;
            i++;
        }
        System.out.println("data::"+previousNode.data);
        previousNode.next=previousNode.next.next;
    }
    public static void main(String[] args) {
        nthNodeSearchProgram n=new nthNodeSearchProgram();
        n.addFirst(1);
        n.addLast(2);
        n.addLast(3);
        n.addLast(4);
        n.addLast(5);
        n.printList();
        n.getListSize();
        n.searchNthNode(2);//search from last


    }
}
