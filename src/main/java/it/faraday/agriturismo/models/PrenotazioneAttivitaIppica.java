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

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Utente getUtente() {
		return utente;
	}

	public void setUtente(Utente utente) {
		this.utente = utente;
	}

	public AttivitaIppica getAttivitaIppica() {
		return attivitaIppica;
	}

	public void setAttivitaIppica(AttivitaIppica attivitaIppica) {
		this.attivitaIppica = attivitaIppica;
	}

	@Override
	public String toString() {
		return "PrenotazioneAttivitaIppica{" + "id=" + id + ", data=" + data + ", utente=" + utente +
				", attivitaIppica=" + attivitaIppica + '}';
	}

}
