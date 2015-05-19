/**
 * Bean per la tabella (campi principali) CorsoStudi
 */
package database;

public class CorsoStudi {

  // === Properties ============================================================

  private int id;
  private String nomeCorsoStudi;
  private String codice;
  private String abbreviazione;
  private int durataAnni;
  private String sede;
  private String informativa;
  private int max;

  // === Methods ===============================================================

  public CorsoStudi() {
    id = 1;
    nomeCorsoStudi = null;
    codice = null;
    abbreviazione = null;
    durataAnni = 3;
    sede = null;
    informativa = null;
  }

  public int getId() {
    return id;
  }

  public void setId( int id ) {
    this.id = id;
  }

  public String getNomeCorsoStudi() {
    return nomeCorsoStudi;
  }

  public void setNomeCorsoStudi( String nomeCorsoStudi ) {
    this.nomeCorsoStudi = nomeCorsoStudi;
  }

  public String getCodice() {
    return codice;
  }

  public void setCodice( String codice ) {
    this.codice = codice;
  }

  public String getAbbreviazione() {
    return abbreviazione;
  }

  public void setAbbreviazione( String abbreviazione ) {
    this.abbreviazione = abbreviazione;
  }

  public int getDurataAnni() {
    return durataAnni;
  }

  public void setDurataAnni( int durataAnni ) {
    this.durataAnni = durataAnni;
  }

  public String getSede() {
    return sede;
  }

  public void setSede( String sede ) {
    this.sede = sede;
  }

  public String getInformativa() {
    return informativa;
  }

  public void setInformativa( String informativa ) {
    this.informativa = informativa;
  }
}
