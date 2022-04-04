import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListMineTest {

    protected LinkedListMine<Integer> list;

    @BeforeEach
    public void setUp() {
        list = new LinkedListMine<>();
        list.add(1);
        list.add(2);
        list.add(3);
    }

    @Test
    void add() {
        list.add(4);
        assertEquals(list.toString(), "List:(4)(3)(2)(1)");
    }

    @Test
    void testToString() {
        assertEquals(list.toString(), "List:(3)(2)(1)");
    }

    @Test
    void deleteMiddle() {
        list.add(2);
        list.deleteFirst(2);
        assertEquals(list.toString(), "List:(3)(2)(1)");
    }

    @Test
    void deleteBeginning() {
        list.add(3);
        list.deleteFirst(3);
        assertEquals(list.toString(), "List:(3)(2)(1)");
    }

    @Test
    void deleteEnd() {
        list.add(1);
        list.deleteFirst(1);
        assertEquals(list.toString(), "List:(3)(2)(1)");
    }

    @Test
    void deleteAll2() {
        list.add(2);
        list.deleteAll(2);
        assertEquals(list.toString(), "List:(3)(1)");
    }

    @Test
    void deleteAll3() {
        list.add(3);
        list.deleteAll(3);
        assertEquals(list.toString(), "List:(2)(1)");
    }

    @Test
    void deleteAll1() {
        list.add(1);
        list.deleteAll(1);
        assertEquals(list.toString(), "List:(3)(2)");
    }

}