package it.faraday.agriturismo.models;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "utenti")
public class Utente {

	@Id
	@Column(name = "id_utente")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "USER_SEQ_GEN")
	@SequenceGenerator(name = "USER_SEQ_GEN", sequenceName = "utenti_id_utente_seq", allocationSize = 1)
	private Integer id;

	@Basic
	private String nome;

	@Basic
	private String cognome;

	@Basic
	private String username;

	@Basic
	private String password;

	@Basic
	private String email;

	@Basic
	private String sesso;

	@Basic
	@Column(name = "data_nascita")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dataNascita;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "utente")
	private List<PrenotazioneSoggiorno> PrenotazioniSoggiorni;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "utente")
	private List<PrenotazioneAttivitaIppica> PrenotazioniAttivitaIppiche;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "utente")
	private List<PrenotazioneEscursione> PrenotazioniEscursione;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "utente")
	private List<OrdinazionePiatto> OrdinaPiatto;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "utente")
	private List<OrdinazionePizza> OrdinaPizza;

	public Utente() {

	}

	public Integer getId() {
		return id;
	}

	public Utente setId(Integer id) {
		this.id = id;
		return this;
	}

	public String getNome() {
		return nome;
	}

	public Utente setNome(String nome) {
		this.nome = nome;
		return this;
	}

	public String getCognome() {
		return cognome;
	}

	public Utente setCognome(String cognome) {
		this.cognome = cognome;
		return this;
	}

	public String getUsername() {
		return username;
	}

	public Utente setUsername(String username) {
		this.username = username;
		return this;
	}

	public String getPassword() {
		return password;
	}

	public Utente setPassword(String password) {
		this.password = password;
		return this;
	}

	public String getEmail() {
		return email;
	}

	public Utente setEmail(String email) {
		this.email = email;
		return this;
	}

	public String getSesso() {
		return sesso;
	}

	public void setSesso(String sesso) {
		this.sesso = sesso;
	}

	public List<PrenotazioneSoggiorno> getPrenotazioniSoggiorni() {
		return PrenotazioniSoggiorni;
	}

	public void setPrenotazioniSoggiorni(List<PrenotazioneSoggiorno> prenotazioniSoggiorni) {
		PrenotazioniSoggiorni = prenotazioniSoggiorni;
	}

	public List<PrenotazioneAttivitaIppica> getPrenotazioniAttivitaIppiche() {
		return PrenotazioniAttivitaIppiche;
	}

	public void setPrenotazioniAttivitaIppiche(List<PrenotazioneAttivitaIppica> prenotazioniAttivitaIppiche) {
		PrenotazioniAttivitaIppiche = prenotazioniAttivitaIppiche;
	}

	public List<PrenotazioneEscursione> getPrenotazioniEscursione() {
		return PrenotazioniEscursione;
	}

	public void setPrenotazioniEscursione(List<PrenotazioneEscursione> prenotazioniEscursione) {
		PrenotazioniEscursione = prenotazioniEscursione;
	}

	public List<OrdinazionePiatto> getOrdinaPiatto() {
		return OrdinaPiatto;
	}

	public void setOrdinaPiatto(List<OrdinazionePiatto> ordinaPiatto) {
		OrdinaPiatto = ordinaPiatto;
	}

	public List<OrdinazionePizza> getOrdinaPizza() {
		return OrdinaPizza;
	}

	public void setOrdinaPizza(List<OrdinazionePizza> ordinaPizza) {
		OrdinaPizza = ordinaPizza;
	}

	public Date getDataNascita() {
		return dataNascita;
	}

	public Utente setDataNascita(Date dataNascita) {
		this.dataNascita = dataNascita;
		return this;
	}

	@Override
	public String toString() {
		return "Utente{" + "id=" + id + ", nome='" + nome + '\'' + ", cognome='" + cognome + '\'' + ", username='" +
				username + '\'' + ", password='" + password + '\'' + ", email='" + email + '\'' + ", sesso='" + sesso +
				'\'' + ", dataNascita=" + dataNascita + '}';
	}

}
