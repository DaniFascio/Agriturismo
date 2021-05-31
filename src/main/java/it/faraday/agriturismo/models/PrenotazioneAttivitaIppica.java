package it.faraday.agriturismo.models;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "prenotazioni_attivitaippiche")
public class PrenotazioneAttivitaIppica {

	@Id
	@Column(name = "id_prenotazioneai")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PRENAI_SEQ_GEN")
	@SequenceGenerator(name = "PRENAI_SEQ_GEN",
			sequenceName = "prenotazioni_attivitaippiche_id_prenotazioneai_seq",
			allocationSize = 1)
	private Integer id;

	@Basic
	private Date data;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_utente")
	private Utente utente;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_attivita")
	private AttivitaIppica attivitaIppica;

	public PrenotazioneAttivitaIppica() {
	}

	public Integer getId() {
		return id;
	}

	public PrenotazioneAttivitaIppica setId(Integer id) {
		this.id = id;
		return this;
	}

	public Date getData() {
		return data;
	}

	public PrenotazioneAttivitaIppica setData(Date data) {
		this.data = data;
		return this;
	}

	public Utente getUtente() {
		return utente;
	}

	public PrenotazioneAttivitaIppica setUtente(Utente utente) {
		this.utente = utente;
		return this;
	}

	public AttivitaIppica getAttivitaIppica() {
		return attivitaIppica;
	}

	public PrenotazioneAttivitaIppica setAttivitaIppica(AttivitaIppica attivitaIppica) {
		this.attivitaIppica = attivitaIppica;
		return this;
	}

	@Override
	public String toString() {
		return "PrenotazioneAttivitaIppica{" + "id=" + id + ", data=" + data + ", utente=" + utente +
				", attivitaIppica=" + attivitaIppica + '}';
	}

}
