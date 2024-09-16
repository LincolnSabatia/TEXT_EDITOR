package com.text.text_editor.DataStructures.Interfaces;

import java.util.Collection;
import java.util.NoSuchElementException;

public interface ListInterface<T extends Comparable<T> & Iterable<T>> {

    /**
     * An ordered collection, where the user has precise control over where in the
     * list each element is inserted.  The user can access elements by their integer
     * index (position in the list), and search for elements in the list.<p>
     *
     * This interface is a generic type, where T is the type of elements in the list.
     * @author  Lincolin sabatia
     */

        /**
         * Returns the  number of elements in the list
         * If  size is greater Integer.MAX_VALUE, return Integer.MAX_VALUE
         * @return the  number of elements in the list
         */

        int size();

        /**
         * Returns {@code true} if this list contains no elements.
         *
         * @return {@code false} if this list has elements
         */
        boolean isEmpty();

        /**
         * Returns True if List contains the provide element
         */
        boolean contains(T element);


        /**
         *Return an array containing all the elements of the List
         * sequence (from first to last element).
         */
        Object[] toArray();



        // Modification Operations

        /**
         * Appends Element to the end of the list
         *
         */
        boolean add(T element);

        /**
         * Removes the first occurrence of the specified element from this list,
         */
        boolean remove(T element);



        // Comparison and hashing

        /**
         * In other words, two lists are defined to be
         * equal if they contain the same elements in the same order.  This
         * definition ensures that the equals method works properly across
         * different implementations of the {@code List} interface.
         *
         * @param T the object to be compared for equality with this list
         * @return {@code true} if the specified object is equal to this list
         */
        boolean equals(T element);

        // Positional Access Operations

        /**
         * Returns the element at the specified position in this list.
         *
         * @param index index of the element to return
         * @return the element at the specified position in this list
         * @throws IndexOutOfBoundsException if the index is out of range
         *         ({@code index < 0 || index >= size()})
         */
        T get(int index);

        /**
         * Replaces the element at the specified position in this list with the
         * specified element (optional operation).
         *
         * @param index index of the element to replace
         * @param element element to be stored at the specified position
         * @return the element previously at the specified position
         * @throws NullPointerException if the specified element is null and
         *         this list does not permit null elements
         * @throws IndexOutOfBoundsException if the index is out of range
         *         ({@code index < 0 || index >= size()})
         */
        T set(int index, T element);

        /**
         * Inserts the specified element at the specified position in this list
         * (optional operation).  Shifts the element currently at that position
         * (if any) and any subsequent elements to the right (adds one to their
         * indices).
         *
         * @param index index at which the specified element is to be inserted
         * @param element element to be inserted
         * @throws NullPointerException if the specified element is null and
         *         this list does not permit null elements
         * @throws IndexOutOfBoundsException if the index is out of range
         *         ({@code index < 0 || index > size()})
         */
        void add(int index, T element);

        /**
         * Removes the element at the specified position in this list (optional
         * operation).  Shifts any subsequent elements to the left (subtracts one
         * from their indices).  Returns the element that was removed from the
         * list.
         *
         * @param index the index of the element to be removed
         * @return the element previously at the specified position
         * @throws IndexOutOfBoundsException if the index is out of range
         *         ({@code index < 0 || index >= size()})
         */
        T remove(int index);


        // Search Operations

        /**
         * Returns the index of the first occurrence of the specified element
         * or -1 if there is no such index.
         *
         * @param element to search for
         * @return the index of the first occurrence of the specified element in
         *         this list, or -1 if this list does not contain the element
         */
        int indexOf(T element);

        /**
         * Returns the index of the last occurrence of the specified element
         * or -1 if there is no such index.
         *
         * @param T element to search for
         */
        int lastIndexOf(T oelement);


    /**
     * Removes all of the elements from this list (optional operation).
     * The list will be empty after this call returns.
     *
     * @throws UnsupportedOperationException if the {@code clear} operation
     *         is not supported by this list
     */
    void clear();

    /**
     * Removes from this list all of its elements that are contained in the
     * specified collection (optional operation).
     *
     * @param c collection containing elements to be removed from this list
     * @see #remove(Object)
     * @see #contains(Object)
     */
    boolean removeAll(Collection<?> c);

        /**
         * Add T element to the first index and moving the rest to the right
         */
        default void addFirst(T element) {
            this.add(0, element);
        }



        /**
         * Adds Element to the end of the list
         * @throws NullPointerException
         */
        default void addLast(T e) {
            this.add(e);
        }

        /**
         *  Return last T element in the list
         * @throws NoSuchElementException
         */
        default T getFirst() {
            if (this.isEmpty()) {
                throw new NoSuchElementException();
            } else {
                return this.get(0);
            }
        }

        /**
         * Return last T element in the list
         * * @throws NoSuchElementException
         */
        default T getLast() {
            if (this.isEmpty()) {
                throw new NoSuchElementException();
            } else {
                return this.get(this.size() - 1);
            }
        }

        /**
         * Removes first element in the list
         * @throws NoSuchElementException {@inheritDoc}
         */
        default T removeFirst() {
            if (this.isEmpty()) {
                throw new NoSuchElementException();
            } else {
                return this.remove(0);
            }
        }

        /**
         *Removes last element in the list
         * @throws NoSuchElementException
         */
        default T removeLast() {
            if (this.isEmpty()) {
                throw new NoSuchElementException();
            } else {
                return this.remove(this.size() - 1);
            }
        }



}
