package org.azterketak.Epidemia;

import java.util.*;

public class Pertsona {
	String izena;
	boolean kutsatuta;
	ArrayList<Pertsona> kontaktuak;
	
	public void epidemiarenSimulazioa() {
		HashSet<Pertsona> aztertuak = new HashSet<Pertsona>();
		Queue<Pertsona> aztGabeak = (Queue<Pertsona>) new LinkedList();
		Pertsona hasiera = kontaktuak.get(0);
		aztertuak.add(hasiera);
		aztGabeak.add(hasiera);
		while(!aztGabeak.isEmpty()) {
			Pertsona unekoa = aztGabeak.remove();
			for(Pertsona p: unekoa.kontaktuak) {
				if(!aztertuak.contains(unekoa)) {
					
				}
			}
		}
	}
	
	public boolean kutsatu() {
		return true;
	}
}
