/**
 * Bean per la tabella (campi principali) Sede
 */
package database;

public class Sede {

  // === Properties ============================================================

  private String sede;

  // === Methods ===============================================================

  public Sede() {
    sede="test";
  }

  public void setSede( String sede ) {
    this.sede = sede;
  }
  public String getSede() {
    return sede;
  }

}
