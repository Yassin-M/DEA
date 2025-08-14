package org.azterketak.EzabatuAgerpenGuztiak;

public class SimpleLinkedList<T> {
	Node<T> first;
	
	public SimpleLinkedList(T[] s){
		for (int i = 0; i < s.length; i++) {
			this.insertLast(s[i]);
		}
	}
	
	public void insertFirst(T elem) {
			Node node1 = new Node();
			node1.data = elem;
			node1.next = first;
			first = node1;
	}
	
	public void insertLast(T elem) {
		Node node = new Node();
		node.data = elem;
		if (first == null) first = node;
		else {
			Node aux = first;
			while (aux.next != null) aux = aux.next;
			aux.next = node;
		}
		
	}
	
	public void print() {
		if (first == null) {
		} else {
			Node act = first;
			System.out.print(act.data.toString() + " ");
			act = act.next;
			while (act != null) {
				System.out.print(act.data.toString() + " ");
				act = act.next;
			}
			System.out.println();
		}
	}
	
	public void ezabatuGuztiak(T elem) {
		while(first!= null && first.data.equals(elem)) {
			first = first.next;
		}
		if(first!=null) {
			if(first.next!=null) {
				Node<T> lag = first;
				Node<T> hurrengoa = first.next;
				while(hurrengoa!=null) {
					if(hurrengoa.data.equals(elem)) {
						lag.next = hurrengoa.next;
						hurrengoa = lag.next;
					}else {
						lag = lag.next;
						hurrengoa = hurrengoa.next;
					}
				}
			}
		}
	}
	
	public static void main(String[] args) {
		// Caso 1: borrar el primero
		String[] s1 = {"ana", "jon", "amaia", "luis", "ander"};
		SimpleLinkedList<String> l = new SimpleLinkedList<String>(s1);
		System.out.println("================================================================");
		System.out.println("Caso 1: borrar(ana, {ana, jon, amaia, luis, ander})");
		System.out.println("================================================================");
		l.print();
		l.ezabatuGuztiak("ana");
		l.print();

		// Caso 2: borrar un elemento del medio
		System.out.println("================================================================");
		System.out.println("Caso 2: borrar(jon, {ana, jon, amaia, luis, ander})");
		System.out.println("================================================================");
		String[] s2 = { "ana", "jon", "amaia", "luis", "ander" };
		l = new SimpleLinkedList<String>(s2);
		l.print();
		l.ezabatuGuztiak("jon");
		l.print();

		// Caso 3: borrar el último
		System.out.println("================================================================");
		System.out.println("Caso 3: borrar(ander, {ana, jon, amaia, luis, ander})");
		System.out.println("================================================================");
		String[] s3 = { "ana", "jon", "amaia", "luis", "ander" };
		l = new SimpleLinkedList<String>(s3);
		l.print();
		l.ezabatuGuztiak("ander");
		l.print();
		
		// Caso 4: borrar en varias posiciones
		System.out.println("================================================================");
		System.out.println("Caso 3: borrar(ander, {ander, ana, jon, ander, ander, amaia, luis, ander})");
		System.out.println("================================================================");
		String[] s4 = { "ander", "ana", "jon", "ander", "ander", "amaia", "luis", "ander" };
		l = new SimpleLinkedList<String>(s4);
		l.print();
		l.ezabatuGuztiak("ander");
		l.print();

		// Caso 5: borrar todos
		System.out.println("================================================================");
		System.out.println("Caso 3: borrar(ander, {ander, ander, ander, ander, ander, ander})");
		System.out.println("================================================================");
		String[] s5 = { "ander", "ander", "ander", "ander", "ander", "ander" };
		l = new SimpleLinkedList<String>(s5);
		l.print();
		l.ezabatuGuztiak("ander");
		l.print();


	}
}
