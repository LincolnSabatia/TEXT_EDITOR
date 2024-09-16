package com.text.text_editor.DataStructures.Impl;

import com.text.text_editor.DataStructures.Interfaces.ListInterface;


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
        return false;
    }

    @Override
    public T[] toArray() {
        return null;
    }

    @Override
    public boolean add(T element) {
        /*
        Time Complexity 0(1)
        Space Complexity 0(1)
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
     * Time Complexity 0(n)
     */
    @Override
    public boolean remove(T element) {

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
        return null;
    }

    @Override
    public int indexOf(T element) {
        return 0;
    }

    @Override
    public int lastIndexOf(T oelement) {
        return 0;
    }
}
