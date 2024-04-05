package org.howard.edu.lsp.assignment5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

/**
 * Represents a set of unique integers, providing operations common to mathematical sets.
 */
public class IntegerSet {

    private List<Integer> elements;

    /**
     * Constructs an empty IntegerSet.
     */
    public IntegerSet() {
        elements = new ArrayList<>();
    }

    /**
     * Constructs an IntegerSet from a collection, removing duplicates.
     *
     * @param initialElements Initial collection of elements for the set.
     */
    public IntegerSet(List<Integer> initialElements) {
        elements = new ArrayList<>(new HashSet<>(initialElements));
    }

    /**
     * Empties the set.
     */
    public void clear() {
        elements.clear();
    }

    /**
     * Returns the number of elements in the set.
     *
     * @return Size of the set.
     */
    public int size() {
        return elements.size();
    }

    /**
     * Checks if the set is empty.
     *
     * @return True if empty, otherwise false.
     */
    public boolean isEmpty() {
        return elements.isEmpty();
    }

    /**
     * Determines if the set contains a specified element.
     *
     * @param value Element to check for.
     * @return True if the element is present, otherwise false.
     */
    public boolean contains(int value) {
        return elements.contains(value);
    }

    public class IntegerSetException extends Exception {
        public IntegerSetException() {
            super("The set is empty");
        }
    }

    /**
     * Finds the largest element in the set.
     *
     * @return Largest element.
     * @throws IntegerSetException If the set is empty.
     */
    public int largest() throws IntegerSetException {
        if (isEmpty()) {
            throw new IntegerSetException();
        }
        return Collections.max(elements);
    }

    /**
     * Finds the smallest element in the set.
     *
     * @return Smallest element.
     * @throws IntegerSetException If the set is empty.
     */
    public int smallest() throws IntegerSetException {
        if (isEmpty()) {
            throw new IntegerSetException();
        }
        return Collections.min(elements);
    }

    /**
     * Adds an element to the set, ensuring no duplicates.
     *
     * @param item Element to add.
     */
    public void add(int item) {
        if (!contains(item)) {
            elements.add(item);
        }
    }

    /**
     * Removes an element from the set.
     *
     * @param item Element to remove.
     */
    public void remove(int item) {
        elements.remove(Integer.valueOf(item));
    }

    /**
     * Compares this set with another set for equality.
     *
     * @param otherSet Set to compare against.
     * @return True if sets are equal, otherwise false.
     */
    public boolean equals(IntegerSet otherSet) {
        return elements.size() == otherSet.elements.size() && elements.containsAll(otherSet.elements);
    }

    /**
     * Merges this set with another set, forming their union.
     *
     * @param otherSet Set to union with.
     */
    public void union(IntegerSet otherSet) {
        for (int item : otherSet.elements) {
            this.add(item); // Ensure no duplicates are added
        }
    }

    /**
     * Updates this set to its intersection with another set.
     *
     * @param otherSet Set to intersect with.
     */
    public void intersect(IntegerSet otherSet) {
        elements.retainAll(otherSet.elements);
    }

    /**
     * Updates this set to contain only elements not in the specified set.
     *
     * @param otherSet Set to differentiate against.
     */
    public void diff(IntegerSet otherSet) {
        elements.removeAll(otherSet.elements);
    }

    /**
     * Returns a string representation of the set.
     *
     * @return String representation.
     */
    public String toString() {
        return elements.toString();
    }
}
