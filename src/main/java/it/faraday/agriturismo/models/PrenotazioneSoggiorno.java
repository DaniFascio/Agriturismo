package it.faraday.agriturismo.models;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "prenotazioni_soggiorni")
public class PrenotazioneSoggiorno {

	@Id
	@Column(name = "id_prenotaziones")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PRES_SEQ_GEN")
	@SequenceGenerator(name = "PRES_SEQ_GEN", sequenceName = "prenotazioni_soggiorni_id_prenotaziones_seq", allocationSize = 1)
	private Integer id;

	@Basic
	private Date dataCheckin;

	@Basic
	private Date dataCheckout;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_utente")
	private Utente utente;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "numero")
	private Camera camera;

	public PrenotazioneSoggiorno() {
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

	public Utente getUtente() {
		return utente;
	}

	public void setUtente(Utente utente) {
		this.utente = utente;
	}

	public Camera getCamera() {
		return camera;
	}

	public void setCamera(Camera camera) {
		this.camera = camera;
	}

	@Override
	public String toString() {
		return "PrenotazioneSoggiorno{" + "id=" + id + ", dataCheckin=" + dataCheckin + ", dataCheckout=" + dataCheckout + ", utente=" + utente + ", camera=" +
				camera + '}';
	}

}
