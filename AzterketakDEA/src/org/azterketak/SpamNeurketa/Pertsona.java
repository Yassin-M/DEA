package org.azterketak.SpamNeurketa;

import java.util.*;

public class Pertsona {
	String izena;
	int spamJasotakoak; // hasieran zero
	ArrayList<Pertsona> kontaktuak;
	public void spamBidali() {
		// aurre:
		// post: mezu bat bidali zaie pertsona honen kontaktu guztiei,
		// eta hauek bere kontaktuei, …
		// Une bakoitzean, spam hori jasotzen duen pertsonak
		// erabakiko du ea berriro bidaltzen duen ala ez
		// spam kontagailua eguneratu da
		Queue<Pertsona> aztertuGabe = new LinkedList<Pertsona>();
		HashSet<String> aztertuak = new HashSet<String>();
		Pertsona hasiera = kontaktuak.get(0);
		aztertuGabe.add(hasiera);
		while(!aztertuGabe.isEmpty()) {
			Pertsona unekoa = aztertuGabe.remove();
			if(berBidali()) {
				for(Pertsona p: unekoa.kontaktuak) {
					p.spamJasotakoak++;
					if(!aztertuak.contains(p)) {
						aztertuGabe.add(p);
					}
				}
			}
		}
		
	}
	public boolean berBidali() {
		Random r = new Random();
		if(r.nextInt()%2==0) {
			return true;
		}else {
			return false;
		}
	}
	// post: true bueltatzen du mezua berbidaltzen bada eta false bestela
}
