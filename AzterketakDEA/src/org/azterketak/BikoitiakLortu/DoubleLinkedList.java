package org.azterketak.BikoitiakLortu;

public class DoubleLinkedList<T> {
	DoubleNode<T> first;
	
	public DoubleLinkedList<T> bikoitiakLortu(){
		if(first!=null) {
			int i = 1;
			DoubleNode<T> emaitza = null;
			DoubleNode<T> lag = first;;
			DoubleNode<T> lag2 = null;
			do {
				if(i%2==0) {
					DoubleNode<T> berria = new DoubleNode<T>();
					berria.data = lag.data;
					if(emaitza == null) {
						emaitza = berria;
						emaitza.next = emaitza;
						emaitza.prev = emaitza;
						lag2 = emaitza;
					}else {
						berria.next = lag2.next;
						lag2.next.prev = berria;
						berria.prev =  lag2;
						lag2.next = berria;
						lag2 = lag2.next;
					}
				}
				lag = lag.next;
				i++;
			}while(lag!=first);
			DoubleLinkedList<T> zerrenda = new DoubleLinkedList<T>();
			zerrenda.first = emaitza;
			return zerrenda;
		}
		return null;
	}
}
