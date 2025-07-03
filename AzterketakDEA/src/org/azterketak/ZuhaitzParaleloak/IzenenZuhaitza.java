package org.azterketak.ZuhaitzParaleloak;

public class IzenenZuhaitza {
	Node rootAbizenak;
	Node rootIzenak;
	
	public String lortuIzena(String abizena) {
		return lortuIzena(rootIzenak, rootAbizenak, abizena);
	}
	
	private String lortuIzena(Node izen, Node abizen, String comp) {
		if(abizen==null) {
			return null;
		}else if(abizen.balioa.equals(comp)) {
			return izen.balioa;
		}else {
			String ezk = lortuIzena(izen.left, abizen.left,comp);
			if(ezk!=null) {
				return ezk;
			}else {
				return lortuIzena(izen.right,abizen.right,comp);
			}
		}
	}
}
