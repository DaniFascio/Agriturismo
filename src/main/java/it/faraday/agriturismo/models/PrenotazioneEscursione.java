package it.faraday.agriturismo.models;

import com.sun.javafx.beans.IDProperty;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "prenotazioni_escursioni")
public class PrenotazioneEscursione {

	@Id
	@Column(name = "id_prenotazionee")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PRENE_SEQ_GEN")
	@SequenceGenerator(name = "PRENE_SEQ_GEN", sequenceName = "prenotazioni_escursioni_id_prenotazionee_seq", allocationSize = 1)
	private Integer id;

	@Basic
	private Date data;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_utente")
	private Utente utente;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_escursione")
	private Escursione escursione;

	public PrenotazioneEscursione() {
	}

	public Integer getId() {
		return id;
	}

	public PrenotazioneEscursione setId(Integer id) {
		this.id = id;
		return this;
	}

	public Date getData() {
		return data;
	}

	public PrenotazioneEscursione setData(Date data) {
		this.data = data;
		return this;
	}

	public Utente getUtente() {
		return utente;
	}

	public PrenotazioneEscursione setUtente(Utente utente) {
		this.utente = utente;
		return this;
	}

	public Escursione getEscursione() {
		return escursione;
	}

	public PrenotazioneEscursione setEscursione(Escursione escursione) {
		this.escursione = escursione;
		return this;
	}

	@Override
	public String toString() {
		return "PrenotazioneEscursione{" + "id=" + id + ", data=" + data + ", utente=" + utente + ", escursione=" +
				escursione + '}';
	}

}
