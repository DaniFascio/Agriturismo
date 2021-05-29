package it.faraday.agriturismo.models;

import javax.persistence.*;

@Entity
@Table(name = "pizze")
public class Pizza {

	@Id
	@Column(name = "id_pizza")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PIZZA_SEQ_GEN")
	@SequenceGenerator(name = "PIZZA_SEQ_GEN", sequenceName = "pizze_id_pizza_seq", allocationSize = 1)
	private Integer id;

	@Basic
	private String descrizione;

	@Basic
	private float prezzo;

	public Pizza() {
	}

	public Integer getId() {
		return id;
	}

	public Pizza setId(Integer id) {
		this.id = id;
		return this;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public Pizza setDescrizione(String descrizione) {
		this.descrizione = descrizione;
		return this;
	}

	public float getPrezzo() {
		return prezzo;
	}

	public Pizza setPrezzo(float prezzo) {
		this.prezzo = prezzo;
		return this;
	}

	@Override
	public String toString() {
		return "Pizza{" + "id=" + id + ", descrizione='" + descrizione + '\'' + ", prezzo=" + prezzo + '}';
	}

}
