package database;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Questa classe mette a disposizione i metodi per effettuare interrogazioni
 * sulla base di dati.
 */
public class DataSource implements Serializable {

  // === Properties ============================================================

  // dati di identificazione dell'utente (da personalizzare)
  private String user = "userlab28";
  private String passwd = "ventottoKJ";

  // URL per la connessione alla base di dati e' formato dai seguenti
  // componenti: <protocollo>://<host del server>/<nome base di dati>.
  private String url = "jdbc:postgresql://dbserver.scienze.univr.it/dblab28";

  // Driver da utilizzare per la connessione e l'esecuzione delle query.
  private String driver = "org.postgresql.Driver";
  
  
  /**
   * Costruttore della classe. Carica i driver da utilizzare per la connessione
   * alla base di dati.
   *
   * @throws ClassNotFoundException Eccezione generata nel caso in cui i driver
   * per la connessione non siano trovati nel CLASSPATH.
   */
  public DataSource() throws ClassNotFoundException {
    Class.forName( driver );
  }
  

  // -- definizione delle query ------------------------------------------------

  // recupera le principali info su tutti i corsi di studi
  private String ImmobiliInVendita =
    "SELECT id, Codice, Nome FROM corsostudi ORDER BY Nome";
  

  // recupera tutte le informazioni di un particolare corso di studi
  private String listaVendita =
    "SELECT * "
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
    int c=0;

    try {
      // tentativo di connessione al database
      con = DriverManager.getConnection( url, user, passwd );
      System.out.println("connesso");
      // connessione riuscita, ottengo l'oggetto per l'esecuzione dell'interrogazione.
      pstmt = con.prepareStatement( listaVendita );
      pstmt.clearParameters();
      // imposto i parametri della query
      pstmt.setDate(1, Date.valueOf(LocalDate.now()));
      // eseguo la query
      rs = pstmt.executeQuery();
      // eseguo l'interrogazione desiderata
      // memorizzo il risultato dell'interrogazione nel Vector
      while( rs.next() ) {
        result.add( makeVenditaBean( rs ) );
        System.out.println(c++);
      }

    } catch( SQLException sqle ) { // catturo le eventuali eccezioni!
      sqle.printStackTrace();

    } finally { // alla fine chiudo la connessione.
      try {
        con.close();
      } catch( SQLException sqle1 ) {
        sqle1.printStackTrace();
      }
    }
    return result;
  }

  private Vendita makeVenditaBean( ResultSet rs ) throws SQLException {
	    Vendita bean = new Vendita(rs.getInt("id_tentata_vendita"),rs.getString("classtype"),rs.getString("indirizzo"),rs.getInt("superficie"),rs.getInt("numero_vani"),rs.getString("descrizione"),rs.getInt("superficie_giardino"),rs.getInt("piano"),rs.getDate("data_inizio"),rs.getDate("data_fine"),rs.getInt("prezzo_minimo"));
	    return bean;
	  }

  // recupera la/e facoltà di un particolare corso di studi
  private String csf =
    "SELECT DISTINCT f.nome "
    + "FROM facolta f INNER JOIN corsoinfacolta csf "
    + "ON (f.id=csf.id_facolta) "
    + "WHERE csf.id_corsostudi=?";


    //
    private String sedi ="SELECT DISTINCT c.sede FROM CorsoStudi c";

    private String max="SELECT MAX(crediti) AS max FROM CorsoStudi C, InsErogato IE WHERE C.id=IE.id_corsostudi AND C.sede='Verona' AND IE.annoaccademico='2010/2011'";

  // === Methods ===============================================================

 


}
