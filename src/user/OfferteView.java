package user;

import database.*;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ComponentSystemEvent;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;





@ManagedBean(name = "OfferteView", eager = true)
@ViewScoped
public class OfferteView {

	private Vendita currentVendita;
	private DataSource ds;
	private List<Offerta> offerte;
	
	
	public OfferteView() {
		ds = null;
		currentVendita=null;
		offerte=null;
	}
	
	@PostConstruct
	public void initialize() {
		

		try {
			this.ds = new DataSource();
		} catch (ClassNotFoundException e) {
			this.ds = null;
		}
		currentVendita=StateTracker.getStateTracker().getCurrent_tentata_vendita();

		aggiornaListaOfferte();
	}
	
	public Vendita getVenditaSelezionata() {
		return currentVendita;
	}
	public List<Offerta> getOfferte(){
		return offerte;
	}
	
	public void aggiornaListaOfferte() {
		offerte = ds.getListaOfferte(currentVendita.getCodice());
	}

}
