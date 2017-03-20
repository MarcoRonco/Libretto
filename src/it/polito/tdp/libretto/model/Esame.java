package it.polito.tdp.libretto.model;

import java.time.LocalDate;

// oggetto semplice che contiene i dati relativi ad un singolo esame.
//POJO - plain old java
/*dati relativi <--- qui serve astuzia
 * costruttore
 * metodi get/set
 * metodi di servizio (toString, equals, hashCode, [compareTo])
 */

public class Esame {

	private String codice;
	private String titolo;
	private String docente; // non faccio una classe al docente perchè è un cretino
	private boolean superato;
	private int voto;
	private LocalDate dataSuperamento;
	
	/**
	 * nuovo esame, non ancora superato
	 * @param codice dell'esame
	 * @param titolo del corso
	 * @param docente nome e cognome del titolare del corso
	 */
	public Esame(String codice, String titolo, String docente) {
		super();
		this.codice = codice;
		this.titolo = titolo;
		this.docente = docente;
		this.superato = false;
	}

	/**
	 * @return the codice
	 */
	public String getCodice() {
		return codice;
	}

	/**
	 * @param codice the codice to set
	 */
	public void setCodice(String codice) {
		this.codice = codice;
	}

	/**
	 * @return the titolo
	 */
	public String getTitolo() {
		return titolo;
	}

	/**
	 * @param titolo the titolo to set
	 */
	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	/**
	 * @return the docente
	 */
	public String getDocente() {
		return docente;
	}

	/**
	 * @param docente the docente to set
	 */
	public void setDocente(String docente) {
		this.docente = docente;
	}

	/**
	 * @return the superato
	 */
	public boolean isSuperato() {
		return superato;
	}

	/**
	 * @param supera the superato to set
	 * se l'esame non è ancora superato, lo considera superato con voto e data passati.
	 * se invece l'esame era gia superato, genera un eccezione.
	 */
	public void Supera(int voto, LocalDate data) {
		if(!this.isSuperato()){
		 this.voto = voto;
		 this.dataSuperamento = data;
		} else { 
			throw new IllegalStateException("Esame "+ this.codice + " già superato"); 
		}
	}

	/**
	 * @return the voto
	 * restituisce il voto se l'esame è superato, altrimenti eccezione
	 */
	public int getVoto() {
		if(this.isSuperato()){
		  return voto;
		  } else {
			  throw new IllegalStateException("Esame "+ this.codice + " già superato");
		}
	}

	/**
	 * @param voto the voto to set
	 */
	private void setVoto(int voto) {
		this.voto = voto;
	}

	/**
	 * @return the dataSuperamento
	 *  restituisce la data del superamento solo se l'esame è superato, altrimenti eccezione
	 */
	public LocalDate getDataSuperamento() {
		if(this.isSuperato()){
			  return dataSuperamento;
			  } else {
				  throw new IllegalStateException("Esame "+ this.codice + " già superato");
			}
	}

	/**
	 * @param dataSuperamento the dataSuperamento to set
	 */
	private void setDataSuperamento(LocalDate dataSuperamento) {
		this.dataSuperamento = dataSuperamento;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Esame [codice=" + codice + ", titolo=" + titolo + ", docente=" + docente + ", superato=" + superato
				+ ", voto=" + voto + ", dataSuperamento=" + dataSuperamento + "]";
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codice == null) ? 0 : codice.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Esame other = (Esame) obj;
		if (codice == null) {
			if (other.codice != null)
				return false;
		} else if (!codice.equals(other.codice))
			return false;
		return true;
	}
	
	
}
