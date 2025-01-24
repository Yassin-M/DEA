package org.azterketak.FutbolTxapelketa;

public class Txapelketa {
	private Adabegia root;
	
	public String txapelduna() {
		return txapelduna(root);
	}
	
	private String txapelduna(Adabegia a) {
		if(a==null) {
			return null;
		}else if(a.eskuin==null&&a.ezker==null) {
			return a.info.irabazlea;
		}else {
			String ezk = txapelduna(a.ezker);
			String esk = txapelduna(a.eskuin);
			
			if(a.info.golakEskuin>a.info.golakEzker) {
				a.info.irabazlea = esk;
			}else {
				a.info.irabazlea = ezk;
			}
			return a.info.irabazlea;
		}
	}
}
