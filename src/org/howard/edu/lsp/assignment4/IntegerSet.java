package org.howard.edu.lsp.assignment4;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Class representing a set of integers.
 */
public class IntegerSet {

    /**
     * Stores the set elements.
     */
    private List<Integer> elements;

    /**
     * Default constructor that initializes an empty set.
     */
    public IntegerSet() {
        elements = new ArrayList<>();
    }

    /**
     * Constructor that initializes a set with the provided elements.
     * Ensures no duplicates are present.
     *
     * @param initialElements The initial elements for the set.
     */
    public IntegerSet(List<Integer> initialElements) {
        HashSet<Integer> uniqueElements = new HashSet<>(initialElements);
        elements = new ArrayList<>(uniqueElements);
    }

    /**
     * Removes all elements from the set.
     */
    public void clear() {
        elements.clear();
    }

    /**
     * Returns the number of elements in the set.
     *
     * @return The size of the set.
     */
    public int size() {
        return elements.size();
    }

    /**
     * Checks if the set is empty.
     *
     * @return True if the set is empty, false otherwise.
     */
    public boolean isEmpty() {
        return size() == 0;
    }

    /**
     * Checks if the set contains a specific element.
     *
     * @param value The element to search for.
     * @return True if the element is present, false otherwise.
     */
    public boolean contains(int value) {
        return elements.contains(value);
    }

    /**
     * Custom exception class for empty set operations.
     */
    public static class EmptySetException extends Exception {
        public EmptySetException() {
            super("The set is empty");
        }
    }

    /**
     * Returns the largest element in the set.
     *
     * @throws EmptySetException if the set is empty.
     * @return The largest element.
     */
    public int largest() throws EmptySetException {
        if (isEmpty()) {
            throw new EmptySetException();
        }
        return Collections.max(elements);
    }

    /**
     * Returns the smallest element in the set.
     *
     * @throws EmptySetException if the set is empty.
     * @return The smallest element.
     */
    public int smallest() throws EmptySetException {
        if (isEmpty()) {
            throw new EmptySetException();
        }
        return Collections.min(elements);
    }

    /**
     * Adds an element to the set if it's not already present.
     *
     * @param item The element to add.
     */
    public void add(int item) {
        if (!contains(item)) {
            elements.add(item);
        }
    }

    /**
     * Removes an element from the set if it's present.
     *
     * @param item The element to remove.
     */
    public void remove(int item) {
        if (contains(item)) {
            elements.remove(item);
        }
        /**
         * Checks if two sets are equal (contain the same elements).
         *
         * @param otherSet The other set to compare with.
         * @return True if the sets are equal, false otherwise.
         */
        public boolean equals(IntegerSet otherSet) {
            if (size() != otherSet.size()) {
                return false;
            }
            for (int element : elements) {
                if (!otherSet.contains(element)) {
                    return false;
                }
            }
            return true;
        }

        /**
         * Performs the union operation on two sets, returning a new set with the combined elements.
         * Does not modify the calling set.
         *
         * @param otherSet The other set to perform the union with.
         * @return A new set containing the union of the elements.
         */
//        public IntegerSet union(IntegerSet otherSet) {
//            List<Integer> combinedElements = new ArrayList<>(elements);  // Start with elements from this set
//            for (int element : otherSet.elements) {
//                if (!combinedElements.contains(element)) {
//                    combinedElements.add(element);
//                }
//            }
//            return new IntegerSet(combinedElements);
//        }
        public IntegerSet union(IntegerSet otherSet) {
            Set<Integer> combinedElements = new HashSet<>(elements);  // Start with elements from this set
            combinedElements.addAll(otherSet.elements);  // Add elements from otherSet
            return new IntegerSet(new ArrayList<>(combinedElements));  // Create and return a new IntegerSet
        }

        /**
         * Performs the intersection operation on two sets, returning a new set with the common elements.
         * Does not modify the calling set.
         *
         * @param otherSet The other set to perform the intersection with.
         * @return A new set containing the intersection of the elements.
         */
        public IntegerSet intersect(IntegerSet otherSet) {
            List<Integer> intersection = new ArrayList<>();
            for (int element : elements) {
                if (otherSet.contains(element)) {
                    intersection.add(element);
                }
            }
            return new IntegerSet(intersection);
        }

        /**
         * Performs the difference operation on two sets, returning a new set with elements in the calling set
         * that are not present in the other set. Does not modify the calling set.
         *
         * @param otherSet The other set to perform the difference with.
         * @return A new set containing the difference of the elements.
         */
        public IntegerSet diff(IntegerSet otherSet) {
            List<Integer> difference = new ArrayList<>(elements);
            difference.removeIf(element -> otherSet.contains(element));
            return new IntegerSet(difference);
        }

        /**
         * Performs the complement operation on a set, returning a new set containing all integers
         * not present in the calling set.
         *
         * @return A new set containing the complement of the elements.
         */
        public IntegerSet complement(IntegerSet universeSet) {
            if (isEmpty()) {
                return new IntegerSet(universeSet.elements);
            }
            List<Integer> complement = new ArrayList<>(universeSet.elements);
            complement.removeIf(element -> elements.contains(element));
            return new IntegerSet(complement);
        }

        /**
         * Returns a string representation of the set in curly braces, with elements separated by commas.
         *
         * @return A string representation of the set.
         */
        @Override
        public String toString() {
            if (isEmpty()) {
                return "{}";
            }
            StringBuilder sb = new StringBuilder("{");
            for (int i = 0; i < elements.size() - 1; i++) {
                sb.append(elements.get(i)).append(", ");
            }
            sb.append(elements.get(elements.size() - 1)).append("}");
            return sb.toString();
        }

    }

    /**
     * Performs the union operation on two sets, modifying the calling set.
     * Adds all elements from the other set that are not already present.
     *
     * @param otherSet The other set to perform the union with.
    **/
