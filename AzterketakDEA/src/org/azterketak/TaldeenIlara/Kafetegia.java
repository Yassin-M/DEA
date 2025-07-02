package org.azterketak.TaldeenIlara;

import java.util.*;

public class Kafetegia {
	Queue<Queue<Integer>> ilara = (Queue<Queue<Integer>>) new LinkedList();
	
	public void txertatu(Integer elem) {
		if(ilara.isEmpty()) {
			ilara.add(new LinkedList<Integer>());
			ilara.peek().add(elem);
		}else {
			Queue<Queue<Integer>> aux = (Queue<Queue<Integer>>) new LinkedList();
			boolean aurkitua = false;
			while(!ilara.isEmpty() || !aurkitua) {
				Queue<Integer> aux2 = ilara.remove();
				if(taldeBera(elem, aux2.remove())) {
					aux2.add(elem);
					aux.add(aux2);
					aurkitua = true;
				}
			}
			if(!ilara.isEmpty()) {
				while(!ilara.isEmpty()) {
					aux.add(ilara.remove());
				}
			}
			ilara = aux;
		}
	}
	
	public Integer ezabatu() {
		Queue<Integer> lehena = ilara.peek();
		Integer ateratakoa = lehena.remove();
		if(lehena.isEmpty()) {
			ilara.remove();
		}
		return ateratakoa;
	}
	
	public boolean taldeBera(int p1, int p2) {
		return p1 == p2;
	}
}
