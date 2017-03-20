package it.polito.tdp.libretto.model;

public class TestModel {

	public static void main(String[] args) {
		Model m = new Model();
		m.addEsame(new Esame("pirla", "albus", "tette"));
		m.addEsame(new Esame("cazzo", "culo", "merda"));
		System.out.println(m.trovaEsame("pirla"));
		System.out.println(m.trovaEsame("ginuzzu"));
		System.out.println(m.addEsame(new Esame("cazzo", "culo", "merda")));
	}

}
