package com.solvd.university.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LinkedList<E> {
    private static final Logger logger = LogManager.getLogger( LinkedList.class );
    private int size = 0;
    private transient Node<E> first;
    private transient Node<E> last;
    private transient Node<E> linkFirst;
    private transient Node<E> linkLast;

    public void add(E elem) {
        if (size == 0) {
            first = new Node<>(first, elem, last);
            linkFirst(first);
        } else {
            Node<E> nextNode = new Node<>(first, elem, null);
            last = nextNode;
            first.setNext(last);
            first = nextNode;
            linkLast(last);
        }
        size++;
    }

    public void clear() {
        if (size != 0) {
            Node<E> elem = linkFirst;
            Node<E> elem2;
            for (int buff = 0; buff < size; buff++) {
                elem2 = elem.getNext();
                elem.prev = null;
                elem.next = null;
                elem.item = null;
                elem = elem2;
            }
            size = 0;
            linkFirst = null;
            linkLast = null;
            logger.info("Все элементы успешно удалены");
        } else {
            logger.info("Нет элементов в коллекции");
        }
    }

    public void addAll(E[] elem) {
        for (E element : elem) {
            add(element);
        }
    }

    public int getSize() {
        return size;
    }

    private void linkFirst(Node<E> firstLink) {
        linkFirst = firstLink;
    }


    private void linkLast(Node<E> lastLink) {
        linkLast = lastLink;
    }

    @SuppressWarnings({"ConstantConditions"})
    public E get(int index) {
        int buff = size;
        Node<E> item;
        do {
            if (index < 0) {
                logger.error("Вы указали отрицательный индекс, так быть не может!");
                break;
            }

            if (buff / 2 >= index) {
                item = linkFirst;
                for (buff = 0; buff != index; buff++) {
                    item = item.getNext();
                }
                return item.getItem();
            }

            if (buff / 2 < index && index <= size) {
                item = linkLast;
                for (; buff - 1 != index; buff--) {
                    item = item.getPrev();
                }
                return item.getItem();
            } else {
                logger.error("Вы вышли за границы коллекции");
            }

        } while (false);

        return null;
    }

    public void remove(int index) {
        Node<E> prevNode;
        Node<E> nextNode;
        if (index < size && index >= 0) {
            if (index > size / 2) {
                if (index != size - 1) {
                    Node<E> lastNode = linkLast;
                    for (int buff = size; index != (buff - 1); buff--) {
                        lastNode = lastNode.getPrev();
                    }
                    prevNode = lastNode.getPrev();
                    nextNode = lastNode.getNext();
                    prevNode.setNext(nextNode);
                    nextNode.setPrev(prevNode);
                    lastNode.allToNull();
                    size--;
                } else {
                    prevNode = linkLast.getPrev();
                    linkLast.allToNull();
                    prevNode.setNext(null);
                    linkLast = prevNode;
                    size--;
                }

            } else {
                if (index != 0) { // проверка не является ли элемент первым в коллекции.
                    Node<E> firstNode = linkFirst;
                    for (int buff = 0; index != buff; buff++) {
                        firstNode = firstNode.getNext();
                    }
                    prevNode = firstNode.getPrev();
                    nextNode = firstNode.getNext();
                    prevNode.setNext(nextNode);
                    nextNode.setPrev(prevNode);
                    firstNode.allToNull();
                    size--;
                } else {
                    if (index != size - 1) {  // проверка а не является ли элемент единственным в коллекции
                        nextNode = linkFirst.getNext();
                        nextNode.setPrev(null);
                        linkFirst = nextNode;
                        size--;
                    } else {
                        linkFirst.allToNull();
                        size--;
                    }
                }

            }
        } else {

            logger.error("Вы вышли за границу коллекции");

        }
    }


    private static class Node<E> {

        private E item;
        private Node<E> next;
        private Node<E> prev;

        private Node(Node<E> prev, E element, Node<E> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }

        private void setNext(Node<E> next) {
            this.next = next;
        }

        private void allToNull() {
            this.item = null;
            this.next = null;
            this.prev = null;
        }

        private void setPrev(Node<E> prev) {
            this.prev = prev;
        }

        private Node<E> getPrev() {
            return prev;
        }

        private Node<E> getNext() {
            return next;
        }

        private E getItem() {
            return item;
        }
    }
}