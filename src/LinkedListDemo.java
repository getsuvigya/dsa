public class LinkedListDemo {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.addNode(5);
        linkedList.traverseNode();
        linkedList.addNode(6);
        linkedList.addNode(7);
        linkedList.addNode(8);
        linkedList.addNode(9);
        linkedList.traverseNode();
        /*System.out.println("delete 9");
        linkedList.deleteNode(9);
        linkedList.traverseNode();
        System.out.println("delete 5");
        linkedList.deleteNode(5);
        linkedList.traverseNode();
        System.out.println("delete 7");
        linkedList.deleteNode(7);
        linkedList.traverseNode();*/
        System.out.println("reverse");
        linkedList.reverseList();
        linkedList.traverseNode();
    }
}

class LinkedList{
    Node head;
    public LinkedList(){

    }

    public Node addNode(int data){
        Node n = new Node(data);
        Node temp = head;
        if(head==null){
            head  = n;
            return head;
        }
        else{

            while(temp.next!=null){
                temp = temp.next;
            }
            temp.next = n;
            temp = temp.next;
            return temp;
        }
    }

    public void traverseNode(){
        Node temp = head;
        while(temp!=null){
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    public void deleteNode(int data){
        Node temp = head;
        Node previous = null;
        if(head!=null && head.data == data){
            head = head.next;
            temp = head;
            return;
        }
        while (temp!=null){
            if(temp.data==data){
               previous.next = temp.next;
               temp.next = null;
               break;
            }
            previous = temp;
            temp = temp.next;

        }
    }

    public int findMiddleElement(){
        Node temp = head;
        Node prev = head;
        int k = 0;
        while(temp.next!=null){
            if(k%2==0){
                prev = prev.next;
            }
            temp = temp.next;
            k++;        }
        return prev.data;
    }

    public void reverseList(){
        Node prev = null;
        Node current = head;
        Node temp = null;
        while(current!=null){
            temp = current.next;
            current.next = prev;
            prev = current;
            current = temp;
        }
       head = prev;
    }
}

class Node{
    int data;
    Node next;
    public Node(int data){
        this.data = data;
    }
}