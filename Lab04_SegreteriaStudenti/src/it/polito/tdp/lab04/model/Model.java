package it.polito.tdp.lab04.model;

import java.util.LinkedList;
import java.util.List;

import it.polito.tdp.lab04.DAO.CorsoDAO;
import it.polito.tdp.lab04.DAO.StudenteDAO;

public class Model {

	private StudenteDAO studenteDao;
	private CorsoDAO corsoDao;
	
	
	/**
	 * @param studenti
	 * @param corsi
	 */
	public Model() {
		this.studenteDao = new StudenteDAO();
		this.corsoDao = new CorsoDAO();
	}
	
	public Studente getStudente(int matricola) {
		return this.studenteDao.getStudente(matricola);
	}
	
	/*
	 * Ritorno tutti gli studenti iscritti al Corso corso
	 */
	public List<Studente> studentiIscrittiAlCorso(Corso corso) {
		this.corsoDao.getStudentiIscrittiAlCorso(corso);
		return corso.getStudenti();
	}
	
	/*
	 * Ritorno tutti i corsi seguiti dallo Studente studente
	 */
	public List<Corso> cercaCorsiDatoStudente(Studente studente) {
		this.studenteDao.getCorsiFromStudente(studente);
		return studente.getCorsi();
	}
	
	/*
	 * Ritorna TRUE se lo studente è iscritto al corso, FALSE altrimenti
	 */
	public boolean isStudenteIscrittoACorso(Studente studente, Corso corso) {
		return this.studenteDao.isStudenteIscrittoACorso(studente, corso);
	}
	
	/*
	 * Iscrivi una studente ad un corso. Ritorna TRUE se l'operazione va a buon fine.
	 */
	public boolean inscriviStudenteACorso(Studente studente, Corso corso) {
		return this.corsoDao.inscriviStudenteACorso(studente, corso);
	}
	
	/*
	 * Ritorna tutti i corsi
	 */
	public List<Corso> getTuttiICorsi() {
		return this.corsoDao.getTuttiICorsi();
	}
}
