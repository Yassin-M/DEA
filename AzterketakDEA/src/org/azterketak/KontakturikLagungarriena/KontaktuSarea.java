package org.azterketak.KontakturikLagungarriena;

import java.util.*;

public class KontaktuSarea {
	private boolean [][] adjMatrix;
	
	public int lagungarriena(ArrayList<Integer> pertsonak) {
		int[] lagungarriak = new int[adjMatrix.length];
		for(Integer i: pertsonak) {
			Queue<Integer> aztGabeak = (Queue<Integer>) new LinkedList();
			boolean[] ikusitakoak = new boolean[adjMatrix.length];
			aztGabeak.add(i);
			ikusitakoak[i] = true;
			while(!aztGabeak.isEmpty()) {
				int unekoa = aztGabeak.remove();
				for(int j = 0; j<adjMatrix[unekoa].length; j++) {
					if(!ikusitakoak[j]) {
						aztGabeak.add(j);
						ikusitakoak[j] = true;
						if(bateragarriakDira(i, j)) {
							lagungarriak[j]++;
						}
					}
				}
			}
		}
		int ind = -1;
		int max = -1;
		for(int k = 0; k<lagungarriak.length; k++) {
			if(lagungarriak[k]>max) {
				max = lagungarriak[k];
				ind = k;
			}
		}
		return ind;
	}
	
	private boolean bateragarriakDira(Integer p1, Integer p2) {
		return p1==p2;
	}
}
