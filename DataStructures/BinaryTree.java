import java.util.LinkedList;

/* Methods
 * size()
 * insert(int input)
 * contains(int input)
 * maxHeight()
 * printPreOrder()
 * printInOrder()
 * printPostOrder()
 * printByLevel()
 */

public class BinaryTree {

  private Node root;
  private int size;

  class Node {
    Node left;
    Node right;
    int value;

    Node() {
      this.left = null;
      this.right = null;
      this.value = -1;
    }

    Node(int value){
      this.left = null;
      this.right = null;
      this.value = value;
    }
  }

  BinaryTree() {
    this.root = null;
    this.size = 0;
  }

  public int size(){
    return this.size;
  }

  public void insert(int value){
    Node newNode = new Node(value);
    if(root == null){
      root = newNode;
    } else {
      Node curr = root;
      while(true) {
        if(value == curr.value) {
          break;
        } else if(value > curr.value){
          if(curr.right == null) {
            curr.right = newNode;
            break;
          } else {
            curr = curr.right;
          }
        } else {
          if(curr.left == null) {
            curr.left = newNode;
            break;
          } else {
            curr = curr.left;
          }
        }
      }
    }
    this.size++;
    return;
  }

  public boolean contains(int value) {
    Node curr = root;
    while(curr != null) {
      if(curr.value == value){
        return true;
      } else if(curr.value > value) {
        curr = curr.right;
      } else {
        curr = curr.left;
      }
    }
    return false;
  }

  public int maxHeight() {
    return maxHeightRecursive(this.root);
  }

  public void printPreOrder() {
    printPreOrderRecursive(this.root);
  }

  public void printPostOrder() {
    printPostOrderRecursive(this.root);
  }

  public void printInOrder() {
    printInOrderRecursive(this.root);
  }

  public void printByLevel() {
    if(root == null){
      return;
    }
    LinkedList<Node> nodeQueue = new LinkedList<Node>();
    nodeQueue.add(root);
    Node lastInlevel = root;  
    Node curr;
    while(nodeQueue.peek() != null) {
      curr = nodeQueue.poll();
      System.out.print(curr.value + " ");
      if(curr.left != null) {
        nodeQueue.add(curr.left);
      }
      if(curr.right != null) {
        nodeQueue.add(curr.right);
      }
      if(curr == lastInlevel){
        System.out.println();
        if(curr.right != null){
          lastInlevel = curr.right;
        } else if (curr.left != null) {
          lastInlevel = curr.left;
        } else {
          lastInlevel = null;
        }
      } 
    }
    return;
  }

  /**************************************************/
  /************** Private Methods *******************/
  /**************************************************/
  private int maxHeightRecursive(Node root){
    if(root == null){
      return 0;
    }
    return 1 + Math.max(maxHeightRecursive(root.left), maxHeightRecursive(root.right));
  }

  private void printPreOrderRecursive(Node root){
    if(root == null){
      return;
    }
    System.out.println(root.value);
    printPreOrderRecursive(root.left);
    printPreOrderRecursive(root.right);
  }

  private void printInOrderRecursive(Node root){
    if(root == null){
      return;
    }
    printInOrderRecursive(root.left);
    System.out.println(root.value);
    printInOrderRecursive(root.right);
  }

  private void printPostOrderRecursive(Node root){
    if(root == null){
      return;
    }
    printPostOrderRecursive(root.left);
    printPostOrderRecursive(root.right);
    System.out.println(root.value);
  }
}
