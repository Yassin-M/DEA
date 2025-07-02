package org.azterketak.ZuhaitzGenealogikoa;

import java.util.*;

public class ZuhaitzGenealogikoa {
	BinaryTreeNode<Pertsona> root;
	
	public boolean bizkaitarPetoPetoaDa(String izena, HashMap<String, String> herriak) {
		BinaryTreeNode<Pertsona> euskalduna = find(root, izena);
		if(euskalduna != null) {
			return bizkaitarPetoPetoaDa(root, herriak);			
		}
		return false;
	}
	
	private boolean bizkaitarPetoPetoaDa(BinaryTreeNode<Pertsona> a, HashMap<String, String> herriak) {
		if(a.left==null&&a.right==null) {
			return herriak.get(a.data.jaioterria).equals("Bizkaia");
		}else {
			if(a.left==null) {
				return bizkaitarPetoPetoaDa(a.right, herriak);
			}else if(a.right==null) {
				return bizkaitarPetoPetoaDa(a.left, herriak);
			}else {
				return bizkaitarPetoPetoaDa(a.left, herriak) && bizkaitarPetoPetoaDa(a.right, herriak);
			}
		}
	}
	
	private BinaryTreeNode<Pertsona> find(BinaryTreeNode<Pertsona> b, String Izena){
		if(b==null) {
			return null;
		}else if(b.data.izena.equals(Izena)) {
			return b;
		}else {
			BinaryTreeNode<Pertsona> bueltatu = find(b.left, Izena);
			if(bueltatu != null) {
				return bueltatu;
			}
			return find(b.right, Izena);
		}
	}
}
