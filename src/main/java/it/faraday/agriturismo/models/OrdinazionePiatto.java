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
			sequenceName = "ordinapiatti_id_ordinazionepiat_seq",
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

	public OrdinazionePiatto setId(Integer id) {
		this.id = id;
		return this;
	}

	public Date getData() {
		return data;
	}

	public OrdinazionePiatto setData(Date data) {
		this.data = data;
		return this;
	}

	public Utente getUtente() {
		return utente;
	}

	public OrdinazionePiatto setUtente(Utente utente) {
		this.utente = utente;
		return this;
	}

	public it.faraday.agriturismo.models.Piatto getPiatto() {
		return Piatto;
	}

	public OrdinazionePiatto setPiatto(it.faraday.agriturismo.models.Piatto piatto) {
		Piatto = piatto;
		return this;
	}

	@Override
	public String toString() {
		return "OrdinazionePiatto{" + "id=" + id + ", data=" + data + ", utente=" + utente + ", Piatto=" + Piatto + '}';
	}

}
