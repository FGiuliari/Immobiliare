package controllerGuest;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import database.Vendita;

@ManagedBean
@RequestScoped
public class TipoListaVenditaBean {

	@ManagedProperty(value = "#{listaVenditaBean}")
	private ListaVenditaBean listaVenditaBean;
	private String tipo;

	public void setListaVenditaBean(ListaVenditaBean l) {
		this.listaVenditaBean = l;
	}

	public TipoListaVenditaBean() {
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public void init() {
		listaVenditaBean.aggiornaListaVendita(null);
	}

	public List<Vendita> getListaTipo() {
		if (tipo != null) {
			switch (tipo) {
			case "palazzina":
				return listaVenditaBean.getListaVenditaPalazzina();
			case "schiera":
				return listaVenditaBean.getListaVenditaSchiera();
			case "singola":
				return listaVenditaBean.getListaVenditaSingola();
			default:
				return new ArrayList<Vendita>();
			}
		}
		return new ArrayList<Vendita>();

	}
}
