
import database.CorsoStudi;
import database.DataSource;
import database.Sede;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ComponentSystemEvent;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

@ManagedBean(name = "cs")
@SessionScoped
public class CorsoStudiView implements Serializable {

  // === Properties ============================================================

  private DataSource ds;
  private List<CorsoStudi> listaCorsi;
  private List<Sede> listaSedi;
  private CorsoStudi corsoSelezionato;
  private String facolta;
  private int max;

  // === Methods ===============================================================

  public CorsoStudiView() {
    this.listaCorsi = null;
    this.corsoSelezionato = null;
  }

  @PostConstruct
  public void initialize() {
    try {
      this.ds = new DataSource();
    } catch( ClassNotFoundException e ){
      this.ds = null;
      
    }

  }
  
  public void handleEvent(ComponentSystemEvent event){
	    listaCorsi = ds.getCorsiStudi();
	}

  public List<CorsoStudi> getCorsi() {

    return listaCorsi;
  }

  public String recuperaCorso( int id ){
    if( this.ds != null ){
      corsoSelezionato = ds.getCorsoStudi( id );
      facolta = ds.getFacoltaCorso( id );
    }
    return "dettaglio";
  }

 public String getMax(){
    if( this.ds != null ){
      max=ds.getMax();
    }
    return Integer.toString(max);
  }

  public List<Sede> getSedi() {
    if( this.ds != null ){
      listaSedi = ds.getSedi();
    }
    return listaSedi;
  }


  public CorsoStudi getCorso(){
    return corsoSelezionato;
  }

  public String getFacolta() {
    return facolta;
  }

  
}
