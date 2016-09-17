/* Methods
 * insertFirst
 * insertTail
 * insertIndex
 * getLength
 * printList
 * reverseList
 */

public class SinglyLinkedList{

  private int length;
  private Node head;

  class Node {
    private int value;
    private Node next;

    public Node(int value){
      this.value = value;
      this.next = null;
    }

    public int getValue(){
      return this.value;
    }
  }

  public SinglyLinkedList(){
    this.length = 0;
    this.head = null;
  }

  public Node getHead(){
    return head;
  }

  public void insertHead(int value){
    Node newNode = new Node(value);
    if(head != null){
      newNode.next = head;
    }
    head = newNode;
    length++;
  }

  public void insertTail(int value){
    Node newNode = new Node(value);
    if(head == null){
      head = newNode;
    } else {
      Node curr = head;
      while(curr.next != null) {
        curr = curr.next;
      }
      curr.next = newNode;
    }
    length++;
  }

  public void reverseList(Node node){
    if(node.next == null){
      head = node;
      return;
    }
    Node nextNode = node.next;
    node.next = null;
    reverseList(nextNode);
    nextNode.next = node;
  }

  public void printInOrder(){
    Node curr = head;
    while(curr != null) {
      System.out.println(curr.value);
      curr = curr.next;
    }
  }
}










