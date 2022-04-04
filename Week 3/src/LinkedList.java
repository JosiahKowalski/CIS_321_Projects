import java.util.List;

/**
* Compile: javac LinkedList.java
* Run:     java LinkedList
**/

public class LinkedList {
  ListNode head;

  public void add (int e) {
    //System.out.println("add "+e);
    ListNode node = new ListNode(e,head);
    head=node;
  }

  public void delete (int e) {
    ListNode node = head;
    while (node != null){
      if (node.payload == e){
        node.payload = null;
        break;
      }
      node=node.next;
    }
  }

  public String toString () {
      String list ="LIST:";
      ListNode node = head;
      while (node != null) {
        if (node.payload != null) {
          list += node.toString();
        }
        node = node.next;
      }
      return list;
  }

  public class ListNode {
    Integer payload;
    ListNode next;

    public ListNode (Integer p, ListNode n) {
      this.payload = p;
      this.next = n;
    }

    public String toString () {
      return "("+payload+")";
    }
  }

  public static void main (String [] args) {
    LinkedList list = new LinkedList();
    list.add(1);
    list.add(2);
    list.add(3);
    System.out.println(list);
    list.delete(2);
    System.out.println(list);
  }

}
