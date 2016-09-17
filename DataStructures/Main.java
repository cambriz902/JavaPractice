public class Main{

  public static void main(String[] args) {
    testLinkedList();
    testBinaryTree();
  }

  public static void testLinkedList() {
    SinglyLinkedList list = new SinglyLinkedList();
    for (int i = 0; i < 5; i++){
      list.insertHead(i);
    }
    System.out.println("***** LinkedList Test *****");
    list.printInOrder();
    list.reverseList(list.getHead());
    list.printInOrder();
    return;
  }

  public static void testBinaryTree() {
    BinaryTree tree = new BinaryTree();
    int[] test = {4,2,1,3,6,5,7,8};
    for(int i = 0; i < test.length; i++) {
      tree.insert(test[i]);
    }
    System.out.println("***** Binary Tree Test *****");
    System.out.println("size= " + tree.size());
    System.out.println("max height= " + tree.maxHeight());
    System.out.println("Pre order print");
    tree.printPreOrder();
    System.out.println("In order print");
    tree.printInOrder();
    System.out.println("Post order print");
    tree.printPostOrder();
    System.out.println("By level");
    tree.printByLevel();
    return;
  }
}