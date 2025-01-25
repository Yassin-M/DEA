package org.azterketak.PertsonenZerrenda;

public class DoubleNode{
	String data;
	DoubleNode prev;
	DoubleNode next;
	Node erosketak; //Zerrenda zirkularra
	
	public void zerrendaSortu(String[] erosketak1){
		if(erosketak==null){
			erosketak = new Node();
			erosketak.data = erosketak1[0];
		}
		Node lag = erosketak;
		for(int i=1; i<erosketak1.length;i++){
			Node berria = new Node();
			berria.data = erosketak1[1];
			lag.next = berria;
			lag = lag.next;
		}
		lag.next = erosketak;
	}
}
