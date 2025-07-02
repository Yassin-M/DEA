package org.azterketak.BlokeenJokoa;

import java.util.*;

public class Jokoa {
	Stack<Bloke>[] taula;
	public static int ZUTABEKOP = 7;
	
	public Jokoa() {
		taula = (Stack<Bloke>[]) new Stack[ZUTABEKOP];
		for(int i = 0; i<taula.length;i++) {
			taula[i] = new Stack<Bloke>();
		}
	}
	
	public int jokatu() {
		int blokeNum = 3;
		boolean amaitu = false;
		boolean irabazi = false;
		int puntuak = 0;
		Bloke unekoa;
		while(!amaitu&&!irabazi) {
			if(taula[blokeNum].isEmpty()) {
				irabazi = true;
			}else {
				unekoa = taula[blokeNum].pop();
				puntuak += unekoa.puntuak;
				if(unekoa.norabidea.equals("l")) {
					blokeNum -= unekoa.jauzia;
				}else {
					blokeNum += unekoa.jauzia;
				}
				
				if(blokeNum<0 || blokeNum>6) {
					amaitu = true;
				}
			}
		}
		if(irabazi) {
			System.out.println("Jokoa irabazi duzu, Zorionak");
		}else {
			System.out.println("Jokoa galdu duzu");
		}
		return puntuak;
	}
}
