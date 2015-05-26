import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import database.*;

@ManagedBean(name = "ImmobileView")
@SessionScoped
public class ImmobileView {
	private DataSource ds;
	private Vendita venditaSelezionata;
	
	// Campi form
	
	private String cognome;
	private String nome;
	private String numTelefono;
	private String prezzoOfferto;
	
	public ImmobileView() {
		ds = null;
		venditaSelezionata = null;
	}
	
	@PostConstruct
	public void initialize() {
		this.venditaSelezionata = StateTracker.getStateTracker().getCurrent_tentata_vendita();
		try {
			this.ds = new DataSource();
		} catch (ClassNotFoundException e) {
			this.ds = null;
		}
	}
	
	public int offerteVenditaSelezionata(){
		int result = 0;
		if (this.venditaSelezionata != null && ds != null)
			result = ds.offerteRegistrate(this.venditaSelezionata.getCodice());
		return result;
	}

	public void setVenditaSelezionata(Vendita venditaSelezionata) {
		this.venditaSelezionata = venditaSelezionata;
	}

	public Vendita getVenditaSelezionata() {
		return venditaSelezionata;
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
}
