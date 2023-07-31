package org.example.hw3;

import java.util.Iterator;

public class main {

    public static void main(String[] args) {
        SingleLinkList<Contact> contactList = new SingleLinkList<>();

        contactList.addToEnd(new Contact(156, "Минаш Игорь Анатольевич", "+375291111111"));
        contactList.addToEnd(new Contact(248, "Минаш Алеся Юрьевна", "+375298888888"));
        contactList.addToEnd(new Contact(186, "Акулов Арсений Олегович", "+375333366666"));
        contactList.addToEnd(new Contact(250, "Мельник Сергей Акимович", "+375448596555"));
        contactList.addToEnd(new Contact(197, "Петкевич Валерия Эдуардовна", "+375336968541"));

        for (Object contact : contactList) {
            System.out.println(contact);
        }
        contactList.reverse();

        System.out.println("-------------------------------------");

        for (Object contact : contactList) {
            System.out.println(contact);
        }
    }

    static class Contact {

        int id;
        String name;
        String phone;

        public Contact(int id, String name, String phone) {
            this.id = id;
            this.name = name;
            this.phone = phone;
        }

        @Override
        public String toString() {
            return "Contact{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", phone='" + phone + '\'' +
                    '}';
        }
    }


    public static class SingleLinkList<T> implements Iterable {

        ListItem<T> head;
        ListItem<T> tail;

        @Override
        public Iterator iterator() {
            return new Iterator<T>() {
                ListItem<T> current = head;

                @Override
                public boolean hasNext() {
                    return current != null;
                }

                @Override
                public T next() {
                    T data = current.data;
                    current = current.next;
                    return data;
                }
            };
        }

        private static class ListItem<T> {

            T data;
            ListItem<T> next;
        }

        //Голова пустая
        public boolean isEmpty() {
            return head == null;
        }

        //заполнение списка
        public void addToEnd(T item) {

            //Выделение памяти для списка
            ListItem<T> newItem = new ListItem<>();
            newItem.data = item;

            //Если, голова и хвост пустая
            if (isEmpty()) {
                head = newItem;
                tail = newItem;
            } else { //Если, не пустая то передаём элементу адрес и ставим в хвост
                tail.next = newItem;
                tail = newItem;
            }
        }

        //метод разворота списка
        public void reverse() {
            if (!isEmpty() && head.next != null) {//Если голова не равна нулю
                tail = head;
                ListItem<T> current = head.next;
                head.next = null;
                while (current != null) {
                    ListItem<T> next = current.next;
                    current.next = head;
                    head = current;
                    current = next;
                }
            }
        }
    }
}