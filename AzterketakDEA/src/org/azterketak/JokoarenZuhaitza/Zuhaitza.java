package org.azterketak.JokoarenZuhaitza;

public class Zuhaitza {
	private Node root;
	
	public Zuhaitza() {
		Node n1 = new Node(new Info("B", 3));
		Node n2 = new Node(new Info("C", 3));
		Node n3 = new Node(new Info("D", 3));
		Node n4 = new Node(new Info("E", 3));
		Node n5 = new Node(new Info("F", 3));
		Node n6 = new Node(new Info("G", 3));
		Node n7 = new Node(new Info("H", 3));

		root = n1;
		n1.ezkerra = n2;
		n2.gurasoa = n1;
		n1.eskuina = n3;
		n3.gurasoa = n1;
		n2.ezkerra = n4;
		n4.gurasoa = n2;
		n2.eskuina = n5;
		n5.gurasoa = n2;
		n3.ezkerra = n6;
		n6.gurasoa = n3;
		n3.eskuina = n7;
		n7.gurasoa = n3;
	}
	
	public void saritu(int pPuntuak, String pElem) {
		Node p = find(root, pElem);
		if(p!=null) {
			saritu(p, pPuntuak);
		}
	}
	
	private void saritu(Node n, int pPuntuak) {
		n.content.puntuak += pPuntuak;
		if(pPuntuak-1>0&&n.gurasoa!=null	) {
			saritu(n.gurasoa, pPuntuak-1);
		}
	}
	
	private Node find(Node a, String pElem) {
		if(a==null) {
			return null;
		}else if(a.content.s.equals(pElem)) {
			return a;
		}else {
			Node ret = find(a.ezkerra, pElem);
			if(ret!=null) {
				return ret;
			}
			return find(a.eskuina, pElem);
		}
	}
	
	public void print(){
		print(root);
	}
	
	private void print(Node n){
		if (n != null)
			{ print(n.ezkerra);
			  n.content.print();
			  print(n.eskuina);
			}
	}
	
	public static void main(String[] args) {

		Zuhaitza a = new Zuhaitza();
		a.print();
		System.out.println();
		a.saritu(8, "G");
		a.print();
	}
}
