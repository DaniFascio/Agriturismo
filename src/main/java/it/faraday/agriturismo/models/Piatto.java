package it.faraday.agriturismo.models;

import javax.persistence.*;

@Entity
@Table(name = "piatti")
public class Piatto {

	@Id
	@Column(name = "id_piatto")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PIATTO_SEQ_GEN")
	@SequenceGenerator(name = "PIATTO_SEQ_GEN", sequenceName = "piatti_id_piatto_seq", allocationSize = 1)
	private Integer id;

	@Basic
	private String descrizione;

	@Basic
	private float prezzo;

	public Piatto() {
	}

	public Integer getId() {
		return id;
	}

	public Piatto setId(Integer id) {
		this.id = id;
		return this;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public Piatto setDescrizione(String descrizione) {
		this.descrizione = descrizione;
		return this;
	}

	public float getPrezzo() {
		return prezzo;
	}

	public Piatto setPrezzo(float prezzo) {
		this.prezzo = prezzo;
		return this;
	}

	@Override
	public String toString() {
		return "Piatto{" + "id=" + id + ", Descrizione='" + descrizione + '\'' + ", prezzo=" + prezzo + '}';
	}

}
