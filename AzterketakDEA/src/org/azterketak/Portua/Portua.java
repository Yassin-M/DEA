package org.azterketak.Portua;

import java.util.*;

public class Portua {
	Stack<String>[] nasak;
	
	public void portuaSimulatu(Queue<Ontzia> ontziak, int maxEskaera, int nasaKop) {
		nasak = (Stack<String>[]) new Stack[nasaKop];
		for(int i = 0; i<nasak.length;i++) {
			nasak[i] = new Stack<String>();
		}
		while(!ontziak.isEmpty()) {
			Ontzia unekoa = ontziak.remove();
			if(unekoa.mota==0) {
				int n = 0;
				while(!unekoa.eskaerak.isEmpty()&&n<maxEskaera) {
					Eskaera unekoE = unekoa.eskaerak.remove();
					nasak[unekoE.nasa].add(unekoE.kontainerNode);
					n++;
				}
				if(!unekoa.eskaerak.isEmpty()) {
					ontziak.add(unekoa);
				}
			}else {
				while(!unekoa.eskaerak.isEmpty()) {
					Eskaera unekoE = unekoa.eskaerak.remove();
					boolean aurkitua = false;
					while(!aurkitua) {
						if(nasak[unekoE.nasa].peek().equals(unekoE.kontainerNode)) {
							aurkitua = true;
							nasak[unekoE.nasa].pop();
						}else {
							nasak[0].push(nasak[unekoE.nasa].pop());
						}
					}
					while(!nasak[0].isEmpty()) {
						 nasak[unekoE.nasa].push(nasak[0].pop());
					}
				}
			}
		}
	}
}
