package it.faraday.agriturismo.models;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "attivitaippiche")
public class AttivitaIppica {

	@Id
	@Column(name = "id_attivita")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ATTIVITA_SEQ_GEN")
	@SequenceGenerator(name = "ATTIVITA_SEQ_GEN", sequenceName = "attivitaippiche_id_attivita_seq", allocationSize = 1)
	private Integer id;

	@Basic
	@Column()
	private Date dataCheckin;


	@Basic
	private Date dataCheckout;

	@Basic
	private float prezzo;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "attivitaippiche_personale",
			joinColumns = @JoinColumn(name = "id_attivita"),
			inverseJoinColumns = @JoinColumn(name = "id_personale"))
	private List<Personale> PersonaleAttivita;


	public AttivitaIppica() {

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDataCheckin() {
		return dataCheckin;
	}

	public void setDataCheckin(Date dataCheckin) {
		this.dataCheckin = dataCheckin;
	}

	public Date getDataCheckout() {
		return dataCheckout;
	}

	public void setDataCheckout(Date dataCheckout) {
		this.dataCheckout = dataCheckout;
	}

	public float getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(float prezzo) {
		this.prezzo = prezzo;
	}

	@Override
	public String toString() {
		return "AttivitaIppica{" + "id=" + id + ", dataCheckin=" + dataCheckin + ", dataCheckout=" + dataCheckout +
				", prezzo=" + prezzo + '}';
	}

}
