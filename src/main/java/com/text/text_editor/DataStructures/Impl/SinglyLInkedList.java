package com.text.text_editor.DataStructures.Impl;

import com.text.text_editor.DataStructures.Interfaces.ListInterface;

import java.util.Collection;


public class SinglyLInkedList<T extends Comparable<T> & Iterable<T>>  implements ListInterface <T>{

    static class Node<T> {
        T value;
        Node<T> next = null;
        Node(T t)
        {
            this.value = t;
        }
    }

    private Node<T> head = null;
    private Node<T> tail = null;
    private int size = 0;

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return this.head == null;
    }

    @Override
    public boolean contains(T element) {
        /*
        Time complexity O(n)
        Space Complexity O(n)
         */
        Node<T> current = this.head;

        while(current != null)
        {
            if(current.value.equals(element)) return true;
            current = current.next;
        }
        return false;
    }

    @Override
    public T[] toArray() {
        return null;
    }

    @Override
    public boolean add(T element) {
        /*
        Time Complexity O(1)
        Space Complexity O(1)
         */
        Node<T> newNode = new Node<>(element);
        if(this.head == null) {
            this.head = newNode;
            this.tail = newNode;
        }
        else {
            this.tail.next = newNode;
            this.tail = newNode;
        }
        this.size ++;
        return true;
    }

    /**
     * Removes last element
     * Time Complexity O(n)
     * Space Complexity O(1)
     *
     */
    @Override
    public boolean remove(T element) {
        if(this.head == null)
        {
            return  false;
        }
        Node<T> current  = this.head;
        Node<T> prev = this.head;

        while(current != null)
        {
            if(current.value.equals(element)) break;
            prev = current;
            current = prev.next;
        }
        if(current != null)
        {
            prev.next = current.next;
            current.next = null;
            this.size --;
            return  true;
        }

        return false;
    }

    @Override
    public boolean equals(T element) {
        return false;
    }

    @Override
    public T get(int index) {
        if(index < 0 || index >= this.size)
        {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        Node<T> current = this.head;
        while(index > 0)
        {
            current = current.next;
            index --;
        }
        return current.value;
    }

    @Override
    public T set(int index, T element) {
        if(index  < 0 || index >= this.size)
        {
            throw new  IndexOutOfBoundsException("Invalid index provided");
        }
        Node<T> current = this.head;
        while(index> 0)
        {
            current = current.next;
            index --;
        }
        Node<T> newNode = new Node<>(element);
        newNode.next = current.next;
        current.next = null;
        this.head = newNode;
        return current.value;
    }

    @Override
    public void add(int index, T element) {
        if(index < 0 || index > this.size)
        {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        //create new node
        Node<T> newNode = new Node<>(element);
        // if index ==0
        if(index == 0)
        {
            if(this.head == null)
            {
                this.head = newNode;
                this.tail = newNode;
                this.size++;
            }
        }
        //when index == size
        else if(index == this.size)
        {
            this.add(element);
        }
        else {
            Node<T> current  = this.head;
            while(index > 1)
            {
                current = current.next;
                index --;
            }
            newNode.next = current.next;
            current.next = newNode;
            this.size ++;
        }


    }

    @Override
    public T remove(int index) {
        /*
        Time Complexity O(n)
        Space Complexity O(1)
         */
        if(index< 0  || index >= this.size)
        {
            throw  new NullPointerException("Invalid index selected");
        }
        else if(this.size == 1)
        {
            Node<T>  temp = this.head;
            this.head = null;
            this.tail = null;
            this.size -- ;
            return temp.value;
        }
        else
        {

            Node<T> current = this.head;
            while(index > 1)
            {
                current = current.next;
                index--;
            }
            if(index == 0)
            {
                this.head = current.next;
                current.next = null;
                this.size --;
                return current.value;

            }
            else {
                Node<T> remove = current.next;
                current.next = remove.next;
                remove.next = null;
                this.size --;
                return  remove.value;
            }


        }
    }

    @Override
    public int indexOf(T element) {

                /*
        Time complexity O(n)
        Space complexity O(1)
         */
        Node<T> current = this.head;

        for(int  i = 0; i< this.size; i++)
        {
            if(current.value.equals(element))
            {
               return i;
            }
            current = current.next;
        }
        return -1;

    }

    @Override
    public int lastIndexOf(T element) {
        /*
        Time complexity O(n)
        Space complexity O(1)
         */
        int lastIndex = -1;
        Node<T> current = this.head;

        for(int  i = 0; i< this.size; i++)
        {
            if(current.value.equals(element))
            {
                lastIndex = i;
            }
            current = current.next;
        }
        return lastIndex;
    }

    @Override
    public void clear() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    public void reverse()
    {
        /*
        Time complexity O(n)
        Space Complexity O(1)
         */
        Node<T> prev = null;
        Node<T> next = this.head;
        Node<T> current  = this.head;
        this.head = this.tail;
        this.tail = next;

        for(int  i = 0; i< this.size; i++)
        {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
    }
}



