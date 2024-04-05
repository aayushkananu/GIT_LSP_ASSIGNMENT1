
package org.howard.edu.lsp.assignment5;

import static org.junit.jupiter.api.Assertions.*;

import org.howard.edu.lsp.assignment5.IntegerSet.IntegerSetException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class IntegerSetTest {

    private IntegerSet set1;
    private IntegerSet set2;

    @BeforeEach
    public void setUp() {
        set1 = new IntegerSet();
        set2 = new IntegerSet();
    }

    @Test
    @DisplayName("Testing clear method")
    public void testClear() {
        set1.add(1);
        set1.add(2);
        set1.clear();
        assertTrue(set1.isEmpty());
    }

    @Test
    @DisplayName("Testing length method")
    public void testLength() {
        set1.add(1);
        set1.add(2);
        assertEquals(2, set1.size());
    }

    @Test
    @DisplayName("Testing equals method")
    public void testEquals() {
        set1.add(1);
        set1.add(2);
        set2.add(2);
        set2.add(1);
        assertTrue(set1.equals(set2));
    }

    @Test
    @DisplayName("Testing contains method")
    public void testContains() {
        set1.add(1);
        set1.add(2);
        assertTrue(set1.contains(1));
        assertFalse(set1.contains(3));
    }

    @Test
    @DisplayName("Testing largest method")
    public void testLargest() throws IntegerSetException {
        set1.add(1);
        set1.add(2);
        assertEquals(2, set1.largest());
        
        set1.clear();
        assertThrows(IntegerSetException.class, () -> {set2.largest();});
    };


    @Test
    @DisplayName("Testing smallest method")
    public void testSmallest() throws IntegerSetException {
        set1.add(1);
        set1.add(2);
        assertEquals(1, set1.smallest());
        
        set1.clear();
        assertThrows(IntegerSetException.class, () -> {set2.smallest();});
    };

    @Test
    @DisplayName("Testing add method")
    public void testAdd() {
        set1.add(1);
        set1.add(2);
        assertTrue(set1.contains(1));
        assertTrue(set1.contains(2));
    }

    @Test
    @DisplayName("Testing remove method")
    public void testRemove() {
        set1.add(1);
        set1.add(2);
        set1.remove(1);
        assertFalse(set1.contains(1));
        assertTrue(set1.contains(2));
    }

    @Test
    @DisplayName("Testing union method")
    public void testUnion() {
        set1.add(1);
        set1.add(2);
        set2.add(2);
        set2.add(3);
        set1.union(set2);
        assertTrue(set1.contains(1));
        assertTrue(set1.contains(2));
        assertTrue(set1.contains(3));
    }

    @Test
    @DisplayName("Testing intersect method")
    public void testIntersect() {
        set1.add(1);
        set1.add(2);
        set2.add(2);
        set2.add(3);
        set1.intersect(set2);
        assertTrue(set1.contains(2));
        assertFalse(set1.contains(1));
        assertFalse(set1.contains(3));
    }

    @Test
    @DisplayName("Testing diff method")
    public void testDiff() {
        set1.add(1);
        set1.add(2);
        set2.add(2);
        set2.add(3);
        set1.diff(set2);
        assertTrue(set1.contains(1));
        assertFalse(set1.contains(2));
        assertFalse(set1.contains(3));
    }

    @Test
    @DisplayName("Testing complement method")
    public void testComplement() {
        set1.add(1);
        set1.add(2);
        set2.add(2);
        set2.add(3);
        set1.complement(set2);
        assertTrue(set1.contains(1));
        assertFalse(set1.contains(2));
        assertFalse(set1.contains(3));
    }

    @Test
    @DisplayName("Testing isEmpty method")
    public void testIsEmpty() {
        assertTrue(set1.isEmpty());
        set1.add(1);
        assertFalse(set1.isEmpty());
    }

    @Test
    @DisplayName("Testing toString method")
    public void testToString() {
        set1.add(1);
        set1.add(2);
        assertEquals("[1, 2]", set1.toString());
    }
}

