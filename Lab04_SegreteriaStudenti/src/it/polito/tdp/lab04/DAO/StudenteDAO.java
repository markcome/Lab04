package it.polito.tdp.lab04.DAO;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import it.polito.tdp.lab04.model.Corso;
import it.polito.tdp.lab04.model.Studente;

public class StudenteDAO {

	/*
	 * Controllo se uno studente (matricola) è iscritto ad un corso (codins)
	 */
	public boolean isStudenteIscrittoACorso (Studente studente , Corso corso) {
		
		final String sql = "SELECT * FROM iscrizione WHERE matricola = ? and codins = ?";
		
		try {
			// preparo la connessione
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			
			// setto i paramentri mancanti della Stringa di SQL
			st.setInt(1, studente.getMatricola());
			st.setString(2, corso.getCodins());
			
			// cerco il risultato
			ResultSet rs = st.executeQuery();
			
			// controllo il risultato
			boolean returnValue = false;
			if (rs.next())
				returnValue = true;
			
			// chiudo la connessione
			conn.close();
			
			return returnValue;
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Errore Db");
		} 
	}
	
	/*
	 * Data una matricola ottengo la lista dei corsi (codins) a cui è iscritto
	 */
	public void getCorsiFromStudente(Studente studente) {
		
		final String sql = "SELECT * FROM iscrizione, corso WHERE iscrizione.codins = corso.codins AND matricola = ?";
		List<Corso> corsi = new LinkedList<Corso>();
		
		try {
			// preparo la connessione
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			
			// setto i parametri mancanti alla Stringa SQL
			st.setInt(1, studente.getMatricola());
			
			// cerco il risultato
			ResultSet rs = st.executeQuery();
			
			// faccio le operazioni sul risultato
			while (rs.next()) {
				Corso corso = new Corso (
						rs.getString("codins"),
						rs.getInt("crediti"),
						rs.getString("nome"),
						rs.getInt("pd"));
				corsi.add(corso);
			}
			
			//chiudo la connessione
			studente.setCorsi(corsi);
			conn.close();
			
		} catch(SQLException e ) {
			e.printStackTrace();
			throw new RuntimeException("Errore DB");
		}
		
	}
	
	/*
	 * Data una matricola ottengo lo studente.
	 */
	public Studente getStudente(int matricola) {
		
		final String sql = "SELECT * FROM studente WHERE matricola = ?";
		
		try {
			// preparo la connessione
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			
			// completo lo statement
			st.setInt(1, matricola);
			
			// Eseguo la query
			ResultSet rs = st.executeQuery();
			
			// Eseguo le operazioni sul risultato
			Studente studente = null;
			if(rs.next())
				studente = new Studente (
						rs.getInt("matricola"),
						rs.getString("cognome"),
						rs.getString("nome"),
						rs.getString("cds"));
			
			// chiudo la connessione 
			conn.close();
			return studente;
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Errore DB");
		}
	}

}
