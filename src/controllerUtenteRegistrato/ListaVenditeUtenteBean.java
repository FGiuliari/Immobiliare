package controllerUtenteRegistrato;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ComponentSystemEvent;

import login.SecurityBacking;
import database.DataSource;
import database.Vendita;

@ManagedBean
@SessionScoped
public class ListaVenditeUtenteBean {
	@ManagedProperty(value = "#{securityBacking}")
	private SecurityBacking securityBacking;
	private List<Vendita> listaVenditaUtente;
	private DataSource ds;

	public ListaVenditeUtenteBean() {
		// TODO Auto-generated constructor stub
	}

	@PostConstruct
	public void initialize() {
		try {
			this.ds = new DataSource();
		} catch (ClassNotFoundException e) {
			this.ds = null;
		}
	}

	public void aggiornaListaVenditeUtente(ComponentSystemEvent event) {
		listaVenditaUtente = ds.getListaVenditaUser(securityBacking
				.getCodFisc());
	}

	public void setSecurityBacking(SecurityBacking securityBacking) {
		this.securityBacking = securityBacking;
	}

	public SecurityBacking getSecurityBacking() {
		return securityBacking;
	}

	public List<Vendita> getListaVenditaUtente() {
		return listaVenditaUtente;
	}
	
}
