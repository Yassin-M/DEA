package org.azterketak.ZaborBilketa;

import java.util.*;

public class MemoriaGrafo {
	
	int numVertices;
	Objektua[] vertices;
	boolean[][] adjMatrix;
	
	public ArrayList<String> zaborraLortu(ArrayList<String> erabiliak){
		boolean[] ikusitakoak = new boolean[numVertices];
		Queue<Integer> aztGabeak = (Queue<Integer>) new LinkedList<Integer>();
		for(String s: erabiliak) {
			int ind = indexOf(s);
			aztGabeak.add(ind);
			ikusitakoak[ind] = true;
			vertices[ind].atzigarria = true;
			while(!aztGabeak.isEmpty()) {
				Integer unekoa = aztGabeak.remove();
				for(int i = 0; i<adjMatrix[unekoa].length;i++) {
					if(adjMatrix[unekoa][i] && !ikusitakoak[i]) {
						aztGabeak.add(i);
						ikusitakoak[i] = true;
						vertices[i].atzigarria = true;
					}
				}
			}
		}
		ArrayList<String> emaitza = new ArrayList<String>();
		for(int j = 0; j<vertices.length; j++) {
			if(!vertices[j].atzigarria) emaitza.add(vertices[j].izena);
		}
		return emaitza;
		
	}
	
	private int indexOf(String elem) {
		return 0;
	}
}
