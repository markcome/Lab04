package it.polito.tdp.lab04.model;


import java.util.ArrayList;
import java.util.List;

public class Corso implements Comparable<Corso> {

	private String codins;
	private int crediti;
	private String nome;
	private int pd;
	private List<Studente> studenti;
	
	/**
	 * Costruttore della classe Corso
	 * @param codins Codice univoco di identificazione del corso
	 * @param crediti Crediti assegnati al corso
	 * @param nome Nome del corso
	 * @param pd Periodo del corso ( 1 o 2 )
	 */
	public Corso(String codice, int crediti, String nome, int periodo) {
		this.codins = codice;
		this.crediti = crediti;
		this.nome = nome;
		this.pd = periodo;
		this.studenti = new ArrayList<Studente>();
	}

	/**
	 * @return the codins
	 */
	public String getCodins() {
		return codins;
	}

	/**
	 * @return the crediti
	 */
	public int getCrediti() {
		return crediti;
	}

	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @return the pd
	 */
	public int getPd() {
		return pd;
	}
	
	/**
	 * @return the studenti
	 */
	public List<Studente> getStudenti() {
		return studenti;
	}
	
	

	/**
	 * @param codins the codins to set
	 */
	public void setCodins(String codins) {
		this.codins = codins;
	}

	/**
	 * @param crediti the crediti to set
	 */
	public void setCrediti(int crediti) {
		this.crediti = crediti;
	}

	/**
	 * @param nome the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * @param pd the pd to set
	 */
	public void setPd(int pd) {
		this.pd = pd;
	}

	/**
	 * @param studenti the studenti to set
	 */
	public void setStudenti(List<Studente> studenti) {
		this.studenti = studenti;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return String.format("%s	%s	%s	%s", codins, crediti, nome, pd );
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codins == null) ? 0 : codins.hashCode());
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
		Corso other = (Corso) obj;
		if (codins == null) {
			if (other.codins != null)
				return false;
		} else if (!codins.equals(other.codins))
			return false;
		return true;
	}
	
	/**
	 * Iscrive al corso lo studente passato come parametro
	 * @param studente
	 * @return TRUE: se è andato a buon fine. FALSE: se è già presente lo studente
	 */
	public boolean iscriviStudente(Studente studente){
		for(Studente s: studenti){
			if(s.equals(studente)){
				return false;
			}
		}
		this.studenti.add(studente);
		return true;
	}

	// Utilizzato per ordinare alfabeticamente i corsi
	@Override
	public int compareTo(Corso o) {
		return this.nome.compareTo(o.nome);
	}
	
	
	
}
