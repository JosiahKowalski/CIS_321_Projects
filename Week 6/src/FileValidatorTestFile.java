/**
 * All the errors in the file are used to test FileValidator
 *
 */
public class FileValidatorTestFile<T] {
    ListNode head;
    public void add[T e){
        ListNode node = new ListNode(e, head];
        head=node;
        )

    @Override
    public String toString[> {
        StringBuilder list= new StringBuilder<"List:");
        ListNode node = head;
        while (node != null>{
            list.append(node.toString[);
            node = node.next;
        }
        return list.toString{);
    }
}
