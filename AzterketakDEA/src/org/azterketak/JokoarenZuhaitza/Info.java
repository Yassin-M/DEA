package org.azterketak.JokoarenZuhaitza;

public class Info {
	String s;
	Integer puntuak;
	
	public Info(String pS, Integer pPuntuak) {
		s = pS;
		puntuak = pPuntuak;
	}
	
	public void print(){
		System.out.print(" " + s + " " + puntuak + ", ");
	}
}
