package it.faraday.agriturismo.models;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "ordinapizze")
public class OrdinazionePizza {

	@Id
	@Column(name = "id_ordinazionepiz")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ORDPIZ_SEQ_GEN")
	@SequenceGenerator(name = "ORDPIZ_SEQ_GEN", sequenceName = "ordinapizze_id_ordinazionepiz_seq", allocationSize = 1)
	private Integer id;

	@Basic
	private Date data;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_utente")
	private Utente utente;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_pizza")
	private Pizza pizza;

	public OrdinazionePizza() {

	}

	public Integer getId() {
		return id;
	}

	public OrdinazionePizza setId(Integer id) {
		this.id = id;
		return this;
	}

	public Date getData() {
		return data;
	}

	public OrdinazionePizza setData(Date data) {
		this.data = data;
		return this;
	}

	public Utente getUtente() {
		return utente;
	}

	public OrdinazionePizza setUtente(Utente utente) {
		this.utente = utente;
		return this;
	}

	public Pizza getPizza() {
		return pizza;
	}

	public OrdinazionePizza setPizza(Pizza pizza) {
		this.pizza = pizza;
		return this;
	}

	@Override
	public String toString() {
		return "OrdinazionePizza{" + "id=" + id + ", data=" + data + ", utente=" + utente + ", pizza=" + pizza + '}';
	}

}
