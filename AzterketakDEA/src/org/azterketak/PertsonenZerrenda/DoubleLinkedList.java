package org.azterketak.PertsonenZerrenda;

public class DoubleLinkedList{
	// Bi norabideko esteka, zerrenda ez zirkularra
	DoubleNode first;

	public void zerrendaLortu(PertsonenZerrenda l){
		// Aurre:
		// Post: l-ko balioekin zerrenda sortu da.
		// Zerrenda estekadura bikoitzekoa da, ez zirkularra
		// Pertsona bakoitzak bere erosketen zerrenda zirkularra izango du
		String[] pertsonakA = l.pertsonak;
		String[][] erosketakA = l.erosketak;

		if(first==null){
			first = new DoubleNode();
			first.data = pertsonakA[0];
			first.zerrendaSortu(erosketakA[0]);
		}

		DoubleNode lag = first;
	
		for(int i = 1; i < pertsonakA.length;i++){
			DoubleNode berria = new DoubleNode();
			berria.data = pertsonakA[i];
			berria.zerrendaSortu(erosketakA[i]);
			berria.prev = lag;
			lag.next = berria;
			lag = lag.next;
		}
	}

	public void print() {
        DoubleNode act = this.first;
        while (act != null) {
            System.out.print(act.data + ": ");
            Node actC = act.erosketak;
            if (actC != null) {
                while (actC.next != act.erosketak) {
                    System.out.print(actC.data + ", ");
                    actC = actC.next;
                }
                System.out.println(actC.data);
            }
            act = act.next;
        }
    }
	 public static void main(String[] args) {
	        DoubleLinkedList lista = new DoubleLinkedList();
	        PertsonenZerrenda lp = new PertsonenZerrenda();
	        lista.zerrendaLortu(lp);
	        lista.print();

	    }
}

