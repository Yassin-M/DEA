package org.azterketak.SekuentziakFusionatu;

public class DoubleCircularLinkedList {
	DoubleNode<String> first;

	public void sekuentziakFusionatu(String[] s){
		// Aurre: s.length >= 1	
		int i = 0;
		
		for(String h: s) {
			DoubleNode<String> unekoa = first;
			boolean eginda = false;
			if(unekoa==null) {
				DoubleNode<String> berria = new DoubleNode<String>();
				berria.data = h;
				first = berria;
				first.next = first;
				first.prev = first;
			}else {
				do {
					if(unekoa.data.compareTo(h)>=0) {
						DoubleNode<String> berria = new DoubleNode<String>();
						berria.data = h;
						berria.next = unekoa;
						berria.prev = unekoa.prev;
						unekoa.prev.next = berria;
						unekoa.prev = berria;
						if(unekoa==first) {
							first = berria;
						}
						eginda = true;
					}else {
						unekoa = unekoa.next;
					}
				}while(!eginda && unekoa!=first);
				if(!eginda) {
					DoubleNode<String> berria = new DoubleNode<String>();
					berria.data = h;
					berria.next = unekoa;
					berria.prev = unekoa.prev;
					unekoa.prev.next = berria;
					unekoa.prev = berria;
				}
				
			}
		}
	}

	public void print(){
		if (first == null){}
		else{
			System.out.println(first.data);
			DoubleNode<String> unekoa = first.next;
			while (unekoa != first){
				System.out.println(unekoa.data);
				unekoa = unekoa.next;
			}
		}
	}
	
	public static void main(String[] args) {
		String[] s1 = {"ama", "oso"};
		DoubleCircularLinkedList l = new DoubleCircularLinkedList();
		l.sekuentziakFusionatu(s1);
		System.out.println("Lehen proba: (ama, oso) eman beharko luke: ");
		l.print();
		
		String[] s2 = {"aba", "eba", "ema", "pao", "zao"};
		l.sekuentziakFusionatu(s2);
		System.out.println("Bigarren proba: (aba, ama, eba, ema, oso, pao, zao) eman beharko luke: ");
		l.print();
	}
}
