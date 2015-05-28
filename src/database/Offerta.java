package database;

import java.sql.Date;

public class Offerta {
	
	private int codiceVendita;
	private String nomeAcq;
	private String cognomeAcq;
	private String numTelefono;
	private String citta;
	private double prezzo;
	private Date dataOfferta;
		
	
	public Offerta(int codiceVendita, String nomeAcq, String cognomeAcq,
			String numTelefono, String citta, double prezzo, Date dataOfferta) {
		super();
		this.codiceVendita = codiceVendita;
		this.nomeAcq = nomeAcq;
		this.cognomeAcq = cognomeAcq;
		this.numTelefono = numTelefono;
		this.citta = citta;
		this.prezzo = prezzo;
		this.dataOfferta = dataOfferta;
	}
	public int getCodiceVendita() {
		return codiceVendita;
	}
	public void setCodiceVendita(int codiceVendita) {
		this.codiceVendita = codiceVendita;
	}
	public String getNomeAcq() {
		return nomeAcq;
	}
	public void setNomeAcq(String nomeAcq) {
		this.nomeAcq = nomeAcq;
	}
	public String getCognomeAcq() {
		return cognomeAcq;
	}
	public void setCognomeAcq(String cognomeAcq) {
		this.cognomeAcq = cognomeAcq;
	}
	public String getNumTelefono() {
		return numTelefono;
	}
	public void setNumTelefono(String numTelefono) {
		this.numTelefono = numTelefono;
	}
	public String getCitta() {
		return citta;
	}
	public void setCitta(String citta) {
		this.citta = citta;
	}
	public double getPrezzo() {
		return prezzo;
	}
	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}
	public Date getDataOfferta() {
		return dataOfferta;
	}
	public void setDataOfferta(Date dataOfferta) {
		this.dataOfferta = dataOfferta;
	}
	
	
	

}
