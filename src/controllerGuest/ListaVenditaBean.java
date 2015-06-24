package controllerGuest;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ComponentSystemEvent;

import database.DataSource;
import database.Vendita;

@ManagedBean
@SessionScoped
public class ListaVenditaBean {

	private List<Vendita> listaVendita;
	private DataSource ds;
	private ArrayList<Vendita> listaVenditaPalazzina;
	private ArrayList<Vendita> listaVenditaSingola;
	private ArrayList<Vendita> listaVenditaSchiera;
	private int nPal;
	private int nSch;
	private int nSin;

	public ListaVenditaBean() {
		this.listaVendita = null;

	}

	@PostConstruct
	public void initialize() {
		try {
			this.ds = new DataSource();
		} catch (ClassNotFoundException e) {
			this.ds = null;
		}
	}

	public void aggiornaListaVendita(ComponentSystemEvent event) {
		listaVendita = ds.getListaVendita();
		listaVenditaPalazzina = new ArrayList<Vendita>();
		listaVenditaSchiera = new ArrayList<Vendita>();
		listaVenditaSingola = new ArrayList<Vendita>();
		for (Vendita ven : listaVendita) {
			if (ven.getTipo().equals("palazzina")) {
				listaVenditaPalazzina.add(ven);
			} else {
				if (ven.getTipo().equals("singola")) {
					listaVenditaSingola.add(ven);
				} else {
					listaVenditaSchiera.add(ven);
				}
			}
		}
		nPal = listaVenditaPalazzina.size();
		nSin = listaVenditaSingola.size();
		nSch = listaVenditaSchiera.size();
		System.out.println(nPal + " " + nSin + " " + nSch);
	}

	public List<Vendita> getListaVendita() {
		return listaVendita;
	}

	public int getnPal() {
		return nPal;
	}

	public int getnSch() {
		return nSch;
	}

	public int getnSin() {
		return nSin;
	}

	protected List<Vendita> getListaVenditaPalazzina() {
		// TODO Auto-generated method stub
		return listaVenditaPalazzina;
	}

	protected List<Vendita> getListaVenditaSchiera() {
		// TODO Auto-generated method stub
		return listaVenditaSchiera;
	}

	protected List<Vendita> getListaVenditaSingola() {
		// TODO Auto-generated method stub
		return listaVenditaSingola;
	}

}
