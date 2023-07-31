package org.example.sem3;

public class LinkedList {
    private Node root;
    private int size;

    public void add(int value) {
        if (root == null) {
            root = new Node(value);
            size = 1;
            return;
        }
        Node currentNode = root;
        while (currentNode.next != null)
            currentNode = currentNode.next;
        currentNode.next = new Node(value);
        size++;
    }

    public boolean remove(int value) {
        if (root == null)
            return false;
        if (root.value == value) {
            root = root.next;
            size--;
            return true;
        }
        Node currentNode = root;
        while (currentNode.next != null) {
            if (currentNode.next.value == value) {
                currentNode.next = currentNode.next.next;
                size--;
                return true;
            }
            currentNode = currentNode.next;
        }
        return false;
    }

    private Node getNode(int index){
        if (index < 0 || index >=size)
            throw new IndexOutOfBoundsException();
        Node currentNode = root;
        for (int i = 0; i < index ; i++)
            currentNode = currentNode.next;
        return currentNode;
    }

    public int getValue(int index){
        return getNode(index).value;
    }

    public void setValue(int index, int value){
        Node setNode = getNode(index);
        setNode.value = value;
    }

    public void swap (int index1, int index2){
        if (index1 < 0 || index1 >= size || index2 < 0 || index2 >= size)
            throw new IndexOutOfBoundsException();
        if (index1 == index2)
            return;
        Node node1 = null, node2 = null, currentNode = root;
        for (int i = 0; currentNode != null; i++){
            if (index1 == i)
                node1 = currentNode;
            if (index2 == i)
                node2 = currentNode;
            if (node2 != null && node1 != null)
                break;
            currentNode = currentNode.next;
        }
        int temp = node1.value;
        node1.value = node2.value;
        node2.value = temp;
    }
    public void print() {
        Node currentNode = root;
        System.out.print("[ ");
        while(currentNode != null){
            System.out.print(currentNode.value + " ");
            currentNode = currentNode.next;
        }
        System.out.println("] size: " + size);
    }

    public int size(){
        return size;
    }

    private class Node{
        int value;

        Node next;

        Node() {}

        Node (int value) {
            this.value = value;
        }
        Node (int value, Node next){
            this.value = value;
            this.next = next;
        }
    }
}
