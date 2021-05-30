package it.faraday.agriturismo.models;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "ordinapiatti")
public class OrdinazionePiatto {

	@Id
	@Column(name = "id_ordinazionepiat")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ORDPIAT_SEQ_GEN")
	@SequenceGenerator(name = "ORDPIAT_SEQ_GEN",
			sequenceName = "ordinapiatti_id_ordinazionepiatti_seq",
			allocationSize = 1)
	private Integer id;

	@Basic
	private Date data;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_utente")
	private Utente utente;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_piatto")
	private Piatto Piatto;

	public OrdinazionePiatto() {
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

	public it.faraday.agriturismo.models.Piatto getPiatto() {
		return Piatto;
	}

	public void setPiatto(it.faraday.agriturismo.models.Piatto piatto) {
		Piatto = piatto;
	}

	@Override
	public String toString() {
		return "OrdinazionePiatto{" + "id=" + id + ", data=" + data + ", utente=" + utente + ", Piatto=" + Piatto + '}';
	}

}
