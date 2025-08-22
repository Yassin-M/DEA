package org.azterketak.OrdenagailuenSarea;

import java.util.*;

public class RedDeOrdenadores {
	protected Boolean[][] adjMatrix = {
			// 0       1     2      3      4      5      6      7      8      9      10
			{false, false, true,  true,  false, false, false, false, false, false, false}, // 0 -> 2, 3
			{false, false, false, false, false, false, false, false, true,  true,  false}, // 1 -> 8, 9
			{false, false, false, false, true,  false, false, false, false, false, false}, // 2 -> 4
			{false, false, false, false, false, false, false, true,  false, false, true }, // 3 -> 7, 10
			{false, false, false, false, false, true,  false, false, false, false, false}, // 4 -> 5
			{false, true,  false, false, false, false, false, true,  false, false, false}, // 5 -> 1, 7
			{false, false, false, false, false, false, false, false, false, false, false}, // 6
			{false, false, false, false, false, false, false, false, false, false, true }, // 7 -> 10
			{false, false, false, false, false, false, false, false, false, false, false}, // 8
			{false, false, false, false, false, false, false, false, false, false, false}, // 9
			{false, false, false, false, false, false, false, false, false, false, false}  // 10
		};
		


		/**
		 * @return For each i (in the range 0 .. number of nodes in the graph), this method calculates
		 * the minimum distance from node 0 to i
		 */
		public int[] obtenerCostes() {
			int[] costes = new int[adjMatrix.length];
			boolean[] aztertuak = new boolean[adjMatrix.length];
			Queue<Integer> aztGabeak = (Queue<Integer>) new LinkedList();
			aztGabeak.add(0);
			aztertuak[0] = true;
			while(!aztGabeak.isEmpty()) {
				int unekoa = aztGabeak.remove();
				for(int i = 0; i<adjMatrix[unekoa].length; i++) {
					if(adjMatrix[unekoa][i]&&!aztertuak[i]) {
						aztGabeak.add(i);
						costes[i] = costes[unekoa] + 1;
						aztertuak[i] = true;
					}
				}
			}
			return costes;
		}
		
		public static void main(String[] args){
			int[] r = new RedDeOrdenadores().obtenerCostes();
			int j = 0;
			for (Integer a: r){
				System.out.println(j + ": " + a);
				j++;
			}
		}
}
