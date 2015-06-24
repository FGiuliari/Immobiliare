package controllerGuest;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;

import database.DataSource;
import database.Vendita;

@ManagedBean
@ViewScoped
public class ImmobileBean {
	@ManagedProperty(value = "#{listaVenditaBean}")
	private ListaVenditaBean listaVenditaBean;
	private int idVendita;
	private Vendita vendita = null;
	private DataSource ds;

	private String codFisc;
	private String cognome;
	private String nome;
	private String numTelefono;
	private String citta;
	private double prezzoOfferto;
	private String esitoQuery = "";

	public void setListaVenditaBean(ListaVenditaBean l) {
		this.listaVenditaBean = l;
	}

	public ImmobileBean() {
		// TODO Auto-generated constructor stub
	}

	@PostConstruct
	public void initialize() {
		try {
			listaVenditaBean.aggiornaListaVendita(null);
			this.ds = new DataSource();
		} catch (ClassNotFoundException e) {
			this.ds = null;
			e.printStackTrace();
		}
	}

	public void init() {
		for (Vendita ven : listaVenditaBean.getListaVendita())
			if (ven.getCodice() == idVendita)
				vendita = ven;
	}

	public int offerteVendita() {
		int result = 0;
		if (vendita != null && ds != null)
			result = ds.offerteRegistrate(vendita.getCodice());
		return result;
	}

	public void submitContatto() {
		System.out.println("INSERT RESULT " + codFisc + cognome + nome
				+ numTelefono + citta);
		if (codFisc != null && cognome != null && nome != null
				&& numTelefono != null && citta != null) {
			if (ds.newContattoAcquirente(vendita.getCodice(), codFisc, cognome,
					nome, numTelefono, citta, prezzoOfferto)) {
				esitoQuery = "Offerta inserita correttamente nel sistema";
			} else {
				esitoQuery = "Errore durante l'inserimento nel sistema";
			}
		}
	}

	public String getEsitoQuery() {
		return this.esitoQuery;
	}

	public String getCodFisc() {
		return "";
	}

	public String getCognome() {
		return "";
	}

	public String getNome() {
		return "";
	}

	public String getNumTelefono() {
		return "";
	}

	public String getCitta() {
		return "";
	}

	public double getPrezzoOfferto() {
		return 0;
	}

	public Vendita getVendita() {
		return vendita;
	}

	public void setIdVendita(int idVendita) {
		this.idVendita = idVendita;
	}

	public int getIdVendita() {
		return idVendita;
	}

	public void setCodFisc(String codFisc) {
		this.codFisc = codFisc;
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

	public void setCitta(String citta) {
		this.citta = citta;
	}

	public void setPrezzoOfferto(double prezzoOfferto) {
		this.prezzoOfferto = prezzoOfferto;
	}

}
