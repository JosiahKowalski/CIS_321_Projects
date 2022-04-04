import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Class {
    public static void main(String[] args) {
        List<String> list;
        list = new LinkedList<>();
        java.lang.Class listType = list.getClass();
        System.out.println(listType);
    }
}
