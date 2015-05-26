import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import database.*;

@ManagedBean(name = "ImmobileView")
@SessionScoped
public class ImmobileView {
	private DataSource ds;
	
	// Campi form
	
	private String codFisc;
	private String cognome;
	private String nome;
	private String numTelefono;
	private String citta;
	private String prezzoOfferto;
	
	private boolean insertResult;
	
	public ImmobileView() {
		ds = null;
		insertResult = false;
	}
	
	@PostConstruct
	public void initialize() {
		try {
			this.ds = new DataSource();
		} catch (ClassNotFoundException e) {
			this.ds = null;
		}
	}
	
	public int offerteVenditaSelezionata(){
		int result = 0;
		if (this.getVenditaSelezionata() != null && ds != null)
			result = ds.offerteRegistrate(this.getVenditaSelezionata().getCodice());
		return result;
	}

	public Vendita getVenditaSelezionata() {
		return StateTracker.getStateTracker().getCurrent_tentata_vendita();
	}
	
	public void submitContatto() {
		System.out.println("INSERT RESULT " + codFisc + cognome + nome + numTelefono + citta);
		if (codFisc != null && cognome != null && nome != null && numTelefono != null && citta != null) {
			float offerta = Float.parseFloat(prezzoOfferto);
			this.insertResult = ds.newContattoAcquirente(this.getVenditaSelezionata().getCodice(), codFisc, cognome, nome, numTelefono, citta, offerta);
		}
	}
	
	// GETTER - SETTER FORM
	
	public String getCognome() {
		return cognome;
	}

	public String getNome() {
		return nome;
	}

	public String getNumTelefono() {
		return numTelefono;
	}

	public String getPrezzoOfferto() {
		return prezzoOfferto;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setNumTelefono(String numTelefono) {
		this.numTelefono = numTelefono;
	}

	public void setPrezzoOfferto(String prezzoOfferto) {
		this.prezzoOfferto = prezzoOfferto;
	}

	public String getCodFisc() {
		return codFisc;
	}

	public String getCitta() {
		return citta;
	}

	public void setCodFisc(String codFisc) {
		this.codFisc = codFisc;
	}

	public void setCitta(String citta) {
		this.citta = citta;
	}
	
	public String insertResult() {
		if (this.insertResult == true)
			return "Query andata a buon fine";
		return "";
	}
}
