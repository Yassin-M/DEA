package org.azterketak.ZaborBilketa;

import java.util.*;

public class MemoriaGrafo {
	
	int numVertices;
	Objektua[] vertices;
	boolean[][] adjMatrix;
	
	public ArrayList<String> zaborraLortu(ArrayList<String> erabiliak){
		boolean[] aztertuak = new boolean[numVertices];
		for(String s: erabiliak) {
			int ind = indexOf(s);
			Queue<Integer> aztGabeak = (Queue<Integer>) new LinkedList();
			aztGabeak.add(ind);
			aztertuak[ind] = true;
			vertices[indexOf(s)].atzigarria = true;
			while(!aztGabeak.isEmpty()) {
				int unekoa = aztGabeak.remove();
				for(int i = 0; i<adjMatrix[unekoa].length;i++) {
					if(!aztertuak[i]) {
						vertices[i].atzigarria=true;
						aztGabeak.add(i);
						aztertuak[i] = true;
					}
				}
				
			}
		}
		ArrayList<String> emaitza = new ArrayList<String>();
		for(Objektua o: vertices) {
			if(o.atzigarria) {
				emaitza.add(o.izena);
			}
		}
		return emaitza;
	}
	
	private int indexOf(String elem) {
		return 0;
	}
}
