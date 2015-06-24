package controllerUtenteRegistrato;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import database.DataSource;
import database.Offerta;
import database.Vendita;

@ManagedBean
@RequestScoped
public class ImmobileUtenteBean {
	@ManagedProperty(value = "#{listaVenditeUtenteBean}")
	private ListaVenditeUtenteBean listaVenditeUtenteBean;
	private Vendita vendita;
	private int idVendita;
	private DataSource ds;
	private List<Offerta> offerte;

	public ImmobileUtenteBean() {
		// TODO Auto-generated constructor stub
	}

	@PostConstruct
	public void initialize() {
		try {
			listaVenditeUtenteBean.aggiornaListaVenditeUtente(null);
			this.ds = new DataSource();
		} catch (ClassNotFoundException e) {
			this.ds = null;
			e.printStackTrace();
		}
	}

	public void init() {
		for (Vendita ven : listaVenditeUtenteBean.getListaVenditaUtente())
			if (ven.getCodice() == idVendita) {
				vendita = ven;
				aggiornaListaOfferte();
			}
	}

	public void aggiornaListaOfferte() {
		offerte = ds.getListaOfferte(vendita.getCodice());
	}

	public int offerteVendita() {
		int result = 0;
		if (vendita != null && ds != null)
			result = ds.offerteRegistrate(vendita.getCodice());
		return result;
	}

	public int getIdVendita() {
		return idVendita;
	}

	public void setIdVendita(int idVendita) {
		this.idVendita = idVendita;
	}

	public Vendita getVendita() {
		return vendita;
	}

	public void setListaVenditeUtenteBean(
			ListaVenditeUtenteBean listaVenditeUtenteBean) {
		this.listaVenditeUtenteBean = listaVenditeUtenteBean;
	}

	public List<Offerta> getOfferte() {
		return offerte;
	}

}
