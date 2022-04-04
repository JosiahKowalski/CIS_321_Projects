public class LinkedListDemo {
    public LinkedListDemo() {
    }

    public static void main(String[] args) {
        LinkedListMine<String> list = new LinkedListMine();
        list.add("1st");
        list.add("2nd");
        list.add("3rd");
        list.add("3rd");
        System.out.println(list);
        list.deleteFirst("3rd");
        System.out.println(list);
    }
}
