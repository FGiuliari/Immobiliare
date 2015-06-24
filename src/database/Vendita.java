package database;

import java.sql.Date;

public class Vendita {

	private int codice; // Tentata_vendita.id
	private String tipo;
	private String indirizzo;
	private String citta;
	private int superficie;
	private int numero_vani;
	private String descrizione;
	private int superficie_giardino;
	private int piano;
	private Date dataInizioVendita;
	private Date dataFineVendita;
	private int prezzoMinimo;
	private int numOfferte;

	public int getNumOfferte() {
		return numOfferte;
	}

	public void setNumOfferte(int numOfferte) {
		this.numOfferte = numOfferte;
	}

	public Vendita(int codice, String tipo, String indirizzo, String citta,
			int superficie, int numero_vani, String descrizione,
			int superficie_giardino, int piano, Date dataInizioVendita,
			Date dataFineVendita, int prezzoMinimo) {
		super();
		this.codice = codice;
		this.tipo = tipo;
		this.indirizzo = indirizzo;
		this.citta = citta;
		this.superficie = superficie;
		this.numero_vani = numero_vani;
		this.descrizione = descrizione;
		this.superficie_giardino = superficie_giardino;
		this.piano = piano;
		this.dataInizioVendita = dataInizioVendita;
		this.dataFineVendita = dataFineVendita;
		this.prezzoMinimo = prezzoMinimo;
	}

	public Vendita(int codice, String tipo, String indirizzo, String citta,
			int superficie, int numero_vani, String descrizione,
			int superficie_giardino, int piano, Date dataInizioVendita,
			Date dataFineVendita, int prezzoMinimo, int numOfferte) {
		super();
		this.codice = codice;
		this.tipo = tipo;
		this.indirizzo = indirizzo;
		this.citta = citta;
		this.superficie = superficie;
		this.numero_vani = numero_vani;
		this.descrizione = descrizione;
		this.superficie_giardino = superficie_giardino;
		this.piano = piano;
		this.dataInizioVendita = dataInizioVendita;
		this.dataFineVendita = dataFineVendita;
		this.prezzoMinimo = prezzoMinimo;
		this.numOfferte = numOfferte;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getIndirizzo() {
		return indirizzo;
	}

	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}

	public int getSuperficie() {
		return superficie;
	}

	public void setSuperficie(int superficie) {
		this.superficie = superficie;
	}

	public int getNumero_vani() {
		return numero_vani;
	}

	public void setNumero_vani(int numero_vani) {
		this.numero_vani = numero_vani;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public int getSuperficie_giardino() {
		return superficie_giardino;
	}

	public void setSuperficie_giardino(int superficie_giardino) {
		this.superficie_giardino = superficie_giardino;
	}

	public int getPiano() {
		return piano;
	}

	public void setPiano(int piano) {
		this.piano = piano;
	}

	public int getCodice() {
		return codice;
	}

	public String getCitta() {
		return citta;
	}

	public void setCitta(String citta) {
		this.citta = citta;
	}

	public Date getDataInizioVendita() {
		return dataInizioVendita;
	}

	public void setDataInizioVendita(Date dataInizioVendita) {
		this.dataInizioVendita = dataInizioVendita;
	}

	public Date getDataFineVendita() {
		return dataFineVendita;
	}

	public void setDataFineVendita(Date dataFineVendita) {
		this.dataFineVendita = dataFineVendita;
	}

	public int getPrezzoMinimo() {
		return prezzoMinimo;
	}

	public void setPrezzoMinimo(int prezzoMinimo) {
		this.prezzoMinimo = prezzoMinimo;
	}

	public void setCodice(int codice) {
		this.codice = codice;
	}

}
