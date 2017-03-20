package it.polito.tdp.libretto.model;

import java.util.*;

public class Model {
	
	private List<Esame> esami;
	
	public Model(){
		this.esami = new ArrayList<Esame>();
	}
	
	/**
	 * aggiunge un nuovo esame all'elenco degli esami presenti
	 * @param e
	 * se l'esame è già presente nella mia struttura dati, ho non faccio nulla (silence solution), o restituisco null o l'elemento
	 */
	public boolean addEsame(Esame e){
		if(!esami.contains(e)){
			esami.add(e);
			return true;
		}
		return false;
	}
	
	public Esame trovaEsame(String codice){
		int pos = esami.indexOf(new Esame(codice, null, null));
		if(pos==-1)
			return null;
		else
			return esami.get(pos);
	}
}
