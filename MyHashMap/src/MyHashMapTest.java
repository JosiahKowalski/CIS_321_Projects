import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class MyHashMapTest {

    MyHashMap<String, String> map;

    @BeforeEach
    void setUp() {
        map = new MyHashMap<>();
        map.put("Josia", "Kowalski");
        map.put("Josiah", "Kowalski");
    }

    @Test
    void put() {
    }

    @Test
    void get1() {
        assertEquals("Kowalski", map.get("Josiah"));
    }

    @Test
    void get2() {
        assertEquals("Kowalski", map.get("Josia"));
    }

    @Test
    void overWrite(){
        map.put("Josiah", "Turkey");
        assertEquals("Turkey", map.get("Josiah"));
    }

    @Test
    void collisionTest(){
        MyHashMap<String,String> collision = new MyHashMap<>();
        collision.put("Hello", "Goodbye");
        collision.put("Hey", "Bye");
        collision.put("Hi", "Cho");
        assertEquals("Goodbye", collision.get("Hello"));
        assertEquals("Bye", collision.get("Hey"));
    }

    @Test
    void removeTest(){
        assertEquals("Kowalski", map.remove("Josia"));
    }

    @Test
    void containsKeyTrue(){
        assertTrue(map.containsKey("Josia"));
    }

    @Test
    void containsKeyFalse(){
        assertFalse(map.containsKey("Woof"));
    }

    @Test
    void containsValueTrue(){
        assertTrue(map.containsValue("Kowalski"));
    }

    @Test
    void containsValueFalse(){
        assertFalse(map.containsValue("Woof"));
    }

    @Test
    void containsValueFalseEmpty(){
        MyHashMap<String,String> empty = new MyHashMap<>();
        assertFalse(empty.containsValue("Any"));
    }

    @Test
    void size(){
        assertEquals(2, map.size());
    }

    @Test
    void getKey(){
        Set<String> s = new HashSet<>();
        s.add("Josia");
        s.add("Josiah");
        assertEquals(s, map.getKey("Kowalski"));
    }

    @Test
    void keySet(){
        Set<String> s = new HashSet<>();
        s.add("Josia");
        s.add("Josiah");
        assertEquals(s, map.keySet());
    }

    @Test
    void values(){
        Set<String> s = new HashSet<>();
        s.add("Kowalski");
        assertEquals(s, map.values());
    }

    @Test
    void putAll(){
        Map<String, String> m = new HashMap<>();
        m.put("hello", "goodbye");
        m.put("Ski", "snowboard");
        map.putAll(m);
        assertEquals("goodbye", map.get("hello"));
        assertEquals("Kowalski", map.get("Josiah"));
    }
}