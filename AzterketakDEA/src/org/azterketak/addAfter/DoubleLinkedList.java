package org.azterketak.addAfter;

public class DoubleLinkedList<T> {
	DoubleNode<T> first;
	
	public DoubleLinkedList<T> addAfter(T elem, T target){
		DoubleNode<T> berria = new DoubleNode<T>();
		berria.data = elem;
		if(first==null) {
			berria.next = berria;
			berria.prev = berria;
			first = berria;
		}else {
			DoubleNode<T> lag = first;
			boolean aurkitua = false;;
			do {
				if(lag.data.equals(target)) aurkitua = true;
				else lag = lag.next;
			}while(!aurkitua && lag!=first);
			
			if(aurkitua) {
				berria.next = lag.next;
				lag.next.prev = berria;
				berria.prev = lag;
				lag.next = berria;
			}else {
				berria.next = first;
				first.prev.next = berria;
				berria.prev = first.prev;
				first.prev = berria;
			}
		}
		return this;
	}
}
