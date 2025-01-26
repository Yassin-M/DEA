package org.azterketak.ZuhaitzParaleloak;

public class IzenenZuhaitza {
	Nodo rootAbizenak;
	Nodo rootIzenak;
	
	public String lortuIzena(String abizena) {
		return lortuIzena(rootIzenak, rootAbizenak, abizena);
	}
	
	private String lortuIzena(Nodo izen, Nodo abizen, String comp) {
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
