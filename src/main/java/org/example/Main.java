package org.example;

public class Main {
    public static void main(String[] args) {
        Node node1 = new Node(5);
        Node node2 = new Node(2);
        Node node3 = new Node(1);
        Node node4 = new Node(8);
        Node node5 = new Node(6);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        System.out.println(node1.value + " ");
        System.out.println(node2.value + " ");
        System.out.println(node3.value + " ");
        System.out.println(node4.value + " ");
        System.out.println(node5.value + " ");

    }
}

class Node {
    int value;

    Node next;

    Node() {}

    Node (int value){
        this.value = value;
    }
}