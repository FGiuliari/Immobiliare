package user;
import database.DataSource;
import database.Vendita;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ComponentSystemEvent;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@ManagedBean(name = "View")
@SessionScoped
public class ListaView implements Serializable {

	// === Properties
	// ============================================================

	private DataSource ds;
	private List<Vendita> listaVendita;
	private List<Vendita> listaVenditaUser;
	private List<Vendita> listaVenditaAppartamenti;
	private List<Vendita> listaVenditaSingola;
	private List<Vendita> listaVenditaSchiera;
	private int nApp, nSin, nSch;
	private Vendita venditaSelezionata;
	private String username;
	private String password;
	private boolean loggedIn;
	private int tipoScelto;

	// === Methods
	// ===============================================================

	public ListaView() {
		this.listaVendita = null;
		this.listaVenditaAppartamenti = null;
		this.listaVenditaSingola = null;
		this.listaVenditaSchiera = null;
		this.venditaSelezionata = null;
		username = null;
		password = null;
		loggedIn = false;
	}

	@PostConstruct
	public void initialize() {
		try {
			this.ds = new DataSource();
		} catch (ClassNotFoundException e) {
			this.ds = null;
		}
	}

	public boolean getCheck() {
		return true;
	}

	public void aggiornaListaVendita(ComponentSystemEvent event) {
		listaVendita = ds.getListaVendita();
		listaVenditaAppartamenti = new ArrayList<Vendita>();
		listaVenditaSchiera = new ArrayList<Vendita>();
		listaVenditaSingola = new ArrayList<Vendita>();
		for (Vendita ven : listaVendita) {
			if (ven.getTipo().equals("palazzina")) {
				listaVenditaAppartamenti.add(ven);
			} else {
				if (ven.getTipo().equals("singola")) {
					listaVenditaSingola.add(ven);
				} else {
					listaVenditaSchiera.add(ven);
				}
			}
		}
		nApp = listaVenditaAppartamenti.size();
		nSin = listaVenditaSingola.size();
		nSch = listaVenditaSchiera.size();
		System.out.println(nApp+" "+nSin+" "+nSch);
	}

	public void aggiornaListaVenditaUser(ComponentSystemEvent event) {
		listaVenditaUser = ds.getListaVenditaUser();
		
	}
	public void ListaImmobili(ComponentSystemEvent event) {
		listaVendita = ds.getListaVendita();
	}

	public String login() {
		loggedIn = ds.login(username, password);
		if (!loggedIn) {
			username = null;
			password = null;
		}
		return "index";
	}

	public String logout() {
		username = null;
		password = null;
		loggedIn = false;
		return "index";
	}

	//public List<Vendita> getListaVendita() {
	//	return listaVendita;
	//}

	/*
	 * public String recuperaImmobile( int id ){ if( this.ds != null ){
	 * venditaSelezionata = ds.getVendita( id ); } return "dettaglio"; }
	 */

	public Vendita getVenditaSelezionata() {
		return venditaSelezionata;
	}

	public int getnApp() {
		return nApp;
	}

	public int getnSin() {
		return nSin;
	}

	public int getnSch() {
		return nSch;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean getLoggedIn() {
		System.out.println("loggedIn:" + loggedIn);
		return loggedIn;
	}
	
	public String TipoScelto(int i){
		tipoScelto=i;
		return "tentativi_vendita";
			
	}
	
	public int getTipoScelto(){
		return tipoScelto;
	}

	public List<Vendita> getListaVendita(){
		switch(tipoScelto){
		case 1 : return listaVenditaAppartamenti;
				
		case 2 : return listaVenditaSchiera;
				 
		case 3 : return listaVenditaSingola;
		
		default: return listaVendita;	
		}
	}
	
	public List<Vendita> getListaVenditaUser(){
		return listaVenditaUser;
	}

	public String VenditaSelezionata(int i) {
		for(Vendita ven : listaVendita){
			if (ven.getCodice()==i){
				venditaSelezionata=ven;
				StateTracker.getStateTracker().setCurrent_tentata_vendita(venditaSelezionata);
			}
		};
	
		return "immobile";
	}
}
