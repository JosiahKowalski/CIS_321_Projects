public class LinkedListMine<T> {
    ListNode head;
    public void add(T e){
        ListNode node = new ListNode(e, head);
        head=node;
    }

    @Override
    public String toString() {
        StringBuilder list= new StringBuilder("List:");
        ListNode node = head;
        while (node != null){
            list.append(node);
            node = node.next;
        }
        return list.toString();
    }

    public void delete(T e, boolean quitOnFirst){
        ListNode node = head;
        ListNode prevNode = head;
        boolean firstFound = false;
        while (node != null && !(quitOnFirst && firstFound)){
            if (node.payload == e){
                if (node == head){
                    head = node.next;
                }
                else {
                    prevNode.next = node.next;
                }
                firstFound = true;
                // set node to next in list to continue deleting from the list (only applies if quitOnFirst is true)
                node = prevNode.next;
            }
            else {
                prevNode = node;
                node = node.next;
            }
        }
    }
//quitonfirst
    public void deleteFirst(T e) {
        delete(e, true);

//        ListNode node = head;
//        ListNode prevNode = head;
//        do {
//            if (node.payload.equals(e)) {
//                if (node == head) {
//                    head = node.next;
//                } else {
//                    prevNode.next = node.next;
//                }
//            }
//            else {
//                prevNode = node;
//                node = node.next;
//            }
//        }
//            while (!node.payload.equals(e));
    }

    public void deleteAll (T e) {
        delete(e, false);
    }

    public class ListNode{
        T payload;
        ListNode next;

        public ListNode(T p, ListNode n){
            this.payload = p;
            this.next = n;
        }

        @Override
        public String toString() {
            return "("+payload+")";
        }
    }
}
