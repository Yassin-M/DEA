package org.azterketak.Epidemia;

import java.util.*;

public class Pertsona {
	String izena;
	boolean kutsatuta;
	ArrayList<Pertsona> kontaktuak;
	
	public void epidemiarenSimulazioa() {
		HashSet<Pertsona> ikusitakoak = new HashSet<Pertsona>();
		Queue<Pertsona> aztGabeak = (Queue<Pertsona>) new LinkedList();
		aztGabeak.add(kontaktuak.get(0));
		ikusitakoak.add(kontaktuak.get(0));
		while(!aztGabeak.isEmpty()) {
			Pertsona unekoa = aztGabeak.remove();
			if(unekoa.kutsatuta) {
				for(Pertsona p: unekoa.kontaktuak) {
					if(!ikusitakoak.contains(p)) {
						if(unekoa.kutsatu()) {
							p.kutsatuta = true;
						}
						aztGabeak.add(p);
						ikusitakoak.add(p);
					}
				}
			}
		}
	}
	
	public boolean kutsatu() {
		return true;
	}
}
