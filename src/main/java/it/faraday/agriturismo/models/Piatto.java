package it.faraday.agriturismo.models;

import org.springframework.stereotype.Component;

import javax.persistence.*;

@Entity
@Table(name = "piatti")
public class Piatto {

	@Id
	@Column(name = "id_piatto")
	private Integer id;

	@Basic
	private String Descrizione;

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
		return Descrizione;
	}

	public Piatto setDescrizione(String descrizione) {
		Descrizione = descrizione;
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
		return "Piatto{" + "id=" + id + ", Descrizione='" + Descrizione + '\'' + ", prezzo=" + prezzo + '}';
	}

}
