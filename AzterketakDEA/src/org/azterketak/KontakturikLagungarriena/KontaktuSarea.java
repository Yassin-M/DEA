package org.azterketak.KontakturikLagungarriena;

import java.util.*;

public class KontaktuSarea {
	private boolean [][] adjMatrix;
	
	public int lagungarriena(ArrayList<Integer> pertsonak) {
		int[] lagung = new int[adjMatrix.length];
		for(Integer p: pertsonak) {
			int hasiera = p;
			Queue<Integer> aztGabeak = (Queue<Integer>) new LinkedList();
			boolean[] aztertuak = new boolean[adjMatrix.length];
			aztGabeak.add(p);
			aztertuak[p] = true;
			while(!aztGabeak.isEmpty()) {
				Integer unekoa = aztGabeak.remove();
				for(int i = 0; i<adjMatrix[unekoa].length;i++) {
					if(adjMatrix[unekoa][i] && !aztertuak[i]) {
						if(bateragarriakDira(hasiera, i)) {
							lagung[i]++;
						}
						aztertuak[i] = true;
						aztGabeak.add(i);
						
					}
				}
			}
			
		}
		int maxp = 0;
		int max = 0;
		for(int j = 0; j<lagung.length;j++) {
			if(lagung[j]>maxp) max = j;
		}
		
		return max;
	}
	
	private boolean bateragarriakDira(Integer p1, Integer p2) {
		return p1==p2;
	}
}
