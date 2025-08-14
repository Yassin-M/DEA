package org.azterketak.ZerrendaSimetrikoa;

public class MiDoubleLinkedList {
	DoubleNode<Integer> first;
	
	public void zerrendaSimetrikoaLortu(SimpleLinkedList l) {
		Node<Integer> aux = l.first;
		if(aux!=null) {
			DoubleNode<Integer> aux2 = null;
			while(aux!=null) {
				DoubleNode<Integer> positibo = new DoubleNode<Integer>();
				positibo.data = aux.data;
				DoubleNode<Integer> negatibo = new DoubleNode<Integer>();
				negatibo.data = aux.data*(-1);
				if(first==null) {
					first=negatibo;
					first.next = positibo;
					first.prev = positibo;
					aux2 = first.next;
					aux2.prev = first;
					aux2.next = first;
				}else {
					positibo.prev = aux2;
					negatibo.next = first;
					aux2.next = positibo;
					first.prev = negatibo;
					negatibo.prev = positibo;
					positibo.next = negatibo;
					first = first.prev;
					aux2 = aux2.next;
				}
				aux = aux.next;
			}
		}
	}
}
