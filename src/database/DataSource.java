package database;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Questa classe mette a disposizione i metodi per effettuare interrogazioni
 * sulla base di dati.
 */
public class DataSource implements Serializable {

	// === Properties
	// ============================================================

	// dati di identificazione dell'utente (da personalizzare)

	/*
	 * private String user = "userlab28"; private String passwd = "ventottoKJ";
	 * 
	 * // URL per la connessione alla base di dati e' formato dai seguenti //
	 * componenti: <protocollo>://<host del server>/<nome base di dati>. private
	 * String url = "jdbc:postgresql://dbserver.scienze.univr.it/dblab28";
	 * 
	 * // Driver da utilizzare per la connessione e l'esecuzione delle query.
	 * private String driver = "org.postgresql.Driver";
	 */

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String user = "cgrmcjkiernsld";
	private String passwd = "2kuEVzBdkZOKYiWg-p4p7wZNfR";

	// URL per la connessione alla base di dati e' formato dai seguenti
	// componenti: <protocollo>://<host del server>/<nome base di dati>.
	private String url = "jdbc:postgresql://ec2-54-217-202-108.eu-west-1.compute.amazonaws.com:5432/d50obhvuof5kka?&ssl=true&sslfactory=org.postgresql.ssl.NonValidatingFactory";

	// Driver da utilizzare per la connessione e l'esecuzione delle query.
	private String driver = "org.postgresql.Driver";

	/**
	 * Costruttore della classe. Carica i driver da utilizzare per la
	 * connessione alla base di dati.
	 *
	 * @throws ClassNotFoundException
	 *             Eccezione generata nel caso in cui i driver per la
	 *             connessione non siano trovati nel CLASSPATH.
	 */
	public DataSource() throws ClassNotFoundException {
		Class.forName(driver);
	}

	// -- definizione delle query
	// ------------------------------------------------

	// recupera tutte le informazioni di un particolare corso di studi
	private String listaVendita = "SELECT * "
			+ "FROM Immobile I join Tentata_vendita V on I.codice=V.immobile "
			+ "WHERE V.data_fine>?";
	
	/**
	 * Metodo per il recupero delle principali informazioni di tutti i corsi di
	 * studi
	 *
	 * @return
	 */
	public List<Vendita> getListaVendita() {
		// dichiarazione delle variabili
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Vendita> result = new ArrayList<Vendita>();
		int c = 1;

		try {
			// tentativo di connessione al database
			con = DriverManager.getConnection(url, user, passwd);
			System.out.println("connesso");
			// connessione riuscita, ottengo l'oggetto per l'esecuzione
			// dell'interrogazione.
			pstmt = con.prepareStatement(listaVendita);
			pstmt.clearParameters();
			// imposto i parametri della query
			pstmt.setDate(1, Date.valueOf(LocalDate.now()));
			// eseguo la query
			rs = pstmt.executeQuery();
			// eseguo l'interrogazione desiderata
			// memorizzo il risultato dell'interrogazione nel Vector
			while (rs.next()) {
				result.add(makeVenditaBean(rs));
				System.out.println(c++);
			}

		} catch (SQLException sqle) { // catturo le eventuali eccezioni!
			sqle.printStackTrace();

		} finally { // alla fine chiudo la connessione.
			try {
				con.close();
			} catch (SQLException sqle1) {
				sqle1.printStackTrace();
			}
		}
		return result;
	}

	private Vendita makeVenditaBean(ResultSet rs) throws SQLException {
		Vendita bean = new Vendita(rs.getInt("id_tentata_vendita"),
				rs.getString("classtype"), rs.getString("indirizzo"),
				rs.getString("citta"),
				rs.getInt("superficie"), rs.getInt("numero_vani"),
				rs.getString("descrizione"), rs.getInt("superficie_giardino"),
				rs.getInt("piano"), rs.getDate("data_inizio"),
				rs.getDate("data_fine"), rs.getInt("prezzo_minimo"));
		return bean;
	}

	private String login = "SELECT 0 " + "FROM Cliente C "
			+ "WHERE login LIKE ? AND password LIKE ?";

	public boolean login(String user1, String psw1) { // dichiarazione delle
														// variabili
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		boolean logged = false;

		try {
			// tentativo di connessione al database
			con = DriverManager.getConnection(url, user, passwd);
			System.out.println("connesso");
			// connessione riuscita, ottengo l'oggetto per l'esecuzione
			// dell'interrogazione.
			pstmt = con.prepareStatement(login);
			pstmt.clearParameters();
			// imposto i parametri della query
			pstmt.setString(1, user1);
			pstmt.setString(2, psw1);
			// eseguo la query
			rs = pstmt.executeQuery();
			// eseguo l'interrogazione desiderata
			// memorizzo il risultato dell'interrogazione nel Vector
			while (rs.next()) {
				System.out.println("esiste un utente");
				logged = true;
			}

		} catch (SQLException sqle) { // catturo le eventuali eccezioni!
			sqle.printStackTrace();
		} finally { // alla fine chiudo la connessione.
			try {
				con.close();
			} catch (SQLException sqle1) {
				sqle1.printStackTrace();
			}
		}
		return logged;
	}
	
	// recupero il numero di offerte registrate fino a questo momento per questa vendita
	private String countOffers = "SELECT count(*) FROM contatto WHERE tentata_vendita = ?";
	
	public int offerteRegistrate(int codice_tentata_vendita){
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int result = 0;
		
		try {
			con = DriverManager.getConnection(url, user, passwd);
			pstmt = con.prepareStatement(countOffers);
			pstmt.setInt(1, codice_tentata_vendita);
			rs = pstmt.executeQuery();
			
			if (rs.next()) result = rs.getInt(0);
		} catch (SQLException sqle) { // catturo le eventuali eccezioni!
			sqle.printStackTrace();
		} finally { // alla fine chiudo la connessione.
			try {
				con.close();
			} catch (SQLException sqle1) {
				sqle1.printStackTrace();
			}
		}
		
		return result;
	}

	public void newContattoAcquirente(String cognome,String nome, String numTelefono, float prezzoOfferta) {
		
	}
	
	// === Methods
	// ===============================================================

}
